import java.util.Scanner;

public class MillspaughOwenAssignment3 {
	
    public static void main(String[] args) {
    	
        final double FRESHMAN_TUITION = 449.00;
        final double SOPHOMORE_TUITION = 465.00;
        final double JUNIOR_TUITION = 478.00;
        final double SENIOR_TUITION = 528.00;
        int CreditHours = 0;
        double BaseFees = 150.00;
        int YearLevel = 0;
        
        
        // Print the header
        System.out.println("Welcome to Tuition Calculator\n");
        System.out.println("---------------------------------------------");
        System.out.println("Option   Level        Cost Per Credit Hour");
        System.out.println("---------------------------------------------");

        // Print each class level and its cost per credit hour
        System.out.printf("%-8s %-12s $%.2f%n", "1", "Freshman", FRESHMAN_TUITION);
        System.out.printf("%-8s %-12s $%.2f%n", "2", "Sophomore", SOPHOMORE_TUITION);
        System.out.printf("%-8s %-12s $%.2f%n", "3", "Junior", JUNIOR_TUITION);
        System.out.printf("%-8s %-12s $%.2f%n", "4", "Senior", SENIOR_TUITION);

        Scanner input = new Scanner(System.in);

        // Assigns the class level into a string
        System.out.printf("Please select your class number from the list above: ");
        YearLevel = input.nextInt();
        String ClassLevel = "";
        double Tuition = 0;

        if (YearLevel > 0 && YearLevel < 5) {
            if (YearLevel == 1) {
                ClassLevel = "Freshman";
                Tuition = FRESHMAN_TUITION;
            	}
            if (YearLevel == 2) {
                ClassLevel = "Sophomore";
                Tuition = SOPHOMORE_TUITION;
            	}
            if (YearLevel == 3) {
                ClassLevel = "Junior";
                Tuition = JUNIOR_TUITION;
            	}
            if (YearLevel == 4) {
                ClassLevel = "Senior";
                Tuition = SENIOR_TUITION;
            	}

            // Assigns how many credit hours the users are taking
            System.out.printf("%nHow many credit hours are you taking: %n");
            System.out.printf("Enter a max of 30 credit hours%n");
            int UserClassHours = input.nextInt();

            if (UserClassHours > 1 && UserClassHours <= 30) {
                CreditHours = UserClassHours;

                // Tuition Calculator Section
                double TotalTuition = (CreditHours * Tuition);
                double Fees = (BaseFees + (15.00 * CreditHours));
                double TotalOwed = (TotalTuition + Fees);

                System.out.println("************************************************************");
                System.out.println("                     TUITION CALCULATOR");
                System.out.println("************************************************************");
                System.out.println("");
                System.out.println("");
                System.out.println("-----------------------------------");
                System.out.printf("%-15s %s%n", "Class Year", ClassLevel);
                System.out.printf("%-15s %d%n", "Credit Hours", CreditHours);
                System.out.printf("%-15s $%.2f%n", "Tuition", TotalTuition);
                System.out.printf("%-15s $%.2f%n", "Fees", Fees);
                System.out.println("-----------------------------------");
                System.out.printf("%-15s $%.2f%n", "Total cost", TotalOwed);
            } else {
                System.out.println("That is an invalid option. Have a good day!");
            }
            
        }
        else {
            System.out.println("That is an invalid option. Have a good day!");
        }
    }
}
