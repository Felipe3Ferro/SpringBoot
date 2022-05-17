package com.example.springmvcmongogradle.task.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TaskRequest {
    @NotBlank(message = "todo can't be empty")
    private String todo;
    private String description;
    @NotNull(message = "completed can't be null")
    private Boolean completed;
}