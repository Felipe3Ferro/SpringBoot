package com.example.spring_mvc_mongo_gradle.service.trelloBoardService.facade;


import com.example.spring_mvc_mongo_gradle.integration.TrelloBoardIntegration;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.service.trelloCardService.facade.FacadeTrelloCardService;
import com.example.spring_mvc_mongo_gradle.service.trelloListService.facade.FacadeTrelloListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FacadeTrelloBoardService {

    private final FacadeTrelloListService facadeTrelloListService;
//    private final FacadeTrelloCardService facadeTrelloCardService;

    public List<ListofBoardDTO> ListOfBoardDTOByBoardId(String boardId) {
        return facadeTrelloListService.ListOfBoardDTOByBoardId(boardId);
    }

//    public void deleteBoard(String id) {
//        trelloBoardIntegration.deleteBoard(id);
//    }
//
//    public BoardDTO createBoard(BoardRequest board) {
//        var boardDTO = toBoardDTO(
//                trelloBoardIntegration.createBoard(board));
//        boardDTO.setList(
//                board.getList().stream().map(value ->
//                        toListofBoardDTO(trelloBoardIntegration.createList(boardDTO.getId(), value))
//                ).collect(Collectors.toList())
//        );
//
//        return boardDTO;
//    }

//    public List<CardDTO> getCardByBoardId(String id) {
//        return facadeTrelloCardService.getCardByBoardId(id);
//    }
}
