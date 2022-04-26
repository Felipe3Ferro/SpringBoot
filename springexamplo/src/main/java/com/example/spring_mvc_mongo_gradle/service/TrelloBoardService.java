package com.example.spring_mvc_mongo_gradle.service;

import com.example.spring_mvc_mongo_gradle.integration.TrelloIntegration;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
import com.example.spring_mvc_mongo_gradle.models.trello.request.CardRequest;
import com.example.spring_mvc_mongo_gradle.repositories.TrelloRepository;
import com.example.spring_mvc_mongo_gradle.service.facade.FacadeTrello;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spring_mvc_mongo_gradle.mapper.CardDTOMapper.toCardDTO;

@AllArgsConstructor
@Service
public class TrelloBoardService {

    private final TrelloRepository repository;
    private final FacadeTrello facadeTrello;
    private final TrelloIntegration trelloIntegration;

    public List<BoardDTO> getBoard() {
        var board = facadeTrello.getBoard();

        // repository
        repository.saveAll(board); //save
        return board;
    }

    public void deleteBoard(String id) {
        facadeTrello.deleteBoard(id);
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public BoardDTO createBoard(BoardRequest board) {
        BoardDTO boardDTO = facadeTrello.createBoard(board);
        return repository.save(boardDTO);
    }

    public CardDTO createCard(CardRequest card) {
        var cardDTO = toCardDTO(trelloIntegration.createCard(card));

        repository.findAll().stream().forEach(valueBoard ->
                valueBoard.getList().stream().forEach(listValue -> {
                            if (listValue.getId().equals(card.getIdList())) {
                                listValue.setCards(List.of(cardDTO));
                            }
                        }
                )
        );

        return cardDTO;
    }
}
