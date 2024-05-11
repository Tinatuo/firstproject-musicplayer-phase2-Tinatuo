package com.example.spotify4.Model.Audio;
import com.example.spotify4.Model.Genre;


public class Music extends Audio {
    private String lyric;

    public Music(String name, String artistName, int year, int mounth, int day, Genre genre, String link, String cover, String lyric) {
        super(name, artistName, year, mounth, day, genre, link, cover);
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
