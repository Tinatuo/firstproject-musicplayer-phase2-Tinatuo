package com.example.spotify4;

import com.example.spotify4.Data.SampleData;
import com.example.spotify4.View.Scenes.ChangeScene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        ChangeScene.stage = stage;
        ChangeScene.stage.setMinWidth(747);
        ChangeScene.stage.setMinHeight(529);
        ChangeScene.homeScene();
        ChangeScene.stage.show();
    }

    @Override
    public void init() {
        SampleData.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
