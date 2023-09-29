import java.util.Scanner;
import java.util.Random;

public class MillspaughOwenAssignment6 {
	
	
	public static void main(String[] args) {
	
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	String spin = "Y";
	int word = 0;
	String image = "SEVEN";
	
	
	
	System.out.println("Please enter how much money you would like to use ($1 = 1 credit): ");
		int userCredits = scanner.nextInt();
		while(userCredits > 0 && spin != "N") { //Outside while loop continues if userCredit > 0 && spin == 'Y'
			//scanner.nextLine();
			System.out.println("Entered while loop");
			
			
			for (int i = 0; i < userCredits; i++) { //spin roulette
				System.out.println("Entered for loop. i = " + i);
				System.out.println("");
					//word = random.nextInt(6); 						
						word = random.nextInt(6); 
					switch (word){ //Assigns random int to a "image" for spinner
						case 1:
							image = "PLUM";
							System.out.println("Prints: " + image);
							break;
						case 2:
							image = "CHERRY";
							System.out.println("Prints: " + image);
	
							break;
						case 3: 
							image = "BELL";
							System.out.println("Prints: " + image);
	
							break;
						case 4: 
							image = "BAR";
							System.out.println("Prints: " + image);
	
							break;
						case 5: 
							image = "SEVEN";
							System.out.println("Prints: " + image);
						default: 
							System.out.println("I shouldnt be here");
							break;
							
				}
				
			}
			System.out.println("Would you like to spin again?");
				spin = scanner.nextLine().toUpperCase();
				//System.out.println(userCredits);
		}
	
	
	
	}
}
