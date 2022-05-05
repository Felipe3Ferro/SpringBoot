package com.example.springmvcmongogradle.board.controller.v1;

import com.example.springmvcmongogradle.board.models.board.BoardRequest;
import com.example.springmvcmongogradle.board.models.board.BoardResponse;
import com.example.springmvcmongogradle.board.service.BoardFacade;
import com.example.springmvcmongogradle.board.service.BoardService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/trello")
public class BoardController {

    private final BoardFacade boardFacade;
    private final BoardService boardService;

    @GetMapping("/board")
    public List<BoardResponse> getBoard() {
        return boardFacade.getBoard();
    }

    @PostMapping("/board")
    public BoardResponse createBoard(@RequestBody BoardRequest board) {
        return boardFacade.createBoard(board);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable String id){
        boardService.deleteBoard(id);
    }

    @DeleteMapping()
    public void deleteAllBoard(){
        boardService.deleteAllBoard();
    }

    @PutMapping
    public BoardResponse alteraBoard(@PathVariable String id){
        return boardFacade.alteraBoard(id);
    }

}