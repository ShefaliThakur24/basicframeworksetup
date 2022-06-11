package com.basicsetup.model.responseDto.fastapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private int id;
    private String Email;
    @JsonProperty("created_at")
    private String createdAt;
}
