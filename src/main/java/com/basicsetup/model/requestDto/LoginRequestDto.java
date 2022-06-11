package com.basicsetup.model.requestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequestDto {

    String username;
    String password;
}
