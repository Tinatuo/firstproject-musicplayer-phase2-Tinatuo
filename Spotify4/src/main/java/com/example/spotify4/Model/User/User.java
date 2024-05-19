package com.example.spotify4.Model.User;

import com.example.spotify4.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Date;

public abstract class User {
    private String userName;
    private String password;
    private String firstAndLastname;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    public static String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{5,20}$";
    public static String regexEmail = "^[A-Za-z0-9._%+-]+@[a-z]+\\.com $";
    public static String phoneNumberRegex = "09[0-9]{9} $";
    private ImageView userPhoto;

    public ImageView getUserPhoto() {
        return userPhoto;
    }

    public void setArtistPhoto(ImageView artistPhoto) {
        this.userPhoto = artistPhoto;
    }

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public User(String userName, String password, String firstAndLastname, String phoneNumber, int year, int mounth, int day, String email,String imageView) {
        this.userName = userName;
        this.password = password;
        this.firstAndLastname = firstAndLastname;
        this.phoneNumber = phoneNumber;
        this.birthDate = new Date(year, mounth, day);
        this.email = email;
        String path = (Main.class.getResource(imageView)).toExternalForm();
        image = new Image(path);
        userPhoto = new ImageView(image);

    }

    public String toString() {
        String string = "";
        string = "Username: " + userName + "\nPassword: " + password + "\nFirstname and Lastname: " + firstAndLastname + "\nPhonenumber: " + phoneNumber + "\nBirthdate: " + birthDate;
        return string;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstAndLastname(String firstAndLastname) {
        this.firstAndLastname = firstAndLastname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(int year, int mounth, int day) {
        this.birthDate = new Date(year, mounth, day);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstAndLastname() {
        return firstAndLastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
