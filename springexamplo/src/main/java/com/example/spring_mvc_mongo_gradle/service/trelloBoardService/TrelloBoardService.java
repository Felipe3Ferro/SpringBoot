package com.example.spring_mvc_mongo_gradle.service.trelloBoardService;

import com.example.spring_mvc_mongo_gradle.integration.TrelloBoardIntegration;
import com.example.spring_mvc_mongo_gradle.mapper.BoardMapper;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
import com.example.spring_mvc_mongo_gradle.models.trello.request.CardRequest;
import com.example.spring_mvc_mongo_gradle.repositories.TrelloRepository;
import com.example.spring_mvc_mongo_gradle.service.trelloBoardService.facade.FacadeTrelloBoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spring_mvc_mongo_gradle.mapper.CardDTOMapper.toCardDTO;


@Service
@AllArgsConstructor
public class TrelloBoardService {

    private final TrelloRepository repository;
    private final FacadeTrelloBoardService facadeTrelloBoardService;
    private final TrelloBoardIntegration trelloBoardIntegration;

    public List<BoardDTO> getBoard() {
        var boardDTO = BoardMapper.toBoardDTO(trelloBoardIntegration.getBoard());

        boardDTO.stream()
                .forEach(varBoardDTO ->
                        varBoardDTO.setList(facadeTrelloBoardService.ListOfBoardDTOByBoardId(varBoardDTO.getId())));

        repository.saveAll(boardDTO);
        return boardDTO;
    }

//    public void deleteBoard(String id) {
//        facadeTrelloBoardService.deleteBoard(id);
//        repository.deleteById(id);
//    }
//
//    public void deleteAll() {
//        repository.deleteAll();
//    }
//
//    public BoardDTO createBoard(BoardRequest board) {
//        BoardDTO boardDTO = facadeTrelloBoardService.createBoard(board);
//        return repository.save(boardDTO);
//    }
//
//    public CardDTO createCard(CardRequest card) {
//        var cardDTO = toCardDTO(trelloBoardIntegration.createCard(card));
//
//        repository.findAll().stream().forEach(valueBoard ->
//                valueBoard.getList().stream().forEach(listValue -> {
//                            if (listValue.getId().equals(card.getIdList())) {
//                                listValue.setCards(List.of(cardDTO));
//                            }
//                        }
//                )
//        );
//
//        return cardDTO;
//    }
}
