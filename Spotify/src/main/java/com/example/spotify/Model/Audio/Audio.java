package com.example.spotify4.Model.Audio;

import com.example.spotify4.Application;
import com.example.spotify4.Model.Genre;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Date;

public class Audio implements Comparable<Audio> {
    private int ID;
    private String name;
    private String artistName;
    private long numberOfPlay = 0;
    private long numberOfLike = 0;
    private Date release;
    private Genre genre;
    private String link;
    private String cover;
    private ImageView audioPhoto;
    private Media audio;
    private MediaPlayer mediaPlayer;


    public void setRelease(Date release) {
        this.release = release;
    }

    public void setAudio(Media audio) {
        this.audio = audio;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public Media getAudio() {
        return audio;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public ImageView getAudioPhoto() {
        return audioPhoto;
    }

    public void setAudioPhoto(ImageView audioPhoto) {
        this.audioPhoto = audioPhoto;
    }

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Audio(String name, String artistName, int year, int mounth, int day, Genre genre, String link, String cover, String imageView) {
        this.name = name;
        this.artistName = artistName;
        this.release = new Date(year - 1900, mounth - 1, day);
        this.genre = genre;
        this.link = link;
        this.cover = cover;
        String path = (Application.class.getResource(imageView)).toExternalForm();
        image = new Image(path);
        audioPhoto = new ImageView(image);
        this.audio = new Media(link);
        this.mediaPlayer = new MediaPlayer(audio);
        this.ID = makeID();
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

    public void setRelease(int year, int mounth, int day) {
        this.release = new Date(year - 1900, mounth - 1, day);
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

    public String toString() {
        String string;
        string = "name:" + name + "\nID:" + ID + "\nModel.User.Artist's name:" + artistName + "\nThe number of play:" + numberOfPlay + "\nThe number of likes" + numberOfLike + "\nData of release:" + release + "\ngenre:" + genre + "\nLink:" + link + "\nCover:" + cover;
        return string;
    }

    public int makeID() {
        int id = this.name.hashCode() + this.getArtistName().hashCode();
        int length = String.valueOf(id).length();
        int Max_Length = 5;
        if (String.valueOf(id).length() > Max_Length) {
            id = (int) (id / Math.pow(10.0, length - Max_Length));
        }
        return id;
    }

    @Override
    public int compareTo(Audio audio) {
        int nameCompare = this.name.compareToIgnoreCase(audio.name);
        if (nameCompare != 0) {
            return nameCompare;
        }

        int likeCompare = Long.compare(audio.numberOfLike, this.numberOfLike);
        if (likeCompare != 0) {
            return likeCompare;
        }

        if (this instanceof Music && audio instanceof Podcast) {
            return -1;
        }
        if (this instanceof Podcast && audio instanceof Music) {
            return 1;
        }

        return Long.compare(audio.numberOfPlay, this.numberOfPlay);
        }
    }
