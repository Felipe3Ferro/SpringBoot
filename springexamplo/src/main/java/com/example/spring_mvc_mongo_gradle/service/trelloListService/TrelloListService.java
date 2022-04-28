package com.example.spring_mvc_mongo_gradle.service.trelloListService;

import com.example.spring_mvc_mongo_gradle.integration.TrelloListIntegration;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.service.trelloBoardService.facade.FacadeTrelloBoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spring_mvc_mongo_gradle.mapper.BoardMapper.toListofBoardDTOList;

@Service
@AllArgsConstructor
public class TrelloListService {

    private final TrelloListIntegration trelloListIntegration;
    private final FacadeTrelloBoardService facadeTrelloBoardService;

    public List<ListofBoardDTO> ListOfBoardDTOByBoardId(String boardId) {
        var listofBoardDTO = toListofBoardDTOList(trelloListIntegration.getListofBoardByBoardId(boardId));

        listofBoardDTO.stream()
                .forEach(varListofBoardDTO ->
                        varListofBoardDTO.setCards(facadeTrelloBoardService.getCardByBoardId(varListofBoardDTO.getId())));

        return listofBoardDTO;
    }

}
