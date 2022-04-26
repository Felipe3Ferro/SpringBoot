package com.example.spring_mvc_mongo_gradle.mapper;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
import com.example.spring_mvc_mongo_gradle.models.trello.response.BoardResponse;
import com.example.spring_mvc_mongo_gradle.models.trello.response.CardResponse;
import com.example.spring_mvc_mongo_gradle.models.trello.response.ListofBoardResponse;

import java.util.List;
import java.util.stream.Collectors;

public class BoardMapper {

    public static List<BoardDTO> toBoardDTO(List<BoardResponse> boardResponse){
      return boardResponse.stream()
               .map(boardValue ->
                       BoardDTO.builder()
                               .id(boardValue.getId())
                               .name(boardValue.getName())
                               .closed(boardValue.getClosed())
                               .build()
               ).collect(Collectors.toList());
    }

    public static List<ListofBoardDTO> toListofBoardDTOList(List<ListofBoardResponse> listOfBoardResponse){
        return listOfBoardResponse.stream()
                .map(varListOfBoardValueResponse ->
                        ListofBoardDTO.builder()
                                .id(varListOfBoardValueResponse.getId())
                                .name(varListOfBoardValueResponse.getName())
                                .build()
                ).collect(Collectors.toList());

    }

    public static List<CardDTO> toCardDTO(List<CardResponse> cardResponse){
        return cardResponse.stream()
                .map(varCardResponse ->
                        CardDTO.builder()
                        .id(varCardResponse.getId())
                        .name(varCardResponse.getName())
                        .desc(varCardResponse.getDesc())
                        .build()
                ).collect(Collectors.toList());
    }

    public static BoardDTO toBoardDTO(BoardResponse board){
        return BoardDTO.builder()
                .id(board.getId())
                .name(board.getName())
                .closed(board.getClosed())
                .build();
    }

    public static BoardDTO toBoardDTO(BoardRequest board){
        return BoardDTO.builder()
                .id(board.getId())
                .name(board.getName())
                .closed(board.getClosed())
                .build();
    }

}
