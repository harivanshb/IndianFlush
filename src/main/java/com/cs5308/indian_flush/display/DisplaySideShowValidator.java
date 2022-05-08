package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplaySideShowValidator;

/* @Author: Meshwa Savalia*/
public class DisplaySideShowValidator implements IDisplaySideShowValidator {
    @Override
    public void displayInvalidPlayersSideShow() {
        System.out.println("Side Show not allowed as number of players in the game are less than 3");
    }

    @Override
    public void displayBlindPlayersSideShow() {
        System.out.println("Either current or previous player is playing blind. Side Show not allowed.");
    }

}
