package com.example.springmvcmongogradle.task.models;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
public class TaskResponse {

    private String id;
    private String todo;
    private String description;
    private Boolean completed;
    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public TaskResponse() {
    }

    public void setDataUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
