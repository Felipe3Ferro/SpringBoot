package com.example.springmvcmongogradle.task.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Task")
public class TaskEntity {
    @Id
    private String id;
    private String todo;
    private String description;
    private Boolean completed;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}