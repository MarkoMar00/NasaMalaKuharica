package hr.tvz.nasamalakuharica.dto;

import lombok.Data;

@Data
public class AuthRespoonseDto {
    private String accessToken;
    private String tokenType = "Bearer ";

    public AuthRespoonseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
