/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display.interfaces;

import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.player.Player;

public interface IDisplayCallAndRaise {
	void callAndRaiseAmountMessage();

	void lowBalanceMessage();

	void invalidInputEnteredMessage();

	void raisedAmountMessage(Double amount);

	void displayPreviousBetAmount(Game game);

	void displayBalance(Player player);

	void displayMaxBetLimitReached();
}
