package com.example.spring_mvc_mongo_gradle.models.trello.response;

import lombok.Data;

@Data
public class Card {
    private String id;
    private String name;
    private String desc;
}
