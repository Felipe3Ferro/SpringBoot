package com.example.springmvcmongogradle.board.repository;

import com.example.springmvcmongogradle.board.models.board.BoardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<BoardEntity, String> {
}
