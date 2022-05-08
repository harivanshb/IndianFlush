package com.cs5308.indian_flush.game;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.game.cards.ICardDistribution;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.player.BotPlayer;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;

import net.bytebuddy.utility.RandomString;
/* author : Vikram */
public class CardDistributionTest {

	@Test
	public void testDistribitorObject() {
		ICardDistribution cardDistributor = GameAbstractFactory.instance().createCardDistributor();
		assertNotNull(cardDistributor);

	}

	public void testDistributeCards() {

		Player player = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "vikram", 10000.0);
		BotPlayer bot = (BotPlayer) PlayerAbstractFactory.instance().createBotPlayer(RandomString.make(5), "Bot-1",
				10000.0);
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		players.add(bot);

		Game game = (Game) GameAbstractFactory.instance().createGame(players);
		assertNotNull(game);

		ICardDistribution cardDistributor = GameAbstractFactory.instance().createCardDistributor();
		game = cardDistributor.distributeCards(players, game);

		assertNotNull(game.getHands());

		for (Map.Entry<String, ArrayList<Card>> mapEntry : game.getHands().entrySet()) {

			for (Card card : mapEntry.getValue()) {
				assertNotNull(card);
				assertNotNull(card.getRank());
				assertNotNull(card.getSuit());
				assertNotNull(card.getRank().getValue());
				assertNotNull(card.getSuit().getLetter());
			}

		}

		GameAbstractFactory.instance().disableGame();

	}
}
