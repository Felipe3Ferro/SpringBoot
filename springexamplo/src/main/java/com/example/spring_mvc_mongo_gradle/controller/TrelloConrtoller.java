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

    @GetMapping("/board/{id}")
    public Board getBoard(@PathVariable String id) {
        return trelloService.getBoard(id);
    }

    @PostMapping("/board")
    public Board createBoard(@RequestBody Board board) {
        return trelloService.createBoard(board);
    }

    @PostMapping("/card/{boardId}/{cardId}")
    public Card createCard(@RequestBody Card card, @PathVariable String boardId, @PathVariable String cardId) {
        return trelloService.createCard(card, boardId, cardId);
    }

}
