package com.example.spring_mvc_mongo_gradle.service.trelloListService.facade;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
import com.example.spring_mvc_mongo_gradle.service.trelloCardService.facade.FacadeTrelloCardService;
import com.example.spring_mvc_mongo_gradle.service.trelloListService.TrelloListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FacadeTrelloListService {

    private final TrelloListService trelloListService;
    private final FacadeTrelloCardService facadeTrelloCardService;

    public void PopulateBoardList(List<BoardDTO> boardDTOS) {
        trelloListService.PopulateBoardList(boardDTOS);

        facadeTrelloCardService.PopulateCard(boardDTOS);
    }

    public void CreateList(String boardId, BoardRequest boardRequest){
        trelloListService.CreateList(boardId, boardRequest);
    }
}
