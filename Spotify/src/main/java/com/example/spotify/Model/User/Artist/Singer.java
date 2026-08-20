package com.example.spotify4.Model.User.Artist;

import com.example.spotify4.Model.Album;

import java.util.ArrayList;

public class Singer extends Artist {

     public ArrayList<Album> albums=new ArrayList<Album>();
    public Singer(String userName, String password, String firstAndLastname, String phoneNumber, int year,int mounth,int day,String email,String biography,String imageView) {
        super(userName, password, firstAndLastname, phoneNumber,year,mounth,day,email,biography,imageView);
    }
    @Override
    public String toString(){
        String string="";
        string="Username: "+getPassword()+"\nPassword: "+getPassword()+"\nFirstname and Lastname: "+getFirstAndLastname()+"\nPhonenumber: "+getPhoneNumber()+"\nBirthdate: "+getBirthDate()+"\nBiography: "+getBiography()+"\nAlbums: ";
       for(Album album1:this.albums){
           string+="\n"+album1.getName();
       }
        return string;
    }
}
