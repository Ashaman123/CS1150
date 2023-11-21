/*
 *  Name: Owen Millspaugh
 *  Class: CS1150 
 *  Due:  Nov 29, 2023
 *  Description: Assignment #12 
 *  This program demonstrates that I understand basic program structure by 
 *  printing a couple paragraphs on the console that tell the instructor what I’m  
 *  passionate about.  It also gives a little practice with arithmetic in Java.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MillspaughOwenAssignment12 {

	public static void main(String[] args) throws IOException{
		// Setup the file reference variable to refer to the text file
				File inputFileName = new File("Animals.txt");
				
				// Open the file for reading by creating a scanner for the file
				Scanner inputFile = new Scanner (inputFileName);
				
				// Read the array length
				int arrayLength = inputFile.nextInt();
				Animal[] animals = new Animal[arrayLength];

				// Used for filling array with the animal's info from the file
				for (int i = 0; i < animals.length; i++) {
				    String type = inputFile.next();
				    String name = inputFile.next();
				    String food = inputFile.next();
				    int weight = inputFile.nextInt();
				    int sleep = inputFile.nextInt();
				    String location = inputFile.next() + " " + inputFile.next();

				    if (type.equalsIgnoreCase("Bear")) {
				        animals[i] = new Bear(name, food, weight, sleep, location);
				    } else if (type.equalsIgnoreCase("Elephant")) {
				        animals[i] = new Elephant(name, food, weight, sleep, location);
				    } else if (type.equalsIgnoreCase("Monkey")) {
				        animals[i] = new Monkey(name, food, weight, sleep, location);
				    } else {
				        animals[i] = new Sloth(name, food, weight, sleep, location);
				    }
				}
				
				//Prints the details of the animal array and calls the various methods associated with them.
					for(int i = 0; i < animals.length; i++) {
						System.out.println("");
						if (animals[i] instanceof Bear) {
							System.out.println("Animal[" + i + "] is a Bear");
					        System.out.print("Bear: ");
					    } else if (animals[i] instanceof Elephant) {
					    	System.out.println("Animal[" + i + "] is a Elephant");
					        System.out.print("Elephant: ");
					    } else if (animals[i] instanceof Monkey) {
					    	System.out.println("Animal[" + i + "] is a Monkey");
					        System.out.print("Monkey: ");
					    } else if (animals[i] instanceof Sloth) {
					    	System.out.println("Animal[" + i + "] is a Sloth");
					        System.out.print("Sloth: ");
					    } else {
					        // Default case for the base class Animal
					        System.out.print("Animal: ");
					    }
						System.out.print("Name: " + animals[i].getName().toString());
						System.out.print(" | Weighs: " + animals[i].getWeight() + " lbs");
						System.out.print(" | Sleeps: " + animals[i].getSleep() + " hours");
						System.out.print(" | Location: " + animals[i].getLocation().toString() + " | ");
						System.out.println("");
						animals[i].eat(animals, i);
						animals[i].sleep(animals, i);
						animals[i].swim(animals);
						
					}
		inputFile.close();
	}

}

class Animal {
	private String name;
	private String food;
	private int weight;
	private int sleep;
	private String location;
	
	public Animal(String name, String food, int weight, int sleep, String location) {
        this.name = name;
        this.food = food;
        this.weight = weight;
        this.sleep = sleep;
        this.location = location;
    }

public String getName() {
	return name;
}

public String getFood() {
	return food;
}

public int getWeight() {
	return weight;
}

public int getSleep() {
	return sleep;
}

public String getLocation() {
	return location;
}

public void eat(Animal[] animals, int i) {
	System.out.println("Animal is eating");
}
public void sleep(Animal[] animals, int i) {
	System.out.println("Animal is sleeping - Do Not Disturb");
}
public void swim(Animal[] animals) {
	System.out.println("Animal is swimming");
}

}

class Bear extends Animal{
	public Bear (String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
		@Override
		public void eat(Animal[] animals, int i) {
			System.out.println("Bear is eating " + getFood()); 
		}

		@Override
		public void sleep(Animal[] animals, int i) {
			System.out.println("Bear is sleeping " + getSleep() + " hours");
		}
		
		@Override
		public void swim(Animal[] animals) {
			System.out.println("Bear is swimming");
			} 

	}

class Elephant extends Animal{
	public Elephant (String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	
	@Override
	public void sleep(Animal[] animals, int i) {
		System.out.println("Elephant is sleeping " + getSleep() + " hours");
	}
}

class Monkey extends Animal{
	public Monkey (String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}
	
	@Override
	public void eat(Animal[] animals, int i) {
		System.out.println("Monkey is eating " + getFood()); 
	}
	
	public void swim(Animal[] animals) {
		System.out.println("Monkey is swimming");
		} 
}

class Sloth extends Animal{
	public Sloth (String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}	
}




