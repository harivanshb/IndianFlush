/* @Author: Vikram*/

package com.cs5308.indian_flush.implementation.gamerules;

import java.util.ArrayList;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;
import com.cs5308.indian_flush.implementation.gamerules.abstractfactory.RulesAbstractFactory;
import com.cs5308.indian_flush.implementation.gamerules.interfaces.IPureSequenceCardShowRule;

public class PureSequenceCardShowRule implements IPureSequenceCardShowRule {

	int firstCardOrder;

	int secondCardOrder;

	int thirdCardOrder;

	int cardSum = 0;

	String firstCardLetter;

	String secondCardLetter;

	String thirdCardLetter;

	int firstCardValue;

	int secondCardValue;

	int thirdCardValue;

	public int pureSequenceCardShowRule(ArrayList<Card> hands) {
		firstCardOrder = hands.get(0).getRank().getOrder();
		secondCardOrder = hands.get(1).getRank().getOrder();
		thirdCardOrder = hands.get(2).getRank().getOrder();
		firstCardLetter = hands.get(0).getSuit().getLetter();
		secondCardLetter = hands.get(1).getSuit().getLetter();
		thirdCardLetter = hands.get(2).getSuit().getLetter();
		firstCardValue = hands.get(0).getRank().getValue();
		secondCardValue = hands.get(1).getRank().getValue();
		thirdCardValue = hands.get(2).getRank().getValue();

		if (RulesAbstractFactory.instance().checkConsecutiveCards().checkConsecutiveCards(firstCardOrder,
				secondCardOrder, thirdCardOrder)) {
			if (firstCardLetter.equalsIgnoreCase(secondCardLetter)
					&& (secondCardLetter.equalsIgnoreCase(thirdCardLetter))) {
				cardSum = firstCardValue + secondCardValue + thirdCardValue;
			}
		}
		return cardSum;
	}
}
