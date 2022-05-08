/* @Author: Vikram*/

package com.cs5308.indian_flush.implementation.gamerules;

import com.cs5308.indian_flush.implementation.gamerules.interfaces.ICheckConsecutiveCards;

public class CheckConsecutiveCards implements ICheckConsecutiveCards {
	int minCardValue = 0;
	int maxCardValue = 0;
	int CONSECUTIVE_CARDS_DIFFERENCE = 2;
	boolean checkConsecutiveCards;

	public boolean checkConsecutiveCards(int firstCardValue, int secondCardValue, int thirdCardValue) {
		minCardValue = Math.min(firstCardValue, Math.min(secondCardValue, thirdCardValue));
		maxCardValue = Math.max(firstCardValue, Math.max(secondCardValue, thirdCardValue));
		checkConsecutiveCards = maxCardValue - minCardValue == CONSECUTIVE_CARDS_DIFFERENCE && firstCardValue != secondCardValue
				&& firstCardValue != thirdCardValue && secondCardValue != thirdCardValue;
		return checkConsecutiveCards;
	}
}
