package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplaySideShow;

/* @Author: Meshwa Savalia*/
public class DisplaySideShow implements IDisplaySideShow {
    @Override
    public void displaySideShowRejectedMessage() {
        System.out.println("Side Show Rejected");
    }
}
