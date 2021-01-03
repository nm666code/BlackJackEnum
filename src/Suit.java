/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * 
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/


/**
 * Represents the suit of a playing card.
 */
public enum Suit 
{ 
	CLUBS(1), DIAMONDS(2), SPADES(4), HEARTS(3);
	 
	private int value;
	 
	    private Suit(int value) {
	        this.value = value;
	    }
	 
	    public int getValue() {
	        return this.value;
	    }
}

