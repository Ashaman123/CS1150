

public class MillspaughOwenAssignment8 {

	
	
		public static void main(String[] args) {
			
			//Create 3 Arrays named courses, grades, and credits with assigned values
			String[] courses = {"CS1150", "Math", "Physics", "Chemistry", "English"};	
			String[] grades = {"A", "C+", "A-", "B", "C-"};	
			int[] credits = {3, 3, 4, 3, 3};
			
			
				
			display(courses, grades, credits);
			System.out.println("");
			
			int sumofCredits = computeSumOfCredits(credits);
			System.out.println("Total Credit Hours: " + sumofCredits);
			
			
			double totalGradePoints = computeTotalGradePoints(grades, credits);
			System.out.printf("Total Grade Points: %4.2f\n", totalGradePoints);
			
			
			float overallGPA = (float)totalGradePoints / sumofCredits;
			System.out.printf("Overall GPA: %4.2f\n", overallGPA);
			System.out.println("");
			System.out.println("---------------------------------");

			
			int gradeWorthMostPoints = findGradeWorthMostPoints(grades, credits);
			String classandGrade = courses[gradeWorthMostPoints] + " " + grades[gradeWorthMostPoints];
			
			System.out.println("");
			System.out.println("Grade Worth Most Points: " + classandGrade);
			
		}
		
		public static void display(String[] courses, String[] grades, int[] credits){
		//Displays all courses in the arrays with course title, grade, and credits displayed in the same table
			System.out.println("---------------------------------");
			System.out.printf("%-16s %-8s %s\n", "Course", "Grade", "Credit");
			System.out.println("---------------------------------");

			for (int i = 0; i < 5; i++) {
			    System.out.printf("%-16s %-8s %s\n", courses[i], grades[i], credits[i]);
			}
			System.out.println("---------------------------------");

		} 

		public static int computeSumOfCredits(int[] credits) {
			int sumofCredits = 0;
			
			for(int i = 0; i < 5; i++) {
				sumofCredits = sumofCredits + credits[i]; 
			}
			
			return sumofCredits;
		} 
	
		public static double convertLetterGradeToPoints(String grade) {
		    double convertedLetterGrade = 0.0;
		    String letterGrade = grade;
		        
		        if (letterGrade.equals("A")) {
		            convertedLetterGrade = 4.0;
		        } else if (letterGrade.equals("A-")) {
		            convertedLetterGrade = 3.7;
		        } else if (letterGrade.equals("B+")) {
		            convertedLetterGrade = 3.3;
		        } else if (letterGrade.equals("B")) {
		            convertedLetterGrade = 3.0;
		        } else if (letterGrade.equals("B-")) {
		            convertedLetterGrade = 2.7;
		        } else if (letterGrade.equals("C+")) {
		            convertedLetterGrade = 2.3;
		        } else if (letterGrade.equals("C")) {
		            convertedLetterGrade = 2.0;
		        } else if (letterGrade.equals("C-")) {
		            convertedLetterGrade = 1.7;
		        } else if (letterGrade.equals("D+")) {
		            convertedLetterGrade = 1.3;
		        } else if (letterGrade.equals("D")) {
		            convertedLetterGrade = 1.0;
		        } else if (letterGrade.equals("D-")) {
		            convertedLetterGrade = 0.7;
		        } else if (letterGrade.equals("F")) {
		            convertedLetterGrade = 0.0;
		        }

		    return convertedLetterGrade;
		}

		
		public static double computeTotalGradePoints(String[] grades, int[] credits) {
		    double totalGradePoints = 0.0;

		    for (int i = 0; i < grades.length; i++) {
		        String grade = grades[i]; // Get the grade for the current course
		        double convertedGrade = convertLetterGradeToPoints(grade);
		        int credit = credits[i]; // Get the credit value for the current course
		        totalGradePoints += convertedGrade * credit; // Calculate grade points for the course and add to the total
		    }

		    return totalGradePoints;
		}

		
		public static int findGradeWorthMostPoints(String[] grades, int[] credits) {
		    int gradeWorthMostPoints = 0; 
		    double worthCalcs = 0.0;
		    double gradePointValue = 0.0;
		    double highestValue = 0.0;
		    String grade = "A-";
		    int credit = 0;
		    
		    for (int i = 0; i < grades.length; i++) {
		    	
		       grade = grades[i];
		       credit = credits[i];
		    
		        gradePointValue = convertLetterGradeToPoints(grade); 
		        worthCalcs = gradePointValue * credit;
		        
		        
		        if (worthCalcs > highestValue) {
		        	highestValue = worthCalcs;
		            gradeWorthMostPoints = i;
		        }
		    }

		    return gradeWorthMostPoints;
		}


}

		/** 

}
public static void makeDogsBark(Dog[] dogArray) {
	
} 

class Dog {							
private String name;					
private String bark;						
						
public Dog (String name, String bark) {
   this.name = name;
   this.bark = bark;
}


								
public String getName() {					
   return name;						
}								

public void setName(String name) {
   this.name = name;
}

public String getBark() {
   return bark;
}

public void setBark(String bark) {
   this.bark = bark;
}
} // Dog
**/