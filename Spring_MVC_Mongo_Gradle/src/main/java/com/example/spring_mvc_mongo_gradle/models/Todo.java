package com.example.spring_mvc_mongo_gradle.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data // shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter (non final filds) @Required Constructor
@AllArgsConstructor //@AllArgsConstructor gera um construtor com 1 parâmetro para cada campo em sua classe. Os campos marcados com @NonNull resultam em verificações nulas nesses parâmetros.
@NoArgsConstructor
@Document(collection = "todos")
public class Todo {
    @Id
    private String id;
    @NotNull
    private String todo;
    private String description;
    @NotNull
    private Boolean completed;
//    @NotNull
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;


    public void setData(){
        this.createAt = LocalDateTime.now();
    }
}
