package com.cs5308.indian_flush.implementation.game.cards;

import java.util.ArrayList;
import java.util.HashMap;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.game.cards.model.Deck;
import com.cs5308.indian_flush.implementation.player.Player;
/* @Author: Vikram */
public class CardsDistribution implements ICardDistribution {

	private Deck deckOfCards;

	@Override
	public Game distributeCards(ArrayList<Player> players, Game game) {

		deckOfCards.shuffle();

		HashMap<String, ArrayList<Card>> hands = new HashMap<>();
		for (Player player : players) {

			ArrayList<Card> cards = new ArrayList<>();
			for (int index = 0; index < Game.getHandSize(); index++) {
				cards.add(deckOfCards.draw());
			}
			player.setHands(cards);
			hands.put(player.getPlayerId(), cards);
		}
		game.setHands(hands);
		return game;
	}

	public static ICardDistribution instance() {
		return new CardsDistribution();
	}

	CardsDistribution() {
		deckOfCards = new Deck();
	}

}
