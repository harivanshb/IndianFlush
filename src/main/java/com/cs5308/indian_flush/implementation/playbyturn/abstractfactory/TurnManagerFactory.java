package com.cs5308.indian_flush.implementation.playbyturn.abstractfactory;

import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IAcceptNumberOfBots;
import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IAcceptPlayerName;
import com.cs5308.indian_flush.implementation.playbyturn.interfaces.IPlayByTurn;

/* @Author: Meshwa Savalia */
public class TurnManagerFactory extends TurnManagerAbstractFactory {

    /* @Author: Meshwa Savalia */
    @Override
    public IPlayByTurn createTurnManager() {
        return new com.cs5308.indian_flush.implementation.playbyturn.PlayByTurn();
    }

    /* @Author: Tanvi Pruthi */
    @Override
    public IAcceptPlayerName acceptPlayerName() {
        return new com.cs5308.indian_flush.implementation.playbyturn.AcceptPlayerName();
    }

    /* @Author: Tanvi Pruthi */
    @Override
    public IAcceptNumberOfBots acceptNumberOfBots() {
        return new com.cs5308.indian_flush.implementation.playbyturn.AcceptNumberOfBots();
    }
}
