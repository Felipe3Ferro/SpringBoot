package com.example.spring_mvc_mongo_gradle.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.spring_mvc_mongo_gradle.models.Cards;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TrelloService {
    
    // private final TrelloRepository repository;

	public static RestTemplate template = new RestTemplate();

    public List getCardsByBoardId(String id) {

        return Arrays.stream(getListCardsOfBoards(id)).map(cards -> cards.getName()).collect(Collectors.toList());
    
    }

    public static Cards[] getListCardsOfBoards(String id){

		//https://api.trello.com/1/boards/61eb148bf61d443d512751de/cards
		
		UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("api.trello.com/")
			.path("1/boards/")
			.path(id + "/cards")
			.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
			.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
			.build();
	
		Cards[] entity =  template.getForObject(uri.toString(), Cards[].class);

		return entity;
	}


    public static Cards[] carrega(String id){

		//https://api.trello.com/1/boards/61eb148bf61d443d512751de/cards
		
		UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("api.trello.com/")
			.path("1/boards/")
			.path(id + "/cards")
			.queryParam("key", "4d22d21f5c6e14648a954f215c23a55f")
			.queryParam("token", "348302ac70e0e10c33a0d89ebaee4194609f992f422c13bb30d70531718efba3")
			.build();
	
		Cards[] entity =  template.getForObject(uri.toString(), Cards[].class);

		return entity;
	}

}
