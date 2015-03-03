import java.util.*;

public class Hand {
	
	private static ArrayList<Card> HandCards = new ArrayList<Card>();
	
	
	
	
	public Hand(){	
		
		int i = 0;
		
		while(i < 5){
		
		Card c = Deck.draw();		
		HandCards.add(c);
		i++;	
		
		}		
		
		//Collections.sort(player[length]);
		
		for(int j = 0; j < 5; j++){
			
			if(HandCards[j].value < HandCards[j+1]){
				
			}
			
					
		}
	
		
		
	}
	




}
