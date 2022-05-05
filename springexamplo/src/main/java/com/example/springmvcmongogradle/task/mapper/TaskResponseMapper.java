package com.example.springmvcmongogradle.task.mapper;

import com.example.springmvcmongogradle.task.models.TaskEntity;
import com.example.springmvcmongogradle.task.models.TaskRequest;
import com.example.springmvcmongogradle.task.models.TaskResponse;


public class TaskResponseMapper {

    public static TaskResponse toTaskResponse(TaskRequest taskRequest){
        return TaskResponse.builder()
                .completed(taskRequest.getCompleted())
                .todo(taskRequest.getTodo())
                .description(taskRequest.getDescription())
                .build();
    }

    public static TaskResponse toTaskResponse(TaskEntity taskEntity){
        return TaskResponse.builder()
                .id(taskEntity.getId())
                .todo(taskEntity.getTodo())
                .description(taskEntity.getDescription())
                .completed(taskEntity.getCompleted())
                .createAt(taskEntity.getCreateAt())
                .updatedAt(taskEntity.getUpdatedAt())
                .build();
    }

}
