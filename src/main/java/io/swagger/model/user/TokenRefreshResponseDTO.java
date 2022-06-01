package io.swagger.model.user;

import lombok.Data;

@Data
public class TokenRefreshResponseDTO {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";

    public TokenRefreshResponseDTO(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
