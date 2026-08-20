package com.example.spotify4.Model.Audio;
import com.example.spotify4.Model.Genre;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Music extends Audio {
    private String lyric;

    public Music(String name, String artistName, int year, int mounth, int day, Genre genre, String link, String cover, String lyric,String imageView) {
        super(name, artistName, year, mounth, day, genre, link, cover, imageView);
        this.lyric = lyric;


    }

    @Override
    public String toString() {
        String string = "";
        string = "name:" + getName() + "\nID:" + getID() + "\nModel.User.Artist's name:" + getArtistName() + "\nThe number of play:" + getNumberOfPlay() + "\nThe number of likes" + getNumberOfLike() + "\nData of release:" + getRelease() + "\ngenre:" + getGenre() + "\nLink:" + getLink() + "\nCover:" + getCover() + "\nlyric: " + getLyric();
        return string;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getLyric() {
        return lyric;
    }
}
