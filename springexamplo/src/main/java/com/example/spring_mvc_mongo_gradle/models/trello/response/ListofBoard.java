package com.example.spring_mvc_mongo_gradle.models.trello.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListofBoard {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
}