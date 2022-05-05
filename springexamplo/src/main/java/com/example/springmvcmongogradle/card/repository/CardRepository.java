package com.example.springmvcmongogradle.card.repository;

import com.example.springmvcmongogradle.card.models.CardEntity;
import com.example.springmvcmongogradle.task.models.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<CardEntity, String>{
}
