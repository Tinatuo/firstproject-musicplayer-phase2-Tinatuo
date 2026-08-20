package com.example.spotify4.Model.Audio;

import com.example.spotify4.Model.Genre;

public class Podcast extends Audio {
   private String caption;
    public Podcast(String name, String artistName, int year, int mounth, int day, Genre genre, String link, String cover, String caption,String imageView) {
        super(name, artistName,year,mounth,day, genre, link, cover, imageView);
        this.caption=caption;
    }
@Override
public String toString() {
    String string = "";
    string = string = "name:" + getName() + "\nID:" + getID() + "\nModel.User.Artist's name:" + getArtistName() + "\nThe number of play:" + getNumberOfPlay() + "\nThe number of likes" + getNumberOfLike() + "\nData of release:" + getRelease() + "\ngenre:" + getGenre() + "\nLink:" + getLink() + "\nCover:" + getCover() + "\ncaption: " + getCaption();
    return string;
}
    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
