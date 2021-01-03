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
 * Represents the rank of a playing card.
 */
public enum Face {
    ACE(11), TWO(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
    private final int value;

    Face(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}