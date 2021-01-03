import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	private ArrayList<Card> onHand = new ArrayList<Card>();
	private int totalpoint = 0;
	private DeckOfCards myDeckOfCards ;
	private boolean softCard = true;
	private boolean bust = false;
	
	public Player(DeckOfCards myDeckOfCards) {
		this.myDeckOfCards = myDeckOfCards;
		Card card = myDeckOfCards.dealCard();
		onHand.add(card);
		totalpoint += card.getFace().getValue();
		//totalpoint += Rule.getePointOfCard(card.geteFace());
	}
	
	public int getTotalPoint() {
		return totalpoint;
	}
	
	public List<Card> getOnHand(){
		return Collections.unmodifiableList(onHand);
	}
	
	public boolean getBust() {
		return bust;
	}
	
	public boolean isSoftCard() {
		return softCard;
	}
	
	public void turnHard() {
		totalpoint-=10;
		softCard = false;
	}
	
	public void bust() {
		bust = true;
	}
	
	public void addCard() {
		Card card = myDeckOfCards.dealCard();
		onHand.add(card);
		totalpoint += card.getFace().getValue();
		//totalpoint += Rule.getePointOfCard(card.geteFace());
		if(totalpoint>21)
			Rule.checkBust(this);
	}
	
	/*public void checkBust() {
		for(int i = 0; i < onHand.size(); i++) {
			if(onHand.get(i).getFace()==Face.ACE&&isSoftCard()) {
				totalpoint-=10;
				softCard = false;
				return;
			}
		}
		bust = true;
		System.out.println("bust");
	}*/
	
	/*public void checkBust() {
		for(int i = 0; i < onHand.size(); i++) {
			if(onHand.get(i).geteFace()==Rule.efaces.Ace&&softCard) {
				totalpoint-=10;
				softCard = false;
				return;
			}
		}
		bust = true;
		System.out.println("bust");

	}*/
    
	/*public boolean checkBlackjack() {
		if(onHand.size()==2 && totalpoint == 21)
			return true;
		else
			return false;
	}*/
	
	public String toString(){
		String cardOnHand = "";
        for(int i=0;i<onHand.size();i++){
            cardOnHand += (i+1)+". " + onHand.get(i).toString()+"\n";
        }
        return cardOnHand;

    }

}