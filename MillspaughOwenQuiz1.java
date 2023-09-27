/**
 * 
 */

/**
 * 
 */
import java.util.Scanner;
public class MillspaughOwenQuiz1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String DELUXE = "Deluxe";
		String PREMIUM = "Premium";
		String STANDARD = "Standard";
Scanner input = new Scanner(System.in);
	System.out.println("Please input the starting character of the type of wash you want: ");
		String WashType = input.nextLine();
		
if (WashType.contains("d") || WashType.contains("s") || WashType.contains("p")) {
	if (WashType.contains("d")){
		System.out.println("You have chosen " + DELUXE);
	}
	else if (WashType.contains("p")) {
		System.out.println("You have chosen " + PREMIUM);
	}
	else {
	System.out.println("You have chosen " + STANDARD);
	}
	
	System.out.println("Please input the number of your type of vehicle: ");
	System.out.println("1. Compact");
	System.out.println("2. Standard ");
	System.out.println("3. Truck");
	System.out.println("4. SUV");

		int VehicleType = input.nextInt();
			if(VehicleType < 5 && VehicleType > 0) {
				System.out.println("  Type of Wash		  Extra Cost");
				System.out.println("--------------------------------------");
				if (WashType.equals("d")) {
					System.out.println("Total Wash Cost: $5 Standard Fee + $3 Extra Cost");
					System.out.println("Amount Due: $8.00");
				}
				else if (WashType.contains("p")) {
					System.out.println("Total Wash Cost: $5 Standard Fee + $6 Extra Cost");
					System.out.println("Amount Due: $11.00");
				}
				else {
					System.out.println("Total Wash Cost: $5 Standard Fee");
					System.out.println("Amount Due: $11.00");
				}

		}
			else {
				System.out.println("Invalid option, please restart program.");
			}
}
else {
	System.out.println("Invalid option, please restart program.");
}
	}

}
