package com.cs5308.indian_flush.implementation.game.abstract_factory;

import java.util.ArrayList;

import com.cs5308.indian_flush.implementation.game.cards.ICardDistribution;
import com.cs5308.indian_flush.implementation.player.Player;

/* @Author: Vikram */
public abstract class GameAbstractFactory {

	private static GameAbstractFactory factoryInstance;

	public static GameAbstractFactory instance() {
		if (factoryInstance == null) {
			factoryInstance = new GameFactory();
		}
		return factoryInstance;
	}

	public abstract AbstractGame createGame();

	public abstract AbstractGame createGame(ArrayList<Player> players);

	public abstract ICardDistribution createCardDistributor();

	public abstract void disableGame();

}
