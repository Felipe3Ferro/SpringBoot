package com.example.spring_mvc_mongo_gradle.models.trello.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRequest {
    private String id;
    private String name;
    private String desc;
}