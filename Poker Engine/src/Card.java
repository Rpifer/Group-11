
public class Card {
	private eSuit suit;
	private eValue value;
	
	
	
	public Card(eSuit suit, eValue value){
		this.suit = suit;
		this.value = value;
	}
	public eSuit getSuit(){
		return suit;
	}
	public eValue getValue(){
		return value;
	}
}

