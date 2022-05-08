/* @Author: Meshwa Savalia */
package com.cs5308.indian_flush.implementation.playbyturn;

import java.util.Scanner;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IAcceptPlayerName;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.player.PlayerAbstractFactory;

import net.bytebuddy.utility.RandomString;

/* @Author: Meshwa Savalia */
public class AcceptPlayerName implements IAcceptPlayerName {

	private static final Double INITIAL_AMOUNT = 10000.0;

	private static final int PLAYER_ID_LENGTH = 5;

	Player player;

	String username;

	/* @Author: Meshwa Savalia */
	public Player acceptPlayerName(Scanner scanner) {
		DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();

		while (true) {
			displayAbstractFactory.displayAcceptPlayerNameInputMessage().displayAcceptPlayerNameInputMessage();
			username = scanner.nextLine();
			if (username != null && !username.isEmpty()) {
				player = PlayerAbstractFactory.instance().createUserPlayer(RandomString.make(PLAYER_ID_LENGTH), username,
						INITIAL_AMOUNT);
				break;
			}
			else {
				displayAbstractFactory.displayAcceptPlayerNameErrorMessage().displayAcceptPlayerNameErrorMessage();
			}
		}
		displayAbstractFactory.displayAcceptPlayerNameSuccessMessage().displayAcceptPlayerNameSuccessMessage(username);
		return player;
	}
}
