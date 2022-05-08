package com.cs5308.indian_flush.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.player.BotPlayer;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;

import net.bytebuddy.utility.RandomString;
/* author : Vikram */

public class GameTest {

	@Test
	public void gameTest() {

		Game game = (Game) GameAbstractFactory.instance().createGame();
		assertNotNull(game);
		GameAbstractFactory.instance().disableGame();
	}

	@Test
	public void gameTestWithPlayers() {

		Player player = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "vikram", 10000.0);
		BotPlayer bot = (BotPlayer) PlayerAbstractFactory.instance().createBotPlayer(RandomString.make(5), "Bot-1",
				10000.0);
		ArrayList<Player> players = new ArrayList<>();
		players.add(player);
		players.add(bot);

		Game game = (Game) GameAbstractFactory.instance().createGame(players);
		assertNotNull(game);
		GameAbstractFactory.instance().disableGame();
	}

	@Test
	public void gameTestWithPlayersAndConfig() {

		Player player = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "vikram", 10000.0);
		BotPlayer bot = (BotPlayer) PlayerAbstractFactory.instance().createBotPlayer(RandomString.make(5), "Bot-1",
				10000.0);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player);
		players.add(bot);

		Game game = (Game) GameAbstractFactory.instance().createGame(players);
		GameAbstractFactory.instance().createCardDistributor().distributeCards(players, game);
		game.setGameDetails((double) 10, (double) 1280, (double) 10240, 4);
		assertNotNull(game);
		assertEquals(game.getBootAmount(), 10);
		GameAbstractFactory.instance().disableGame();
	}

}
