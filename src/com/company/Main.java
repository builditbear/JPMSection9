package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create an item from a class that implements the saveable interface, and tests that the values were
        // assigned correctly.
        Saveable saveableItem = new clOrder("Alcon", "Bausch & Lomb",
                "Ultra", 8, 6, 2);
        System.out.println(saveableItem);

        List<String> writeBuffer = saveableItem.write();
        for(String s : writeBuffer){
            System.out.println(s + " was written to disk.");
        }

        saveableItem.read(readValues());
        System.out.println(saveableItem);
    }

    // Taken from Tim Buchalka's source code - he wrote it to simply read user input values into an ArrayList.
    // He recommended we use it to simulate reading data from data storage for this exercise, as we have not covered
    // I/O just yet!
    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
