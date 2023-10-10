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

            System.out.println("Please choose your activity level from the following menu:");
            System.out.println("1. Sedentary: Little to no activity");
            System.out.println("2. Lightly Active: Light exercise/sport 1-3 times a week");
            System.out.println("3. Moderately Active: Moderate exercise/sport 4-5 times a week");
            System.out.println("4. Very Active: Hard exercise/sport 6-7 times a week");
            System.out.println("5. Extra Active: Very hard exercise/sport daily or physical job");
            int activityLevel = input.nextInt();
            input.nextLine(); // Consume the newline character

            displayResults(bmr, activityLevel);

            continueCalorieCheck = continueProcessing(input);
        }

        System.out.println("Have a healthy day! Goodbye.");
        input.close();
    }

    public static char getGender(Scanner input) {
        System.out.println("Please enter your sex (M/F)");
        char gender = input.nextLine().toUpperCase().charAt(0);
        while (gender != 'M' && gender != 'F') {
            System.out.println("Please enter either M/F: ");
            gender = input.nextLine().toUpperCase().charAt(0);
        }
        return gender;
    }

    public static int getAge(Scanner input) {
        System.out.println("Please enter your age");
        int age = input.nextInt();
        input.nextLine(); // Consume the newline character
        while (age <= 0) {
            System.out.println("Please enter a valid age");
            age = input.nextInt();
            input.nextLine(); // Consume the newline character
        }
        return age;
    }

    public static int getHeight(Scanner input) {
        System.out.println("Please enter your height in feet: ");
        int heightInFeet = input.nextInt();
        input.nextLine(); // Consume the newline character
        System.out.println("Please enter your height in inches: ");
        int heightInInches = input.nextInt();
        input.nextLine(); // Consume the newline character
        int height = ((heightInFeet * 12) + heightInInches);
        return height;
    }

    public static double getWeight(Scanner input) {
        System.out.println("Please enter your weight in pounds (Round to two decimal places)");
        double weight = input.nextDouble();
        input.nextLine(); // Consume the newline character
        return weight;
    }

    public static boolean continueProcessing(Scanner input) {
        System.out.println("Would you like to continue the process? (Y or N)");
        char continueProcessing = input.nextLine().toLowerCase().charAt(0);
        while (continueProcessing != 'y' && continueProcessing != 'n') {
            System.out.println("Please enter a valid entry option (Y or N)");
            continueProcessing = input.nextLine().toLowerCase().charAt(0);
        }
        return continueProcessing == 'y';
    }

    public static double computeBMR(char gender, int age, int height, double weight) {
        if (gender == 'M') {
            double bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
            return bmr;
        } else {
            double bmr = 655 + (4.35 * weight) + (4.7 * height) + (4.7 * age);
            return bmr;
        }
    }

    public static double computeCaloriesWithActivity(double bmr, int activityLevel) {
        double caloriesWithActivity = 0;
        switch (activityLevel) {
            case 1:
                caloriesWithActivity = bmr * 1.2;
                return caloriesWithActivity;
            case 2:
                caloriesWithActivity = bmr * 1.375;
                return caloriesWithActivity;
            case 3:
                caloriesWithActivity = bmr * 1.55;
                return caloriesWithActivity;
            case 4:
                caloriesWithActivity = bmr * 1.725;
                return caloriesWithActivity;
            case 5:
                caloriesWithActivity = bmr * 1.9;
                return caloriesWithActivity;
        }
        return caloriesWithActivity;
    }

    public static void displayResults(double bmr, int activityLevel) {
        System.out.println("");
        System.out.println("BMR (Basal Metabolic Rate): " + String.format("%.2f", bmr) + " calories per day");
        System.out.println("");

        switch (activityLevel) {
            case 1:
                System.out.println("Sedentary: Little to no activity");
                double calories1 = computeCaloriesWithActivity(bmr, 1);
                System.out.println("Calories needed: " + String.format("%.2f", calories1));
                break;
            case 2:
                System.out.println("Lightly Active: Light exercise/sport 1-3 times a week");
                double calories2 = computeCaloriesWithActivity(bmr, 2);
                System.out.println("Calories needed: " + String.format("%.2f", calories2));
                break;
            case 3:
                System.out.println("Moderately Active: Moderate exercise/sport 4-5 times a week");
                double calories3 = computeCaloriesWithActivity(bmr, 3);
                System.out.println("Calories needed: " + String.format("%.2f", calories3));
                break;
            case 4:
                System.out.println("Very Active: Hard exercise/sport 6-7 times a week");
                double calories4 = computeCaloriesWithActivity(bmr, 4);
                System.out.println("Calories needed: " + String.format("%.2f", calories4));
                break;
            case 5:
                System.out.println("Extra Active: Very hard exercise/sport daily or physical job");
                double calories5 = computeCaloriesWithActivity(bmr, 5);
                System.out.println("Calories needed: " + String.format("%.2f", calories5));
                break;
            default:
                System.out.println("Invalid activity level");
        }
    }
}
