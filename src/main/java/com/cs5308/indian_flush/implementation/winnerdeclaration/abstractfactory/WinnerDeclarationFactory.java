/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory;

import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IDeclareWinner;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IGameResult;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IRankBuckets;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IWinnerDeclarationCheck;

public class WinnerDeclarationFactory extends WinnerDeclarationAbstractFactory {
    @Override
    public IGameResult setGameResult(int score) {
        return new com.cs5308.indian_flush.implementation.winnerdeclaration.GameResult(score);
    }

    @Override
    public IRankBuckets setRankBuckets() {
        return new com.cs5308.indian_flush.implementation.winnerdeclaration.RankBuckets();
    }

    @Override
    public IWinnerDeclarationCheck winnerDeclarationCheck() {
        return new com.cs5308.indian_flush.implementation.winnerdeclaration.WinnerDeclarationCheck();
    }

    @Override
    public IDeclareWinner declareWinner() {
        return new com.cs5308.indian_flush.implementation.winnerdeclaration.DeclareWinner();
    }
}
