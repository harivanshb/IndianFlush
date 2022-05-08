package com.cs5308.indian_flush.implementation.player;

import java.util.ArrayList;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;

/* @Author: Vikram */
public abstract class Player {

	String playerId;

	String playerName;

	Double walletAmount;

	ArrayList<Card> hands;

	Boolean playersIsBlindMapping;

	Boolean playersIsActiveMapping;

	Boolean playersPackedCards;

	Boolean isBot;

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Double getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(Double walletAmount) {
		this.walletAmount = walletAmount;
	}

	public ArrayList<Card> getHands() {
		return hands;
	}

	public void setHands(ArrayList<Card> hands) {
		this.hands = hands;
	}

	public Boolean getPlayersIsBlindMapping() {
		return playersIsBlindMapping;
	}

	public void setPlayersIsBlindMapping(Boolean playersIsBlindMapping) {
		this.playersIsBlindMapping = playersIsBlindMapping;
	}

	public Boolean getPlayersIsActiveMapping() {
		return playersIsActiveMapping;
	}

	public void setPlayersIsActiveMapping(Boolean playersIsBlindMapping) {
		this.playersIsActiveMapping = playersIsBlindMapping;
	}

	public void setPlayerPackCardsMapping(Boolean playersPackedCards) {
		this.playersPackedCards = playersPackedCards;
	}

	public Boolean hasPlayerNotPackedCardsMapping() {
		return !playersPackedCards;
	}

	public Boolean getIsBot() {
		return isBot;
	}

}
