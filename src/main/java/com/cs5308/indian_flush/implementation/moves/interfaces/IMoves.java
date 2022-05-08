/* @Author: Tanvi Pruthi */

package com.cs5308.indian_flush.implementation.moves.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.player.Player;

public interface IMoves {
	Boolean playerMove(Game game, Player player, ArrayList<Player> players, HashMap<String, ArrayList<Card>> hands,
			Scanner scanner);

	void botMove(String move, Game game, Player player, ArrayList<Player> players, HashMap<String, ArrayList<Card>> hands);
}
