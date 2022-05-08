/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display.interfaces;

import com.cs5308.indian_flush.implementation.player.Player;

public interface IDisplaySeeCards {
	void seeCards(Player player, int counter);

	void seeCardsInitialMessage(String player);
}
