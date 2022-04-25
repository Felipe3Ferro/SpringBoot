package com.example.spring_mvc_mongo_gradle.service.mapper;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.ListofBoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.response.Board;
import com.example.spring_mvc_mongo_gradle.models.trello.response.Card;
import com.example.spring_mvc_mongo_gradle.models.trello.response.ListofBoard;

import java.util.List;
import java.util.stream.Collectors;

public class TrellotoDTO {

    public static List<BoardDTO> toBoardDTO(List<Board> board){
      return board.stream()
               .map(boardValue ->
                       BoardDTO.builder()
                               .id(boardValue.getId())
                               .name(boardValue.getName())
                               .closed(boardValue.getClosed())
                               .build()
               ).collect(Collectors.toList());
    }

    public static List<ListofBoardDTO> toListofBoardDTO(List<ListofBoard> listOfBoard){
        return listOfBoard.stream()
                .map(varListOfBoardValue ->
                        ListofBoardDTO.builder()
                                .id(varListOfBoardValue.getId())
                                .name(varListOfBoardValue.getName())
                                .build()
                ).collect(Collectors.toList());

    }

    public static List<CardDTO> toCardDTO(List<Card> card){
        return card.stream()
                .map(varCard ->
                        CardDTO.builder()
                        .id(varCard.getId())
                        .name(varCard.getName())
                        .desc(varCard.getDesc())
                        .build()
                ).collect(Collectors.toList());
    }
}
