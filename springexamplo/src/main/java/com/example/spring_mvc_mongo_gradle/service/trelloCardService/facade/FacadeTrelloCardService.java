package com.example.spring_mvc_mongo_gradle.service.trelloCardService.facade;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.service.trelloCardService.TrelloCardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FacadeTrelloCardService {

    private final TrelloCardService trelloCardService;

    public List<CardDTO> getCardByBoardId(String id) {

        return trelloCardService.getCard(id);
    }
}
