package com.cs5308.indian_flush.implementation.player;

import java.util.ArrayList;
import java.util.HashMap;

import com.cs5308.indian_flush.implementation.game.cards.model.Card;

/* @Author: Vikram, Meshwa*/
public abstract class Bot extends Player {

	/* @Author: Vikram, Meshwa */
	public abstract String decidePlayerAction(String playerId, HashMap<String, ArrayList<Card>> hands);
}
