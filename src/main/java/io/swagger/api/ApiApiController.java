package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.model.Account;
import io.swagger.model.AccountPatchDTO;
import io.swagger.model.AccountPostDTO;
import io.swagger.model.Error;
import io.swagger.model.Transaction;
import io.swagger.model.TransactionPostDTO;
import io.swagger.model.User;
import io.swagger.model.UserLoginDTO;
import io.swagger.model.UserPasswordDTO;
import io.swagger.model.UserPatchDTO;
import io.swagger.model.UserPostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-05T18:12:07.854Z[GMT]")
@RestController
@Api(tags = {"users"})
public class ApiApiController implements ApiApi {

    private static final Logger log = LoggerFactory.getLogger(ApiApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ApiApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<User> addUser(@Parameter(in = ParameterIn.DEFAULT, description = "Created User object", required=true, schema=@Schema()) @Valid @RequestBody UserPostDTO body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstname\" : \"Kiana\",\n  \"role\" : {\n    \"name\" : \"Employee\",\n    \"id\" : 1\n  },\n  \"transaction_limit\" : 100,\n  \"id\" : \"123e4567-e89b-12d3-a456-426614174000\",\n  \"email\" : \"Kiana.Padilla@gmail.com\",\n  \"daily_limit\" : 25000,\n  \"lastname\" : \"Padilla\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> editPassword(@Parameter(in = ParameterIn.DEFAULT, description = "Password information", required=true, schema=@Schema()) @Valid @RequestBody UserPasswordDTO body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> editUserById(@Parameter(in = ParameterIn.PATH, description = "Id of the user you want to edit", required=true, schema=@Schema()) @PathVariable("id") String id,@Parameter(in = ParameterIn.DEFAULT, description = "Created User object", required=true, schema=@Schema()) @Valid @RequestBody UserPatchDTO body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> getUserById(@Parameter(in = ParameterIn.PATH, description = "Id of the user you want to get", required=true, schema=@Schema()) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstname\" : \"Kiana\",\n  \"role\" : {\n    \"name\" : \"Employee\",\n    \"id\" : 1\n  },\n  \"transaction_limit\" : 100,\n  \"id\" : \"123e4567-e89b-12d3-a456-426614174000\",\n  \"email\" : \"Kiana.Padilla@gmail.com\",\n  \"daily_limit\" : 25000,\n  \"lastname\" : \"Padilla\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Object>> getUsers(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Page number for pagination" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "page", required = true) Integer page,@Parameter(in = ParameterIn.QUERY, description = "Name value that needs to be considered for filter" ,schema=@Schema()) @Valid @RequestParam(value = "name", required = false) String name,@Parameter(in = ParameterIn.QUERY, description = "IBAN value that needs to be considered for filter" ,schema=@Schema()) @Valid @RequestParam(value = "iban", required = false) String iban) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Object>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Object>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> loginUser(@Parameter(in = ParameterIn.DEFAULT, description = "Login credentials", required=true, schema=@Schema()) @Valid @RequestBody UserLoginDTO body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\n  \"firstname\" : \"Kiana\",\n  \"role\" : {\n    \"name\" : \"Employee\",\n    \"id\" : 1\n  },\n  \"transaction_limit\" : 100,\n  \"id\" : \"123e4567-e89b-12d3-a456-426614174000\",\n  \"email\" : \"Kiana.Padilla@gmail.com\",\n  \"daily_limit\" : 25000,\n  \"lastname\" : \"Padilla\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

}
