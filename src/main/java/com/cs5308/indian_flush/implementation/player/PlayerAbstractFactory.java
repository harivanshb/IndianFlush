package com.cs5308.indian_flush.implementation.player;
/* @Author: Vikram */
public abstract class PlayerAbstractFactory {

	private static PlayerAbstractFactory factoryInstance;

	public static PlayerAbstractFactory instance() {

		if (factoryInstance == null) {
			factoryInstance = new PlayerFactory();
		}

		return factoryInstance;
	}

	public abstract Player createUserPlayer();

	public abstract Player createBotPlayer();

	public abstract Player createUserPlayer(String playerId, String playerName, double walletAmount);
	
	public abstract Player createBotPlayer(String playerId, String playerName, double walletAmount);

}
