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
        System.out.println("Cars at the start of the simulation");
        printCars(cars); //Print the details for all the cars in the array
        runSimulator(cars); //Run the simulation for the cars
    }

    // Create the cars for the simulation based on the assignment sheet table and
    // fills the incoming array with the cars
    public static void createCars(Car[] cars) {
    	    // Car 0
    	    cars[0] = new Car("Donkey", "Toyota Tundra", 15, new FuelGauge(), new Odometer(), "HasGas");
    	    cars[0].getOdometer().setOdometer(34000); 
    	    cars[0].getFuelGauge().setGallons(8); 
    	    // Car 1
    	    cars[1] = new Car("Fiona", "Audi Q7", 21, new FuelGauge(), new Odometer(), "HasGas");
    	    cars[1].getOdometer().setOdometer(7110);
    	    cars[1].getFuelGauge().setGallons(10); 
    	    // Car 2
    	    cars[2] = new Car("Shrek", "Jeep CJ5", 14, new FuelGauge(), new Odometer(), "HasGas");
    	    cars[2].getOdometer().setOdometer(11800);
    	    cars[2].getFuelGauge().setGallons(5); 
    	    // Car 3
    	    cars[3] = new Car("Farquaad", "Smart Car", 42, new FuelGauge(), new Odometer(), "HasGas");
    	    cars[3].getOdometer().setOdometer(82700);
    	    cars[3].getFuelGauge().setGallons(4); 
    	    // Car 4
    	    cars[4] = new Car("Dragon", "Chevy Suburban", 12, new FuelGauge(), new Odometer(), "HasGas");
    	    cars[4].getOdometer().setOdometer(150245); 
    	    cars[4].getFuelGauge().setGallons(30); 

    }

    // Print the details for each car in the array. Display the car’s owner,
    // model, MPG, gallons, and mileage
    public static void printCars(Car[] cars) {
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
        double fuelReqd = 0.0;
        String hasGas = "";

        for (int i = 0; i < cars.length; i++) {
            carFuelGauge = cars[i].getFuelGauge();
            fuelCheck = carFuelGauge.getGallons();
            fuelReqd = calcGallonsRequired(cars, i);

            // Check if the fuel gauge is not empty (greater than 0)
            if (fuelCheck < fuelReqd) {
                hasGas = "Empty";
            } else {
                hasGas = cars[i].getFuelLevel();
            }

            if (hasGas.equalsIgnoreCase("HasGas")) {
                notEmpty++;
            }
        }

        if (notEmpty != 0) {
            return true;
        } else {
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
    @SuppressWarnings("unused")
	public static void runSimulator(Car[] cars) {
        Car[] carsOutOfGas = new Car[5]; // Use the length of the input array
        FuelGauge fuelGauge;
        Odometer odometer;
        double gasRequired = 0.0;
        final double distanceNeeded = 25.0;
        double fuel = 0.0;
        int outOfGasIndex = 0;
        boolean carsStillHaveGas = true;

        // Continue the simulation until all cars are out of gas
        while (carsStillHaveGas) {
            // Iterate through each car
            for (int i = 0; i < cars.length; i++) {
            	
                    // Check if the car has gas
                    if (cars[i].getFuelGauge().getGallons() > 0) {
                        fuelGauge = cars[i].getFuelGauge();
                        fuel = fuelGauge.getGallons();
                        gasRequired = calcGallonsRequired(cars, i);

                        // Check if the car has enough gas to travel 25 miles
                        if (fuel >= gasRequired) {
                            decrementGallons(cars, i, gasRequired);
                            incrementMiles(cars, i);
                        } else {
                            // Car doesn't have enough gas
                        	 String ownerToCheck = cars[i].getOwner();
                        	 
                             // Check if the car is not already in the carsOutOfGas array
                             boolean carNotInList = true;
                             for (int j = 0; j < outOfGasIndex ; j++) {
                                 if (carsOutOfGas[j] != null && ownerToCheck.equalsIgnoreCase(carsOutOfGas[j].getOwner())) {
                                     carNotInList = false;
                                 }
                             }
                             // If the car is not in the list, add it
                             if (carNotInList) {
                                 carsOutOfGas[outOfGasIndex] = cars[i];
                                 outOfGasIndex++;
                             }
                        }
                    }
                }          
            carsStillHaveGas = checkFuelLevels(cars);
        }
        allCarsIncluded(cars, carsOutOfGas);
        //carsOutOfGas[outOfGasIndex] = cars[4];
        // Print the cars that ran out of gas
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("Cars Ran Out of Gas in This Order");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < carsOutOfGas.length; i++) {
            if (carsOutOfGas[i] != null) {
                System.out.println("Ran out of gas: " + carsOutOfGas[i].getOwner());
            }
        }

        // Print the cars at the end of the simulation
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("Cars at End of Simulation");
        System.out.println("------------------------------------------------------");
        printCars(cars);
    }


    public static void allCarsIncluded(Car[] cars, Car[] carsOutOfGas) {
        for (int i = 0; i < cars.length; i++) {
            String carOwner = cars[i].getOwner();
            boolean ownerIncluded = false;

            // Check if the owner is already in the carsOutOfGas array
            for (Car car : carsOutOfGas) {
                if (car != null && carOwner.equalsIgnoreCase(car.getOwner())) {
                    ownerIncluded = true;
                    break;
                }
            }

            // If the owner is not included, add the car to the carsOutOfGas array
            if (!ownerIncluded) {
                for (int j = 0; j < carsOutOfGas.length; j++) {
                    if (carsOutOfGas[j] == null) {
                        carsOutOfGas[j] = cars[i];
                        break;  // Break after adding the car
                    }
                }
            }
        }
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
    private String fuelLevel;
    
    public Car(String owner, String model, int mpg, FuelGauge fuelGauge, Odometer odometer, String fuelLevel) {
		this.owner = owner;
		this.model = model;
		this.mpg = mpg;
		this.fuelGauge = fuelGauge;
		this.odometer = odometer;
		this.fuelLevel = fuelLevel;
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
    public String getFuelLevel() {
    	return fuelLevel;
    }
    public void setFuelLevel(String fuelLevel) {
		// TODO Auto-generated method stub
		this.fuelLevel = fuelLevel;
	}
}

class FuelGauge {
    // Details for the fuel gauge class go here
    private double gallons;
    private String fuelLevel;
    
    public double getGallons() {
        return gallons;
    }

    public void setFuelLevel(String string) {
		// TODO Auto-generated method stub
		this.fuelLevel = fuelLevel;
	}

	public void setGallons(double gallons) {
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

