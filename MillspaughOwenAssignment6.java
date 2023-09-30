import java.util.Scanner;
import java.util.Random;

public class MillspaughOwenAssignment6 {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String spin = "Y";
        int word1 = 0, word2 = 0, word3 = 0;
        String image1 = "SEVEN", image2 = "SEVEN", image3 = "SEVEN";
        int winCount = 0;
        int loseCount = 0;
        int originalUserCredits = 0;
        int loopCount = 0;
        
        System.out.println("Please enter how much money you would like to use ($1 = 1 credit): ");
        int userCredits = scanner.nextInt();
        originalUserCredits = userCredits;
        loopCount = userCredits;
        
        while (userCredits <= 0) {
            System.out.println("$" + userCredits + " is an invalid amount. Please enter a valid amount: ");
            userCredits = scanner.nextInt();
            originalUserCredits = userCredits;
            loopCount = userCredits;
        }

        System.out.printf("%s\t%s\t%s%n", image1, image2, image3);
        System.out.println("-------------------------------------------------");
        System.out.printf("|Credits: %d\tWins: %d\t|Loses: %d|%n", userCredits, winCount, loseCount);
        System.out.println("-------------------------------------------------");
        System.out.println("Spinning...");
        System.out.println("");

        while (userCredits > 0 && spin.equalsIgnoreCase("Y")) {
             

            // Prompt user for the number of credits to bet
            // Validate the input and handle it as you did before
        	for(int i = 0; i < loopCount; i++) {
            // Generate three random numbers for the spinner
            word1 = random.nextInt(5);
            word2 = random.nextInt(5);
            word3 = random.nextInt(5);

            // Assign images based on the random numbers
            image1 = getImage(word1);
            image2 = getImage(word2);
            image3 = getImage(word3);
            
            System.out.println("-------------------------------------------------");
            System.out.printf("|\t%s\t|\t%s\t|\t%s\t|%n", image1, image2, image3);
            

            // Compare the numbers and images to check for wins or losses
            // Update credits, wins, and losses accordingly
            if (word1 == word2 && word2 == word3) {
                
            	winCount++;
                userCredits += 3;
            } else if (word1 == word2 || word2 == word3 || word1 == word3) {
                
            	winCount++;
                userCredits += 2;
            } else {
                
            	loseCount++;
                userCredits -= 1;
            }
        }
            System.out.println("-------------------------------------------------");
        	System.out.println("");
        	System.out.println("");
            System.out.println("-------------------------------------------------");
            System.out.printf("|Credits: %d\tWins: %d\t|Loses: %d|%n", userCredits, winCount, loseCount);
            System.out.println("-------------------------------------------------");
        
            // Ask the user if they want to spin again and handle the input
            System.out.println("Would you like to spin again? (Y/N): ");
            spin = scanner.next().toUpperCase();
            if (spin.equalsIgnoreCase("Y")) {
                System.out.println("How many credits would you like to bet? " + userCredits + " credits remaining");
                loopCount  = scanner.nextInt();
                
                	while (loopCount > userCredits) {
                		System.out.println(loopCount + " is an invalid amount. Please enter a valid amount: ");
                		loopCount = scanner.nextInt();
                } 
                	System.out.println("Spinning...");
            } else {
                System.out.println("Quitting...");
            }
        }

        // Display the final results when the user quits
        System.out.println("-------------------------------------------------");
    	System.out.println("");
    	System.out.println("");
        System.out.println("Game over!");
        System.out.println("Original bet: $" + originalUserCredits);
        System.out.println("Spins Won: " + winCount);
        System.out.println("Spins Lost: " + loseCount);
        System.out.println("Dispensing: $" + userCredits);
        scanner.close();
    }

    // Helper method to get image based on the word index
    public static String getImage(int word) {
        switch (word) {
            case 0:
                return "PLUM";
            case 1:
                return "CHERRY";
            case 2:
                return "BELL";
            case 3:
                return "BAR";
            case 4:
                return "SEVEN";
            default:
                return "INVALID";
        }
    }
}
