package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayPackCards;

/* @Author: Harivansh Bhatia */
public class DisplayPackCards implements IDisplayPackCards {
    @Override
    public void packCardsMessage() {
        System.out.println("All players Packed !! Ending the game !!");
    }
}
