/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.gamerules;

import com.cs5308.indian_flush.implementation.gamerules.abstractfactory.RulesAbstractFactory;
import com.cs5308.indian_flush.implementation.gamerules.interfaces.IPairCardShowRule;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;

import java.util.ArrayList;

public class PairCardShowRule implements IPairCardShowRule {
    Integer[] cardsInDescendingOrder;
    int firstCardAfterSorting;
    int secondCardAfterSorting;
    int thirdCardAfterSorting;
    int pairValue = 0;

    public int pairCardShowRule(ArrayList<Card> hands) {
        cardsInDescendingOrder = RulesAbstractFactory.instance().sortCardsDescendingOrder().sortCardsDescendingOrder(hands);
        firstCardAfterSorting = cardsInDescendingOrder[0];
        secondCardAfterSorting = cardsInDescendingOrder[1];
        thirdCardAfterSorting = cardsInDescendingOrder[2];

        if (firstCardAfterSorting == secondCardAfterSorting) {
            pairValue = firstCardAfterSorting;
        } else if (secondCardAfterSorting == thirdCardAfterSorting) {
            pairValue = secondCardAfterSorting;
        }
        return pairValue;
    }
}
