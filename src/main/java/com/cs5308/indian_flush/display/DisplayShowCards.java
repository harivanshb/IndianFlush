package com.cs5308.indian_flush.display;

import com.cs5308.indian_flush.display.interfaces.IDisplayShowCards;

/* @Author: Harivansh Bhatia*/
public class DisplayShowCards implements IDisplayShowCards {

    private static IDisplayShowCards display;

    public static IDisplayShowCards instance() {
        if (display == null) {
            display = new DisplayShowCards();
        }
        return display;
    }

    @Override
    public void showCardsErrorMessage() {
        System.out.println("Cannot show the cards as there are more than 2 players still in the game. Choose another option");
    }
}
