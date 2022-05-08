/* @Author: Tanvi Pruthi*/

package com.cs5308.indian_flush.implementation.winnerdeclaration.abstractfactory;

import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IDeclareWinner;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IGameResult;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IRankBuckets;
import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IWinnerDeclarationCheck;

public abstract class WinnerDeclarationAbstractFactory {
    private static WinnerDeclarationFactory singleInstance = null;

    public static WinnerDeclarationFactory instance() {
        if (null == singleInstance) {
            singleInstance = new WinnerDeclarationFactory();
        }
        return singleInstance;
    }

    public static void setFactory(WinnerDeclarationFactory winnerDeclarationFactory) {
        singleInstance = winnerDeclarationFactory;
    }

    public abstract IGameResult setGameResult(int score);

    public abstract IRankBuckets setRankBuckets();

    public abstract IWinnerDeclarationCheck winnerDeclarationCheck();

    public abstract IDeclareWinner declareWinner();
}
