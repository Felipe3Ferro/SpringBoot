package com.example.spring_mvc_mongo_gradle.controller;

import java.util.List;

import com.example.spring_mvc_mongo_gradle.models.Board;
import com.example.spring_mvc_mongo_gradle.models.Card;
import com.example.spring_mvc_mongo_gradle.service.TrelloService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/trello")
public class TrelloConrtoller {

    private final TrelloService trelloService;

    // @GetMapping("{id}/cards")
    // public List getCards(@PathVariable String id) {
    // return trelloService.getCardsByBoardId(id);
    // }

    @GetMapping("/board")
    public List<Board> getBoard() {
        return trelloService.getBoard();
    }

    @PostMapping("/board")
    public Board createBoard(@RequestBody Board board) {
        return trelloService.createBoard(board);
    }

    @PostMapping("/card/{boardId}/{listofBoardId}")
    public Card createCard(@RequestBody Card card, @PathVariable String boardId, @PathVariable String listofBoardId) {
        return trelloService.createCard(card, boardId, listofBoardId);
    }

    @DeleteMapping
    public void deleteBoard(){
        trelloService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable String id){
        trelloService.deleteBoard(id);
    }

}
