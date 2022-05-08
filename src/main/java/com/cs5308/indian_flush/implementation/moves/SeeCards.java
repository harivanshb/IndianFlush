/* @Author: Tanvi Pruthi */

package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.moves.interfaces.ISeeCards;
import com.cs5308.indian_flush.implementation.player.Player;

public class SeeCards implements ISeeCards {
	DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();

	public void seeCards(Player player, Game game) {
		if (Boolean.FALSE.equals(player.getIsBot())) {
			displayAbstractFactory.displayInitialSeeCardsMessage().seeCardsInitialMessage(player.getPlayerName());
			for (int index = 0; index < Game.getHandSize(); index++) {
				displayAbstractFactory.displaySeeCards().seeCards(player, index);
			}
		}
		setBlindMapping(player);
	}

	public void setBlindMapping(Player player) {
		player.setPlayersIsBlindMapping(false);
	}
}
