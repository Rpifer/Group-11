import java.util.*;

public class Hand {
	// ranks hand
	private int strength;
	// high card value for play cards
	private int high;
	// low card value for play cards
	private int low;
	// card values not used for high play
	private int[] kicker = new int[5];
	// new list to hold cards in hand
	private ArrayList<Card> handCards = new ArrayList<Card>();

	// getter for hand strength
	public int getStrength() {
		return strength;
	}

	// setter for hand strength
	private void setStrength(int strength) {
		this.strength = strength;
	}

	// getter for high card
	public int getHigh() {
		return high;
	}

	// setter for high card
	private void setHigh(int high) {
		this.high = high;
	}

	// getter for low card
	public int getLow() {
		return low;
	}

	// setter for low card
	private void setLow(int low) {
		this.low = low;
	}

	// getter for kickers
	public int[] getKicker() {
		return kicker;
	}

	// basic hand constructor, must pass specific deck
	public Hand(Deck deck) {
		// all hands start with no strength or high cards until ranked
		this.setStrength(0);
		this.setHigh(0);
		this.setLow(0);
		// draws 5 cards and adds them to hand
		for (int i = 0; i < 5; i++) {
			Card topCard = deck.draw();
			handCards.add(topCard);
		}
	}

	// getter for array to access card in hands
	public ArrayList<Card> getHandCards() {
		return handCards;
	}

	// shortens writing of mutli-method chain to get card value
	public int getCardValue(Hand hand, int index) {
		return hand.getHandCards().get(index).getValue().getValue();
	}

	// Sorts hand from low->high ignoring suits
	public void sortHand() {
		Card temp;
		// check each positions value and compares it to every other value
		// when it finds the lowest position that it is smaller than, it removes
		// the
		// current position and adds it before the value its smaller than.
		for (int i = 1; i < 5; i++) {
			if (handCards.get(i).getValue().getValue() <= handCards.get(0)
					.getValue().getValue()) {
				temp = handCards.get(i);
				handCards.remove(i);
				handCards.add(0, temp);
			} else if (handCards.get(i).getValue().getValue() <= handCards
					.get(1).getValue().getValue()) {
				temp = handCards.get(i);
				handCards.remove(i);
				handCards.add(1, temp);
			} else if (handCards.get(i).getValue().getValue() <= handCards
					.get(2).getValue().getValue()) {
				temp = handCards.get(i);
				handCards.remove(i);
				handCards.add(2, temp);
			} else if (handCards.get(i).getValue().getValue() <= handCards
					.get(3).getValue().getValue()) {
				temp = handCards.get(i);
				handCards.remove(i);
				handCards.add(3, temp);
			}
		}

	}

	// Used to rate a hand when passed a specific hand
	public void rateHand(Hand hand) {
		// Top ranking, high is Ace, low is 10
		if (hand.isRoyalFlush()) {
			hand.setStrength(10);
			hand.setHigh(14);
			hand.setLow(10);
		}
		// 2nd ranking, sets the high card as last postiion
		else if (hand.isStraightFlush()) {
			hand.setStrength(9);
			hand.setHigh(getCardValue(hand, 4));
			hand.setLow(getCardValue(hand, 0));
		}
		// 3rd ranking, the 4th card will always be part of the 4 of a kind so
		// that is high card
		// the kicker is then assigned whichever card is the odd one out
		else if (hand.isFourOfAKind()) {
			hand.setStrength(8);
			hand.setHigh(getCardValue(hand, 3));
			hand.setLow(0);
			if (handCards.get(0).getValue().getValue() == handCards.get(3)
					.getValue().getValue()) {
				this.kicker[0] = getCardValue(hand, 4);
			} else
				this.kicker[0] = getCardValue(hand, 0);
		}

		// Need full house checker

		// 5th ranking, the top card will always be last value
		// the rest are kickers and is used to determine winner if top card ties
		else if (hand.isFlush()) {
			hand.setStrength(6);
			hand.setHigh(getCardValue(hand, 4));
			for (int i = 0; i < 4; i++) {
				this.kicker[i] = getCardValue(hand, i);
			}
		}
	}

	public Hand rateHand(Hand[] hands) {
		Hand winner = null;
		int max = 0;
		int high = 0;
		for (Hand hand : hands) {
			rateHand(hand);
			if (hand.getStrength() > max) {
				max = hand.getStrength();
				high = hand.getHigh();
				winner = hand;
			} else if (hand.getStrength() == max) {
				if (hand.getHigh() > high) {
					max = hand.getStrength();
					high = hand.getHigh();
					winner = hand;
				}

			}
		}
		return winner;
	}

	// Example: (10H,JH, QH, KH, AceH)
	// checks is all five cards are the 10,J,Q,K,Ace
	// then checks if all of them have same suit using in straight
	public boolean isRoyalFlush() {
		if ((handCards.get(0).getValue().getValue() == 10)
				&& (handCards.get(1).getValue().getValue() == 11)
				&& (handCards.get(2).getValue().getValue() == 12)
				&& (handCards.get(3).getValue().getValue() == 13)
				&& (handCards.get(4).getValue().getValue() == 14)) {
			return (isFlush());
		} else
			return false;
	}

	// Example:(4H,5H,6H,7H,8H)
	// checks if all are the same suit using isStraight
	// if they are, it will see if the first card is one less than next card
	// etc.
	public boolean isStraightFlush() {
		if (isFlush()) {
			return ((handCards.get(0).getValue().getValue() == handCards.get(1)
					.getValue().getValue() - 1)
					& (handCards.get(1).getValue().getValue() == handCards
							.get(2).getValue().getValue() - 1)
					& (handCards.get(2).getValue().getValue() == handCards
							.get(3).getValue().getValue() - 1) & (handCards
					.get(3).getValue().getValue() == handCards.get(4)
					.getValue().getValue() - 1));
		} else
			return false;
	}

	// Example: (3H,6H,6C,6D,6S)
	// Checks if the first and fourth cards are the same (then the between are
	// the same)
	// Or if the second an fith are the same (again, between)
	public boolean isFourOfAKind() {
		if (handCards.get(0).getValue().getValue() == handCards.get(3)
				.getValue().getValue()) {
			return true;
		} else
			return (handCards.get(1).getValue().getValue() == handCards.get(4)
					.getValue().getValue());
	}

	// Example: (3C,7C,8C,JC,KC)
	// Checks if all cards have the same suit
	public boolean isFlush() {
		return ((handCards.get(0).getSuit() == handCards.get(1).getSuit())
				&& (handCards.get(1).getSuit() == handCards.get(2).getSuit())
				&& (handCards.get(2).getSuit() == handCards.get(3).getSuit()) && (handCards
				.get(3).getSuit() == handCards.get(4).getSuit()));

	}

	// Proof of concept that the draw method works, that the new hand method
	// works, that the sort hand method works.
	// public static void main(String[] args){
	// Deck test = new Deck();
	// Hand testHand = new Hand(test);
	// for (int i = 0; i < 5; i++){
	// System.out.println(testHand.getHandCards().get(i).getValue());
	// System.out.println(testHand.getHandCards().get(i).getSuit());
	// }
	// testHand.sortHand();
	// for (int i = 0; i < 5; i++){
	// System.out.println(testHand.getHandCards().get(i).getValue());
	// System.out.println(testHand.getHandCards().get(i).getSuit());
	// }
	// }
}
