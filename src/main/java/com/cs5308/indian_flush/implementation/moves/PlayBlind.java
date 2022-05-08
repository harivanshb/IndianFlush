/* @Author: Tanvi Pruthi */

package com.cs5308.indian_flush.implementation.moves;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.moves.interfaces.IPlayBlind;
import com.cs5308.indian_flush.implementation.player.Player;

public class PlayBlind extends Moves implements IPlayBlind {

	public void setPlayersBlind(Player player, Game game) {
		DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();
		if (Boolean.FALSE.equals(player.getPlayersIsBlindMapping())) {
			game.setMoveToNextPlayer(false);
			displayAbstractFactory.displayPlayBlindFailMessage().displayPlayBlindFailMessage(player);
		} else {
			player.setPlayersIsBlindMapping(true);
			game.setMoveToNextPlayer(true);
			displayAbstractFactory.displayPlayBlindSuccessMessage().displayPlayBlindSuccessMessage(player);
		}
	}
}
