package com.example.spotify4.Model;

import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.User.User;

import java.util.ArrayList;

public class DataBase {
    private static DataBase dataBase;
   public ArrayList<User> users;
   public ArrayList<Audio> audios;
    public ArrayList<Report> reports;
    public DataBase(){
        this.users=new ArrayList<User>();
        this.audios=new ArrayList<Audio>();
        this.reports=new ArrayList<Report>();
    }
    public static DataBase getDataBase() {
        if (dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }

}
