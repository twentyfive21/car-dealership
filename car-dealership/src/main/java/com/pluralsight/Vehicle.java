package com.pluralsight;

public class Vehicle {
    // A Vehicle class with various attributes such as VIN, year, make, model, etc.
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    // Constructor to initialize a Vehicle object with given attributes
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // getters and setters

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        // Create a StringBuilder object to efficiently construct the formatted string
        StringBuilder sb = new StringBuilder();
        // Append the top border of the box
        // Append each piece of vehicle information with proper formatting using String.format()
        // Append the title of the vehicle information section
        // %-21s: Left-aligns the string within a 21-character wide field
        sb.append("╔═══════════════════════════╗\n");
        sb.append("║        🚘 🚔 🚙 🚕       ║\n");
        sb.append("║    Vehicle Information    ║\n");
        sb.append("╠═══════════════════════════╣\n");
        sb.append(String.format("║ Vin: %-21s║\n", vin));
        sb.append(String.format("║ Year: %-20s║\n", year));
        sb.append(String.format("║ Make: %-20s║\n", make));
        sb.append(String.format("║ Model: %-19s║\n", model));
        sb.append(String.format("║ Vehicle Type: %-12s║\n", vehicleType));
        sb.append(String.format("║ Color: %-19s║\n", color));
        sb.append(String.format("║ Odometer: %-16s║\n", String.format("%,d", odometer)));
        sb.append(String.format("║ Price: $%-18s║\n", String.format("%,.2f", price)));
        sb.append("╚═══════════════════════════╝\n");
        // Convert the StringBuilder object to a String and return it
        return sb.toString();
    }

}
