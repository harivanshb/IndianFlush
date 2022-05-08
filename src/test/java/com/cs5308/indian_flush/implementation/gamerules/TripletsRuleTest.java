package com.cs5308.indian_flush.implementation.gamerules;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.game.cards.ICardDistribution;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.game.cards.model.Rank;
import com.cs5308.indian_flush.implementation.game.cards.model.Suit;
import com.cs5308.indian_flush.implementation.gamerules.abstractfactory.RulesAbstractFactory;
import com.cs5308.indian_flush.implementation.gamerules.interfaces.ITripletsCardShowRule;
import com.cs5308.indian_flush.implementation.player.BotPlayer;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;

import net.bytebuddy.utility.RandomString;
/* author : Vikram */

public class TripletsRuleTest {

	@Test
	void testClassTriplesRuleCheck() {
		ITripletsCardShowRule triples = RulesAbstractFactory.instance().checkTripletsCardShowRule();
		assertNotNull(triples);
	}

	@Test
	void testRuleColorPassCheck() {
		ITripletsCardShowRule triples = RulesAbstractFactory.instance().checkTripletsCardShowRule();
		ArrayList<Card> hands = new ArrayList<>();
		hands.add(0, new Card(Rank.values()[0], Suit.values()[0]));
		hands.add(1, new Card(Rank.values()[0], Suit.values()[1]));
		hands.add(2, new Card(Rank.values()[0], Suit.values()[2]));
		int i = triples.tripletsCardShowRule(hands);
		assertEquals(14, i);
	}

	@Test
	void testRuleColorFailCheck() {
		ITripletsCardShowRule triples = RulesAbstractFactory.instance().checkTripletsCardShowRule();
		ArrayList<Card> hands = new ArrayList<>();
		hands.add(0, new Card(Rank.values()[0], Suit.values()[0]));
		hands.add(1, new Card(Rank.values()[1], Suit.values()[1]));
		hands.add(2, new Card(Rank.values()[0], Suit.values()[2]));
		int i = triples.tripletsCardShowRule(hands);
		assertEquals(0, i);
	}

	@Test
	void testRule() {
		assertDoesNotThrow(() -> {
			Player player = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "vikram", 10000.0);
			BotPlayer bot = (BotPlayer) PlayerAbstractFactory.instance().createBotPlayer(RandomString.make(5), "Bot-1",
					10000.0);
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			players.add(bot);

			Game game = (Game) GameAbstractFactory.instance().createGame(players);
			ICardDistribution cardDistributor = GameAbstractFactory.instance().createCardDistributor();
			game = cardDistributor.distributeCards(players, game);

			ITripletsCardShowRule triples = RulesAbstractFactory.instance().checkTripletsCardShowRule();
			int i = triples.tripletsCardShowRule(game.getHands().get(player.getPlayerId()));
			GameAbstractFactory.instance().disableGame();
		});

	}

}
