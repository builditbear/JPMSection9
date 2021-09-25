package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Test code for Album > Song class, in order of dependency.
        ArrayList<Album> albums = new ArrayList<>();

        Album a = new Album("My Incredible Songs", "Mr.Incredible");
        a.addSong("The Incredible Bulk", 10.32);
        a.addSong("No Butts, No Glory", 1.01);
        a.addSong("Nice Glutes", 3.13);
        a.addSong("Saturday Night Beaver", 12.54);
        a.addSong("In the Gravy", 50.12);
        albums.add(a);

        Album b = new Album("Now THAT'S What I Call Snoozing!", "Mr. Sandman");
        b.addSong("Dreamland Anthem", 5.43);
        b.addSong("Chloroform", 10.43);
        b.addSong("Food Coma", 4.55);
        b.addSong("Oops! I Slept Through It Again", 4.56);
        b.addSong("Sho Schleepy", 7.87);
        albums.add(b);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(1).addToPlayList("Dreamland Anthem", playlist);
        albums.get(1).addToPlayList("Food Coma", playlist);
        albums.get(0).addToPlayList("Nice Glutes", playlist);
        albums.get(0).addToPlayList("Saturday Night Beaver", playlist);

        // Testing overloaded version of addToPlayList.
        albums.get(0).addToPlayList(5, playlist);
        albums.get(1).addToPlayList(2, playlist);
        albums.get(1).addToPlayList(5, playlist);

        // This index should not exist, but should also not result in an error.
        albums.get(0).addToPlayList(5, playlist);
        // These should not be added, as they are duplicates.
        albums.get(0).addToPlayList("Nice Glutes", playlist);
        albums.get(0).addToPlayList("Saturday Night Beaver", playlist);
        albums.get(1).addToPlayList(2, playlist);
        albums.get(1).addToPlayList(4, playlist);

        System.out.println();
        System.out.println();

        PlaylistUI.UI(playlist);

        // Test code for Saveable Interface and clOrder implementation of that interface.
//        // Create an item from a class that implements the saveable interface, and tests that the values were
//        // assigned correctly.
//        Saveable saveableItem = new clOrder("Alcon", "Bausch & Lomb",
//                "Ultra", 8, 6, 2);
//        System.out.println(saveableItem);
//
//        List<String> writeBuffer = saveableItem.write();
//        for(String s : writeBuffer){
//            System.out.println(s + " was written to disk.");
//        }
//
//        saveableItem.read(readValues());
//        System.out.println(saveableItem);
//    }
//
//    // Taken from Tim Buchalka's source code - he wrote it to simply read user input values into an ArrayList.
//    // He recommended we use it to simulate reading data from data storage for this exercise, as we have not covered
//    // I/O just yet!
//    public static ArrayList<String> readValues() {
//        ArrayList<String> values = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//        boolean quit = false;
//        int index = 0;
//        System.out.println("Choose\n" +
//                "1 to enter a string\n" +
//                "0 to quit");
//
//        while (!quit) {
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            switch (choice) {
//                case 0:
//                    quit = true;
//                    break;
//                case 1:
//                    System.out.print("Enter a string: ");
//                    String stringInput = scanner.nextLine();
//                    values.add(index, stringInput);
//                    index++;
//                    break;
//            }
//        }
//        return values;
    }
}
