package com.example.springmvcmongogradle.task.repository;

import com.example.springmvcmongogradle.task.models.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<TaskEntity, String> {

}