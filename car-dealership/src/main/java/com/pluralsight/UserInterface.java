package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
    }

    private void saveNewDealership(){
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle item : vehicles){
            System.out.println(item);
        }
    }

    public void display(){
        init();
        boolean running = true;

        while (running) {
        displayChoices();
        String choice = scanner.nextLine().trim();
            switch (choice){
                case "1" : processGetByPriceRequest();
                    break;
                case "2" : processGetByMakeModelRequest();
                    break;
                case "3" : processGetByYearRequest();
                    break;
                case "4" : processGetByColorRequest();
                    break;
                case "5" : processGetByMileageRequest();
                    break;
                case "6" : processGetByVehicleTypeRequest();
                    break;
                case "7" : processGetAllVehiclesRequest();
                    break;
                case "8" : processAddVehicleRequest();
                    break;
                case "9" : processRemoveVehicleRequest();
                    break;
                case "0" :  System.out.println("\nYou have chosen to leave! Have a nice day and come again!");
                            running = false;
                    break;
                default: System.out.println("\n**** Error invalid choice! Please choose a valid option. ****\n");
                    break;
            }
        }

    }

    public void displayChoices(){
        System.out.println("\n---- Welcome to the dealership! Please select one of the following. ----\n");
        System.out.println("(1) Find vehicles within a price range");
        System.out.println("(2) Find vehicles by make / model");
        System.out.println("(3) Find vehicles by year range");
        System.out.println("(4) Find vehicles by color");
        System.out.println("(5) Find vehicles by mileage range");
        System.out.println("(6) Find vehicles by type(car,truck,suv,van)");
        System.out.println("(7) List all vehicles");
        System.out.println("(8) Add a vehicle");
        System.out.println("(9) Remove a vehicle");
        // did 0 instead of 99 for user to type less
        System.out.println("(0) Quit");
        System.out.print("Selection: ");
    }

    public void processGetByPriceRequest(){
        try{
            System.out.println("\n~~~~ You have chosen to search by Price ~~~~");
            System.out.print("Max : ");
            double max = scanner.nextDouble();
            System.out.print("Min : ");
            double min = scanner.nextDouble();
            scanner.nextLine();
            // Create a new ArrayList to store vehicles that fall within the specified price range
            ArrayList<Vehicle> inRange = new ArrayList<>();
            // boolean for matching result
            boolean match = false;
            // Iterate through all vehicles in the dealership to check if their prices fall within the specified range
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                // Check if the price of the current vehicle is greater than or equal to the minimum price
                // and less than or equal to the maximum price
                if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                    // If the vehicle's price falls within the range, add it to the 'inRange' ArrayList
                    inRange.add(vehicle);
                    match = true;
                }
            }
            // Display vehicles in the price range
            displayVehicles(inRange);
            // display message for match result
            if(!match){
                System.out.println("\n **** No matching cars found in price range ****");
            } else {
                System.out.println("++++++++++ End of matching price results ++++++++++");
            }
        }catch (Exception e){
            // clear buffer if try fails
            scanner.nextLine();
            System.out.println("!! Error please provide a valid price !!");
            // re-run program
            processGetByPriceRequest();
        }
    }

    public void processGetByMakeModelRequest(){
        System.out.println("~~~~ You have chosen to search by make/model ~~~~");
        System.out.print("Please provide the make: ");
        String makeInput = scanner.nextLine().toLowerCase().trim();
        System.out.print("Please provide the model: ");
        String modelInput = scanner.nextLine().toLowerCase().trim();
        // boolean for matching result
        boolean match = false;
        ArrayList<Vehicle> matchingMakeModel = new ArrayList<>();
        for (Vehicle car : dealership.getAllVehicles()){
            String make = car.getMake().toLowerCase();
            String model = car.getModel().toLowerCase();

            if(model.contains(modelInput) && make.contains(makeInput)){
                matchingMakeModel.add(car);
                match = true;
            }
        }
        // pass matching vehicles to display
        displayVehicles(matchingMakeModel);
        // display message for match result
        if(!match){
            System.out.println("\n**** No matching cars found with make and model provided ****");
        } else {
            System.out.println("++++++++++ End of matching make/model results ++++++++++");
        }
    }

    public void processGetByYearRequest(){
        try{
            System.out.println("\n~~~~ You have chosen to search by year ~~~~");
            int year = scanner.nextInt();
            // clear buffer
            scanner.nextLine();
            // set match to false until match is founf
            boolean match = false;
            // create new arraylist to hold matching vehicles
            ArrayList<Vehicle> yearMatch = new ArrayList<>();
            // loop through all vehicles checking for possible match
            for(Vehicle vehicle : dealership.getAllVehicles()){
                if(vehicle.getYear() == year){
                    // add match to array list
                    yearMatch.add(vehicle);
                    // set bool to true
                    match = true;
                }
            }
            // send matching vehicles to be displayed
            displayVehicles(yearMatch);
            // display match results
            if(!match){
                System.out.println("\n**** No matching cars found with year provided ****");
            } else {
                System.out.println("++++++++++ End of matching year results ++++++++++");
            }
        }catch (Exception e){
            // clear buffer if string is given causing error
            scanner.nextLine();
            System.out.println("Please provide a valid number!");
            // re-run program
            processGetByYearRequest();
        }
    }

    public void processGetByColorRequest(){
        System.out.println("**** You have chosen to search by color! ****");
        System.out.print("Please provide the color: ");
        String color = scanner.nextLine();

        boolean match = false;
        ArrayList<Vehicle> matchingColor = new ArrayList<>();
        for(Vehicle vehicle : dealership.getAllVehicles()){
            if(vehicle.getColor().toLowerCase().equalsIgnoreCase(color)){
                matchingColor.add(vehicle);
                match = true;
            }
        }
        displayVehicles(matchingColor);
        if(!match){
            System.out.println("\n**** No matching cars found with color provided ****");
        } else {
            System.out.println("++++++++++ End of matching color results ++++++++++");
        }
    }

    public void processGetByMileageRequest(){
        try{
            System.out.println("You have chosen to search by mileage");
            System.out.print("Please provide the mileage: ");
            System.out.print("Max : ");
            double max = scanner.nextDouble();
            System.out.print("Min : ");
            double min = scanner.nextDouble();
            scanner.nextLine();
            // Create a new ArrayList to store vehicles that fall within the specified price range
            ArrayList<Vehicle> mileageMatch = new ArrayList<>();
            // boolean for matching result
            boolean match = false;
            // Iterate through all vehicles in the dealership to check if their prices fall within the specified range
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                // Check if the price of the current vehicle is greater than or equal to the minimum price
                // and less than or equal to the maximum price
                if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                    // If the vehicle's price falls within the range, add it to the 'inRange' ArrayList
                    mileageMatch.add(vehicle);
                    match = true;
                }
            }
            // Display vehicles in the price range
            displayVehicles(mileageMatch);
            // display message for match result
            if(!match){
                System.out.println("\n **** No matching cars found in mileage range ****");
            } else {
                System.out.println("++++++++++ End of matching mileage results ++++++++++");
            }
        }catch (Exception e){
            // clear buffer if try fails
            scanner.nextLine();
            System.out.println("!! Error please provide a valid mileage !!");
            // re-run program
            processGetByMileageRequest();
        }
    }

    public void processGetByVehicleTypeRequest(){
        System.out.println("**** You have chosen to search vehicle by type(car,suv,truck,van,ect) ****");
        System.out.print("Selection: ");
        String carType = scanner.nextLine().trim();

        boolean match = false;
        ArrayList<Vehicle> matchingType = new ArrayList<>();
        for (Vehicle vehicle : dealership.getAllVehicles()){
            if(vehicle.getVehicleType().equalsIgnoreCase(carType)){
                matchingType.add(vehicle);
                match = true;
            }
        }
        displayVehicles(matchingType);
        // display message for match result
        if(!match){
            System.out.println("\n **** No matching cars found by type ****");
        } else {
            System.out.println("++++++++++ End of matching car type results ++++++++++");
        }
    }

    public void processGetAllVehiclesRequest(){
        System.out.println("\n~~~~~~~ Start of all vehicles ~~~~~~~ ");
        displayVehicles(dealership.getAllVehicles());
        System.out.println("~~~~~~~ End of all vehicles ~~~~~~~\n");
    }

    public void processAddVehicleRequest(){
        try{
            System.out.println("**** You have chosen to add a vehicle ****");
            System.out.print("Please provide Vin: ");
            int vin = scanner.nextInt();
            System.out.print("Please provide Year: ");
            int year = scanner.nextInt();
            System.out.print("Please provide Odometer: ");
            int odometer = scanner.nextInt();
            System.out.print("Please provide Price: ");
            double price = scanner.nextInt();
            // clear leftover in buffer
            scanner.nextLine();
            System.out.print("Please provide Make: ");
            String make = scanner.nextLine().trim();
            System.out.print("Please provide Model: ");
            String model = scanner.nextLine().trim();
            System.out.print("Please provide Vehicle Type(car,suv,truck): ");
            String vehicleType = scanner.nextLine().trim();
            System.out.print("Please provide Color: ");
            String color = scanner.nextLine().trim();

            Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
            // add new vehicle to arraylist
            dealership.addVehicle(vehicle);
            System.out.println("\n**** Vehicle had been added ****");
            System.out.println(vehicle);
            System.out.println("\n**** Thank you for registering you vehicle today!  ****");
            // rewrite file by calling method that handles rewrite.
            saveNewDealership();
        }catch (Exception e ){
            // catch error from int or double
            scanner.nextLine();
            System.out.println("**** Error please provide a valid number ****");
            // re-run method
            processAddVehicleRequest();
        }
    }

    public void processRemoveVehicleRequest(){
        try{
            System.out.println("**** You have chosen to remove a vehicle ****");
            System.out.print("Please provide vin number for removal: ");
            int vin = scanner.nextInt();
            scanner.nextLine();
            Vehicle toDelete = null;
            for(Vehicle vehicle : dealership.getAllVehicles()){
                if(vehicle.getVin() == vin){
                    // remove vehicle with matching vin
                    dealership.removeVehicle(vehicle);
                    toDelete = vehicle;
                }
            }
            System.out.println("\n**** Vehicle below has been deleted!");
            System.out.println(toDelete);
            System.out.println("\n**** Thank you for removing your unused vehicle! ****");
            // rewrite file by calling method that handles rewrite.
            saveNewDealership();
        }catch (Exception e){
            // clear buffer for error if given string
            scanner.nextLine();
            System.out.println("\n**** Error please provide a number! ****");
            processRemoveVehicleRequest();
        }
    }

}