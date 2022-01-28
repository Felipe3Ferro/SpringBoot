package com.example.spring_mvc_mongo_gradle.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.spring_mvc_mongo_gradle.models.Board;
import com.example.spring_mvc_mongo_gradle.models.Card;
import com.example.spring_mvc_mongo_gradle.models.ListofBoard;
import com.example.spring_mvc_mongo_gradle.repositories.TrelloRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TrelloService {

	private final TrelloRepository repository;
	private final RestTemplate template;
	private final UriComponentsBuilder uriComponentsBuilder;

	// public List getCardsByBoardId(String id) {

	// return Arrays.stream(getCardsOfListById(id)).map(cards ->
	// cards.getName()).collect(Collectors.toList());

	// }

	public Card[] getCardsFromListById(String id) {

		// https://api.trello.com/1/lists/61f15dfcc7b3c971222b035d/cards

		UriComponents uri = uriComponentsBuilder
				.path("1/lists/")
				.path(id + "/cards")
				.build();

		Card[] cards = template.getForObject(uri.toString(), Card[].class);

		return cards;
	}

	public ListofBoard[] getListFromABoardById(String id) {
		// https://api.trello.com/1/boards/61eb148bf61d443d512751de/lists

		UriComponents uri = uriComponentsBuilder.newInstance()
				.build();

		System.out.println("UIR=====>" + uri.toString());

		ListofBoard[] listofBoards = template.getForObject(uri.toString(), ListofBoard[].class);

		for (int i = 0; i < listofBoards.length; i++) {
			listofBoards[i].setCards(getCardsFromListById(listofBoards[i].getId()));
		}

		return listofBoards;
	}

	public Board createBoard(Board board) {

		UriComponents uri = uriComponentsBuilder
				.path("1/boards/")
				.build();

		Board aux = template.postForObject(uri.toString(), board, Board.class);

		System.out.println("passsou");

		aux.setList(getListFromABoardById(aux.getId()));

		return repository.save(aux);
	}

	public Card createCard(Card card, String boardId, String cardId) {

		UriComponents uri = uriComponentsBuilder
				.path("1/cards")
				.queryParam("idList", "61f16d89d935ce331d7481fe")
				.build();

		Card aux = template.postForObject(uri.toString(), card, Card.class);

		ListofBoard[] list = repository.findById(boardId).get().getList();

		for (ListofBoard listofBoard : list) {
			if (listofBoard.getId().equals(cardId)) {
				Card[] cards = { card };
				listofBoard.setCards(cards);
			}
		}

		return aux;
	}

	public Board getBoard(String id) {
		return repository.findById(id).get();
	}

}