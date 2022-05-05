package com.example.springmvcmongogradle.board.mapper.board;

import com.example.springmvcmongogradle.board.models.board.BoardEntity;
import com.example.springmvcmongogradle.board.models.board.BoardResponse;

import java.util.List;

import static com.example.springmvcmongogradle.board.mapper.list.ListEntityMapper.toListEntity;

public class BoardEntityMapper {

    public static List<BoardEntity> toBoardEntity(List<BoardResponse> boardResponses) {
        return boardResponses.stream()
                .map(boardValue ->
                        BoardEntity.builder()
                                .id(boardValue.getId())
                                .name(boardValue.getName())
                                .closed(boardValue.getClosed())
                                .list(toListEntity(boardValue.getList()))
                                .build()
                ).toList();
    }

    public static BoardEntity toBoardEntity(BoardResponse boardResponses) {
        return BoardEntity.builder()
                .id(boardResponses.getId())
                .name(boardResponses.getName())
                .closed(boardResponses.getClosed())
                .list(toListEntity(boardResponses.getList()))
                .build();
    }

}
