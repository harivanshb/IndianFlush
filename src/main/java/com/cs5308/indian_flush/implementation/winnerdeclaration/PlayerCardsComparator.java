/* @Author: Vikram*/

package com.cs5308.indian_flush.implementation.winnerdeclaration;

import java.util.Comparator;
import java.util.HashMap;

public class PlayerCardsComparator implements Comparator<String> {

    private final HashMap<String, GameResult> gameResult;

    public PlayerCardsComparator(HashMap<String, GameResult> gameResult) {
        super();
        this.gameResult = gameResult;
    }

    @Override
    public int compare(String o1, String o2) {
        return gameResult.get(o1).getScore().compareTo(gameResult.get(o2).getScore());
    }
}
