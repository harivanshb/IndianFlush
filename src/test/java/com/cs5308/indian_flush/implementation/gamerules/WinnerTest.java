package com.cs5308.indian_flush.implementation.gamerules;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.game.cards.ICardDistribution;
import com.cs5308.indian_flush.implementation.player.BotPlayer;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IDeclareWinner;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IWinnerDeclarationCheck;

import net.bytebuddy.utility.RandomString;
/* author : Vikram */

public class WinnerTest {

	@Test
	void testWinnerDeclarationCall() {

		assertDoesNotThrow(() -> {

			IWinnerDeclarationCheck winnerDeclarationCheck = WinnerDeclarationAbstractFactory.instance()
					.winnerDeclarationCheck();

			Player player = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(5), "vikram", 10000.0);
			BotPlayer bot = (BotPlayer) PlayerAbstractFactory.instance().createBotPlayer(RandomString.make(5), "Bot-1",
					10000.0);
			ArrayList<Player> players = new ArrayList<>();
			players.add(player);
			players.add(bot);

			Game game = (Game) GameAbstractFactory.instance().createGame(players);
			ICardDistribution cardDistributor = GameAbstractFactory.instance().createCardDistributor();
			game = cardDistributor.distributeCards(players, game);

			HashMap<String, Integer> result = winnerDeclarationCheck.rankHandsAndDecideWinner(game.getHands());
			assertNotNull(result);
			assertNotNull(result.values());
			GameAbstractFactory.instance().disableGame();
		});

	}

}
