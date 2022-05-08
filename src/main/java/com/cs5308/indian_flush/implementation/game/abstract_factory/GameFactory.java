package com.cs5308.indian_flush.implementation.game.abstract_factory;

import java.util.ArrayList;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.game.cards.CardsDistribution;
import com.cs5308.indian_flush.implementation.game.cards.ICardDistribution;
import com.cs5308.indian_flush.implementation.player.Player;

/* @Author: Vikram */
public class GameFactory extends GameAbstractFactory {

	@Override
	public AbstractGame createGame() {
		return Game.instance();
	}

	@Override
	public AbstractGame createGame(ArrayList<Player> players) {
		return Game.instance(players);
	}

	@Override
	public ICardDistribution createCardDistributor() {

		return CardsDistribution.instance();
	}

	@Override
	public void disableGame() {
		Game.disable();
	}

}
