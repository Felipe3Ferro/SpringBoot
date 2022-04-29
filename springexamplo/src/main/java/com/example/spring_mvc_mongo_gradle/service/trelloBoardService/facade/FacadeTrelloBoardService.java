package com.example.spring_mvc_mongo_gradle.service.trelloBoardService.facade;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
import com.example.spring_mvc_mongo_gradle.service.trelloBoardService.TrelloBoardService;
import com.example.spring_mvc_mongo_gradle.service.trelloListService.facade.FacadeTrelloListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.spring_mvc_mongo_gradle.mapper.BoardMapper.toBoardDTO;
import static com.example.spring_mvc_mongo_gradle.mapper.ListOfBoardDTOMapper.toListofBoardDTO;

@Component
@AllArgsConstructor
public class FacadeTrelloBoardService {

    private final TrelloBoardService trelloBoardService;
    private final FacadeTrelloListService facadeTrelloListService;

    public List<BoardDTO> getBoard(){
        var boardDTOS = trelloBoardService.getBoard();
        facadeTrelloListService.PopulateBoardList(boardDTOS);
        return boardDTOS;
    }

    public BoardDTO createBoard(BoardRequest boardRequest){
        var boardDTO = trelloBoardService.createBoard(boardRequest);
        var listDTO = facadeTrelloListService.CreateList(boardDTO.getId(), boardRequest);
        trelloBoardService.saveListOnBoard(boardDTO,listDTO);
        return boardDTO;

    }

    public void deleteBoard(String id) {
        trelloBoardService.deleteBoard(id);
    }
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
