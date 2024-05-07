package com.pluralsight;

import java.util.ArrayList;
/*
 This Dealership class models a car dealership with attributes like name,
 address, phone, and an inventory of vehicles. It provides methods for
 retrieving vehicles based on different criteria and managing the inventory.
 */
public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // constructor to create dealership object
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
   // Instantiating the ArrayList and creates an empty list when dealership object is created
        this.inventory = new ArrayList<>();
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // methods
    public Vehicle getVehiclesByPrice(double min, double max){
        return null;
    }

    public Vehicle getVehiclesByMakeModel(String make, String model){
        return null;
    }

    public Vehicle getVehiclesByYear(int min, int max){
        return null;
    }

    public Vehicle getVehiclesByColor(String color){
        return null;
    }

    public Vehicle getVehiclesByMileage(double min, double max){
        return null;
    }

    public Vehicle getVehiclesByType(String vehicleType){
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
