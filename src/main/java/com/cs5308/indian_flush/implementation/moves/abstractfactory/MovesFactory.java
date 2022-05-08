package com.cs5308.indian_flush.implementation.moves.abstractfactory;
import com.cs5308.indian_flush.implementation.moves.interfaces.*;

public class MovesFactory extends MovesAbstractFactory{

    /* @Author: Meshwa Savalia */
    public ISideShow sideShow() {
        return new com.cs5308.indian_flush.implementation.moves.SideShow();
    }

    /* @Author: Meshwa Savalia */
    public ISideShowAccept getHandsOfSideShowPlayers() {
        return new com.cs5308.indian_flush.implementation.moves.SideShowAccept();
    }

    /* @Author: Meshwa Savalia */
    public ISideShowAccept decideSideShowWinner() {
        return new com.cs5308.indian_flush.implementation.moves.SideShowAccept();
    }

    /* @Author: Meshwa Savalia */
    public ISideShowValidator getActivePlayersList() {
        return new com.cs5308.indian_flush.implementation.moves.SideShowValidator();
    }

    /* @Author: Meshwa Savalia */
    public ISideShowValidator getPreviousPlayerID() {
        return new com.cs5308.indian_flush.implementation.moves.SideShowValidator();
    }

    /* @Author: Meshwa Savalia */
    public ISideShowValidator getNotBlindPlayersList() {
        return new com.cs5308.indian_flush.implementation.moves.SideShowValidator();
    }

    /* @Author: Meshwa Savalia */
    public ISideShowValidator isCurrentOrPreviousPlayerBlind() {
        return new com.cs5308.indian_flush.implementation.moves.SideShowValidator();
    }

    /* @Author: Meshwa Savalia */
    public ISideShowValidator validateSideShow() {
        return new com.cs5308.indian_flush.implementation.moves.SideShowValidator();
    }

    /* @Author: Tanvi Pruthi */
    @Override
    public IPackCards packCards() {
        return new com.cs5308.indian_flush.implementation.moves.PackCards();
    }

    /* @Author: Tanvi Pruthi */
    @Override
    public ISeeCards seeCards() {
        return new com.cs5308.indian_flush.implementation.moves.SeeCards();
    }

    /* @Author: Tanvi Pruthi */
    @Override
    public IPlayBlind playBlind() {
        return new com.cs5308.indian_flush.implementation.moves.PlayBlind();
    }

    /* @Author: Tanvi Pruthi */
    @Override
    public IMoves playerMoves() {
        return new com.cs5308.indian_flush.implementation.moves.Moves();
    }

    /* @Author: Tanvi Pruthi */
    @Override
    public ICallAndRaise callAndRaise() {
        return new com.cs5308.indian_flush.implementation.moves.CallAndRaise();
    }

    /* @Author: Harivansh Bhatia*/
    @Override
    public IShowCards showCards() {
        return new com.cs5308.indian_flush.implementation.moves.ShowCards();
    }
}
