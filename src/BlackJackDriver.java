
public class BlackJackDriver {

	public static void main(String[] args) {
		//dependency injection
		Card[] deck = new Card[52];int count = 0;
		for( Suit suit : Suit.values() ){
	        for( Face face : Face.values() ){
	        	deck[count] = new Card(face, suit );
	        	count++;
	        }
		}
		DeckOfCards myDeckOfCards = new DeckOfCards(deck);
		
		myDeckOfCards.shuffle(); // place Cards in random order
		Rule rule = new Rule();
		
		String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        	//check need shuffle or not
        	if(myDeckOfCards.needShuffle())
        		myDeckOfCards.shuffle();

        	int numOfPlayer = Console.getInt("Enter numOfPlayer:  ", 0, 5);
			Player[] players = new Player[numOfPlayer];
		
			for(int i = 0; i < players.length; i++) {
				//create players & get their first card
				players[i] = new Player(myDeckOfCards);
			 
				System.out.println("Player"+(i+1)+"'s Card");
				System.out.print(players[i].toString());
				System.out.println("Point: "+players[i].getTotalPoint());
				System.out.println();
			}
			//create dealer & show  first card
			Player dealer = new Player(myDeckOfCards);
			System.out.println("dealer's Card");
			System.out.print(dealer.toString());
			System.out.println("Point: "+dealer.getTotalPoint());
			System.out.println();
		
			for(int i = 0; i < players.length; i++) {
				//players get their second card
				players[i].addCard();
			
				System.out.println("Player"+(i+1)+"'s Card");
				System.out.print(players[i].toString());
				System.out.println("Point: "+players[i].getTotalPoint());
				System.out.println();
			}
			
			rule.playerTurn(players);
			rule.dealerTurn(dealer);
			rule.judge(dealer, players);
			
			choice = Console.getString("Continue? (y/n): ");
            System.out.println();
        }
	}
}
