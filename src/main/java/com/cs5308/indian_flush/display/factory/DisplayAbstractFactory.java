package com.cs5308.indian_flush.display.factory;

import com.cs5308.indian_flush.display.interfaces.*;

public abstract class DisplayAbstractFactory {

    /* @Author: Harivansh Bhatia*/
    private static DisplayAbstractFactory factoryInstance;

    public static DisplayAbstractFactory instance() {
        if (factoryInstance == null) {
            factoryInstance = new DisplayFactory();
        }
        return factoryInstance;
    }

    /* @Author: Harivansh Bhatia*/
    public abstract IDisplayShowCards createDisplay();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayMoves displayMoves();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayMoves displayInvalidMoves();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayCurrentPlayer displayCurrentPlayer();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayStartNewGameMessage displayStartNewGameMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayStartNewGameMessage displayStartNewErrorMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayEndGameMessage displayEndGameMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplaySeeCards displaySeeCards();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplaySeeCards displayInitialSeeCardsMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayPlayBlind displayPlayBlindSuccessMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayPlayBlind displayPlayBlindFailMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayCallAndRaise displayCallAndRaiseInitialMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayNumberOfBotsInput displayNumberOfBotsInputMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayNumberOfBotsInput displayNumberOfBotsErrorMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayNumberOfBotsInput displayNumberOfBotsSuccessMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayAcceptPlayerName displayAcceptPlayerNameInputMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayAcceptPlayerName displayAcceptPlayerNameErrorMessage();

    /* @Author: Tanvi Pruthi */
    public abstract IDisplayAcceptPlayerName displayAcceptPlayerNameSuccessMessage();

    /* @Author: Harivansh Bhatia */
    public abstract IDisplayPackCards displayPackCards();

    /* @Author: Meshwa Savalia */
    public abstract IDisplaySideShow displaySideShowRejectedMessage();

    /* @Author: Meshwa Savalia */
    public abstract IDisplaySideShowAccept displaySideShowWinner();

    /* @Author: Meshwa Savalia*/
    public abstract IDisplaySideShowAccept displaySideShowLoser();

    /* @Author: Meshwa Savalia*/
    public abstract IDisplaySideShowAccept displayUserLostSideShow();

    /* @Author: Meshwa Savalia*/
    public abstract IDisplaySideShowValidator displayInvalidPlayersSideShow();

    /* @Author: Meshwa Savalia*/
    public abstract IDisplaySideShowValidator displayBlindPlayersSideShow();

}
