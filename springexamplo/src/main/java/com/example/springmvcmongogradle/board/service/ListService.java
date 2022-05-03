package com.example.springmvcmongogradle.board.service;

import com.example.springmvcmongogradle.board.integration.ListIntegration;
import com.example.springmvcmongogradle.board.models.board.BoardRequest;
import com.example.springmvcmongogradle.board.models.board.BoardResponse;
import com.example.springmvcmongogradle.board.models.list.ListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListService {

    private final ListIntegration listIntegration;

    public List<ListResponse> getList(String idBoard) {
        return listIntegration.getListofBoardByBoardId(idBoard);
    }

    public BoardResponse createBoard() {
        return null;
    }

    public List<ListResponse> CreateList(String id, BoardRequest boardRequest) {
        return boardRequest.getList().stream().map(valueBoard ->
                        listIntegration.createList(id, valueBoard)
                )
                .toList();
    }
}
