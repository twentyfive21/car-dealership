package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;
/*
This DealershipFileManager class facilitates reading dealership information
and writing it to a file. The getDealership() method reads from "inventory.csv"
and constructs a Dealership object along with its vehicles.
The saveDealership() writes the dealership's details back to the file.
Both methods handle file I/O (input/output) and ensure data integrity.
 */

public class DealershipFileManager {

    public Dealership getDealership(){
        // Instantiate a Dealership object
        Dealership dealership = null;
        try{// create buf reader and file reader to read from file
            BufferedReader bufReader = new BufferedReader(new FileReader("inventory.csv"));
            // split the dealership info up to create dealership object
            String[] firstLine = bufReader.readLine().split(Pattern.quote("|"));
            // set dealership object attributes
            dealership = new Dealership(firstLine[0],firstLine[1],firstLine[2]);
            String input;
            // Continuously reads lines from the BufferedReader until the end of file (null) is reached,
            while((input = bufReader.readLine()) != null){
                // split at pipe
                String[] line = input.split(Pattern.quote("|"));
                // create each vehicle object
                Vehicle current = new Vehicle(Integer.parseInt(line[0]),
                        Integer.parseInt(line[1]), line[2],line[3],line[4],
                        line[5],Integer.parseInt(line[6]),Double.parseDouble(line[7]));
                // add to array list each vehicle object
                dealership.addVehicle(current);
            }
        // close reader
        bufReader.close();
        }catch(Exception e){
            System.out.println("Error loading inventory");
        }
        return dealership;
    }

    // overwrite the inventory file with current dealership information
    public void saveDealership(Dealership dealership){
     try{// create new buf writer to write to file
         BufferedWriter bufWriter = new BufferedWriter(new FileWriter("inventory.csv"));
         // write first line of dealership object
         bufWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
         // ship new line for vehicles
         bufWriter.newLine();
         String pipe = "|";
         // loop through array list and add each vehicle
         for(Vehicle car : dealership.getAllVehicles()){
             bufWriter.write(car.getVin()+ pipe +car.getYear()+ pipe + car.getMake() + pipe
                     +car.getModel()+ pipe + car.getVehicleType()+ pipe + car.getColor()+ pipe +
                     car.getOdometer()+ pipe + car.getPrice());
             // new line so vehicles are not stacked on top of each other
             bufWriter.newLine();
         }
         // close the writer
         bufWriter.flush();
         bufWriter.close();
     }catch (Exception e){
         System.out.println("Error saving new dealership info");
     }
    }
}
