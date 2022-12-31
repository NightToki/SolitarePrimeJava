package solitare01;


import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	public Deck() {
		this.cards=new ArrayList<Card>();
	}
	public void newDeck() {
		for(Suit cardSuit : Suit.values() ) {
			for(Ranks cardRank : Ranks.values()) {
				this.cards.add(new Card(cardSuit,cardRank));
			}
		}
	}
	public void shuffle() {
		ArrayList<Card>tmpDeck = new ArrayList<Card>();
		Random random = new Random();
		int randomCardIndex = 0;
		int originalSize = this.cards.size();
		for(int i =0; i< originalSize;i++) {
			randomCardIndex = random.nextInt((this.cards.size()-1 - 0)+1)+0;
			tmpDeck.add(this.cards.get(randomCardIndex));
			this.cards.remove(randomCardIndex);
		}
		
		this.cards= tmpDeck;
	}
	public String toString() {
		String cardListOutput="";
		//for(Card aCard: this.cards) {
		int counter = 0;
			for(int row = 0; row <4; row++) {
				for(int col = 0; col <13;col++) {
				cardListOutput +=this.cards.get(counter)  +" ";
				counter++;
				
				}
				cardListOutput += "\n";
			}
			
			//nested loop 4x13
		return cardListOutput;
	}
	public String toString2() {
		String cardListOutput="";
		for(Card aCard: this.cards) {
			cardListOutput += aCard.toString() +" ";
			//nested loop 4x13
		}
		return cardListOutput;
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	public Card getCard(int i ) {
		return this.cards.get(i);
	}
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	public void draw(Deck comingFrom) {
		this.cards.add(comingFrom.getCard(0));
		comingFrom.removeCard(0);
		
	}
	public void discardHand(Deck discard) {
		discard.removeCard(0);
	}
	public int deckSize()
	{
		return this.cards.size();
	}
	public void moveAllToDeck(Deck moveTo) {
		int thisDeckSize = this.cards.size();
		
		for(int i = 0; i < thisDeckSize; i++) {
			moveTo.addCard(this.getCard(i));
		}
		
		for(int i = 0; i< thisDeckSize;i++) {
				this.removeCard(0);
		}
	}
	public int cardsValue() {
		int totalValue = 0;
		for(Card aCard : this.cards) {
			switch(aCard.getRank()) {
			case Two__2: totalValue += 2; break;
			case Three3: totalValue += 3; break;
			case Four_4: totalValue += 4; break;
			case Five_5: totalValue += 5; break;
			case Six__6: totalValue += 6; break;
			case Seven7: totalValue += 7; break;
			case Eight8: totalValue += 8; break;
			case Nine_9: totalValue += 9; break;
			case Ten__T: totalValue += 10; break;
			case Jack_J: totalValue += 10; break;
			case QueenQ: totalValue += 10; break;
			case King_K: totalValue += 10; break;
			case Ace__A: totalValue += 1; break;
			
			}
		}
		return totalValue;
	}

}

