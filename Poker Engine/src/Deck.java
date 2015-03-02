import java.util.ArrayList;
import java.util.*;


public class Deck {
	
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	private Deck(){
		int i;
		int j;
		
		for(i = 0; i < 4; i++){			
			eSuit suit = eSuit.values()[i];
			
			for(j = 0; j < 14; j++){				
				eValue value = eValue.values()[j];
				
				DeckCards.add(new Card(suit, value));
				
				
			}
				
			Collections.shuffle(DeckCards);
		}

	}
}

