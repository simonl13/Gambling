import java.util.stream.IntStream;


public class Player {
	
	public int playerAmount;
	Cards[] playerCards = new Cards[10];
	int[] playerValue = new int[10];
	
	public int playerTotal = IntStream.of(playerValue).sum();
	
	public int playerStart() {
		playerCards[1] = new Cards();
		if (playerCards[1].askValue == 2) {
			playerCards[1].setValue(11);
			playerValue[1] = playerCards[1].cardValue;
			System.out.println("You drew an Ace. Value is 11.");
		}
		else {
			playerValue[1] = playerCards[1].cardValue;
			System.out.println("You drew a " + playerCards[1].card + ".");
		}
		
		playerCards[2] = new Cards();
		
		if ((playerCards[2].askValue == 2) || (playerTotal > 10)) {
			playerCards[2].setValue(1);
			playerValue[2] = playerCards[2].cardValue;
			playerTotal = IntStream.of(playerValue).sum();
			System.out.println("You drew an Ace. Value is 1. Total is " + playerTotal + ".");
		}
		else {
			playerValue[2] = playerCards[2].cardValue;
			playerTotal = IntStream.of(playerValue).sum();
			System.out.println("You drew a " + playerCards[2].card + ". Total is now " + playerTotal + ".");
		}
		
		playerAmount += 2;
		return playerTotal;
	}
	
	public int playerStay() {
		playerTotal = IntStream.of(playerValue).sum();
		System.out.println("Player stayed. Total is still " + playerTotal + ".");
		return playerTotal;
	}
	
	public int playerHit() {
	playerAmount++;
	playerCards[playerAmount] = new Cards();
	if (playerCards[playerAmount].askValue == 2) {
		if (playerTotal > 10) {
			playerCards[playerAmount].setValue(1);
			playerValue[playerAmount] = playerCards[playerAmount].cardValue;
			playerTotal = IntStream.of(playerValue).sum();
			System.out.println("Player drew an Ace. Total is now " + playerTotal + ".");
			return playerTotal;
		}
		else {
			playerCards[playerAmount].setValue(11);
			playerValue[playerAmount] = playerCards[playerAmount].cardValue;
			playerTotal = (IntStream.of(playerValue).sum());
			System.out.println("Player drew an Ace. Total is now " + playerTotal + ".");
			return playerTotal;
		}
	}
	else {
		//this code is broken somehow..
		playerValue[playerAmount] = playerCards[playerAmount].cardValue;
		playerTotal = (IntStream.of(playerValue).sum());
		System.out.println("Player has drawn a " + playerCards[playerAmount].card + ". Total is " + playerTotal + ".");
		return playerTotal;
	}
	}
	
}
