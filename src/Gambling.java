import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Gambling {

	static Scanner playerInput = new Scanner(System.in);
	static Random randomNumber = new Random();
	
	public static long cheat() {
		System.out.println("How much more money would you like to magically obtain?");
		long cheatAmount = playerInput.nextLong();
		System.out.println("Congratulations, you've inherited $" + cheatAmount + " from a mysterious death.");
		
		return cheatAmount;
		//returns cheatAmount, added into balance later.
	}
	
	public static long bet(long balance) throws InterruptedException {
		short number;
		long wager;
		long difference;
		
		System.out.println("Pick an integer, 1-4."); //Typing in a decimal will break this.
		number = playerInput.nextShort();
		if (0<number && number<5) {
			System.out.println("Wager Amount (must be an integer) :"); //Typing in a decimal will break this.
			wager = playerInput.nextLong();
			if (wager < 0) {
				System.out.println("You cannot bet a negative amount.");
				return 0;
			}
			else {
				if (wager<=balance) {
					int luckyNumber = randomNumber.nextInt(4) +1;
					if (number == luckyNumber) {
						Thread.sleep(400);
						System.out.println("You've guessed the number!");
						Thread.sleep(400);
						System.out.println("You win $" + wager + "!");
						difference = wager;
						return difference;
					}
					else {
						Thread.sleep(400);
						System.out.println("The number was " + luckyNumber + ". You guessed " + number + ".");
						Thread.sleep(400);
						System.out.println("You've lost $" + wager + ".");
						difference = 0 - wager;
						return difference;
					}
					
				}
				else {
					System.out.println("You do not have $" + wager + ". You only have $" + balance + ".");
					return 0;
				}
			}
		}
		else {
			System.out.println("That is not a number from 1-4.");
			return 0;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		long balance = 1000;
		long difference;
		String command = "";
		
		System.out.println("Welcome to the Gambling Place. You start with a balance of $1000.");
		Thread.sleep(200);
		System.out.println("When you run out of money, you lose the game.");
		Thread.sleep(200);
		System.out.println("Let's start. Type \"help\" to start.");
		
		while(true) {
			if (balance == 0) {
				System.out.println("Game over. You ran out of cash.");
				playerInput.close();
				
				System.exit(0);
			}
			else {
				command = playerInput.next();
				switch (command) {
				default:
					System.out.println("Invalid command: Type \"help\" to see commands.");
					break;
				case "blackjack":
					difference = blackjack(balance);
					balance += difference;
					break;
				case "cards":
					difference = cards(balance);
					balance += difference;
					break;
				case "help":
					System.out.println("Possible choices:");
					Thread.sleep(200);
					System.out.println("balance, blackjack, cards, help, lottery, numbers, quit");
					break;
				case "balance":
					System.out.println("Balance: $" + balance);
					break;
				case "quit":
					System.out.println("Game Over.");
					Thread.sleep(400);
					System.out.println("You have $" + balance + " left.");
					playerInput.close();
					System.exit(0);
				case "cheat":
					long cheatAmount = cheat();
					balance += cheatAmount;
					//adds cheatAmount from cheat(); to balance
					break;
				case "numbers":
					difference = bet(balance);
					balance += difference;
					break;
				case "lottery":
					difference = lottery(balance);
					balance += difference;
					break;
				}
			}
		}
	}

	public static long cards(long balance) throws InterruptedException {
		long difference = 0;
		String suit;
		String [] suitList = { "DIAMONDS", "CLOVERS", "HEARTS", "SPADES"};
		String [] cardList = { "ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING" };
		short correctCard = 0;
		short correctSuit = 0;
		String luckySuit;
		int luckyCardNumber;
		String luckyCard;
		String card = null;
		long wager;
		
		System.out.println("Welcome to Card Guessing!");
		Thread.sleep(400);
		System.out.println("If you get either the suit or the number right, you win half your bet.");
		Thread.sleep(300);
		System.out.println("If you get both right, you win your bet.");
		Thread.sleep(300);
		System.out.println("What would you like to bet?");
		wager = playerInput.nextLong();
		if (wager<=balance) {

			System.out.println("Choose a suit: Diamonds, Clovers, Hearts, Spades.");
			suit = (playerInput.next()).toUpperCase();
			if (Arrays.asList(suitList).contains(suit)) {

				int luckyNumber = randomNumber.nextInt(4);
				luckySuit = suitList[luckyNumber];
				
				if (luckySuit.equalsIgnoreCase(suit)) {
					correctSuit = 2;
				}
			
				System.out.println("Choose a card: Ace-King");
				card = (playerInput.next()).toUpperCase();
				if (Arrays.asList(cardList).contains(card)) {
					luckyCardNumber = randomNumber.nextInt(13);
					luckyCard = cardList[luckyCardNumber];
			
					if (card.equalsIgnoreCase(luckyCard)) {
						correctCard = 2;
					}
		
					if (correctSuit == 2 && correctCard == 2) {
						System.out.println("You guessed correct! Here's your $" + wager + ".");
						difference = wager;
					}
					else if (correctSuit == 2 || correctCard == 2) {
						System.out.println("The card was a " + luckySuit + " " + luckyCard + ".");
						System.out.println("You win $" + wager/2 + ".");
						difference = wager/2;
					}
					else {
						System.out.println("The card was a " + luckySuit + " " + luckyCard + ".");
						System.out.println("You lose $" + wager + ".");
						difference = 0 - wager;
					}
		
					return difference;
				}
				else {
					System.out.println("That is not a card.");
					return 0;
				}
			}
			else {
				System.out.println("That is not a suit.");
				return 0;
			}
		}
		else {
			System.out.println("You do not have $" + wager + ".");
			return 0;
		}
	}

	public static long blackjack(long balance) throws InterruptedException {
		System.out.println("Welcome to Blackjack!");
		System.out.println("How much would you like to bet?");
		long wager = playerInput.nextLong();
		if (wager < 0) {
			System.out.println("You can not wager nonpositive integers.");
			return 0;
		}
		if (wager<=balance) {
			Cards cards [] = new Cards[10];
			int cardValues [] = new int[10];
			short cardAmount = 0;
			short aceAmount = 0;
			int extra = 0;
			int dealerTotal;
			
			cards[1] = new Cards();
			cardAmount++;
			if (cards[1].askValue == 2) {
				System.out.println("You have drawn an Ace. You can alter its value with the \"ace\" command.");
				aceAmount++;
			}
			else {
				cardValues[1] = cards[1].cardValue;
				System.out.println("You drew a " + cards[cardAmount].card + ".");
			}
			
			cards[2] = new Cards();
			cardAmount++;
			if (cards[2].askValue == 2) {
				System.out.println("You have drawn an Ace. You can alter its value with the \"ace\" command.");
				aceAmount++;
			}
			else {
				cardValues[2] = cards[2].cardValue;
				System.out.println("You drew a " + cards[cardAmount].card + ".");
			}
			
			Dealer dealerMan = new Dealer();
			dealerTotal = dealerMan.dealerStart();
			if (dealerTotal == 21) {
				System.out.println("The dealer drew 21. You lose $" + wager + ".");
				return 0 - wager;
			}
			else {
				while(true) {
					String command2 = playerInput.next();
					switch (command2){
					default:
						System.out.println("Invalid command. Type \"help\" for commands.");
						break;
					case "ace":
						if (aceAmount == 0) {
							System.out.println("You have no Aces.");
							break;
						}
						else {
							System.out.println("You have " + aceAmount + " Aces.");
							System.out.println("Your total is currently " + ((IntStream.of(cardValues).sum()) + extra) + ". Which value: 1 or 11?");
							int aceValue = playerInput.nextInt();
							if (aceValue == 1 || aceValue == 11) {
								extra += aceValue;
								aceAmount--;
								System.out.println("Your total is now " + ((IntStream.of(cardValues).sum()) + extra) + ".");
								break;
							}
							else {
								System.out.println("That is not a valid value.");
								break;
							}
						}
					case "help":
						System.out.println("Commands: help, hit, stay, total.");
						break;
					case "hit":
						dealerTotal = dealerMan.dealerHit();
						if (dealerTotal == 21) {
							System.out.println("Dealer got 21. You lose $" + wager + ".");
							return 0 - wager;
						}
						else if (dealerTotal > 21) {
							System.out.println("Dealer has over 21. You win $" + wager + ".");
							return wager;
						}
						else {
							cardAmount++;
							cards[cardAmount] = new Cards();
							if (cards[cardAmount].askValue == 2) {
								System.out.println("You drew an Ace. Use the command \"ace\" to change its value.");
								aceAmount++;
								break;
							}
							else {	
								cardValues[cardAmount] = cards[cardAmount].cardValue;
								int cardTotal = IntStream.of(cardValues).sum() + extra;
								System.out.println("You drew a " + cards[cardAmount].card + " and your total is " + cardTotal + ".");
								if (cardTotal > 21) {
									System.out.println("Your total is over 21. You lost $" + wager + ".");
									return 0 - wager;
								}
								else if (cardTotal == 21) {
									System.out.println("Your total is 21. You win $" + wager + ".");
									return wager;
								}
								else {
									break;
								}
							}
						}
					case "stay":
						while(dealerTotal < 17) {
							dealerTotal = dealerMan.dealerHit();
						}
						if (dealerTotal == 21) {
							System.out.println("The dealer has 21. You lose $" + wager + ".");
							return 0 - wager;
						}
						else if (dealerTotal > 21) {
							System.out.println("The dealer has over 21. You win $" + wager + ".");
							return wager;
						} 
						else {
							int yourTotal = IntStream.of(cardValues).sum() + extra;
							System.out.println("Your total is " + yourTotal + ". The dealer has " + dealerTotal + ".");
							if (dealerTotal == 21) {
								System.out.println("The dealer has 21 and wins. You lose $" + wager + ".");
								return 0 - wager;
							}
							else if (dealerTotal > 21) {
								System.out.println("The dealer has more than 21. You win $" + wager + ".");
								return wager;
							}
							else if ((21 - dealerTotal) < (21 - yourTotal)) {
								System.out.println("The dealer has " + dealerTotal + " and you have " + yourTotal + ".");
								System.out.println("You lose $" + wager + ".");
								return 0 - wager;
							}
							else if (dealerTotal == yourTotal) {
								System.out.println("You both have " + dealerTotal + ".");
								System.out.println("You lose $" + wager + ".");
								return 0 - wager;
							}
							else {
								System.out.println("The dealer has " + dealerTotal + " and you have " + yourTotal + ".");
								System.out.println("You win $" + wager + ".");
								return wager;
							}
						}
					case "total":
						int cardTotal = IntStream.of(cardValues).sum() + extra;
						System.out.println("Your total is " + cardTotal + ".");
						System.out.println("The dealer has " + dealerMan.dealerTotal + ".");
					}
				}
			}
		}
		else {
			System.out.println("You do not have $" + wager + ".");
			return 0;
		}
		
	}

	public static long lottery(long balance) {
		System.out.println("Welcome to the Lottery Place!");
		System.out.println("Which ticket do you want to buy?");
		System.out.println("$5, $25, $100, $1000 (Type without the dollar sign)");
		
		int gambleAmount = playerInput.nextInt();
		if (gambleAmount == 5 || gambleAmount == 25 || gambleAmount == 100 || gambleAmount == 1000) {
			System.out.println("What is your first lucky number from 1-25?");
			int guess1 = playerInput.nextInt();
			
			System.out.println("What is your second lucky number from 1-25?");
			int guess2 = playerInput.nextInt();
			
			
			System.out.println("What is your third lucky number from 1-25?");
			int guess3 = playerInput.nextInt();
			
			if ((guess1 > 25) || (guess2 > 25) || (guess3 > 25) || (1 > guess1) || (1 > guess2) || (1 > guess3)) {
				System.out.println("One of your numbers was invalid.");
				return 0;
			}
			else {
				Lottery lotto = new Lottery();
				if ((guess1 == lotto.number1) && (guess2 == lotto.number2) && (guess3 == lotto.number3)) {
					System.out.println("All your numbers were right! You win $" + gambleAmount + "!");
					return gambleAmount;
				}
				else if (((lotto.number1 == guess1) ^ (lotto.number2 == guess2) ^ (lotto.number3 == guess3)) && !((lotto.number1 == guess1) && (lotto.number2 == guess2) && (lotto.number3 == guess3))) {
					System.out.println("Tonight's lucky numbers were " + lotto.number1 + " " + lotto.number2 + " " + lotto.number3 + ".");
					System.out.println("One of your numbers was right! You win $" + (gambleAmount/6) + "!");
					return (gambleAmount/6);
				}
				else if ((lotto.number1 == guess1) ^ (lotto.number2 == guess2) ? (lotto.number3 == guess3) : (lotto.number1 == guess1)) {
					System.out.println("Tonight's lucky numbers were " + lotto.number1 + " " + lotto.number2 + " " + lotto.number3 + ".");
					System.out.println("Two out of three of your numbers were right! You win $" + (gambleAmount/2) + "!");
					return (gambleAmount/2);
				}
				else {
					System.out.println("Tonight's lucky numbers were " + lotto.number1 + " " + lotto.number2 + " " + lotto.number3 + ".");
					System.out.println("None of your numbers were right. You lose $" + gambleAmount + ".");
					return (0 - gambleAmount);
				}
			}
			
		}
		else {
			System.out.println("That is not a valid ticket amount.");
			return 0;
		}
	}
}