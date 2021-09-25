package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlaylistUI {
    private static final Scanner input = new Scanner(System.in);

    public static void UI(LinkedList<Song> playlist){
        if(playlist.isEmpty()){
            System.out.println("This playlist is empty! Add some songs and try again.");
        }else{
            ListIterator<Song> playlistIterator = playlist.listIterator();
            Song currentSong;
            currentSong = playlistIterator.next();
            System.out.println("Now playing: " + currentSong.toString());
            boolean traversingForward = true;
            while(true){
                switch(inputSelection()){
                    // Quit.
                    case 0:
                        System.out.println("Exiting playlist UI.");
                        return;
                    // Skip to next song.
                    case 1:
                        if(!traversingForward){
                            // Return to the "forward" facing side of the current song, or we will effectively repeat
                            // whatever is playing right now.
                            playlistIterator.next();
                            traversingForward = true;
                        }
                        if(!playlistIterator.hasNext()){
                            // If we've reached the end of the playlist, just loop to the start of the list with
                            // a new iterator - this feels more graceful than just telling the user they've reached
                            // the end of the playlist, and is a behavior I'm accustomed to in real life.
                            playlistIterator = playlist.listIterator();
                        }
                        currentSong = playlistIterator.next();
                        System.out.println("Skipping to next song. Now playing: " + currentSong.toString());
                        break;
                    // Play previous song.
                    case 2:
                        if(traversingForward){
                            playlistIterator.previous();
                            traversingForward = false;
                        }
                        if(playlistIterator.hasPrevious()){
                            currentSong = playlistIterator.previous();
                            System.out.println("Playing previous song. Now playing: " + currentSong.toString());
                        }else{
                            // Would like to loop to the end of the playlist, but can't think of an elegant, time efficient
                            // way to do this (i.e., a way that doesn't call for iterating through the whole list).
                            System.out.println("We're already playing the first song of the playlist!");
                        }
                        break;
                    // Replay current song.
                    case 3:
                        if(traversingForward){
                            playlistIterator.previous();
                        }else{
                            // If we're traversing backward, the iterator should be in position to play the song
                            // that was played last.
                            traversingForward = true;
                        }
                        currentSong = playlistIterator.next();
                        System.out.println("Replaying current song. Now playing: " + currentSong.toString());
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    public static int inputSelection(){
        System.out.println("Enter '0' to quit listening to this playlist.");
        System.out.println("Enter '1' to skip to the next song.");
        System.out.println("Enter '2' to play the previous song.");
        System.out.println("Enter '3' to replay the current song.");
        if(input.hasNextInt()){
            return input.nextInt();
        }else{
            return -1;
        }
    }
}
