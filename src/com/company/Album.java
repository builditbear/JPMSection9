package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new SongList();
    }

    public boolean addToPlayList(int trackNo, LinkedList<Song> playlist){
        // Adjust input for 0 based index;
        trackNo -= 1;
        if(trackNo < songs.getSize() && trackNo >= 0){
            return addToPlayList(songs.getSongs().get(trackNo).getTitle(), playlist);
        }
        // No need to proceed further if trackNo given is out of bounds.
        return false;
    }

    public boolean addToPlayList(String song, LinkedList<Song> playlist){
        Song s = songs.findSong(song);
        // Check if that song exists on this album...
        if(songs.findSong(song) == null){
            return false;
        }
        // Then ensure that it's not in the playlist.
        for (Song current : playlist) {
            if (current.getTitle().equals(song)) {
                System.out.println(song + " is already in this playlist.");
                return false;
            }
        }
        // Song is not in the playlist, so we are free to add the song.
        playlist.add(s);
        return true;
    }

    public boolean addSong(String song, double duration){
        return songs.addSong(song, duration);
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public ArrayList<Song> getSongs() {
            return songs;
        }

        public int getSize(){
            return songs.size();
        }

        public void setSongs(ArrayList<Song> songs) {
            this.songs = songs;
        }

        public boolean addSong(String song, double duration){
            if(findSong(song) == null){
                songs.add(new Song(song, duration));
                return true;
            }
            return false;
        }

        private Song findSong(String song) {
            for (Song s : songs) {
                if (s.getTitle().equals(song)) {
                    return s;
                }
            }
            return null;
        }
    }
}
