

public class MillspaughOwenAssignment8 {

	
	
		public static void main(String[] args) {
			
			//Create 3 Arrays named courses, grades, and credits with assigned values
			String[] courses = {"CS 1150", "Math", "Physics", "Chemistry", "English"};	
			String[] grades = {"A", "C+", "A-", "B", "3"};	
			int[] credits = {3, 3, 4, 3, 3};
			
			
				
			display(courses, grades, credits);
			System.out.println("");
			
			int sumofCredits = computeSumOfCredits(credits);
			System.out.println("Total Credit Hours: " + sumofCredits);
			
			
			double totalGradePoints = computeTotalGradePoints();
			System.out.println("Total Grade Points: " + totalGradePoints);
			
			
			double overallGPA = computeOverallGPA(totalGradePoints);
			System.out.println("Overall GPA: " + overallGPA);
			
			
			String gradeWorthMostPoints = findGradeWorthMostPoints(courses, grades);
			System.out.println("");
			System.out.println("Grade Worth Most Points: " + gradeWorthMostPoints);
			
		}
		
		public static void display(String[] courses, String[] grades, int[] credits){
		//Displays all courses in the arrays with course title, grade, and credits displayed in the same table
			System.out.println("---------------------------------");
			System.out.printf("%-16s %-8s %s\n", "Course", "Grade", "Credit");
			System.out.println("---------------------------------");

			for (int i = 0; i < 5; i++) {
			    System.out.printf("%-16s %-8s %s\n", courses[i], grades[i], credits[i]);
			}
		} 

		public static int computeSumOfCredits(int[] credits) {
			int sumofCredits = 0;
			
			for(int i = 0; i < 5; i++) {
				sumofCredits = sumofCredits + credits[i]; 
			}
			
			return sumofCredits;
		} 
	
		public static double convertLetterGradeToPoints(String grades) {
		    double convertedLetterGrade = 0.0;

		    for (int i = 0; i < 5; i++) {
		        String letterGrade = grades[i];
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
		    }

		    return convertedLetterGrade;
		}

		
		public static double computeTotalGradePoints(String[] grades, int[] credits) {
			double totalGradePoints = 0.0;
			double convertedGrade = 0.0;
			
			
			
			
			return totalGradePoints;
			
		}
		
		public static double computeOverallGPA(double totalGradePoints) {
			double overallGPA = totalGradePoints / 5;
			return overallGPA;
		}
		
		public static String findGradeWorthMostPoints(String[] courses, String[] grades){
			String gradeWorthMostPoints = "Physics: A-";
			char mostValuableGrade = 'F';
			char checkGradeValue = 'F';
			
			for(int i = 0; i < 5; i++) {
				checkGradeValue = grades[i].charAt(0); 
					
					
				if(mostValuableGrade < checkGradeValue) {
					mostValuableGrade = checkGradeValue;
					gradeWorthMostPoints = courses[i] + mostValuableGrade;
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