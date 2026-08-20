package com.example.spotify4.Controller;

import com.example.spotify4.Controller.Exception.UserNotFoundException;
import com.example.spotify4.Model.*;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.User.Admin;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.User;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.spotify4.Model.User.Admin.getAdmin;

public class AdminController extends UserController {
    public static AdminController adminController;
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public static AdminController getAdminController() {
        if (adminController == null)
            adminController = new AdminController();
        return adminController;
    }
    @Override
    public String signUp(String userName, String password, String firstAndLastname, String email, String phoneNumber, int year, int mounth, int day, String biograph) {
       String string="";
        Admin.getAdmin(userName,password,firstAndLastname,phoneNumber,year,mounth,day,email,getAdmin().getImage().getUrl());
        string="the registration operation was successful";
        return string;
    }

    public boolean logIn(String userName, String password) throws UserNotFoundException {
        boolean flag=false;
        if (Objects.equals(Admin.getAdmin().getUserName(), userName) && Objects.equals(Admin.getAdmin().getPassword(), password)) {
            this.admin = getAdmin();
            flag = true;
        } else {
            throw new UserNotFoundException();
        }
        return flag;
    }

    public String mostPopularAudioFile() {
       String string = "";
        for (int i = 0; i < DataBase.getDataBase().audios.size(); i++) {
            string += "\n" + String.valueOf(i + 1) + ":" + mostPopularAudioFileArray().get(i).getName();
        }
        return string;
    }
    public ArrayList<Audio> mostPopularAudioFileArray() {
        DataBase.getDataBase().audios.sort(java.util.Comparator.comparingLong(Audio::getNumberOfLike).reversed());
        return DataBase.getDataBase().audios;
    }
    public String showReports(){
        String string="Reports:";
        for (int i=0;i<DataBase.getDataBase().reports.size();i++){
            string+="\n"+String.valueOf(i+1)+" : "+DataBase.getDataBase().reports.get(i).toString();
        }
        return string;
    }
    public String showUserInfo(){
      return getAdmin().toString();
    }
    public String showAudioInfo(int ID){
        String string="";
        for(Audio audio:DataBase.getDataBase().audios){
            if(audio.getID()==ID){
                string=audio.toString();
            }
        }
        return string;
    }
    public String showArtistInfo(String artistName){
        String string="";
        for (User user:DataBase.getDataBase().users){
            if(user instanceof Artist){
                if(Objects.equals(((Artist) user).getUserName(), artistName)){
                    string=((Artist)user).toString();
                }
            }
        }
        return string;
    }
}
