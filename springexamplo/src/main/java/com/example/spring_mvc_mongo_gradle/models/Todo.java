package com.example.spring_mvc_mongo_gradle.models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data // shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter (non final filds) @Required Constructor
@AllArgsConstructor //@AllArgsConstructor gera um construtor com 1 parâmetro para cada campo em sua classe. Os campos marcados com @NonNull resultam em verificações nulas nesses parâmetros.
//@NoArgsConstructor
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
    // @Builder.Default
    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public Todo() {
    }

    public void setDataUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}