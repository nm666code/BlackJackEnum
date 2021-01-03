// Fig. 7.9: Card.java
// Card class represents a playing card.

public class Card {
	private final Face face;
	private final Suit suit;
	// two-argument constructor initializes card's face and suit
	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}
	
	public Face getFace() {
		return face;
	}


	public Suit getSuit() {
		return suit;
	}

	// return String representation of Card
	public String toString() {
		return face + " of " + suit;
	}
} // end class Card


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
