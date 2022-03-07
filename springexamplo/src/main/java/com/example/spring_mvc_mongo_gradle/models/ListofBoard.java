package com.example.spring_mvc_mongo_gradle.models;

import lombok.Data;

import java.util.List;

@Data
public class ListofBoard {
    private String id;
    private String name;
    private String desc;
    private List<Card> cards;
}