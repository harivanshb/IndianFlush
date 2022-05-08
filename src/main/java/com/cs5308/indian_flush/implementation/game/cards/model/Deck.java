package com.cs5308.indian_flush.implementation.game.cards.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/* @Author: Vikram */
public class Deck implements Serializable {

	private static final long serialVersionUID = 1488486344846201434L;

	private ArrayList<Card> deckOfCards;

	public Deck() {
		deckOfCards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deckOfCards.add(new Card(rank, suit));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}

	public Card draw() {
		return deckOfCards.remove(0);
	}

	public int size() {
		return deckOfCards.size();
	}

	public ArrayList<Card> getDeckOfCards() {
		return deckOfCards;
	}

}
