package com.example.spring_mvc_mongo_gradle.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "boards")
public class Boards{
    @NotNull
    private String id;
    @NotNull
    private String name;
    private Boolean closed;
    // private String desc;
    private ListofBoards list;
    private Cards cards;

}