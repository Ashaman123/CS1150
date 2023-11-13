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
    }

    // Create the cars for the simulation based on the assignment sheet table and
    // fills the incoming array with the cars
    public static void createCars(Car[] cars) {
        // Implementation for creating cars
    }

    // Print the details for each car in the array. Display the car’s owner,
    // model, MPG, gallons, and mileage
    public static void printCars(Car[] cars) {
        // Implementation for printing car details
    }

    // Returns true if all the cars are out of gas. This requires examining the
    // fuel level of each car in the array. If all cars have “Empty” fuel level
    // return true, otherwise return false
    public static boolean checkFuelLevels(Car[] cars) {
        // Implementation for checking fuel levels
        return false;
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
}

class FuelGauge {
    // Details for the fuel gauge class go here
    private int gallons;

    // Add constructor, getters, and setters as needed

    public int getGallons() {
        return gallons;
    }
}

class Odometer {
    // Details for the odometer class go here
    // Add necessary attributes, constructor, getters, and setters
}

