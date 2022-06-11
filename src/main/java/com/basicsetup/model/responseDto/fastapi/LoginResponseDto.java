package com.basicsetup.model.responseDto.fastapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResponseDto {
    @JsonProperty("access_token")
    String accessToken;
    @JsonProperty("token_type")
    String tokenType;
}
