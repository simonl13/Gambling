import java.util.stream.IntStream;


public class Dealer {
	
	public int dealerTotal;
	public int dealerAmount;
	Cards[] dealerCards = new Cards[10];
	int[] dealerValue = new int[10];
	
	public int dealerStart() {
		dealerCards[1] = new Cards();
		if (dealerCards[1].askValue == 2) {
			dealerCards[1].setValue(11);
			dealerValue[1] = dealerCards[1].cardValue;
		}
		else {
			dealerValue[1] = dealerCards[1].cardValue;
		}
		
		dealerCards[2] = new Cards();
		dealerTotal = IntStream.of(dealerValue).sum();
		if ((dealerCards[2].askValue == 2) || (dealerTotal > 10)) {
			dealerCards[2].setValue(1);
			dealerValue[2] = dealerCards[2].cardValue;
		}
		else {
			dealerValue[2] = dealerCards[2].cardValue;
		}
		dealerAmount += 2;
		dealerTotal = (IntStream.of(dealerValue).sum());
		return dealerTotal;
	}
	
	public int dealerHit() {
	if (dealerTotal < 17) {
		dealerAmount++;
		dealerCards[dealerAmount] = new Cards();
		if (dealerCards[dealerAmount].askValue == 2) {
			if (dealerTotal > 10) {
				dealerCards[dealerAmount].setValue(1);
				dealerValue[dealerAmount] = dealerCards[dealerAmount].cardValue;
				System.out.println("Dealer drew an Ace. His total is now " + (IntStream.of(dealerValue).sum()) + ".");
				dealerTotal = (IntStream.of(dealerValue).sum());
				return dealerTotal;
			}
			else {
				dealerCards[dealerAmount].setValue(11);
				dealerValue[dealerAmount] = dealerCards[dealerAmount].cardValue;
				System.out.println("Dealer drew an Ace. Total is now " + (IntStream.of(dealerValue).sum()) + ".");
				dealerTotal = (IntStream.of(dealerValue).sum());
				return dealerTotal;
			}
		}
		else {
			dealerValue[dealerAmount] = dealerCards[dealerAmount].cardValue;
			System.out.println("Dealer has drawn a " + dealerCards[dealerAmount].card + ". Dealer's total is " + (IntStream.of(dealerValue).sum()) + ".");
			dealerTotal = (IntStream.of(dealerValue).sum());
			return dealerTotal;
		}
	}
	else if ((dealerTotal >= 17) && (dealerTotal < 21)) {
		System.out.println("Dealer stays. Value is " + (IntStream.of(dealerValue).sum()) + ".");
		dealerTotal = (IntStream.of(dealerValue).sum());
		return dealerTotal;
	}
	else if (dealerTotal == 21) {
		return 21;
	}
	else {
		dealerTotal = (IntStream.of(dealerValue).sum());
		return dealerTotal;
	}
	}
	
}
