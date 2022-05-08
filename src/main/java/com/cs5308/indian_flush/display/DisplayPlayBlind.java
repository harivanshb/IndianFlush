/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayPlayBlind;
import com.cs5308.indian_flush.implementation.player.Player;

public class DisplayPlayBlind implements IDisplayPlayBlind {
	@Override
	public void displayPlayBlindSuccessMessage(Player player) {
		System.out.println("Player " + player.getPlayerName() + " is playing blind");
	}

	@Override
	public void displayPlayBlindFailMessage(Player player) {
		System.out.println("Player " + player.getPlayerName()
				+ " has already seen the cards, cannot play blind. Choose another option");
	}
}
