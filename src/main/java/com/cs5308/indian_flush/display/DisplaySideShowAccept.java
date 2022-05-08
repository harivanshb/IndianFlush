package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplaySideShowAccept;

/* @Author: Meshwa Savalia*/
public class DisplaySideShowAccept implements IDisplaySideShowAccept {

    @Override
    public void displaySideShowWinner(String winnerID) {
        System.out.println("Winner of Side Show: Player " + winnerID);
    }

    @Override
    public void displaySideShowLoser(String loserID) {
        System.out.println("Player " + loserID+ "is out of the game");
    }

    @Override
    public void displayUserLostSideShow() {
        System.out.println("You have lost the game!");
    }

}
