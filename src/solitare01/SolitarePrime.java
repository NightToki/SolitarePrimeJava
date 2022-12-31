package solitare01;


import java.util.Scanner;

public class SolitarePrime {
	public static boolean isPrime(int x) {
		boolean isPrime = true;
		if (x ==1) {
			isPrime = false;
		}
		
		for(int i = 2; i < x;i++) {
			if(x%i==0) {
				isPrime = false;
				
			}
		}
		return isPrime;
	}
	private static int menuChoice;
	public static int menu() {
		return menuChoice;
		
	}
	public static void main(String[] args) {
		
		System.out.println("Welcome to Solitaire Prime!");
		
		Deck playingDeck = new Deck();
		playingDeck.newDeck();
		
		Deck playerDeck = new Deck();
		
		Scanner userInput = new Scanner(System.in);
		// Need the menu function here
		
		//game loop
		
		while(true) {
			System.out.println("1) New Deck");
			System.out.println("2) Display Deck");
			System.out.println("3) Shuffle Deck");
			System.out.println("4) Play Solitare Prime");
			System.out.println("5) Exit");
			System.out.println("Please select a menu choice: ");
			menuChoice  = userInput.nextInt();
			
		switch(menuChoice) {
		case 1:
			playingDeck.newDeck();
			break;
		case 2:
			//nested loop 
			System.out.println(playingDeck.toString());
			break;
		case 3:
			playingDeck.shuffle();
			break;
			
			//
		case 4:
			//this is where the game begins
			//game loop
			//(1) make a card stack which playerDeck
			// add a card to the stack //draw
			//print playerDeck which is now the player hand
			//(2) add up the value of the stack 
			//// create stack counter variable
			//(3) if stack = prime number 
			// add +1 to stack counter 
			// print the stack only if stack is prime
			//(4) else if not prime draw again
			// print stack
			// (5)add the stack and print it
			//(6)	if prime stack count +1 
			//(7) if deck =< 0 then game ends
			//check if previous stack #was prime or not
			// if stack = prime then win if not = lose	
			int primeCount = 0;

			while(playingDeck.deckSize()>0){
				playerDeck.draw(playingDeck);

				
				
				if (isPrime(playerDeck.cardsValue())) { // Problem here this 
					primeCount+= 1;
					System.out.println(playerDeck.toString2());
					System.out.println("Prime: " +playerDeck.cardsValue());
					while(playerDeck.deckSize() > 0) {
						playerDeck.removeCard(0);
					}
					
					
					// Need to discard stack here
					//break;
				}

			
				
			}// will only print the prime ones
			
			if(isPrime(playerDeck.cardsValue())) {
				System.out.println("You won in : "+primeCount+ " piles.");
				
				
			}
			else {
				System.out.println(playerDeck.toString2());
				System.out.println("Not prime: " +playerDeck.cardsValue());

				System.out.println("Lmao loser");
				while(playerDeck.deckSize() > 0) {
					playerDeck.removeCard(0);
				}
			}
			break;
		case 5:
			System.out.println("Good-bye");
			System.exit(0);
			break;
		default:
			System.out.println("This is not a valid Menu Option! Please Select Another");
            break;

		}
	}
	}

}
