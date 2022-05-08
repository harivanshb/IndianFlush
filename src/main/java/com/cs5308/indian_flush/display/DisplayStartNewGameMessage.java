/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayStartNewGameMessage;

public class DisplayStartNewGameMessage implements IDisplayStartNewGameMessage {

    @Override
    public void displayStartNewGameMessage(String playerName) {
        System.out.println("\nHello " + playerName + "! Please enter : \n [1] To start new game \n [2] To exit");
        System.out.print(">> ");
    }

    @Override
    public void displayStartNewErrorMessage() {
        System.out.println("Invalid Input! Please try again!");
    }
}
