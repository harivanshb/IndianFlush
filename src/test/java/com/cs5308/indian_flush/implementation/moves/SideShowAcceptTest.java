package com.cs5308.indian_flush.implementation.moves;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.game.cards.ICardDistribution;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.game.cards.model.Rank;
import com.cs5308.indian_flush.implementation.game.cards.model.Suit;
import com.cs5308.indian_flush.implementation.moves.abstractfactory.MovesAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.interfaces.ISideShowAccept;
import com.cs5308.indian_flush.implementation.player.BotPlayer;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;

import net.bytebuddy.utility.RandomString;

/* @Author: Meshwa*/
public class SideShowAcceptTest {

	@Test
	void testSideShowAcceptCheck() throws ClassNotFoundException {
		Class<?> sideShowAcceptClass = Class.forName("com.cs5308.indian_flush.implementation.moves.SideShowAccept");
		assertNotNull(sideShowAcceptClass);
	}

	@Test
	void getHandsOfSideShowPlayersTest() {
		Player player1 = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "vikram", 10000.0);
		Player player2 = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "tanvi", 10000.0);
		Player player3 = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "meshwa", 10000.0);

		ArrayList<Card> handsPlayer1 = new ArrayList<>();
		handsPlayer1.add(0, new Card(Rank.values()[0], Suit.values()[0]));
		handsPlayer1.add(1, new Card(Rank.values()[1], Suit.values()[0]));
		handsPlayer1.add(2, new Card(Rank.values()[1], Suit.values()[0]));

		ArrayList<Card> handsPlayer2 = new ArrayList<>();
		handsPlayer2.add(0, new Card(Rank.values()[1], Suit.values()[1]));
		handsPlayer2.add(1, new Card(Rank.values()[2], Suit.values()[2]));
		handsPlayer2.add(2, new Card(Rank.values()[2], Suit.values()[3]));

		ArrayList<Card> handsPlayer3 = new ArrayList<>();
		handsPlayer3.add(0, new Card(Rank.values()[2], Suit.values()[2]));
		handsPlayer3.add(1, new Card(Rank.values()[3], Suit.values()[0]));
		handsPlayer3.add(2, new Card(Rank.values()[3], Suit.values()[1]));

		player1.setHands(handsPlayer1);
		player2.setHands(handsPlayer2);
		player3.setHands(handsPlayer3);

		HashMap<String, ArrayList<Card>> hands = new HashMap<>();
		hands.put(player1.getPlayerId(), handsPlayer1);
		hands.put(player2.getPlayerId(), handsPlayer2);
		hands.put(player3.getPlayerId(), handsPlayer3);

		HashMap<String, ArrayList<Card>> handsExpected = new HashMap<>();
		handsExpected.put(player1.getPlayerId(), handsPlayer1);
		handsExpected.put(player2.getPlayerId(), handsPlayer2);

		ISideShowAccept sideShowAccept = MovesAbstractFactory.instance().getHandsOfSideShowPlayers();
		Assertions.assertEquals(handsExpected,
				sideShowAccept.getHandsOfSideShowPlayers(player1.getPlayerId(), player2.getPlayerId(), hands));

	}

	@Test
	public void sideShowTest() {

		assertDoesNotThrow(() -> {
			Player player = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "vikram", 10000.0);
			BotPlayer bot = (BotPlayer) PlayerAbstractFactory.instance().createBotPlayer(RandomString.make(5), "Bot-1",
					10000.0);

			BotPlayer bot1 = (BotPlayer) PlayerAbstractFactory.instance().createBotPlayer(RandomString.make(5), "Bot-2",
					10000.0);
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			players.add(bot);
			players.add(bot1);

			Game game = (Game) GameAbstractFactory.instance().createGame(players);
			assertNotNull(game);

			ICardDistribution cardDistributor = GameAbstractFactory.instance().createCardDistributor();
			players.forEach(setPlayer -> setPlayer.setPlayersIsBlindMapping(true));
			players.forEach(setPlayer -> setPlayer.setPlayerPackCardsMapping(false));
			game.setGameEnd(false);
			game.setActivePlayer(players.get(0));
			game = cardDistributor.distributeCards(players, game);

			MovesAbstractFactory movesAbstractFactory = MovesAbstractFactory.instance();
			movesAbstractFactory.sideShow().sideShow(player.getPlayerId(), players, game.getHands(), game);
			GameAbstractFactory.instance().disableGame();
		});

	}
}
