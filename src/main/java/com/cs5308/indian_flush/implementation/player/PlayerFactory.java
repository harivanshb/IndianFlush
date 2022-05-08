package com.cs5308.indian_flush.implementation.player;
/* @Author: Vikram */
public class PlayerFactory extends PlayerAbstractFactory {

	@Override
	public Player createUserPlayer() {
		return UserPlayer.instance();
	}

	@Override
	public Player createBotPlayer() {
		return BotPlayer.instance();
	}

	@Override
	public Player createUserPlayer(String playerId, String playerName, double walletAmount) {
		return UserPlayer.instance(playerId, playerName, walletAmount);
	}

	@Override
	public Player createBotPlayer(String playerId, String playerName, double walletAmount) {
		return BotPlayer.instance(playerId, playerName, walletAmount);
	}

}
