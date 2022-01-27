package com.example.spring_mvc_mongo_gradle.models;

import lombok.Data;

@Data
public class ListofBoard {
    private String id;
    private String name;
    private String desc;
    private Card[] cards;
}