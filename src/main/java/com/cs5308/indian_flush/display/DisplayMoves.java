/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayMoves;

public class DisplayMoves implements IDisplayMoves {
	@Override
	public void displayMoves() {
		System.out.println("################\n\nChoose the move and enter the choice number:\n1. Pack Cards"
				+ "\n2. Call and Raise\n3. SideShow\n4. Play Blind\n5. See Cards\n6. Show Cards\n################");
	}

	public void displayInvalidMoves() {
		System.out.println("Invalid move selected, please select another option");
	}

	@Override
	public void displayBotMove(String player, String move) {
		System.out.println("\n####### Player " + player + " played a " + move + " #######");
	}
}
