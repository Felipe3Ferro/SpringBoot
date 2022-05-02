//package com.example.spring_mvc_mongo_gradle.service.trelloListService;
//
//import com.example.spring_mvc_mongo_gradle.integration.ListIntegration;
//import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
//import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListDTO;
//import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//import static com.example.spring_mvc_mongo_gradle.mapper.BoardMapper.toListofBoardDTOList;
//import static com.example.spring_mvc_mongo_gradle.mapper.ListOfBoardDTOMapper.toListofBoardDTO;
//
//@Service
//@AllArgsConstructor
//public class TrelloListService {
//
//    private final ListIntegration listIntegration;
//
//    public void PopulateBoardList(List<BoardDTO> boardDTOS) {
//        boardDTOS.forEach(varBoardDTO ->
//                varBoardDTO.setList(toListofBoardDTOList(listIntegration.getListofBoardByBoardId(varBoardDTO.getId()))));
//    }
//
//    public List<ListDTO> CreateList(String boardId, BoardRequest boardRequest) {
//        return boardRequest.getList().stream()
//                .map(varList -> toListofBoardDTO(listIntegration.createList(boardId, varList)))
//                .toList();
//    }
//}