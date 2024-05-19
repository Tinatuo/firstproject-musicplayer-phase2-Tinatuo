package com.example.spotify4.Controller.ArtistController;

import com.example.spotify4.Controller.Exception.InvalidFormatException;
import com.example.spotify4.Controller.Exception.UserNotFoundException;
import com.example.spotify4.Controller.Exception.WrongPasswordException;
import com.example.spotify4.Controller.UserController;
import com.example.spotify4.Model.*;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.User;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class ArtistController extends UserController {
   private Artist artist1;
   public static ArtistController artistController;
    public static ArtistController getArtistController() {
        if (artistController == null)
            artistController= new ArtistController() ;

        return artistController;
    }

     public Artist getArtist1() {
         return artist1;
     }

     public void setArtist1(Artist artist1) {
         this.artist1 = artist1;
     }

     public  String signUp(String userName, String password, String firstAndLastname, String email, String phoneNumber, int year, int mounth, int day, String biography,String link) throws WrongPasswordException, InvalidFormatException {
        boolean flag = true;
        String string = null;
        Pattern pattern1 = Pattern.compile(User.regexPassword);
        Matcher matcher1 = pattern1.matcher(password);
        Pattern pattern2 = Pattern.compile(User.regexEmail);
        Matcher matcher2 = pattern2.matcher(email);
        Pattern pattern3 = Pattern.compile(User.phoneNumberRegex);
        Matcher matcher3 = pattern3.matcher(phoneNumber);
        for (User userUserName : DataBase.getDataBase().users) {
            if (Objects.equals(userUserName.getUserName(), userName)) {
                flag = false;
                string = "Duplicate Username";
                break;
            } else {
                flag = true;
            }
        }
        if (flag) {
            if (matcher1.matches() && matcher2.matches() && matcher3.matches()) {
                Artist newArtist = new Artist(userName, password, firstAndLastname, phoneNumber, year, mounth, day, email,biography,link);
                DataBase.getDataBase().users.add(newArtist);
                string = "the registration operation was successful";
            } else if (!matcher1.matches()) {
                throw new WrongPasswordException();
            } else if (!matcher2.matches()) {
                throw new InvalidFormatException();
            } else if (matcher3.matches()) {
                throw new InvalidFormatException();
            }
        }

        return string;
    }
    public String logIn(String userName, String password) throws UserNotFoundException {
        String string = "";
        for (User user : DataBase.getDataBase().users) {
            if (user instanceof Artist) {
                if (Objects.equals(((Artist) user).getUserName(), userName) && Objects.equals(((Artist) user).getPassword(), password)) {
                    this.artist1=((Artist)user);
                    string = "Successful login enter";
                } else {
                    throw new UserNotFoundException();
                }
            }
        }
        return string;
    }
    public String showFollowers(){
        String string="Followers: ";
        for(int i=0;i<artist1.followers.size();i++){
            string+="\n"+String.valueOf(i+1)+artist1.followers.get(i).getUserName();
        }
        return string;
    }
    public String numberOfPlay(){
        String string="The number of play musics or podcasts:";
        for(Audio audio:DataBase.getDataBase().audios){
            if(Objects.equals(audio.getArtistName(), artist1.getUserName())){
                string="\nAudio: "+audio.getName()+" : "+audio.getNumberOfPlay();
            }
        }
        return string;
    }
    public  double calculateIncome(){
        double dou=0;
        return dou;
    }
    public String showArtistInfo(){
        calculateIncome();
        return artist1.toString();
    }
    public String showUserInfo(){
        String string;
        string=artist1.toString();
        return string;
    }
}
