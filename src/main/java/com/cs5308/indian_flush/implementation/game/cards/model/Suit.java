package com.cs5308.indian_flush.implementation.game.cards.model;

/* @Author: Vikram */
public enum Suit {
	CLUB("club", 'C', "♣️"), DIAMOND("diamond", 'D', "♦️"), HEART("heart", 'H', "♥️"), SPADE("spade", 'S', "♠️");

	private final String name;
	private final char letter;
	private final String symbol;

	Suit(String name, char letter, String symbol) {
		this.name = name;
		this.letter = letter;
		this.symbol = symbol;
	}

	public String getLetter() {
		return Character.toString(letter);
	}
}
