import java.util.Scanner;

public class MillspaughOwenAssignment7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueCalorieCheck = true;
        
        while (continueCalorieCheck) {
            char gender = getGender(input);
            int age = getAge(input);
            int height = getHeight(input);
            double weight = getWeight(input);
            
            double bmr = computeBMR(gender, age, height, weight);
            
            displayResults(bmr);
            
            continueCalorieCheck = continueProcessing(input);
        }
        
        System.out.println("Have a healthy day! Goodbye.");
        input.close();
    }

    public static char getGender(Scanner input) {
        // Implement this method to get and validate user's gender input
    }

    public static int getAge(Scanner input) {
        // Implement this method to get and validate user's age input
    }

    public static int getHeight(Scanner input) {
        // Implement this method to get and validate user's height input
        // Allow the user to enter height in feet and inches, and convert it to inches.
    }

    public static double getWeight(Scanner input) {
        // Implement this method to get and validate user's weight input
    }

    public static boolean continueProcessing(Scanner input) {
        // Implement this method to ask the user if they want to continue and validate their input
    }

    public static double computeBMR(char gender, int age, int height, double weight) {
        // Implement this method to calculate BMR based on Harris Benedict formulas
    }

    public static double computeCaloriesWithActivity(double bmr, int activityLevel) {
        // Implement this method to calculate daily calorie needs based on BMR and activity level using a switch statement
    }

    public static void displayResults(double bmr) {
        // Implement this method to display BMR and results for each activity level based on BMR
    }
}
