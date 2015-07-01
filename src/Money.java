import java.util.Scanner;


public class Money {
	
	static Scanner cheatInput = new Scanner(System.in);
	public long balance = 1000;
	
	public long getCash() {
		return balance;
	}
	
	public long removeCash(long difference) {
		balance += difference;
		return balance;
	}
	
	public long giveCash(long difference) {
		balance += difference; //does the same exact thing as removeCash, only here for naming.
		return balance;
	}
	
	public long clearCash (){
		balance = 0;
		return balance;
	}
	
	public void cheatCash () {
		System.out.println("How much cash would you like to magically obtain?");
		long cheatAmount = cheatInput.nextLong();
		System.out.println("Congratulations, you inherited $" + cheatAmount + " from a mysterious death.");
		
		balance += cheatAmount;
	}
}
