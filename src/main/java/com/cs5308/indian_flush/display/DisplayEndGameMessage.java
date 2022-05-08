/* @Author: Tanvi Pruthi */
package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayEndGameMessage;

public class DisplayEndGameMessage implements IDisplayEndGameMessage {
    @Override
    public void displayEndGameMessage(String player) {
        System.out.println("Thank You For Playing " + player + "!");
    }
}
