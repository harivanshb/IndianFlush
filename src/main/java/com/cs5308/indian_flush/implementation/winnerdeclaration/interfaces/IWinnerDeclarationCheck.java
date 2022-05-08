/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces;

import java.util.*;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;

public interface IWinnerDeclarationCheck {
    HashMap<String, Integer> rankHandsAndDecideWinner(HashMap<String, ArrayList<Card>> hands);
}
