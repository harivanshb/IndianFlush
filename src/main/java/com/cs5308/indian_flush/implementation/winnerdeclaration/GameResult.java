/* @Author: Vikram*/

package com.cs5308.indian_flush.implementation.winnerdeclaration;

import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IGameResult;

public class GameResult implements IGameResult {

    private Integer score;

    public Integer getScore() {
        return score;
    }

    public GameResult() {
    }

    public GameResult(int score) {
        this.score = score;
    }
}
