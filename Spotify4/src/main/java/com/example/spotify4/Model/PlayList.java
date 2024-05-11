package com.example.spotify4.Model;

import com.example.spotify4.Model.Audio.Audio;

import java.util.ArrayList;

public class PlayList {
    private int ID=makeID();
    private String name;
    private String userCreatorName;
    private ArrayList<Audio> audoisList=new ArrayList<Audio>();

    public PlayList( String name, String userCreatorName) {
        this.name = name;
        this.userCreatorName = userCreatorName;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getUserCreatorName() {
        return userCreatorName;
    }

    public ArrayList<Audio> getAudoisList() {
        return audoisList;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserCreatorName(String userCreatorName) {
        this.userCreatorName = userCreatorName;
    }

    public void setAudoisList(ArrayList<Audio> audoisList) {
        this.audoisList = audoisList;
    }
    @Override
    public String toString(){
        String string="name: "+name+"\ncreator's name: "+userCreatorName+"\nplay list's ID: "+ID+"\nAudios: ";
        for(Audio audio1:audoisList){
            string+="\n"+audio1.getName();
        }
        return string;
    }
    public int makeID() {

        int id = this.name.hashCode() + this.userCreatorName.hashCode();
        int length = String.valueOf(id).length();
        int Max_Length = 5;
        if(String.valueOf(id).length()>Max_Length)
        {
            id = (int) (id /Math.pow(10.0,length - Max_Length ));
        }
        return  id;
    }
}
