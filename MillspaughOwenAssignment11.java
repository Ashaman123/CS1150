/*
 *  Name: Owen Millspaugh
 *  Class: CS1150 
 *  Due:  Nov 15, 2023
 *  Description: Assignment #11 
 *  This program is working on arrays of objects and writing to a file
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class MillspaughOwenAssignment11 {

    public static void main(String[] args) throws IOException {
        // Your main program logic goes here
    	Car[] cars = new Car[5];
        
        createCars(cars); //Create the cars in the cars array
        writeCarDetailsToFile(cars); //Write the array cars to a file
        printCars(cars); //Print the details for all the cars in the array
        runSimulator(cars); //Run the simulation for the cars
    }

    // Create the cars for the simulation based on the assignment sheet table and
    // fills the incoming array with the cars
    public static void createCars(Car[] cars) {
    	    // Car 0
    	    cars[0] = new Car("Donkey", "Toyota Tundra", 15, new FuelGauge(), new Odometer());
    	    cars[0].getOdometer().setOdometer(34000); 
    	    cars[0].getFuelGauge().setGallons(8); 
    	    // Car 1
    	    cars[1] = new Car("Fiona", "Audi Q7", 21, new FuelGauge(), new Odometer());
    	    cars[1].getOdometer().setOdometer(7110);
    	    cars[1].getFuelGauge().setGallons(10); 
    	    // Car 2
    	    cars[2] = new Car("Shrek", "Jeep CJ5", 14, new FuelGauge(), new Odometer());
    	    cars[2].getOdometer().setOdometer(11800);
    	    cars[2].getFuelGauge().setGallons(5); 
    	    // Car 3
    	    cars[3] = new Car("Farquaad", "Smart Car", 42, new FuelGauge(), new Odometer());
    	    cars[3].getOdometer().setOdometer(82700);
    	    cars[3].getFuelGauge().setGallons(4); 
    	    // Car 4
    	    cars[4] = new Car("Dragon", "Chevy Suburban", 12, new FuelGauge(), new Odometer());
    	    cars[4].getOdometer().setOdometer(150245); 
    	    cars[4].getFuelGauge().setGallons(30); 

    }

    // Print the details for each car in the array. Display the car’s owner,
    // model, MPG, gallons, and mileage
    public static void printCars(Car[] cars) {
        // Implementation for printing car details
        System.out.println("Cars at the start of the simulation");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-15s %-15s%n", "Owner", "Vehicle", "MPG", "Gallons", "Mileage");
        System.out.println("-------------------------------------------------------------------------");
        
        for (int i = 0; i < cars.length; i++) {
            FuelGauge carFuelGauge = cars[i].getFuelGauge();
            double fuelGauge = carFuelGauge.getGallons();
            Odometer odometer = cars[i].getOdometer();
    		double mileage = odometer.getOdometer();
    		
    		System.out.printf("%-10s ", cars[i].getOwner());
    		System.out.printf("%-20s ", cars[i].getModel());
    		System.out.printf("%-15.2f ", cars[i].getMpg());
    		System.out.printf("%-15.2f ", mileage);
    		System.out.printf("%-15.2f \n", fuelGauge);
        }
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("");
    }



    // Returns true if all the cars are out of gas. This requires examining the
    // fuel level of each car in the array. If all cars have “Empty” fuel level
    // return true, otherwise return false
    public static boolean checkFuelLevels(Car[] cars) {
        FuelGauge carFuelGauge;
        double fuelCheck;
        int notEmpty = 0;

        for (int i = 0; i < cars.length; i++) {
            carFuelGauge = cars[i].getFuelGauge();
            fuelCheck = carFuelGauge.getGallons();

            // Check if the fuel gauge is not empty (greater than 0)
            if (fuelCheck > 0) {
                notEmpty++;
            }
        }
    		
    	if(notEmpty == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Print the details for each car in the cars array to a file
    public static void writeCarDetailsToFile(Car[] cars) throws IOException {
        // Implementation for writing car details to a file
        File fileName = new File("Assignment11.txt");
        PrintWriter resultsFile = new PrintWriter(fileName);

        resultsFile.println("Car Details");
        for (int i = 0; i < cars.length; i++) {
            resultsFile.println(cars[i].getOwner());
            resultsFile.println(cars[i].getModel());
            resultsFile.println(cars[i].getMpg());
            resultsFile.println(cars[i].getFuelGauge().getGallons());
            resultsFile.println();
        }
        resultsFile.close();

        System.out.println("Find the file here " + fileName.getAbsolutePath());
        System.out.println();
    }

	//Runs the simulation to check if cars have enough gas and if so, they should run the program
	//decreasing the gallons required and increasing the odometer value by the amount required
	//This runs until all cars are empty or 
	public static void runSimulator(Car[] cars) {
		Car[] carsOutOfGas = new Car[5]; //Creates array to store cars that are "Empty"
		FuelGauge fuelGauge; //Create instance of FuelGauge for this method
		Odometer odometer; //Create instance of Odometer for this method
		double gasRequired = 0.0;
		final double distanceNeeded = 25.0;
		double fuelCheck = 0.0;
		double fuel = 0.0;
		int outOfGasIndex = 0;
		 
		
		System.out.println("Hold on tight! ");
		System.out.println("Starting simulation...");
		System.out.println("");
		while(!checkFuelLevels(cars)) { //Uses the checkFuelLevels method to check if the cars are empty
			
			for(int i = 0; i < cars.length; i++) { //Used to check and potentially run the cars for 25 miles
				fuelGauge = cars[i].getFuelGauge();
				fuel = fuelGauge.getGallons();
				gasRequired = calcGallonsRequired(cars, i);
				//fuelCheck = distanceNeeded / gasRequired;
				
				if(fuel > gasRequired) {
					
					decrementGallons(cars,i , gasRequired);
					incrementMiles(cars, i);
				}
				else {
		                carsOutOfGas[outOfGasIndex] = cars[i];
		                outOfGasIndex++;
				}
				checkFuelLevels(cars);
			}
			System.out.println("Here we go again!");
		}
		System.out.println("");
		System.out.println("------------------------------------------------------");
		System.out.println("Cars Out of Gas");
		System.out.println("------------------------------------------------------");
		printCars(carsOutOfGas);
		
		System.out.println("");
		System.out.println("------------------------------------------------------");
		System.out.println("Original Full Car List");
		System.out.println("------------------------------------------------------");
		printCars(cars);
	}
	
	public static double calcGallonsRequired(Car[] cars, int i) {
		final double distanceNeeded = 25.0;
		double gallonsRequired = 0.0;
		
		gallonsRequired = distanceNeeded / cars[i].getMpg(); 
		return gallonsRequired;
	}
	
	public static void decrementGallons(Car[] cars, int i, double gasRequired) {
		FuelGauge fuelGauge = cars[i].getFuelGauge();
		fuelGauge.subtractGallons(gasRequired);
	}
	
	public static void incrementMiles(Car[] cars, int i) {
		Odometer odometer = cars[i].getOdometer();
		odometer.addOdometer();
	}
	
}
	
class Car {
    // Details for the car class go here
    private String owner;
    private String model;
    private double mpg;
    private FuelGauge fuelGauge;
    private Odometer odometer;

    public Car(String owner, String model, int mpg, FuelGauge fuelGauge, Odometer odometer) {
		this.owner = owner;
		this.model = model;
		this.mpg = mpg;
		this.fuelGauge = fuelGauge;
		this.odometer = odometer;
		//odometer = new Odometer(mileage);
		//fuelGauge = new FuelGauge(gallons);
	}

    public void setOdometer(Odometer odometerValue) {
        this.odometer = odometerValue;
    }


	// Add constructor, getters, and setters as needed

    public String getOwner() {
        return owner;
    }

    public String getModel() {
        return model;
    }

    public double getMpg() {
        return mpg;
    }

    public FuelGauge getFuelGauge() {
        return fuelGauge;
    }
    public Odometer getOdometer() {
    	return odometer;
    }
}

class FuelGauge {
    // Details for the fuel gauge class go here
    private double gallons;

    public double getGallons() {
        return gallons;
    }

    public void setGallons(int gallons) {
        this.gallons = gallons;
    }
    public void subtractGallons(double gallonsRequired) {
        this.gallons -= gallonsRequired;
    }

}


class Odometer {
    private int odometer;

    public int getOdometer() {
        return odometer;
    }
    public void addOdometer() {
        this.odometer += 25;
    }


    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}

