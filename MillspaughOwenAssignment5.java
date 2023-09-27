import java.util.Random;
import java.util.Scanner;
/**
 * 
 */
public class MillspaughOwenAssignment5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		System.out.println("*************************");
		System.out.println("   SCRATCH TICKET GAME   ");
		System.out.println("*************************");
		
 /**
  * Prompt user for number of scratch tickets they want to buy
  * between 1-15. While loop used to reenter program if number 
  * of tickets is not allowed.
  */
		System.out.println("How many scratch tickets would you like to buy? (1-15)");
		int TicketNumber = input.nextInt();
		
		while(TicketNumber > 15 || TicketNumber < 0) {
			System.out.println("Invalid ticket number. Try again!");
			TicketNumber = input.nextInt();
		}
 /*
  * Use for loop to iterate through amount of tickets required
  * generates 1 random winning number and 3 random numbers. (generate random numbers
  * first then use check if winning number is equal). Display ticket number, 
  * outcome(winning and losing) Winning number, and the scratch numbers		
  */
    int WinCount = 0;
	System.out.println("Ticket	Outcome	 Winning #	Scratch Ticket Numbers");
	System.out.println("--------------------------------------------------");
		for (int i = 0; i < TicketNumber; i++) {
			int Num1 = random.nextInt(30) + 1; 
			int Num2 = random.nextInt(30) + 1;
			int Num3 = random.nextInt(30) + 1;
			int WinningNumber = random.nextInt(30) + 1;
			
				if(WinningNumber == Num1 || WinningNumber == Num2 || WinningNumber == Num3) {
					WinCount++;
					System.out.printf("%d	Winner	 %d		%d	%d	%d%n", i, WinningNumber, Num1, Num2, Num3);
					
				}
				else {
					System.out.printf("%d	Loser	 %d		%d	%d	%d%n", i, WinningNumber, Num1, Num2, Num3);
				}
		}	
 /*
  * After for loop completes, display overall statistics. # of tickets purchased, 
  * # of winning tickets, proportion won based on tickets purchased
  */
		float WinPercent = (float)WinCount / TicketNumber * 100;
		System.out.println("");
		System.out.println("Number of scratch tickets: " + TicketNumber);
		System.out.println("Number of winning tickets: " + WinCount);
		System.out.println("Win percentage: " + WinPercent + "%");
		
		
		input.close();
	}

}
