package com.example.spring_mvc_mongo_gradle.repositories;

import com.example.spring_mvc_mongo_gradle.models.Board;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrelloRepository extends MongoRepository<Board, String> {

    @Override
    public void delete(Board todo);

    // void findByBoard();
}