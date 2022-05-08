/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayNumberOfBotsInput;

public class DisplayNumberOfBotsInput implements IDisplayNumberOfBotsInput {
	public void displayNumberOfBotsInputMessage(String playerName) {
		System.out.println("\nHello " + playerName
				+ "! Please enter with how many bots you want to play with ? ( Enter a number between 3 to 5 )");
		System.out.print(">> ");
	}

	public void displayNumberOfBotsErrorMessage() {
		System.out.println("Please enter a number between 3 to 5");
	}

	public void displayNumberOfBotsSuccessMessage(int playerCount, String playerName) {
		if (playerCount == 1) {
			System.out.println("\nPlayers involved in the game : \n");
		}
		System.out.println(playerCount + ". " + playerName);
	}
}
