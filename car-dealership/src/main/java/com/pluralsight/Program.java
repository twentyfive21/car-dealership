package com.pluralsight;

/*
This Program class serves as the entry point for the application.
It creates an instance of the UserInterface class and calls its display()
method to initiate the user interface. */

public class Program {
    public static void main(String[] args) {
    UserInterface userInterface = new UserInterface();
    userInterface.display();
    }
}