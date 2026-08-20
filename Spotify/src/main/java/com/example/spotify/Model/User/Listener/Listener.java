package com.example.spotify4.Model.User.Listener;

import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.Genre;
import com.example.spotify4.Model.PlayList;
import com.example.spotify4.Model.User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Listener extends User {
    private double accountCredit;
    public ArrayList<PlayList> playLists=new ArrayList<PlayList>();
    public Map<Audio,Integer> numberOfPlayingAudio=new HashMap<>();

    private Date endSubscription;
    private ArrayList<Genre> favoriteGenre=new ArrayList<Genre>();

    public Listener(double accountCredit,int endYear,int endMounth,int endDay, ArrayList<Genre> favoriteGenre , String userName, String password, String firstAndLastname, String phoneNumber,int year,int mounth,int day,String email,String imageView) {
        super(userName, password, firstAndLastname, phoneNumber,year,mounth,day,email,imageView);
        this.accountCredit=accountCredit;
        this.endSubscription=new Date(endYear - 1900,endMounth - 1,endDay);
        if(ListenerController.getListenerController().listener instanceof FreeListener){
            ListenerController.getListenerController().listener.endSubscription=null;
        }
        this.favoriteGenre=favoriteGenre;
    }
    @Override
    public String toString(){
        String string="";
        string="Username: "+getUserName()+"\nPassword: "+getPassword()+"\nFirstname and Lastname: "+getFirstAndLastname()+"\nPhonenumber: "+getPhoneNumber()+"\nBirthdate: "+getBirthDate()+"\naccount credit: "+accountCredit+"\nDate of end subscription: "+ endSubscription;
        return string;
    }
    public double getAccountCredit() {
        return accountCredit;
    }

    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }


    public Date getEndSubscription() {
        return endSubscription;
    }

    public ArrayList<Genre> getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setPlayLists(ArrayList<PlayList> playLists) {
        this.playLists = playLists;
    }


    public void setEndSubscription(Date endSubscription) {
        this.endSubscription = endSubscription;
    }

    public void setFavoriteGenre(ArrayList<Genre> favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public void setAccountCredit(double accountCredit) {
        this.accountCredit = accountCredit;
    }
}
