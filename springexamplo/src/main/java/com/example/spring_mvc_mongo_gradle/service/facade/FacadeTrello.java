package com.example.spring_mvc_mongo_gradle.service.facade;


import com.example.spring_mvc_mongo_gradle.integration.TrelloIntegration;
import com.example.spring_mvc_mongo_gradle.mapper.BoardMapper;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
import com.example.spring_mvc_mongo_gradle.models.trello.request.CardRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.spring_mvc_mongo_gradle.mapper.BoardMapper.*;
import static com.example.spring_mvc_mongo_gradle.mapper.ListOfBoardDTOMapper.toListofBoardDTO;

@Component
@AllArgsConstructor
public class FacadeTrello {

    private final TrelloIntegration trelloIntegration;

    public List<BoardDTO> getBoard() {

        var boardDTO = BoardMapper.toBoardDTO(trelloIntegration.getBoard());

        boardDTO.stream()
                .forEach(varBoardDTO ->
                        varBoardDTO.setList(getListOfBoardDTOByBoardId(varBoardDTO.getId())));
        return boardDTO;
    }

    public List<ListofBoardDTO> getListOfBoardDTOByBoardId(String boardId) {
        var listofBoardDTO = toListofBoardDTOList(trelloIntegration.getListofBoardByBoardId(boardId));

        listofBoardDTO.stream()
                .forEach(varListofBoardDTO ->
                        varListofBoardDTO.setCards(getCardByBoardId(varListofBoardDTO.getId())));

        return listofBoardDTO;
    }

    private List<CardDTO> getCardByBoardId(String boardId) {

        return toCardDTO(trelloIntegration.getCard(boardId));
    }

    public void deleteBoard(String id) {
        trelloIntegration.deleteBoard(id);
    }

    public BoardDTO createBoard(BoardRequest board) {
        var boardDTO = toBoardDTO(
                trelloIntegration.createBoard(board));
        boardDTO.setList(
                board.getList().stream().map(value ->
                        toListofBoardDTO(trelloIntegration.createList(boardDTO.getId(), value))
                ).collect(Collectors.toList())
        );

        return boardDTO;
    }

}
