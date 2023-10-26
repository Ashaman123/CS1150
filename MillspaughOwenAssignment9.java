import java.util.Arrays;

public class MillspaughOwenAssignment9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test #1
		int[] array1 = {11, 30, 19, 4, 15, 1, 20, 10, 12, 28, 14, 5, 3, 21, 22, 13};
		int[] array2 = {16, 2, 7, 18, 24, 6, 17, 8, 23, 9, 25, 26, 29};
		
		//Test #2
		int[] array3 = {15, 21, 22};
		int[] array4 = {16, 18, 24, 17, 23, 20, 19};

		//Test #3
		int[] array5 = {26, 31, 28, 25, 29, 30, 35};
		int[] array6 = {32, 33, 27};

		//Test #4
		int[] array7 = {6, 10, 8, 4, 9, 3};
		int[] array8 = {5, 7, 2};
		
		int[] array9 = {16, 20, 10, 18, 14, 19, 13};
		int[] array10 = {11, 15, 17, 12};

		int upper = 0;
		int lower = 0;
	
		for(int i = 1; i <= 5; i++) {
			int testNum = i;
			if(testNum == 1) {
				lower = 1;
				upper = 30;
				runTest(testNum, lower, upper, array1, array2); //runs array tests w/ 1 and 2
			}
			else if(testNum == 2) {
				lower = 15;
				upper = 25;
				runTest(testNum, lower, upper, array3, array4); //runs array tests w/ 1 and 2
			}
			else if(testNum == 3) {
				lower = 25;
				upper = 35;
				runTest(testNum, lower, upper, array5, array6); //runs array tests w/ 1 and 2
			}
			else if(testNum == 4) {
				lower = 1;
				upper = 10;
				runTest(testNum, lower, upper, array7, array8); //runs array tests w/ 1 and 2
			}
			else if(testNum == 5) {
				lower = 10;
				upper = 20;
				runTest(testNum, lower, upper, array9, array10); //runs array tests w/ 1 and 2
			}
			else {
				System.out.println("You messed something up");
			}
		
		}
		
	}
	
	
	// Runs one test. This means the method must perform all the test steps:
		// 1) display test number, 2) combine the 2 arrays into one, 3) sort combined array, 
		// 4) display the combined array, 5) finally find and display missing number.
	public static void runTest (int testNum, int lower, int upper, int[] firstArray, int[] secondArray) {

		int[] combinedArray = combineTwoArrays(firstArray, secondArray);
		
		Arrays.sort(combinedArray); //Sort the combined array
		
		displayArray(combinedArray); //Display the combined and sorted array
	
		int missingNumber = findMissingNumber(combinedArray, lower, upper);
		System.out.println("");
		System.out.println("The missing number is: " + missingNumber + "!");
		System.out.println("");
			}
	
	
	
	// Displays the values in the incoming array.
	public static void displayArray (int[] array) {
		System.out.println("Printing array...");
			for(int i = 0; i < array.length; i++ ) {
				System.out.println("array[" + i + "]: " + array[i]);
			}
	}

	// Combine the values in two arrays into one and return the combined array
	// Must combine arrays manually.  You may NOT use System.arraycopy method
	public static int[] combineTwoArrays (int[] array1, int[] array2) {
		int[] combinedArray = new int[array1.length + array2.length]; //placeholder code
			
				for(int i = 0; i < array1.length; i++) {
					combinedArray[i] = array1[i];
				}
				for(int i = 0; i < array2.length; i++) {
					combinedArray[array1.length + i] = array2[i];
				}
		
		return combinedArray;
	}

	// The array sent in contains the numbers from lower to upper with exactly 1 number
	// missing. This method finds and returns the missing number.
	public static int findMissingNumber(int[] array, int lower, int upper) {
	    // Calculate the expected sum of all numbers in the range [lower, upper]
	    int expectedSum = (upper * (upper + 1) / 2) - ((lower - 1) * lower / 2);
	    
	    // Calculate the actual sum of the numbers in the array
	    int actualSum = 0;
	    for (int num : array) {
	        actualSum += num;
	    }
	    
	    if(actualSum == expectedSum) {
	    	int noMissingNumber = -1;
	    	return noMissingNumber;
	    }
	    
	    // The difference between the expected sum and actual sum is the missing number
	    return expectedSum - actualSum;
	    
	    
	}


	
	

}
