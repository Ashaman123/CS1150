import java.util.Scanner; //import scanner class
public class MillspaughOwenAssignment2 {
	
	final int NumberDripsPerGallon = 15140;
	final static int NumberGallonsInOlympicPool = 600000;
	int HomesC1;
	int LeakyFaucetsC1;
	int DripsPerMinuteC1;
	int HomesC2;
	int LeakyFaucetsC2;
	int DripsPerMinuteC2;
	public static void main(String[] args) {
// TODO Auto-generated method stub
		//Create Scanner and Assign variables based on user input
		
		//City 1
		Scanner myObj = new Scanner(System.in);
		System.out.println("City #1 Drip Information: ");
		System.out.println("---------------------------");
		System.out.print("Enter the average number of homes in City #1: ");
		int HomesC1 = myObj.nextInt();
		System.out.print("Enter the average number of leaky faucets: ");
		int LeakyFaucetsC1 = myObj.nextInt();
		System.out.print("Enter the average number of drips per minute: ");
		int DripsPerMinuteC1 = myObj.nextInt();
		System.out.println("");
		
		//City 2
		System.out.println("City #2 Drip Information: ");
		System.out.println("--------------------------");
		System.out.print("Enter the average number of homes in City #2: ");
		int HomesC2 = myObj.nextInt();
		System.out.print("Enter the average number of leaky faucets: ");
		int LeakyFaucetsC2 = myObj.nextInt();
		System.out.print("Enter the average number of drips per minute: ");
		int DripsPerMinuteC2 = myObj.nextInt();

System.out.println("");	
System.out.println("City #1");
System.out.println("---------------------------------");
System.out.println ("i.   # Homes: " + HomesC1);
System.out.println ("ii.  # Faucets: " + LeakyFaucetsC1);
System.out.println ("iii. # Drips per Minute: " + DripsPerMinuteC1);
System.out.println("");

System.out.println("City #2");
System.out.println("---------------------------------");
System.out.println ("i.   # Homes: " + HomesC2);
System.out.println ("ii.  # Faucets: " + LeakyFaucetsC2);
System.out.println ("iii. # Drips per Minute: " + DripsPerMinuteC2);


double GallonsPerDayC1;
double GallonsPerYearC1;

GallonsPerDayC1 = (((DripsPerMinuteC1 * 1440.0) * LeakyFaucetsC1) * HomesC1 / 15140.0);
GallonsPerYearC1 = (GallonsPerDayC1 * 365.0);
double GallonsPerDayC2;
double GallonsPerYearC2;

GallonsPerDayC2 = (((DripsPerMinuteC2 * 1440.0) * LeakyFaucetsC2) * HomesC2 / 15140.0);
GallonsPerYearC2 = (GallonsPerDayC2 * 365.0);

double TotalGPD = (GallonsPerDayC1 + GallonsPerDayC2);
double TotalGPY = (GallonsPerYearC1 + GallonsPerYearC2);
double OlymPool = (GallonsPerYearC1 + GallonsPerYearC2) / NumberGallonsInOlympicPool;

System.out.println("");
System.out.println("");
System.out.println("-------------------------------");
System.out.println("     Water Drip Calculator");
System.out.println("-------------------------------");
System.out.println("");


System.out.println("     Homes     Faucets     Drips/Minute     Gallons/Day     Gallons/Year");
System.out.println("-----------------------------------------------------------------------------");
System.out.printf("     %d     %d           %d                %.2f         %.2f%n", HomesC1, LeakyFaucetsC1, DripsPerMinuteC1, GallonsPerDayC1, GallonsPerYearC1);
System.out.printf("     %d     %d           %d               %.2f         %.2f%n", HomesC2, LeakyFaucetsC2, DripsPerMinuteC2, GallonsPerDayC2, GallonsPerYearC2);
System.out.println("-----------------------------------------------------------------------------");
System.out.printf("     Total                                  %.2f        %.2f%n", TotalGPD, TotalGPY);
System.out.printf("%n Number of Olympic pools that could be filled: %.2f", OlymPool);	
System.out.println();
	}

}
