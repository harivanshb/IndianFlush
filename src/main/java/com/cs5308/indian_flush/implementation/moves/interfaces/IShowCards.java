/* @Author: Harivansh Bhatia*/

package com.cs5308.indian_flush.implementation.moves.interfaces;

import java.util.ArrayList;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.player.Player;

public interface IShowCards {
	void showCards(ArrayList<Player> players, Game game);
}
