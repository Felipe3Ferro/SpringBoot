package com.example.spring_mvc_mongo_gradle.repositories;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrelloRepository extends MongoRepository<BoardDTO, String> {

    @Override
    public void delete(BoardDTO todo);

    // void findByBoard();
}