package com.basicsetup.model.responseDto.fastapi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Post",
        "votes"
})
public class GetResponse {

    @JsonProperty("Post")
    private Post post;
    @JsonProperty("votes")
    private Integer votes;
}
