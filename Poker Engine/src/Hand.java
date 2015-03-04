import java.util.*;

public class Hand {

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
