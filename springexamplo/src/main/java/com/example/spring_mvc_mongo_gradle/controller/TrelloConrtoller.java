package com.example.spring_mvc_mongo_gradle.controller;

import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.example.spring_mvc_mongo_gradle.service.TrelloService;



@AllArgsConstructor
@RestController
@RequestMapping("/v1/trello")
public class TrelloConrtoller {

    private final TrelloService trelloService;

    @GetMapping("{id}/cards")
    public List getCards(@PathVariable String id){
        return trelloService.getCardsByBoardId(id);
    }
}
