/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayCurrentPlayer;

public class DisplayCurrentPlayer implements IDisplayCurrentPlayer {
    @Override
    public void displayCurrentPlayer(String player, String playerId) {
        System.out.println("\nCurrent Player: "+player+", Current Player Id: "+playerId);
    }
}
