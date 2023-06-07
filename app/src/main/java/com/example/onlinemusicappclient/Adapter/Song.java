package com.example.onlinemusicappclient.Adapter;

public class Song {
    String category, title, artist, albumName, durationInSeconds, link, id;

    public Song(String category, String title, String artist, String albumName, String durationInSeconds, String link) {

        if(title.trim().equals("")){
            title = "No Title";
        }


        this.category = category;
        this.title = title;
        this.artist = artist;
        this.albumName = albumName;
        this.durationInSeconds = durationInSeconds;
        this.link = link;
    }

    public Song() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(String durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
