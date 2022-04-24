package com.example.spring_mvc_mongo_gradle.models.trello.dto;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

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
    @NotNull
    private String id;
    @NotNull
    private String name;
    private Boolean closed;
    // private String desc;
    private List<ListofBoardDTO> list;

}