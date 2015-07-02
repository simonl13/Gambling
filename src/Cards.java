import java.util.Random;

public class Cards{
	
	Random randomNumber = new Random();

	private String[] cardList = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	public int cardValue;
	public int askValue;
	public String card = cardList[randomNumber.nextInt(13)];
	public int askPlayer; {
	
	if (card.equalsIgnoreCase("Ace")) {
		cardValue = 1;
		askValue = 2;
	}
	else if (card.equalsIgnoreCase("Jack")) {
		cardValue = 10;
	}
	else if (card.equalsIgnoreCase("Queen")) {
		cardValue = 10;
	}
	else if (card.equalsIgnoreCase("King")) {
		cardValue = 10;
	}
	else {
		cardValue = Integer.parseInt(card);
	}
}

	public void setValue(int aceValue) {
		cardValue = aceValue;
	}
}
