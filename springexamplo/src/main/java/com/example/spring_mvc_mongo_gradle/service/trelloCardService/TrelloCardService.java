//package com.example.spring_mvc_mongo_gradle.service.trelloCardService;
//
//import com.example.spring_mvc_mongo_gradle.integration.TrelloCardIntegration;
//import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//import static com.example.spring_mvc_mongo_gradle.mapper.BoardMapper.toCardDTO;
//
//@Service
//@AllArgsConstructor
//public class TrelloCardService {
//
//    private final TrelloCardIntegration trelloCardIntegration;
//
//    public void PopulateCard(List<BoardDTO> boardDTOS) {
//
//        boardDTOS.forEach(
//                BoardDTOValue -> BoardDTOValue.getList().forEach(
//                        ListDTOValue -> ListDTOValue.setCards(
//                                toCardDTO(trelloCardIntegration.getCard(ListDTOValue.getId()))
//                        )
//                )
//        );
//
//    }
//}
