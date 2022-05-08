/* @Author: Meshwa Savalia */
package com.cs5308.indian_flush.implementation.moves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cs5308.indian_flush.display.factory.DisplayAbstractFactory;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.moves.interfaces.ISideShowAccept;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IWinnerDeclarationCheck;

/* @Author: Meshwa Savalia */
public class SideShowAccept implements ISideShowAccept {
	String winnerPlayer = "";
	Boolean playerLost = false;

	/* @Author: Meshwa Savalia */
	public HashMap<String, ArrayList<Card>> getHandsOfSideShowPlayers(String currentPlayerId, String previousActivePlayerId, HashMap<String, ArrayList<Card>> hands) {

		HashMap<String, ArrayList<Card>> handsSideshowPlayers = new HashMap<>();
		handsSideshowPlayers.put(String.valueOf(currentPlayerId), hands.get(String.valueOf(currentPlayerId)));
		handsSideshowPlayers.put(String.valueOf(previousActivePlayerId), hands.get(String.valueOf(previousActivePlayerId)));
		return handsSideshowPlayers;
	}

	/* @Author: Meshwa Savalia */
	public Boolean decideSideShowWinner(HashMap<String, ArrayList<Card>> handsSideshowPlayers, ArrayList<Player> players, Game game) {

		IWinnerDeclarationCheck winnerDeclare = WinnerDeclarationAbstractFactory.instance().winnerDeclarationCheck();
		DisplayAbstractFactory displayAbstractFactory = DisplayAbstractFactory.instance();
		HashMap<String, Integer> ranking = winnerDeclare.rankHandsAndDecideWinner(handsSideshowPlayers);

		for (Map.Entry<String, Integer> mapEntry : ranking.entrySet()) {
			if (mapEntry.getValue() != null && mapEntry.getValue().equals(1)) {
				winnerPlayer = mapEntry.getKey();
			}
			if (mapEntry.getValue() != null && mapEntry.getValue().equals(2)) {
				String playerToRemove = mapEntry.getKey();
				for (Player player : players) {
					if (player.getPlayerId().equals(playerToRemove)) {
						player.setPlayersIsActiveMapping(false);
						displayAbstractFactory.displaySideShowLoser().displaySideShowLoser(player.getPlayerId());

						if (Boolean.FALSE.equals(player.getIsBot())) {
							displayAbstractFactory.displayUserLostSideShow().displayUserLostSideShow();
							playerLost = true;
						}
					}
					else if (player.getPlayerId().equalsIgnoreCase(winnerPlayer)) {
						displayAbstractFactory.displaySideShowWinner().displaySideShowWinner(player.getPlayerId());
					}
				}
			}
		}
		game.setPlayers(players);
		return playerLost;
	}
}
