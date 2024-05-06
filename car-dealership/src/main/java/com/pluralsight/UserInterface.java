package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;


    public UserInterface() {

    }

    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle item : vehicles){
            System.out.println(item);
        }
    }

    public void display(){
        init();
        displayChoices();
        Scanner scanner = new Scanner(System.in);
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
            case "0" : quit();
                break;
            default: System.out.println("\nError invalid choice! Please choose a valid option.");
                    display();
                    break;
        }

    }

    public void quit(){
        System.out.println("\nYou have chosen to leave! Have a nice day and come again!");
    }

    public void displayChoices(){
        System.out.println("Welcome to the dealership! Please select one of the following.\n");
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
        display();
    }

    public void processGetByMakeModelRequest(){
        display();
    }

    public void processGetByYearRequest(){
        display();
    }

    public void processGetByColorRequest(){
        display();
    }

    public void processGetByMileageRequest(){
        display();
    }

    public void processGetByVehicleTypeRequest(){
        display();
    }

    public void processGetAllVehiclesRequest(){
        System.out.println("\n~~~~~~~ Start of all vehicles ~~~~~~~ ");
        displayVehicles(dealership.getAllVehicles());
        System.out.println("~~~~~~~ End of all vehicles ~~~~~~~\n");
        System.out.println("    ");
        display();

    }

    public void processAddVehicleRequest(){
        display();
    }

    public void processRemoveVehicleRequest(){
        display();
    }

}
