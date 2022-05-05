package com.example.springmvcmongogradle.task.mapper;

import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.example.springmvcmongogradle.task.models.TaskResponse;

public class TaskEntityMapper {
    public static TaskEntity toTaskEntity(TaskRequest taskRequest) {
        return TaskEntity.builder()
                .completed(taskRequest.getCompleted())
                .todo(taskRequest.getTodo())
                .description(taskRequest.getDescription())
                .build();
    }

    public static TaskEntity toTaskEntity(TaskResponse taskResponse){
        return TaskEntity.builder()
                .id(taskResponse.getId())
                .todo(taskResponse.getTodo())
                .description(taskResponse.getDescription())
                .completed(taskResponse.getCompleted())
                .createAt(taskResponse.getCreateAt())
                .updatedAt(taskResponse.getUpdatedAt())
                .build();
    }
}
