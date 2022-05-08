package com.cs5308.indian_flush.implementation.game;

import java.util.ArrayList;
import java.util.HashMap;

import com.cs5308.indian_flush.implementation.game.abstract_factory.AbstractGame;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.player.Player;

import net.bytebuddy.utility.RandomString;

/* @Author: Vikram */
public class Game extends AbstractGame {

	public static final int HAND_SIZE = 3;

	private HashMap<String, ArrayList<Card>> hands;

	private ArrayList<Player> players;

	private Player activePlayer;

	private int activePlayerIndex;

	private HashMap<String, Integer> playerHandRanking;

	private String gameId;

	private Double bootAmount;

	private Double chaalLimit;

	private Double potLimit;

	private int maxBlinds;

	private Double currentBetAmount;

	private Double currentBlindBetAmount;

	private Double chipsOnTable;

	private Boolean isChaalLimitReached;

	private Boolean gameEnd;

	private static AbstractGame game;

	private Boolean moveToNextPlayer;

	private Game(ArrayList<Player> players) {
		this.players = players;
		activePlayer = players.get(0);
		activePlayerIndex = 0;
		gameId = RandomString.make(5);
	}

	private Game() {
	}

	@Override
	public void setGameDetails(Double bootAmount, Double chaalLimit, Double potLimit, int maxBlinds) {
		this.bootAmount = bootAmount;
		this.chaalLimit = chaalLimit;
		this.potLimit = potLimit;
		this.maxBlinds = maxBlinds;
		this.currentBetAmount = bootAmount;
		this.currentBlindBetAmount = bootAmount;
		this.chipsOnTable = bootAmount * players.size();
		this.isChaalLimitReached = false;
		this.gameEnd = false;
	}

	public static int getHandSize() {
		return HAND_SIZE;
	}

	public static AbstractGame instance() {
		if (game == null) {
			game = new Game();
		}
		return game;
	}

	public static AbstractGame instance(ArrayList<Player> players) {
		if (game == null) {
			game = new Game(players);
		}
		return game;
	}

	public static void disable() {
		game = null;
	}

	public HashMap<String, ArrayList<Card>> getHands() {
		return hands;
	}

	public void setHands(HashMap<String, ArrayList<Card>> hands) {
		this.hands = hands;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public int getActivePlayerIndex() {
		return activePlayerIndex;
	}

	public void setActivePlayerIndex(int activePlayerIndex) {
		this.activePlayerIndex = activePlayerIndex;
	}

	public Double getBootAmount() {
		return bootAmount;
	}

	public Double getPotLimit() {
		return potLimit;
	}

	public Double getCurrentBetAmount() {
		return currentBetAmount;
	}

	public void setCurrentBetAmount(Double currentBetAmount) {
		this.currentBetAmount = currentBetAmount;
	}

	public Double getChipsOnTable() {
		return chipsOnTable;
	}

	public void setChipsOnTable(Double chipsOnTable) {
		this.chipsOnTable = chipsOnTable;
	}

	public Boolean isGameEnd() {
		return gameEnd;
	}

	public void setGameEnd(Boolean gameEnd) {
		this.gameEnd = gameEnd;
	}

	public Boolean isMoveToNextPlayer() {
		return moveToNextPlayer;
	}

	public void setMoveToNextPlayer(Boolean moveToNextPlayer) {
		this.moveToNextPlayer = moveToNextPlayer;
	}

}
