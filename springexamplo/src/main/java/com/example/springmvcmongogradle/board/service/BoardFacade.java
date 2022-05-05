package com.example.springmvcmongogradle.board.service;

import com.example.springmvcmongogradle.board.models.board.BoardRequest;
import com.example.springmvcmongogradle.board.models.board.BoardResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BoardFacade {

    private final BoardService boardService;
    private final ListService listService;

    public List<BoardResponse> getBoard() {
        var board = boardService.getBoard();
        board.forEach(boardResponse -> boardResponse.setList(
                        listService.getList(boardResponse.getId())
                )
        );
        boardService.saveBoard(board);
        return board;
    }

    public BoardResponse createBoard(BoardRequest boardRequest){
        var board = boardService.createBoard(boardRequest);
        var list = listService.CreateList(board.getId(), boardRequest);
        board.setList(list);
        boardService.saveBoard(board);
        return board;
    }

    public BoardResponse alteraBoard(String id) {
        var board = boardService.alteraBoard(id);
        return null;
    }
}
