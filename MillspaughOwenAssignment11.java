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

    public static void main(String[] args) {
        // Your main program logic goes here
    	Car[] cars = new Car[5];
        
        createCars(cars);
        printCars(cars);    }

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
    	for(int i = 0; i < cars.length; i++) {
    		System.out.println("Owner: " + cars[i].getOwner());
    		System.out.println("Model: " + cars[i].getModel());
    		System.out.println("MPG: " + cars[i].getMpg());
    		System.out.println("Gallons: " + cars[i].getFuelGauge());
    		System.out.println("Mileage: " + cars[i].getOdometer());
    		System.out.println("");
    	}
    }

    // Returns true if all the cars are out of gas. This requires examining the
    // fuel level of each car in the array. If all cars have “Empty” fuel level
    // return true, otherwise return false
    public static boolean checkFuelLevels(Car[] cars) {
    	FuelGauge carFuelGauge;
    	double fuelCheck = 0.0;
    	double carMPG = 0.0;
    	double carFuel = 0.0;
    	int notEmpty = 0;
    	int empty = 0;
    	
    	for(int i = 0; i < cars.length; i++) {
    		carFuelGauge = cars[i].getFuelGauge();
    		carMPG = cars[i].getMpg();
    		carFuel = carFuelGauge.getGallons();
    		fuelCheck = carMPG * carFuel;
    		if(fuelCheck % 2 == 0) {
    			empty++;
    		}
    		else {
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
}

class Car {
    // Details for the car class go here
    private String owner;
    private String model;
    private int mpg;
    private FuelGauge fuelGauge;
    private Odometer odometer;

    public Car(String owner, String model, int mpg, FuelGauge fuelGauge, Odometer odometer) {
		this.owner = owner;
		this.model = model;
		this.mpg = mpg;
		this.fuelGauge = fuelGauge;
		this.odometer = odometer;
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

    public int getMpg() {
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
    private int gallons;

    public int getGallons() {
        return gallons;
    }

    public void setGallons(int gallons) {
        this.gallons = gallons;
    }
}


class Odometer {
    private int odometer;

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}

