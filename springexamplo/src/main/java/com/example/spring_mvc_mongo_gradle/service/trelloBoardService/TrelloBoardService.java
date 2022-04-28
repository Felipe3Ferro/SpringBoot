package com.example.spring_mvc_mongo_gradle.service.trelloBoardService;

import com.example.spring_mvc_mongo_gradle.integration.TrelloBoardIntegration;
import com.example.spring_mvc_mongo_gradle.mapper.BoardMapper;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
import com.example.spring_mvc_mongo_gradle.repositories.TrelloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.spring_mvc_mongo_gradle.mapper.BoardMapper.toBoardDTO;


@Service
@AllArgsConstructor
public class TrelloBoardService {

    private final TrelloRepository repository;
    private final TrelloBoardIntegration trelloBoardIntegration;

    public List<BoardDTO> getBoard() {
        var boardDTO = toBoardDTO(trelloBoardIntegration.getBoard());

        repository.saveAll(boardDTO);
        return boardDTO;
    }

    public void deleteBoard(String id) {
        trelloBoardIntegration.deleteBoard(id);
        repository.deleteById(id);
    }
//
//    public void deleteAll() {
//        repository.deleteAll();
//    }
//
    public BoardDTO createBoard(BoardRequest board) {
        trelloBoardIntegration.createBoard(board);
        return repository.save(toBoardDTO(board));
    }


//    public BoardDTO createBoard(BoardRequest board) {
//        var boardDTO =
//        boardDTO.setList(
//                board.getList().stream().map(value ->
//                        toListofBoardDTO(trelloBoardIntegration.createList(boardDTO.getId(), value))
//                ).collect(Collectors.toList())
//        );
//
//        return boardDTO;
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
