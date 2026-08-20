package com.example.spotify4.Model;

import com.example.spotify4.Model.Audio.Music;

import java.util.ArrayList;

public class Album {
    private int ID=makeID();
    private String name;
    private String singerName;
    private ArrayList<Music> songsList = new ArrayList<Music>();

    public Album(String name, String singer) {
        this.name = name;
        this.singerName = singer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSinger(String singer) {
        this.singerName = singer;
    }

    public void setSongsList(ArrayList<Music> songsList) {
        this.songsList = songsList;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singerName;
    }

    public ArrayList<Music> getSongsList() {
        return songsList;
    }

    @Override
    public String toString() {
        String string;
        string="Name:"+name+"\nID:"+"\nSinger's name:"+singerName+"\n List of album's songs:";
        for(int i=0;i< songsList.size();i++){
            string+="\n"+songsList.get(i);
        }
        return string;
    }
    public int makeID() {

        int id = this.name.hashCode() + this.singerName.hashCode();
        int length = String.valueOf(id).length();
        int Max_Length = 5;
        if(String.valueOf(id).length()>Max_Length)
        {
            id = (int) (id /Math.pow(10.0,length - Max_Length ));
        }
        return  id;
    }
}
