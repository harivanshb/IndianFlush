package com.cs5308.indian_flush.implementation.player;

/* @Author: Vikram */
public class UserPlayer extends Player {

	public static Player instance() {
		return new UserPlayer();
	}

	public static Player instance(String playerID, String name, double walletAmount) {

		return new UserPlayer(playerID, name, walletAmount);
	}

	UserPlayer() {
	}

	UserPlayer(String playerId, String name, double walletAmount) {
		this.playerId = playerId;
		this.playerName = name;
		this.walletAmount = walletAmount;
		this.isBot = false;
	}

}
