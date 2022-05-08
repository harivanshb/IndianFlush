/* @Author: Meshwa Savalia */

package com.cs5308.indian_flush.implementation.moves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.moves.abstractfactory.MovesAbstractFactory;
import com.cs5308.indian_flush.implementation.moves.interfaces.ISideShow;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IDeclareWinner;

/* @Author: Meshwa Savalia */
public class SideShow implements ISideShow {

	/* @Author: Meshwa Savalia */
	public void sideShow(String currentPlayerId, ArrayList<Player> players, HashMap<String, ArrayList<Card>> hands, Game game) {

		Boolean isSideShowAllowed;
		Boolean isCurrentOrPreviousPlayerBlind;
		String previousActivePlayerId;
		List<String> activePlayerList;
		HashMap<String, ArrayList<Card>> handsSideshowPlayers;

		MovesAbstractFactory movesAbstractFactory = MovesAbstractFactory.instance();
		DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();

		activePlayerList = movesAbstractFactory.getActivePlayersList().getActivePlayersList(players);
		previousActivePlayerId = movesAbstractFactory.getPreviousPlayerID().getPreviousPlayerID(currentPlayerId, activePlayerList);
		isCurrentOrPreviousPlayerBlind = movesAbstractFactory.isCurrentOrPreviousPlayerBlind().isCurrentOrPreviousPlayerBlind(currentPlayerId, previousActivePlayerId, players);
		isSideShowAllowed = movesAbstractFactory.validateSideShow().validateSideShow(isCurrentOrPreviousPlayerBlind, activePlayerList);

		if (Boolean.TRUE.equals(isSideShowAllowed)) {

			handsSideshowPlayers = movesAbstractFactory.getHandsOfSideShowPlayers().getHandsOfSideShowPlayers(currentPlayerId, previousActivePlayerId, hands);
			Boolean isPlayerLost = movesAbstractFactory.decideSideShowWinner().decideSideShowWinner(handsSideshowPlayers, players, game);

			if (Boolean.TRUE.equals(isPlayerLost)) {
				IDeclareWinner declareWinner = WinnerDeclarationAbstractFactory.instance().declareWinner();
				game.setGameEnd(true);
				declareWinner.declareWinner(game);
			}
		}
		else {
			displayAbstractFactory.displaySideShowRejectedMessage().displaySideShowRejectedMessage();
			game.setMoveToNextPlayer(false);
		}
	}
}
