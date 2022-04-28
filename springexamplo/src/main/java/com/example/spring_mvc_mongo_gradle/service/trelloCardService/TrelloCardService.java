package com.example.spring_mvc_mongo_gradle.service.trelloCardService;

import com.example.spring_mvc_mongo_gradle.integration.TrelloCardIntegration;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spring_mvc_mongo_gradle.mapper.BoardMapper.toCardDTO;

@Service
@AllArgsConstructor
public class TrelloCardService {

    private final TrelloCardIntegration trelloCardIntegration;

    public List<CardDTO> getCard(String listId) {
        return toCardDTO(trelloCardIntegration.getCard(listId));
    }
}
