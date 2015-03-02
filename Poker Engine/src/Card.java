
public class Card {
	private eSuit suit;
	private eValue value;
	
	private Card(){
		
	}
	
	private Card(eSuit suit, eValue value){
		this.suit = suit;
		this.value = value;
	}
	public eSuit getSuit(){
		return this.suit;
	}
	public eValue getValue(){
		return this.value;
	}
}
