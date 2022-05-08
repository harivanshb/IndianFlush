/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplaySeeCards;
import com.cs5308.indian_flush.implementation.player.Player;

public class DisplaySeeCards implements IDisplaySeeCards {

	String cardNumber;
	String cardSuit;
	public void seeCards(Player player, int counter) {

		cardNumber = player.getHands().get(counter).getRank().getName().toUpperCase();
		cardSuit = player.getHands().get(counter).getSuit().toString().toUpperCase();
		System.out.println( cardNumber + " Of " + cardSuit + "\n");
	}

	@Override
	public void seeCardsInitialMessage(String player) {
		System.out.println("\n\nCards of Player " + player + " are:\n");
	}
}
