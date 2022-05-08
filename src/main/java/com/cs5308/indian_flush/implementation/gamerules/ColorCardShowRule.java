/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.gamerules;

import com.cs5308.indian_flush.implementation.gamerules.interfaces.IColorCardShowRule;
import com.cs5308.indian_flush.implementation.game.cards.model.Card;

import java.util.ArrayList;

public class ColorCardShowRule implements IColorCardShowRule {
    String firstCardLetter;
    String secondCardLetter;
    String thirdCardLetter;
    int firstCardValue;
    int secondCardValue;
    int thirdCardValue;
    int cardsSum = 0;

    public int checkColorCardShowRule(ArrayList<Card> hands) {
        firstCardLetter = hands.get(0).getSuit().getLetter();
        secondCardLetter = hands.get(1).getSuit().getLetter();
        thirdCardLetter = hands.get(2).getSuit().getLetter();
        firstCardValue = hands.get(0).getRank().getValue();
        secondCardValue = hands.get(1).getRank().getValue();
        thirdCardValue = hands.get(2).getRank().getValue();

        if (firstCardLetter.equalsIgnoreCase(secondCardLetter) && secondCardLetter.equalsIgnoreCase(thirdCardLetter)) {
            cardsSum = firstCardValue + secondCardValue + thirdCardValue;
        }
        return cardsSum;
    }
}
