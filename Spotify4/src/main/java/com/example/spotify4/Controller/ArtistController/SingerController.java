package com.example.spotify4.Controller.ArtistController;

import com.example.spotify4.Model.*;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.Audio.Music;
import com.example.spotify4.Model.User.Artist.Singer;

import java.util.Date;
import java.util.Objects;

public class SingerController extends ArtistController {
    public static SingerController singerController;
    Date date1=new Date();
    public static SingerController getSingerController() {
        if (singerController == null)
            singerController = new SingerController();
        return singerController;
    }
    @Override
    public double calculateIncome() {
        double inCome1 = 0;
        if(artist1 instanceof Singer){
            for (Audio audio: DataBase.getDataBase().audios){
                if(Objects.equals(audio.getArtistName(), artist1.getUserName())){
                    inCome1+=(audio.getNumberOfPlay()*0.4);
                }
            }
        }
        return inCome1;
    }
    public Music publishMusic(String title, String genreName, String lyric, String link, String cover, int albumID){
        Genre genre = null;
        for(Genre genre1:Genre.values()){
            if(genre1.name().equals(genreName)){
                genre=genre1;
            }
        }
        Music newMusic=new Music(title,artist1.getUserName(),date1.getYear(),date1.getMonth(), date1.getDay(), genre,link,cover,lyric);
        for (Album album:((Singer)artist1).albums){
            if(album.getID()==albumID){
                album.getSongsList().add(newMusic);
            }
        }
        return newMusic;
    }
    public Album makeAlbum(String albumName){
        Album newAlbum=new Album(albumName,((Singer)artist1).getUserName());
        ((Singer)artist1).albums.add(newAlbum);
        return newAlbum;
    }
}
