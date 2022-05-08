/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.gamerules;

import com.cs5308.indian_flush.implementation.gamerules.abstractfactory.RulesAbstractFactory;
import com.cs5308.indian_flush.implementation.gamerules.interfaces.IHighCardShowRule;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;

import java.util.ArrayList;

public class HighCardShowRule implements IHighCardShowRule {
    Integer[] cardsInDescendingOrder;
    int highCard;

    public int checkHighCardShowRule(ArrayList<Card> hands) {
        cardsInDescendingOrder = RulesAbstractFactory.instance().sortCardsDescendingOrder().sortCardsDescendingOrder(hands);
        highCard = cardsInDescendingOrder[0];
        return highCard;
    }

}

