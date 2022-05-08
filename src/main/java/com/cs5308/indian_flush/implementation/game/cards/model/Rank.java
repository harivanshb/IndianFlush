package com.cs5308.indian_flush.implementation.game.cards.model;

/* @Author: Vikram */
public enum Rank {

	ACE(1, 14, "ace", 'A'), KING(13, 13, "king", 'K'), QUEEN(12, 12, "queen", 'Q'), JACK(11, 11, "jack", 'J'),
	TEN(10, 10, "ten", 'T'), NINE(9, 9, "nine", '9'), EIGHT(8, 8, "eight", '8'), SEVEN(7, 7, "seven", '7'),
	SIX(6, 6, "six", '6'), FIVE(5, 5, "five", '5'), FOUR(4, 4, "four", '4'), THREE(3, 3, "three", '3'),
	TWO(2, 2, "two", '2');

	private Rank(int order, int value, String name, char symbol) {
		this.order = order;
		this.value = value;
		this.name = name;
		this.symbol = symbol;
	}

	private final int order;

	private final int value;

	private final String name;

	private final char symbol;

	public String toString() {
		return Character.toString(symbol);
	}

	public int getOrder() {
		return order;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}
