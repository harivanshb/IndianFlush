/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayAcceptPlayerName;

public class DisplayAcceptPlayerName implements IDisplayAcceptPlayerName {

    @Override
    public void displayAcceptPlayerNameInputMessage() {
        System.out.println("\nHello Player! Please enter your name :");
        System.out.print(">> ");
    }

    @Override
    public void displayAcceptPlayerNameErrorMessage() {
        System.out.println("Please Enter a valid name!");
    }

    @Override
    public void displayAcceptPlayerNameSuccessMessage(String userName) {
        System.out.println("\nHello " + userName + "! You have 10,000 Chips to play the game!");
        System.out.println("Current Balance : 10,000 Chips");
    }
}
