package com.basicsetup.model.requestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class PostRequestDto {
    private String title;
    private String content;
    private boolean published;
}
