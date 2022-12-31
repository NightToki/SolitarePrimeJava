package solitare01;

public class Card {
	private Suit suit;
	private Ranks rank;
	public Card(Suit suit, Ranks rank) {
		this.suit =suit;
		this.rank = rank; 

	}
	public String toString() {
		return this.rank.toString().charAt(5)+""+this.suit.toString().charAt(0);
	}

	//.charAt(0)
	public Ranks getRank() {
		return this.rank;
	}


}