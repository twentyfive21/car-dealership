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
        String choice = scanner.nextLine();
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
        System.out.println("(1) Find vehicles within a price range\n");
        System.out.println("(2) Find vehicles by make / model \n");
        System.out.println("(3) Find vehicles by year range \n");
        System.out.println("(4) Find vehicles by color \n");
        System.out.println("(5) Find vehicles by mileage range\n");
        System.out.println("(6) Find vehicles by type(car,truck,suv,van) \n");
        System.out.println("(7) List all vehicles \n");
        System.out.println("(8) Add a vehicle \n");
        System.out.println("(9) Remove a vehicle \n");
        // did 0 instead of 99 for user to type less
        System.out.println("(0) Quit \n");
        System.out.print("Selection: ");
    }

    public void processGetByPriceRequest(){

    }

    public void processGetByMakeModelRequest(){

    }

    public void processGetByYearRequest(){

    }

    public void processGetByColorRequest(){

    }

    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }

    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){

    }

    public void processRemoveVehicleRequest(){

    }

}
