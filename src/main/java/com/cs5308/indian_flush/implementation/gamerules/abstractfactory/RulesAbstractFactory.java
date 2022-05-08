package com.cs5308.indian_flush.implementation.gamerules.abstractfactory;

import com.cs5308.indian_flush.implementation.gamerules.interfaces.*;

public abstract class RulesAbstractFactory {
    private static RulesAbstractFactory singleInstance = null;

    /* @Author: Tanvi Pruthi*/
    public static RulesAbstractFactory instance() {
        if (null == singleInstance) {
            singleInstance = new RulesFactory();
        }
        return singleInstance;
    }

    /* @Author: Tanvi Pruthi*/
    public static void setFactory(RulesFactory rulesFactory) {
        singleInstance = rulesFactory;
    }

    /* @Author: Tanvi Pruthi*/
    public abstract IColorCardShowRule checkColorCardShowRule();

    /* @Author: Tanvi Pruthi*/
    public abstract IPairCardShowRule checkPairCardShowRule();

    /* @Author: Tanvi Pruthi*/
    public abstract IHighCardShowRule checkHighCardShowRule();

    /* @Author: Tanvi Pruthi*/
    public abstract ICheckConsecutiveCards checkConsecutiveCards();

    /* @Author: Tanvi Pruthi*/
    public abstract ISortCardsDescendingOrder sortCardsDescendingOrder();

    /* @Author: Tanvi Pruthi*/
    public abstract ITripletsCardShowRule checkTripletsCardShowRule();

    /* @Author: Tanvi Pruthi*/
    public abstract IPureSequenceCardShowRule checkPureSequenceCardShowRule();

    /* @Author: Tanvi Pruthi*/
    public abstract IStraightSequenceCardShowRule checkStraightSequenceCardShowRule();
}
