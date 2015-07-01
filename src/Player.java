import java.util.stream.IntStream;


public class Player {
	
	public int playerAmount;
	Cards[] playerCards = new Cards[10];
	int[] playerValue = new int[10];
	
	public int playerTotal = IntStream.of(playerValue).sum();
	
	public int playerStart() {
		playerCards[1] = new Cards();
		if (playerCards[1].askValue == 2) {
			playerCards[1].cardValue = 11;
			System.out.println("You drew an Ace. Value is 11.");
		}
		else {
			playerValue[1] = playerCards[1].cardValue;
			System.out.println("You drew a " + playerCards[1].card + ".");
		}
		
		playerCards[2] = new Cards();
		playerTotal = IntStream.of(playerValue).sum();
		if ((playerCards[2].askValue == 2) || (playerTotal > 10)) {
			playerCards[2].cardValue = 1;
			System.out.println("You drew an Ace. Value is 1. Total is " + playerTotal + ".");
		}
		else {
			playerValue[2] = playerCards[2].cardValue;
			System.out.println("You drew a " + playerCards[2].card + ". Total is now " + playerTotal + ".");
		}
		
		playerAmount++;
		return playerTotal;
	}
	
	public int playerStay() {
		System.out.println("Player stayed. Total is still " + playerTotal + ".");
		return playerTotal;
	}
	
	public int playerHit() {
	playerAmount++;
	playerCards[playerAmount] = new Cards();
	if (playerCards[playerAmount].askValue == 2) {
		if (playerTotal > 10) {
			playerCards[playerAmount].cardValue = 1;
			playerValue[playerAmount] = playerCards[playerAmount].cardValue;
			System.out.println("Player drew an Ace. Total is now " + (IntStream.of(playerValue).sum()) + ".");
			playerTotal = (IntStream.of(playerValue).sum());
			return playerTotal;
		}
		else {
			playerCards[playerAmount].cardValue = 11;
			playerValue[playerAmount] = playerCards[playerAmount].cardValue;
			System.out.println("Player drew an Ace. Total is now " + (IntStream.of(playerValue).sum()) + ".");
			playerTotal = (IntStream.of(playerValue).sum());
			return playerTotal;
		}
	}
	else {
		playerValue[playerAmount] = playerCards[playerAmount].cardValue;
		System.out.println("Player has drawn a " + playerCards[playerAmount].card + ". Total is " + (IntStream.of(playerValue).sum()) + ".");
		playerTotal = (IntStream.of(playerValue).sum());
		return playerTotal;
	}
	}
	
}
