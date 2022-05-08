/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayCallAndRaise;
import com.cs5308.indian_flush.implementation.game.Game;
import com.cs5308.indian_flush.implementation.player.Player;

public class DisplayCallAndRaise implements IDisplayCallAndRaise {
	public void callAndRaiseAmountMessage() {
		System.out.println("\nEnter amount to be raised");
	}

	public void lowBalanceMessage() {
		System.out.println("\nChoose another option: Cannot call the Bet “Insufficient Funds");
	}

	@Override
	public void invalidInputEnteredMessage() {
		System.out.println("Invalid Input Entered");
	}

	@Override
	public void raisedAmountMessage(Double amount) {
		System.out.println("Raised Amount is " + amount);
	}

	@Override
	public void displayPreviousBetAmount(Game game) {
		System.out.println("\nPrevious Bet Amount was " + game.getCurrentBetAmount());
	}

	@Override
	public void displayBalance(Player player) {
		System.out.println("\nPlayer balance - " + player.getWalletAmount() + "\n");
	}

	@Override
	public void displayMaxBetLimitReached() {
		System.out.println("\nMax Bet Limit Reached! Ending Game !!");

	}
}
