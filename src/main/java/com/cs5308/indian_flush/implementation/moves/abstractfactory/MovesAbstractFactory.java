package com.cs5308.indian_flush.implementation.moves.abstractfactory;

import com.cs5308.indian_flush.implementation.moves.interfaces.*;

/* @Author: Meshwa Savalia */
public abstract class MovesAbstractFactory {

    /* @Author: Meshwa Savalia */
    private static MovesAbstractFactory singleInstance = null;

    /* @Author: Meshwa Savalia */
    public static MovesAbstractFactory instance()
    {
        if(null==singleInstance)
        {
            singleInstance=new MovesFactory();
        }
        return singleInstance;
    }
    /* @Author: Meshwa Savalia */
    public static void setFactory(MovesFactory movesFactory)
    {
        singleInstance=movesFactory;
    }

    /* @Author: Meshwa Savalia */
    public abstract ISideShow sideShow();

    /* @Author: Meshwa Savalia */
    public abstract ISideShowAccept getHandsOfSideShowPlayers();

    /* @Author: Meshwa Savalia */
    public abstract ISideShowAccept decideSideShowWinner();

    /* @Author: Meshwa Savalia */
    public abstract ISideShowValidator getActivePlayersList();

    /* @Author: Meshwa Savalia */
    public abstract ISideShowValidator getPreviousPlayerID();

    /* @Author: Meshwa Savalia */
    public abstract ISideShowValidator getNotBlindPlayersList();

    /* @Author: Meshwa Savalia */
    public abstract ISideShowValidator isCurrentOrPreviousPlayerBlind();

    /* @Author: Meshwa Savalia */
    public abstract ISideShowValidator validateSideShow();

    /* @Author: Tanvi Pruthi */
    public abstract IPackCards packCards();

    /* @Author: Tanvi Pruthi */
    public abstract ISeeCards seeCards();

    /* @Author: Tanvi Pruthi */
    public abstract IPlayBlind playBlind();

    /* @Author: Tanvi Pruthi */
    public abstract IMoves playerMoves();

    /* @Author: Tanvi Pruthi */
    public abstract ICallAndRaise callAndRaise();

    /* @Author: Harivansh Bhatia*/
    public abstract IShowCards showCards();
}
