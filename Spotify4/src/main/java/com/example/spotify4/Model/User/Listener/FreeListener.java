package com.example.spotify4.Model.User.Listener;

import com.example.spotify4.Model.Genre;

import java.util.ArrayList;

public class FreeListener extends Listener {

    private int limitAddMusicToPlayList=10;
    private int limitMakePlayList=3;
@Override
public String toString(){
    String string="";
    string="Username: "+getUserName()+"\nPassword: "+getPassword()+"\nFirstname and Lastname: "+getFirstAndLastname()+"\nPhonenumber: "+getPhoneNumber()+"\nBirthdate: "+getBirthDate()+"\naccount credit: "+getAccountCredit()+"\nDate of end subscription: "+ getEndSubscription()+"\nlimit Add Music To PlayList: "+getLimitAddMusicToPlayList()+"limit Make PlayList: "+limitMakePlayList;
    return string;
}
    public int getLimitAddMusicToPlayList() {
        return limitAddMusicToPlayList;
    }

    public int getLimitMakePlayList() {
        return limitMakePlayList;
    }

    public void setLimitAddMusicToPlayList(int limitAddMusicToPlayList) {
        this.limitAddMusicToPlayList = limitAddMusicToPlayList;
    }

    public void setLimitMakePlayList(int limitMakePlayList) {
        this.limitMakePlayList = limitMakePlayList;
    }

    public FreeListener(double accountCredit, int endYear, int endMounth, int endDay, ArrayList<Genre> favoriteGenre, String userName, String password, String firstAndLastname, String phoneNumber, int year, int mounth, int day, String email,String imageView) {
        super(accountCredit,endYear,endMounth,endDay , favoriteGenre, userName, password, firstAndLastname, phoneNumber,year,mounth,day,email,imageView);
    }

}
