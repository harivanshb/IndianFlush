package com.cs5308.indian_flush.game;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.game.cards.model.Deck;
/* author : Vikram */

public class DeckTest {

	@Test
	public void testDeckObject() {
		Deck deckOfCards = new Deck();
		assertNotNull(deckOfCards);
	}

	@Test
	public void testDeckShuffle() {
		Deck deckOfCards = new Deck();
		Card cardBeforeShuffling = deckOfCards.getDeckOfCards().get(0);
		deckOfCards.shuffle();
		Card cardAfterShuffling = deckOfCards.getDeckOfCards().get(0);
		assertNotNull(cardBeforeShuffling);
		assertNotNull(cardAfterShuffling);
	}

	@Test
	public void testDeckDraw() {
		Deck deckOfCards = new Deck();
		Card cardOne = deckOfCards.draw();
		int sizeOne = deckOfCards.size();

		Card cardTwo = deckOfCards.draw();
		int sizeTwo = deckOfCards.size();

		assertNotEquals(cardOne.getRank().getValue(), cardTwo.getRank().getValue());
		assertNotEquals(sizeOne, sizeTwo);
	}

}
