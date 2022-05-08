package com.cs5308.indian_flush.implementation.playbyturn.abstractfactory;

import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IAcceptNumberOfBots;
import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IAcceptPlayerName;
import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IPlayByTurn;

/* @Author: Meshwa Savalia */
public abstract class TurnManagerAbstractFactory {

    /* @Author: Meshwa Savalia */
    private static TurnManagerAbstractFactory factoryInstance;

    /* @Author: Meshwa Savalia */
    public static TurnManagerAbstractFactory instance() {
        if (factoryInstance == null) {
            factoryInstance = new TurnManagerFactory();
        }

        return factoryInstance;
    }

    /* @Author: Meshwa Savalia */
    public abstract IPlayByTurn createTurnManager();

    /* @Author: Tanvi Pruthi */
    public abstract IAcceptPlayerName acceptPlayerName();

    /* @Author: Tanvi Pruthi */
    public abstract IAcceptNumberOfBots acceptNumberOfBots();

}
