import java.util.*;

public class Hand {
	private int strength;
	private int high;
	private int low;
	private ArrayList<Integer> kicker = new ArrayList<>();
	
	public int getStrength() {
		return strength;
	}

	private void setStrength(int strength) {
		this.strength = strength;
	}

	public int getHigh() {
		return high;
	}

	private void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	private void setLow(int low) {
		this.low = low;
	}

	public ArrayList<Integer> getKicker() {
		return kicker;
	}

	private static ArrayList<Card> handCards = new ArrayList<Card>();

	public Hand(Deck deck) {
		for (int i = 0; i < 5; i++) {
			Card topCard = deck.draw();
			handCards.add(topCard);
		}
	}
	
	public static ArrayList<Card> getHandCards() {
		return handCards;
	}
	
	public int getCardValue(Hand hand, int index){
		return hand.getHandCards().get(index).getValue().getValue();
	}

	public static void sortHand() {
		Card temp;
		for (int i = 1; i < 5; i++) {
			if (handCards.get(i).getValue().getValue() <= handCards.get(0).getValue().getValue()) 
			{
				temp = handCards.get(i);
				handCards.remove(i);
				handCards.add(0, temp);
			}
			else if (handCards.get(i).getValue().getValue() <= handCards.get(1).getValue().getValue())
			{
				temp = handCards.get(i);
				handCards.remove(i);
				handCards.add(1, temp);
			}
			else if (handCards.get(i).getValue().getValue() <= handCards.get(2).getValue().getValue())
			{
				temp = handCards.get(i);
				handCards.remove(i);
				handCards.add(2, temp);
			}
			else if (handCards.get(i).getValue().getValue() <= handCards.get(3).getValue().getValue())
			{
				temp = handCards.get(i);
				handCards.remove(i);
				handCards.add(3, temp);
			}
		}

	}
	
	
	public void rateHand(Hand hand){
		if(hand.isRoyalFlush()){
			hand.setStrength(10);
			hand.setHigh(14);
			hand.setLow(10);
		}
		else if(hand.isStraightFlush()){
			hand.setStrength(9);
			hand.setHigh(getCardValue(hand, 4));
			hand.setLow(getCardValue(hand,0));
		}
		else if(hand.isFourOfAKind()){
			hand.setStrength(8);
			hand.setHigh(getCardValue(hand,3));
			hand.setLow(0);
			if (handCards.get(0).getValue().getValue() == handCards.get(3).getValue().getValue()){
				hand.kicker.add(getCardValue(hand,4));
			}else
				hand.kicker.add(getCardValue(hand,0));
			
		}
	}
	
	public boolean isRoyalFlush(){
		if((handCards.get(0).getValue().getValue() == 10) && (handCards.get(1).getValue().getValue() == 11)
				&& (handCards.get(2).getValue().getValue() == 12) && (handCards.get(3).getValue().getValue() == 13)
				&& (handCards.get(4).getValue().getValue() == 14)){
			return ((handCards.get(0).getSuit() == handCards.get(1).getSuit())
					&&(handCards.get(1).getSuit() == handCards.get(2).getSuit())
					&&(handCards.get(2).getSuit() == handCards.get(3).getSuit())
					&&(handCards.get(3).getSuit() == handCards.get(4).getSuit()));			
		}
		else
			return false;
	}
	public boolean isStraightFlush(){
		if((handCards.get(0).getValue().getValue() == handCards.get(1).getValue().getValue() - 1)
				& (handCards.get(1).getValue().getValue() == handCards.get(2).getValue().getValue() - 1)
				& (handCards.get(2).getValue().getValue() == handCards.get(3).getValue().getValue() - 1)
				& (handCards.get(3).getValue().getValue() == handCards.get(4).getValue().getValue() - 1))
		{
			return ((handCards.get(0).getSuit() == handCards.get(1).getSuit())
					&&(handCards.get(1).getSuit() == handCards.get(2).getSuit())
					&&(handCards.get(2).getSuit() == handCards.get(3).getSuit())
					&&(handCards.get(3).getSuit() == handCards.get(4).getSuit()));			
		}
		else
			return false;
	}
	public boolean isFourOfAKind(){
		if (handCards.get(0).getValue().getValue() == handCards.get(3).getValue().getValue()){
			return true;
		}
		else
			return (handCards.get(1).getValue().getValue() == handCards.get(4).getValue().getValue());		
	}
	
	//Proof of concept that the draw method works, that the new hand method works, that the sort hand method works.
//	public static void main(String[] args){
//		Deck test = new Deck();
//		Hand testHand = new Hand(test);
//		for (int i = 0; i < 5; i++){
//			System.out.println(testHand.getHandCards().get(i).getValue());
//			System.out.println(testHand.getHandCards().get(i).getSuit());	
//		}
//		testHand.sortHand();
//		for (int i = 0; i < 5; i++){
//			System.out.println(testHand.getHandCards().get(i).getValue());
//			System.out.println(testHand.getHandCards().get(i).getSuit());	
//		}
//	}
}
