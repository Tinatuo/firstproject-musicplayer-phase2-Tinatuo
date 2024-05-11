package com.example.spotify4.Controller.ArtistController;

import com.example.spotify4.Model.*;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.Audio.Podcast;
import com.example.spotify4.Model.User.Artist.Podcaster;

import java.util.Date;
import java.util.Objects;

public class PodcasterController extends ArtistController {
    public static PodcasterController podcasterController;
    public static PodcasterController getPodcasterController() {
        if (podcasterController == null)
            podcasterController= new PodcasterController();
        return podcasterController;
    }
    Date date2=new Date();
    @Override
    public double calculateIncome() {
        double inCome1 = 0;
        if(artist1 instanceof Podcaster){
            for (Audio audio: DataBase.getDataBase().audios){
                if(Objects.equals(audio.getArtistName(), artist1.getUserName())){
                    inCome1+=(audio.getNumberOfPlay()*0.5);
                }
            }
        }
        return inCome1;
    }
    public void publishPodcast(String title, String genreName, String caption, String link, String cover){
        Genre genre = null;
        for(Genre genre1:Genre.values()){
            if(genre1.name().equals(genreName)){
                genre=genre1;
            }
        }
        Podcast newPodcast=new Podcast(title,artist1.getUserName(),date2.getYear(), date2.getMonth(),date2.getDay(),genre,link,cover,caption);
        ((Podcaster)artist1).podcasts.add(newPodcast);
    }
}
