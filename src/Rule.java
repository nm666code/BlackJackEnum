//import java.util.ArrayList;
//import java.util.Arrays;
public class Rule {
	   /*private static ArrayList<String> faces = new ArrayList<>(Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six",
		         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"));    
	   private static ArrayList<String> suits = new ArrayList<>(Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades"));*/
	   
	   /*public static enum efaces{
		   Ace,Deuce,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen,King;
	   }
	   
	   public static enum esuits{
		   Hearts,Diamonds,Clubs,Spades;
	   }*/
	   
	   /*public static String getFace(int n) {
		   return faces.get(n);
	   }
	   
	   public static String getSuit(int n) {
		   return suits.get(n);
	   }
	   
	   public static int getPointOfCard(String face) {
		   if(faces.indexOf(face)==0)
			   return faces.indexOf(face) + 11;
		   else if(faces.indexOf(face)>=10)
			   return 10;
		   else
			   return faces.indexOf(face) + 1;
	   }
	   
	   public static int binarySearch(ArrayList<String> integerList, String searchValue) {

        int low = 0;
        int high = integerList.size() - 1;
        int mid = (low + high) / 2;

        while (low <= high && !integerList.get(mid).equalsIgnoreCase(searchValue)) {

            if (integerList.get(mid).compareTo(searchValue) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;

            if (low > high) {
                mid = -1;
            }

        }
        return mid;

      }*/
	   
	  /*public static efaces geteFace(int n) {
		   for(efaces face:efaces.values()) {
			   if(face.ordinal()==n)
				   return face;
		   }
		   return null;
	   }
	   
	   public static esuits geteSuit(int n) {
		   for(esuits suit:esuits.values()) {
			   if(suit.ordinal()==n)
				   return suit;
		   }
		   return null;
	   }
	   
	   public static int getePointOfCard(efaces eface) {
		   if(eface.ordinal()==0)
			   return eface.ordinal() + 11;
		   else if(eface.ordinal()>=10)
			   return 10;
		   else
			   return eface.ordinal() + 1;
	   }
	 */
		
		
	   public static void checkBust(Player player) {
		   for(int i = 0; i < player.getOnHand().size(); i++) {
			   if(player.getOnHand().get(i).getFace()==Face.ACE &&player.isSoftCard()) {
				   player.turnHard();
				   return ;
			   }
		   }
		   player.bust();
	   }
	   
		public boolean checkBlackjack(Player player) {
			if(player.getOnHand().size() == 2 && player.getTotalPoint() == 21)
				return true;
			else
				return false;
		}
	   
	   public  void playerTurn(Player[] players) {
		   for(int i = 0; i < players.length; i++) {
				while (!players[i].getBust()) {
					
					String action = Console.getString("Enter action Player"+(i+1)+"'s (Hit/Stand): ");
					
					if(action.equalsIgnoreCase("Hit")) {
						players[i].addCard();
						
						System.out.println("Player"+(i+1)+"'s Card");
						System.out.print(players[i].toString());
						System.out.println("Point: "+players[i].getTotalPoint());
						if(players[i].getBust())
							System.out.println("Player"+(i+1)+": bust");
						System.out.println();
					}
					else if(action.equalsIgnoreCase("Stand"))
						break;
					else
						System.out.println("error! please enter action again");
				}
			}
	   }
	   
	   public  void dealerTurn(Player dealer) {
		   do{
			   dealer.addCard();
			   System.out.println("dealer's Card");
			   System.out.print(dealer.toString());
			   System.out.println("Point: "+dealer.getTotalPoint());
			   if(dealer.getBust())
					System.out.println("dealer: bust");
			   System.out.println();
		   }while(dealer.getTotalPoint() < 17 );
	   }
	   
	   public  void judge(Player dealer,Player[] players) {
		   for(int i = 0; i < players.length; i++) {
			   if (players[i].getBust())
				   System.out.println("Player"+(i+1)+" lose");
			   else if (dealer.getBust())
				   System.out.println("Player"+(i+1)+" win");
			   else if (players[i].getTotalPoint() > dealer.getTotalPoint())
				   System.out.println("Player"+(i+1)+" win");
			   else if (players[i].getTotalPoint() < dealer.getTotalPoint())
				   System.out.println("Player"+(i+1)+" lose");
			   else if (checkBlackjack(players[i]) && !checkBlackjack(dealer))
				   System.out.println("Player"+(i+1)+" win");
			   else if (!checkBlackjack(players[i]) && checkBlackjack(dealer))
				   System.out.println("Player"+(i+1)+" lose");
			   else
				   System.out.println("Player"+(i+1)+" tie");
		   }	   
	   }
}
