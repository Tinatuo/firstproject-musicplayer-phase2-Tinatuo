package com.example.spotify4.Model.User.Artist;

import com.example.spotify4.Main;
import com.example.spotify4.Model.User.User;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Artist extends User {

    private double incom;
    public ArrayList<User> followers = new ArrayList<User>();
    private String biography;


    public Artist(String userName, String password, String firstAndLastname, String phoneNumber, int year, int mounth, int day, String email, String biography, String imageView) {
        super(userName, password, firstAndLastname, phoneNumber, year, mounth, day, email,imageView);
        this.biography = biography;

    }

    public String toString() {
        String string = "";
        string = "Username: " + getPassword() + "\nPassword: " + getPassword() + "\nFirstname and Lastname: " + getFirstAndLastname() + "\nPhonenumber: " + getPhoneNumber() + "\nBirthdate: " + getBirthDate() + "\nBiography: " + biography;
        return string;
    }

    public double getIncom() {
        return incom;
    }

    public String getBiography() {
        return biography;
    }

    public void setIncom(double incom) {
        this.incom = incom;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
