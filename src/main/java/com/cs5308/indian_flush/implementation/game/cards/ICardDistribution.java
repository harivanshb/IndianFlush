package com.cs5308.indian_flush.implementation.game.cards;

import java.util.ArrayList;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.player.Player;
/* @Author: Vikram */
public interface ICardDistribution {

	public Game distributeCards(ArrayList<Player> players, Game game);

}
