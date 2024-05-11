package com.example.spotify4.Model.Audio;

import com.example.spotify4.Model.Genre;

import java.util.Date;

public abstract class Audio {
    private int ID=makeID();
    private String name;
    private String artistName;
    private long numberOfPlay=0;
    private long numberOfLike=0;
    private Date release;
    private Genre genre;
    private String link;
    private String cover;

    public Audio(String name, String artistName, int year,int mounth,int day, Genre genre, String link, String cover) {
        this.name = name;
        this.artistName = artistName;
        this.release = new Date(year,mounth,day);
        this.genre = genre;
        this.link = link;
        this.cover = cover;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setNumberOfPlay(long numberOfPlay) {
        this.numberOfPlay = numberOfPlay;
    }

    public void setNumberOfLike(long numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    public void setRelease(int year,int mounth,int day) {
        this.release =new Date(year,mounth,day) ;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public long getNumberOfPlay() {
        return numberOfPlay;
    }

    public long getNumberOfLike() {
        return numberOfLike;
    }

    public Date getRelease() {
        return release;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getLink() {
        return link;
    }

    public String getCover() {
        return cover;
    }
    public String toString(){
        String string;
        string="name:"+name+"\nID:"+ID+"\nModel.User.Artist's name:"+artistName+"\nThe number of play:"+numberOfPlay+"\nThe number of likes"+numberOfLike+"\nData of release:"+release+"\ngenre:"+genre+"\nLink:"+link+"\nCover:"+cover;
        return string;
    }
    public int makeID() {

        int id = this.name.hashCode() + this.getArtistName().hashCode();
        int length = String.valueOf(id).length();
        int Max_Length = 5;
        if(String.valueOf(id).length()>Max_Length)
        {
            id = (int) (id /Math.pow(10.0,length - Max_Length ));
        }
        return  id;
    }
}
