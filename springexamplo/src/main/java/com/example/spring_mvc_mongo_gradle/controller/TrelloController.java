package com.example.spring_mvc_mongo_gradle.controller;

import java.util.List;

import com.example.spring_mvc_mongo_gradle.models.trello.dto.BoardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.dto.CardDTO;
import com.example.spring_mvc_mongo_gradle.models.trello.request.BoardRequest;
import com.example.spring_mvc_mongo_gradle.models.trello.request.CardRequest;
import com.example.spring_mvc_mongo_gradle.service.trelloBoardService.TrelloBoardService;

import com.example.spring_mvc_mongo_gradle.service.trelloBoardService.facade.FacadeTrelloBoardService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    private final FacadeTrelloBoardService facadeTrelloBoardService;

    @GetMapping("/board")
    public List<BoardDTO> getBoard() {
        return facadeTrelloBoardService.getBoard();
    }

    @PostMapping("/board")
    public BoardDTO createBoard(@RequestBody BoardRequest board) {
        return facadeTrelloBoardService.createBoard(board);
    }

//    @PostMapping("/card")
//    public CardDTO createCard(@RequestBody CardRequest card){
//        return trelloBoardService.createCard(card);
//    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable String id){
        facadeTrelloBoardService.deleteBoard(id);
    }

}