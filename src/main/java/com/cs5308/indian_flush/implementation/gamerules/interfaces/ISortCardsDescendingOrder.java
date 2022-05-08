/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.gamerules.interfaces;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;

import java.util.ArrayList;

public interface ISortCardsDescendingOrder {
    Integer[] sortCardsDescendingOrder(ArrayList<Card> hands);
}
