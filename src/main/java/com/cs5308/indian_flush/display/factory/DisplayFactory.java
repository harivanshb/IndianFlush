package com.cs5308.indian_flush.display.factory;

import com.cs5308.indian_flush.display.DisplayPackCards;
import com.cs5308.indian_flush.display.DisplayShowCards;
import com.cs5308.indian_flush.display.interfaces.*;


public class DisplayFactory extends DisplayAbstractFactory {
    /* @Author: Harivansh Bhatia*/
    @Override
    public IDisplayShowCards createDisplay() {
        return new DisplayShowCards();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayMoves displayMoves() {
        return new com.cs5308.indian_flush.display.DisplayMoves();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayMoves displayInvalidMoves() {
        return new com.cs5308.indian_flush.display.DisplayMoves();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayCurrentPlayer displayCurrentPlayer() {
        return new com.cs5308.indian_flush.display.DisplayCurrentPlayer();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayStartNewGameMessage displayStartNewGameMessage() {
        return new com.cs5308.indian_flush.display.DisplayStartNewGameMessage();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayStartNewGameMessage displayStartNewErrorMessage() {
        return new com.cs5308.indian_flush.display.DisplayStartNewGameMessage();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayEndGameMessage displayEndGameMessage() {
        return new com.cs5308.indian_flush.display.DisplayEndGameMessage();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplaySeeCards displaySeeCards() {
        return new com.cs5308.indian_flush.display.DisplaySeeCards();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplaySeeCards displayInitialSeeCardsMessage() {
        return new com.cs5308.indian_flush.display.DisplaySeeCards();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayPlayBlind displayPlayBlindSuccessMessage() {
        return new com.cs5308.indian_flush.display.DisplayPlayBlind();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayPlayBlind displayPlayBlindFailMessage() {
        return new com.cs5308.indian_flush.display.DisplayPlayBlind();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayCallAndRaise displayCallAndRaiseInitialMessage() {
        return new com.cs5308.indian_flush.display.DisplayCallAndRaise();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayNumberOfBotsInput displayNumberOfBotsInputMessage() {
        return new com.cs5308.indian_flush.display.DisplayNumberOfBotsInput();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayNumberOfBotsInput displayNumberOfBotsErrorMessage() {
        return new com.cs5308.indian_flush.display.DisplayNumberOfBotsInput();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayNumberOfBotsInput displayNumberOfBotsSuccessMessage() {
        return new com.cs5308.indian_flush.display.DisplayNumberOfBotsInput();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayAcceptPlayerName displayAcceptPlayerNameInputMessage() {
        return new com.cs5308.indian_flush.display.DisplayAcceptPlayerName();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayAcceptPlayerName displayAcceptPlayerNameErrorMessage() {
        return new com.cs5308.indian_flush.display.DisplayAcceptPlayerName();
    }

    /* @Author: Tanvi Pruthi*/
    @Override
    public IDisplayAcceptPlayerName displayAcceptPlayerNameSuccessMessage() {
        return new com.cs5308.indian_flush.display.DisplayAcceptPlayerName();
    }

    /* @Author: Harivansh Bhatia */
    @Override
    public IDisplayPackCards displayPackCards() {
        return new DisplayPackCards();
    }

    /* @Author: Meshwa Savalia*/
    @Override
    public IDisplaySideShow displaySideShowRejectedMessage() {
        return new com.cs5308.indian_flush.display.DisplaySideShow();
    }

    /* @Author: Meshwa Savalia*/
    @Override
    public IDisplaySideShowAccept displaySideShowWinner() {
        return new com.cs5308.indian_flush.display.DisplaySideShowAccept();
    }

    /* @Author: Meshwa Savalia*/
    @Override
    public IDisplaySideShowAccept displaySideShowLoser() {
        return new com.cs5308.indian_flush.display.DisplaySideShowAccept();
    }

    @Override
    public IDisplaySideShowAccept displayUserLostSideShow() {
        return new com.cs5308.indian_flush.display.DisplaySideShowAccept();
    }

    /* @Author: Meshwa Savalia*/
    @Override
    public IDisplaySideShowValidator displayInvalidPlayersSideShow() {
        return new com.cs5308.indian_flush.display.DisplaySideShowValidator();
    }

    /* @Author: Meshwa Savalia*/
    @Override
    public IDisplaySideShowValidator displayBlindPlayersSideShow() {
        return new com.cs5308.indian_flush.display.DisplaySideShowValidator();
    }
}
