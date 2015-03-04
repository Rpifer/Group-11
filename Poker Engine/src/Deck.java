import java.util.ArrayList;
import java.util.*;

public class Deck {

	private static ArrayList<Card> deckCards = new ArrayList<>();

	public Deck() {
		// i is the suit
		for (int i = 1; i < 5; i++) {
			// j is the value
			for (int j = 2; j < 15; j++) {
				//creats a new card object and adds to deck for all values/suits
				deckCards.add(new Card(i, j));
			}
		}
		
		//Proof of concept showing full, in order deck
//		for(int i = 0; i < 52; i++){
//		System.out.println((deckCards.get(i)).getValue().getValue()); 
//		System.out.println((deckCards.get(i)).getSuit());
//		}
		
		//After deck is made, shuffle the deck
		Collections.shuffle(deckCards);
		
		//Proof of concept showing full, shuffled deck
//		for (int i = 0; i < 52; i++) {
//			System.out.println((deckCards.get(i)).getValue());
//			System.out.println((deckCards.get(i)).getSuit());
//		}

	}
	public static ArrayList<Card> getDeckCards() {
		return deckCards;
	}
	//used to draw the top card from deck
	public Card draw() {
		//takes first card in list (top card) and 
		Card dealtCard = deckCards.get(0);
		//removes it from deck so that it cannot be used again
		deckCards.remove(dealtCard);
		return dealtCard;

	}
	
	public int deckCount() {
		//returns number of cards left
		return deckCards.size();
	}
//	public static void main(String[] args){
//		Deck test = new Deck();
//	}
}
