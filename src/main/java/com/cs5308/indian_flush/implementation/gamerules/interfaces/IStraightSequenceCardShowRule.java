package com.cs5308.indian_flush.implementation.gamerules.interfaces;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;

import java.util.ArrayList;

public interface IStraightSequenceCardShowRule {
    int straightSequenceCardShowRule(ArrayList<Card> hands);
}
