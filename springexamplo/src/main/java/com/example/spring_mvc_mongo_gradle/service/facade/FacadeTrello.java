package com.example.spring_mvc_mongo_gradle.service.facade;


import com.example.spring_mvc_mongo_gradle.integration.TrelloIntegration;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.repositories.TrelloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.spring_mvc_mongo_gradle.service.mapper.TrellotoDTO.*;

@Component
@AllArgsConstructor
public class FacadeTrello {

    private final TrelloIntegration trelloIntegration;

    public List<BoardDTO> createBoard() {

       var boardDTO = toBoardDTO(trelloIntegration.getBoard());

       boardDTO.stream()
               .forEach(varBoardDTO ->
                       varBoardDTO.setList(getListOfBoardDTOByBoardId(varBoardDTO.getId())));
       return boardDTO;
    }

    public List<ListofBoardDTO> getListOfBoardDTOByBoardId(String boardId){
        var listofBoardDTO = toListofBoardDTO(trelloIntegration.getListofBoardByBoardId(boardId));

        listofBoardDTO.stream()
                .forEach(varListofBoardDTO ->
                        varListofBoardDTO.setCards(getCardByBoardId(varListofBoardDTO.getId())));

        return listofBoardDTO;
    }

    private List<CardDTO> getCardByBoardId(String boardId) {

        return toCardDTO(trelloIntegration.getCard(boardId));
    }
}
