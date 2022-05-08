/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.gamerules;

import com.cs5308.indian_flush.implementation.gamerules.interfaces.ISortCardsDescendingOrder;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortCardsDescendingOrder implements ISortCardsDescendingOrder {
	Integer[] cardsSortingArray;
	int firstCardValue;
	int secondCardValue;
	int thirdCardValue;

	public Integer[] sortCardsDescendingOrder(ArrayList<Card> hands) {
		firstCardValue = hands.get(0).getRank().getValue();
		secondCardValue = hands.get(1).getRank().getValue();
		thirdCardValue = hands.get(2).getRank().getValue();

		cardsSortingArray = new Integer[]{ firstCardValue, secondCardValue, thirdCardValue };
		Arrays.sort(cardsSortingArray, Collections.reverseOrder());
		return cardsSortingArray;
	}
}
