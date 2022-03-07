package com.example.spring_mvc_mongo_gradle.models;

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
@Document(collection = "boards")

public class Board {
    @NotNull
    private String id;
    @NotNull
    private String name;
    private Boolean closed;
    // private String desc;
    private List<ListofBoard> list;

}