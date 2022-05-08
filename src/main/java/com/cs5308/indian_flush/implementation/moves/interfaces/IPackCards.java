/* @Author: Harivansh Bhatia */

package com.cs5308.indian_flush.implementation.moves.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.player.Player;

public interface IPackCards {
	Game packCards(Game game, ArrayList<Player> players, Player player, HashMap<String, ArrayList<Card>> hands);
}
