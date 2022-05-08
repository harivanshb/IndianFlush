package com.cs5308.indian_flush.implementation.game.cards.model;
/* @Author: Vikram */
public class Card implements Comparable {

	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	private final Rank rank;
	private final Suit suit;

	@Override
	public int compareTo(Object o) {
		return ((Integer) hashCode()).compareTo(o.hashCode());
	}

	public Card() {
		super();
		this.rank = null;
		this.suit = null;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

}
