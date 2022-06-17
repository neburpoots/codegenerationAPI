package io.swagger.cucumber.glue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.swagger.model.entity.User;
import io.swagger.model.user.UserGetDTO;
import io.swagger.repository.UserRepository;
import io.swagger.security.JwtTokenProvider;
import io.swagger.security.WebSecurityConfig;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GetUserSteps {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    final String baseUrl = "http://localhost:";
    @LocalServerPort
    int serverPort;

    private User exampleUser;
    private ResponseEntity<String> response;
    private UserGetDTO actualUser;

    private UUID uuid;

    @Given("^A valid UUID$")
    public void givenAValidUUID() {
        makeExampleUser();
        this.uuid = exampleUser.getUser_id();
    }

    private void makeExampleUser() {
        this.exampleUser = new User("Example", "User", "emailUser@example.com", new BigDecimal(50), new BigDecimal(1500), webSecurityConfig.passwordEncoder().encode("Secret123!"));
        this.exampleUser = this.userRepository.save(exampleUser);
    }

    @When("^A user is requested")
    public void whenAUserIsRequested() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type",
                "application/json");
        httpHeaders.add("Authorization", "Bearer " + jwtTokenProvider.createToken("ruben@student.inholland.nl", new ArrayList<>(), UUID.randomUUID()));

        response = restTemplate
                .exchange(baseUrl + serverPort + "/api/users/" + uuid,
                        HttpMethod.GET, new HttpEntity<>(httpHeaders),
                        String.class);
        JSONObject jsonObject = new JSONObject(response.getBody());
        actualUser = mapper.readValue(String.valueOf(jsonObject), new TypeReference<UserGetDTO>() {
        });
    }

    @Then("^The user object is returned")
    public void theUserObjectIsReturned() {
        validateOutput();
    }

    private void validateOutput() {
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        Assertions.assertEquals(uuid, actualUser.getUser_id());
        Assertions.assertEquals(exampleUser.getEmail(), actualUser.getEmail());
    }
}
