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
        if(artistController.getArtist1() instanceof Singer){
            for (Audio audio: DataBase.getDataBase().audios){
                if(Objects.equals(audio.getArtistName(), artistController.getArtist1().getUserName())){
                    inCome1+=(audio.getNumberOfPlay()*0.4);
                }
            }
        }
        return inCome1;
    }
    public Music publishMusic(String title, String genreName, String lyric, String link, String cover, int albumID,String imageView){
        Genre genre = null;
        for(Genre genre1:Genre.values()){
            if(genre1.name().equals(genreName)){
                genre=genre1;
            }
        }
        Music newMusic=new Music(title,artistController.getArtist1().getUserName(),date1.getYear(),date1.getMonth(), date1.getDay(), genre,link,cover,lyric,imageView);
        for (Album album:((Singer)artistController.getArtist1()).albums){
            if(album.getID()==albumID){
                album.getSongsList().add(newMusic);
            }
        }
        return newMusic;
    }
    public Album makeAlbum(String albumName){
        Album newAlbum=new Album(albumName,((Singer)artistController.getArtist1()).getUserName());
        ((Singer)artistController.getArtist1()).albums.add(newAlbum);
        return newAlbum;
    }
}
