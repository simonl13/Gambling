import java.util.Random;

public class Lottery {
	
	
	public int number1;
	public int number2;
	public int number3;
	
	Random lotteryNumbers = new Random(); {
	
	number1 = lotteryNumbers.nextInt(26) + 1;
	number2 = lotteryNumbers.nextInt(26) + 1;
	number3 = lotteryNumbers.nextInt(26) + 1;
	

}
}
