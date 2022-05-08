/* @Author: Harivansh Bhatia */

package com.cs5308.indian_flush.implementation.moves.interfaces;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.player.Player;

public interface ICallAndRaise {
	Game callAndRaise(Player player, Game game, double raisedAmount) throws Exception;
}
