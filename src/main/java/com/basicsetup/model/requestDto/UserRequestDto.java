package com.basicsetup.model.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
