package com.cs5308.indian_flush.implementation.playbyturn;

import java.util.ArrayList;
import java.util.Scanner;

import com.cs5308.indian_flush.database.abstractfactory.GameDaoAbstractFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.abstract_factory.GameAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.abstractfactory.MovesAbstractFactory;
import com.cs5308.indian_flush.implementation.playbyturn.abstractfactory.TurnManagerAbstractFactory;
import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IPlayByTurn;
import com.cs5308.indian_flush.implementation.player.Bot;
import com.cs5308.indian_flush.implementation.player.Player;

/* @Author: Meshwa Savalia */
public class PlayByTurn implements IPlayByTurn {

	private Game game;
	Logger LOGGER = LoggerFactory.getLogger(PlayByTurn.class);
	DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();

	private static final Double BOOT_AMT = 10.0;
	private static final Double MAX_BET = 1280.0;
	private static final Double POT_LIMIT = 10240.0;
	private static final int MAX_BLINDS = 4;

	/* @Author: Meshwa Savalia */
	@Override
	public void initiateGame() throws Exception {

		Scanner scanner = new Scanner(System.in);
		Player player = TurnManagerAbstractFactory.instance().acceptPlayerName().acceptPlayerName(scanner);

		ArrayList<Player> players = TurnManagerAbstractFactory.instance().acceptNumberOfBots()
				.acceptNumberOfBots(player, scanner);

		game = (Game) GameAbstractFactory.instance().createGame(players);
		GameAbstractFactory.instance().createCardDistributor().distributeCards(players, game);
		game = getGameConfigFromUser(game, scanner);
		setInitialPlayersConfig(players);
		GameDaoAbstractFactory gameDao = GameDaoAbstractFactory.instance();
		gameDao.createDao().insertPlayerDataToWallet(players);
		MovesAbstractFactory moves = MovesAbstractFactory.instance();

		try {
			while (Boolean.FALSE.equals(game.isGameEnd())) {
				displayAbstractFactory.displayCurrentPlayer().displayCurrentPlayer(
						game.getActivePlayer().getPlayerName(), game.getActivePlayer().getPlayerId());

				if (Boolean.FALSE.equals(game.getActivePlayer().getIsBot())) {
					if (Boolean.FALSE.equals(moves.playerMoves().playerMove(game, game.getActivePlayer(), players, game.getHands(), scanner))) {
						continue;
					}
				} else {
					Bot botPlayer = (Bot) game.getActivePlayer();
					String nextMove = botPlayer.decidePlayerAction(botPlayer.getPlayerId(), game.getHands());
					moves.playerMoves().botMove(nextMove, game, game.getActivePlayer(), players, game.getHands());
				}

			}
		} catch (Exception exception) {
			LOGGER.error("Something went wrong! ", exception);
		}
		displayAbstractFactory.displayEndGameMessage().displayEndGameMessage(player.getPlayerName());
		scanner.close();
		}

	/* @Author: Meshwa Savalia */
	public Game getGameConfigFromUser(Game game, Scanner scanner) throws Exception {
		game.setGameDetails(BOOT_AMT, MAX_BET, POT_LIMIT, MAX_BLINDS);
		return game;
	}

	/* @Author: Tanvi Pruthi */
	public void setInitialPlayersConfig(ArrayList<Player> players) {
		players.forEach(setPlayer -> setPlayer.setPlayersIsBlindMapping(true));
		players.forEach(setPlayer -> setPlayer.setPlayerPackCardsMapping(false));
		game.setGameEnd(false);
		game.setActivePlayer(players.get(0));
	}

	/* @Author: Meshwa Savalia */
	public Game getGameObject() throws Exception {
		return this.game;
	}
}
