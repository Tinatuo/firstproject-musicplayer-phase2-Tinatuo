package com.example.spotify4.Model.User.Artist;

import com.example.spotify4.Model.Audio.Podcast;

import java.util.ArrayList;

public class Podcaster extends Artist {

   public ArrayList<Podcast> podcasts=new ArrayList<Podcast>();
    public Podcaster(String userName, String password, String firstAndLastname, String phoneNumber,int year,int mounth,int day,String email, String biography) {
        super(userName, password, firstAndLastname, phoneNumber,year,mounth,day,email, biography);
    }
}
