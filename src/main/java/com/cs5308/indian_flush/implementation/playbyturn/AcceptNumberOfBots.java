/* @Author: Meshwa Savalia */

package com.cs5308.indian_flush.implementation.playbyturn;

import java.util.ArrayList;
import java.util.Scanner;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IAcceptNumberOfBots;
import com.cs5308.indian_flush.implementation.player.BotPlayer;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;

import net.bytebuddy.utility.RandomString;

/* @Author: Meshwa Savalia */
public class AcceptNumberOfBots implements IAcceptNumberOfBots {

	private static final Double INITIAL_AMOUNT = 10000.0;

	private static final int MIN_PLAYERS = 2;

	private static final int MAX_PLAYERS = 6;

	int playerCount = 1;

	ArrayList<Player> players;

	int numberOfBots;

	/* @Author: Meshwa Savalia */
	public ArrayList<Player> acceptNumberOfBots(Player player, Scanner scanner) {

		DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();

		while (true) {
			displayAbstractFactory.displayNumberOfBotsInputMessage()
					.displayNumberOfBotsInputMessage(player.getPlayerName());

			numberOfBots = scanner.nextInt();

			if (numberOfBots > MIN_PLAYERS && numberOfBots < MAX_PLAYERS) {
				players = new ArrayList<>();

				displayAbstractFactory.displayNumberOfBotsSuccessMessage()
						.displayNumberOfBotsSuccessMessage(playerCount++, player.getPlayerName());

				for (int index = 1; index <= numberOfBots; index++) {
					BotPlayer bot = (BotPlayer) PlayerAbstractFactory.instance().createBotPlayer(RandomString.make(5), "Bot-" + index, INITIAL_AMOUNT);
					players.add(bot);
					displayAbstractFactory.displayNumberOfBotsSuccessMessage().displayNumberOfBotsSuccessMessage(playerCount++, bot.getPlayerName());
				}
				players.add(player);
				break;
			}
			else {
				displayAbstractFactory.displayNumberOfBotsErrorMessage().displayNumberOfBotsErrorMessage();
			}
		}
		return players;
	}
}
