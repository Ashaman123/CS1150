import java.util.Scanner;

public class MillspaughOwenAssignment4 {

	public static void main(String[] args) {
		
		//Initialize Scanner to scanner
		Scanner scanner = new Scanner(System.in);
		
		//Prompt User input on cipher menu
		System.out.println("---------------------------------");
		System.out.printf("1) Ceasar Cipher");
		System.out.printf("%n2) XOR Cipher %n");
		System.out.println("");
		System.out.println("Which encryption/decryption would you like?  Select option 1 or 2: ");

		
		//Broad if then statements for cipher choice
		int input1 = scanner.nextInt();
		
		//If statement for user input and type of encryption
	if (input1 > 0 && input1 < 3) {
			scanner.nextLine(); // Consume the newline character
		    System.out.println("Enter string with exactly 5 characters to encrypt or decrypt:");
		    String UndecryptedString = scanner.nextLine().toLowerCase();
		    //System.out.printf("Your original string: %s ", UndecryptedString);
		    
		    //String Length Check and Entrance into cipher
		    
		    	if(input1 == 1 && UndecryptedString.length() == 5) { //CeasarCipher
		    		//Create random key for shift variable
		    		int shift = (int)(Math.random() * 26);
		    		char[] charArray = new char[5]; // Creates a new integer array with a size of 5

		    		//Encrypt the String
		    			for(int i = 0; i < UndecryptedString.length(); i++) {
		    			char encrypt = UndecryptedString.charAt(i);
		    		    char encryptedChar1 = (char)((encrypt - 'a' + shift) % 26 + 'a');
			    		charArray[i] = encryptedChar1;
		    			}
		    			
		    			StringBuilder stringBuilder = new StringBuilder(); //Add all characters to final string
		    			for (char c : charArray) {
		    			    stringBuilder.append(c);
		    			}
		    			String finalString = stringBuilder.toString();
			    		
			    		
			    	//Decrypt the String	
			    		
		    			int shift2 = 26 - shift;
			    		char[] charArray2 = new char[5]; // Creates a new integer array with a size of 5

			    			for(int i = 0; i < finalString.length(); i++) {
			    			char encrypt = finalString.charAt(i);
			    		    char encryptedChar2 = (char)((encrypt - 'a' + shift2) % 26 + 'a');
				    		charArray2[i] = encryptedChar2;
			    			}
			    			StringBuilder OriginalStringBuilder = new StringBuilder();
			    					
			    			for (char c : charArray2) {
			    			    OriginalStringBuilder.append(c);
			    			}
			    			String originalString = OriginalStringBuilder.toString();
		   
		    	
		    	//Print out all the info
			    System.out.println("Shift Value (encrypt): " + shift);
			    System.out.println("Shift Value (decrypt): " + shift2);
		    	System.out.println("Original String:       " + UndecryptedString);
		    	System.out.println("Encrypted String:      " + finalString);
		    	System.out.println("Decrypted String:      " + originalString);

		    }
		    	
		    		else if(input1 == 2 && UndecryptedString.length() == 5) { //XORCipher
		    			//Create random key for shift variable
		    			
		    			char shift = (char) ('A' + (int)(Math.random() * 26));		    			// Generate a random uppercase letter
		    			char[] encryptedChars = new char[UndecryptedString.length()];
		    			
		    			
		    			//Encrypt with XOR
		    			for (int i = 0; i < UndecryptedString.length(); i++) {
		    			    char originalChar = UndecryptedString.charAt(i);
		    			    char encryptedChar = (char) (originalChar ^ shift);
		    			    encryptedChars[i] = encryptedChar;
		    			}

		    			String encryptedString = new String(encryptedChars);

		    			StringBuilder StringBuilder3 = new StringBuilder();
		    			
		    			for (char c : encryptedChars) {
		    			    StringBuilder3.append(c);
		    			}
		    			String finalString = StringBuilder3.toString();
		    			
		    			
		    			
		    			//Decrypt with XOR
		    			char shift2 = (char) ('Z' - (shift - 'A'));
		    			// Decrypt with XOR using the same shift value
		    			char[] decryptedChars = new char[encryptedString.length()];

		    			for (int i = 0; i < encryptedString.length(); i++) {
		    			    char encryptedChar = encryptedString.charAt(i);
		    			    char decryptedChar = (char) (encryptedChar ^ shift);
		    			    decryptedChars[i] = decryptedChar;
		    			}

		    			String decryptedString = new String(decryptedChars);


		    			StringBuilder stringBuilder4 = new StringBuilder(); // Create a new StringBuilder

		    			for (char c : decryptedChars) { // Use decryptedChars instead of decryptedChar
		    			    stringBuilder4.append(c);
		    			}

		    			String originalString = stringBuilder4.toString(); // Use stringBuilder4 instead of StringBuilder3
		    		
		    		
		    			System.out.println("Shift Value (encrypt): " + shift);
		  			    System.out.println("Shift Value (decrypt): " + shift2);
		  		    	System.out.println("Original String:       " + UndecryptedString);
		  		    	System.out.println("Encrypted String:      " + finalString);
		  		    	System.out.println("Decrypted String:      " + originalString);
		    		}
		    	
		    	
		    	
		    	
		    	else {
				    System.out.println("Invalid option; please restart the program!");
		    	}
		
	} else {
		System.out.println("Invalid option; please restart the program!");
			}

		scanner.close();
	}
}
