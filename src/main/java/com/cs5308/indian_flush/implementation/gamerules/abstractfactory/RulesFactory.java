package com.cs5308.indian_flush.implementation.gamerules.abstractfactory;

import com.cs5308.indian_flush.implementation.gamerules.interfaces.*;

public class RulesFactory extends RulesAbstractFactory {

    /* @Author: Tanvi Pruthi*/
    public IColorCardShowRule checkColorCardShowRule() {
        return new com.cs5308.indian_flush.implementation.gamerules.ColorCardShowRule();
    }

    /* @Author: Tanvi Pruthi*/
    public IPairCardShowRule checkPairCardShowRule() {
        return new com.cs5308.indian_flush.implementation.gamerules.PairCardShowRule();
    }

    /* @Author: Tanvi Pruthi*/
    public IHighCardShowRule checkHighCardShowRule() {
        return new com.cs5308.indian_flush.implementation.gamerules.HighCardShowRule();
    }

    /* @Author: Tanvi Pruthi*/
    public ICheckConsecutiveCards checkConsecutiveCards() {
        return new com.cs5308.indian_flush.implementation.gamerules.CheckConsecutiveCards();
    }

    /* @Author: Tanvi Pruthi*/
    public ISortCardsDescendingOrder sortCardsDescendingOrder() {
        return new com.cs5308.indian_flush.implementation.gamerules.SortCardsDescendingOrder();
    }

    /* @Author: Tanvi Pruthi*/
    public ITripletsCardShowRule checkTripletsCardShowRule() {
        return new com.cs5308.indian_flush.implementation.gamerules.TripletsCardShowRule();
    }

    /* @Author: Tanvi Pruthi*/
    public IPureSequenceCardShowRule checkPureSequenceCardShowRule() {
        return new com.cs5308.indian_flush.implementation.gamerules.PureSequenceCardShowRule();
    }

    /* @Author: Tanvi Pruthi*/
    public IStraightSequenceCardShowRule checkStraightSequenceCardShowRule() {
        return new com.cs5308.indian_flush.implementation.gamerules.StraightSequenceCardShowRule();
    }

}
