package com.example.spotify4.Model.User.Listener;

import com.example.spotify4.Model.Genre;

import java.util.ArrayList;

public class Premium extends Listener {

    private int remainingDays;

    public Premium(double accountCredit, int endYear, int endMounth, int endDay, ArrayList<Genre> favoriteGenre, String userName, String password, String firstAndLastname, String phoneNumber, int year, int mounth, int day, String email, int remainingDays) {
        super(accountCredit,endYear,endMounth,endDay, favoriteGenre, userName, password, firstAndLastname, phoneNumber, year, mounth, day, email);
        this.remainingDays = remainingDays;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    public int getRemainingDays() {
        return remainingDays;
    }
}
