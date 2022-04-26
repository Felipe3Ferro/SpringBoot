package com.example.spring_mvc_mongo_gradle.models.trello.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListofBoardRequest {
    private String id;
    private String name;
    private String desc;
}