package com.example.springmvcmongogradle.board.mapper.board;

import com.example.springmvcmongogradle.board.models.board.BoardEntity;
import com.example.springmvcmongogradle.board.models.board.BoardResponse;

import java.util.List;

import static com.example.springmvcmongogradle.board.mapper.list.ListResponseMapper.toListResponse;

public class BoardResponseMapper {

    public static List<BoardResponse> toBoardResponse(List<BoardEntity> boardEntities) {
        return boardEntities.stream()
                .map(boardValue ->
                        BoardResponse.builder()
                                .id(boardValue.getId())
                                .name(boardValue.getName())
                                .closed(boardValue.getClosed())
                                .list(toListResponse(boardValue.getList()))
                                .build()
                ).toList();
    }

    public static BoardResponse toBoardResponse(BoardEntity boardEntity) {
        return BoardResponse.builder()
                .id(boardEntity.getId())
                .name(boardEntity.getName())
                .closed(boardEntity.getClosed())
                .list(toListResponse(boardEntity.getList()))
                .build();
    }
}
