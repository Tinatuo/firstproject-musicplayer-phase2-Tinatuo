package com.example.spotify4;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Model.Audio.Music;
import com.example.spotify4.Model.DataBase;
import com.example.spotify4.Model.Genre;
import com.example.spotify4.View.Scenes.ChangeScene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        ChangeScene.stage = stage;
        ChangeScene.homeScene();
        ChangeScene.stage.show();
    }

    @Override
    public void init() throws Exception {
        //      Music music1=new Music("Ayene","Farhad Mehrad",1367,3,7,Genre.SOCIETY,"https://dl.mahanmusics.com/Song/farhad/Farhad%20Mehrad%20-%20Ayne-128.mp3","","یه شب مهتاب ماه میاد تو خواب","ab6761610000e5eb7af76b827df15f2342833123.jpg");
        Music music = new Music("Boye Gandom", "Daryosh", 1360, 11, 12, Genre.POP, "https://dl.musiceto.com/Music/1401/10/Dariush%20-%20Boye%20Khobe%20Gandom_musiceto.com.mp3?_=1", "", "بوي گندم مال من هرچي كه دارم مال تو", "Dariush - Nadim.webp");
        //     DataBase.getDataBase().audios.add(music1);
        DataBase.getDataBase().audios.add(music);
        //      ListenerController.getListenerController().getSuggestions().add(music);
     //   AdminController.getAdminController().mostPopularAudioFileArray().add(music);

    }

    public static void main(String[] args) {
        launch(args);
    }
}