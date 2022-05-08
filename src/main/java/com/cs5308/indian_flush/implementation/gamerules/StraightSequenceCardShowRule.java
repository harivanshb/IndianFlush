/* @Author: Vikram*/

package com.cs5308.indian_flush.implementation.gamerules;

import java.util.ArrayList;

import com.cs5308.indian_flush.implementation.gamerules.abstractfactory.RulesAbstractFactory;
import com.cs5308.indian_flush.implementation.gamerules.interfaces.IStraightSequenceCardShowRule;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;

public class StraightSequenceCardShowRule implements IStraightSequenceCardShowRule {
	int firstCardValue;
	int secondCardValue;
	int thirdCardValue;
	int firstCardOrder;
	int secondCardOrder;
	int thirdCardOrder;
	int cardsSum;

	public int straightSequenceCardShowRule(ArrayList<Card> hands) {
		firstCardValue = hands.get(0).getRank().getValue();
		secondCardValue = hands.get(1).getRank().getValue();
		thirdCardValue = hands.get(2).getRank().getValue();

		if (RulesAbstractFactory.instance().checkConsecutiveCards().checkConsecutiveCards(firstCardValue,
				secondCardValue, thirdCardValue)) {
			cardsSum = firstCardValue + secondCardValue + thirdCardValue;
		}
		return cardsSum;
	}
}
