/*
 *  Name: Owen Millspaugh
 *  Class: CS1150 
 *  Due:  Nov 29, 2023
 *  Description: Assignment #12 
 *  Used to check and practice the use of polymorphism and the use of super and
 *  sub classes with the use of an Animal super class and multiple subclasses
 *  that are used for various different functions that set the subclasses apart. 
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
					        
					    } else if (animals[i] instanceof Elephant) {
					    	System.out.println("Animal[" + i + "] is a Elephant");
					        
					    } else if (animals[i] instanceof Monkey) {
					    	System.out.println("Animal[" + i + "] is a Monkey");
					       
					    } else if (animals[i] instanceof Sloth) {
					    	System.out.println("Animal[" + i + "] is a Sloth");
					        
					    } else {
					        // Default case for the base class Animal
					        System.out.print("Animal: ");
					    }
						animals[i].print(animals);
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

public void print(Animal[] animals) {
		System.out.printf("Animal | Name: %s | Weighs: %s lbs | Sleeps: %d hours | Location: %s ",getName(), getWeight(), getSleep(), getLocation());
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
		@Override
		public void print(Animal[] animals) {
			System.out.printf("Bear | Name: %s | Weighs: %s lbs | Sleeps: %d hours | Location: %s ",getName(), getWeight(), getSleep(), getLocation());
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
	@Override
	public void print(Animal[] animals) {
		System.out.printf("Elephant | Name: %s | Weighs: %s lbs | Sleeps: %d hours | Location: %s ",getName(), getWeight(), getSleep(), getLocation());
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
	@Override
	public void print(Animal[] animals) {
		System.out.printf("Monkey | Name: %s | Weighs: %s lbs | Sleeps: %d hours | Location: %s ",getName(), getWeight(), getSleep(), getLocation());
	}
}

class Sloth extends Animal{
	public Sloth (String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}	
	
	@Override
	public void print(Animal[] animals) {
		System.out.printf("Sloth | Name: %s | Weighs: %s lbs | Sleeps: %d hours | Location: %s ",getName(), getWeight(), getSleep(), getLocation());
	}
}




