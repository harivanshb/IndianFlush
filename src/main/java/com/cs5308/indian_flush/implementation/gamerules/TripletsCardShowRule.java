/* @Author: Vikram*/

package com.cs5308.indian_flush.implementation.gamerules;

import java.util.ArrayList;

import com.cs5308.indian_flush.implementation.gamerules.interfaces.ITripletsCardShowRule;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;

public class TripletsCardShowRule implements ITripletsCardShowRule {
	int firstCardOrder;
	int secondCardOrder;
	int thirdCardOrder;
	int cardTripletsValue = 0;

	public int tripletsCardShowRule(ArrayList<Card> hands) {
		firstCardOrder = hands.get(0).getRank().getOrder();
		secondCardOrder = hands.get(1).getRank().getOrder();
		thirdCardOrder = hands.get(2).getRank().getOrder();

		if (firstCardOrder == secondCardOrder && secondCardOrder == thirdCardOrder) {
			cardTripletsValue = hands.get(0).getRank().getValue();
		}
		return cardTripletsValue;
	}
}
