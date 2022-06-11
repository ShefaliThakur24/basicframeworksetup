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
            "title",
            "content",
            "published",
            "id",
            "created_at",
            "owner_id",
            "owner"
    })

    public class Post {

        @JsonProperty("title")
        private String title;
        @JsonProperty("content")
        private String content;
        @JsonProperty("published")
        private Boolean published;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("owner_id")
        private Integer ownerId;
        @JsonProperty("owner")
        private Owner owner;

    }
