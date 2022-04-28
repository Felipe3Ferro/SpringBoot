package com.example.spring_mvc_mongo_gradle.models.trello.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private String id;
    private String name;
    private Boolean closed;
    private List<ListDTO> list;

}