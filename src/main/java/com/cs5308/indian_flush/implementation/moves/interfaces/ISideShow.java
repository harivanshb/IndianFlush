/* @Author: Meshwa Savalia */

package com.cs5308.indian_flush.implementation.moves.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.player.Player;

/* @Author: Meshwa Savalia */
public interface ISideShow {
	void sideShow(String currentPlayerId, ArrayList<Player> players, HashMap<String, ArrayList<Card>> hands, Game game);
}
