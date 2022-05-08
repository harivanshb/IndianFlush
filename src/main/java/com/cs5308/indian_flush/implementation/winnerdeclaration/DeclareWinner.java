/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.winnerdeclaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.player.Player;
import com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory.WinnerDeclarationAbstractFactory;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IDeclareWinner;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IWinnerDeclarationCheck;

public class DeclareWinner implements IDeclareWinner {

	public void declareWinner(Game game) {
		IWinnerDeclarationCheck winnerDeclarationCheck = WinnerDeclarationAbstractFactory.instance()
				.winnerDeclarationCheck();

		HashMap<String, ArrayList<Card>> hands = game.getHands();
		HashMap<String, Integer> ranking = winnerDeclarationCheck.rankHandsAndDecideWinner(hands);

		ArrayList<String> players = new ArrayList<String>();

		ArrayList<Player> playerList = game.getPlayers();
		for (Player player : playerList) {
			players.add(player.getPlayerId());
		}

		Entry<String, Integer> min = null;
		for (Entry<String, Integer> entry : ranking.entrySet()) {
			if (players.contains(entry.getKey())) {
				if (min == null || min.getValue() > entry.getValue()) {
					min = entry;
				}
			}
		}
		String winner = min.getKey();
		for (Player player : playerList) {
			if (player.getPlayerId().equalsIgnoreCase(winner)) {
				System.out.println("\n\nWinner: Player " + player.getPlayerName());
				System.out.println("Winning Amount : " + game.getChipsOnTable());
			}
		}

	}
}
