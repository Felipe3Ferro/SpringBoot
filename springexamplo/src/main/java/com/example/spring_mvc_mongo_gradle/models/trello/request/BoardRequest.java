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
public class BoardRequest {
    private Boolean defaultLists = false;
    private String name;
    private Boolean closed;
    private List<ListRequest> list;
}