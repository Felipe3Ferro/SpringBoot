package com.example.spring_mvc_mongo_gradle.repositories;

import com.example.spring_mvc_mongo_gradle.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {

    @Override
    public void delete(Todo todo);


    void findByTodo();
}