package com.example.spring_mvc_mongo_gradle.service.trelloListService.facade;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.service.trelloListService.TrelloListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FacadeTrelloListService {

    private final TrelloListService trelloListService;

    public List<ListofBoardDTO> ListOfBoardDTOByBoardId(String boardId) {

        return trelloListService.ListOfBoardDTOByBoardId(boardId);
    }
}
