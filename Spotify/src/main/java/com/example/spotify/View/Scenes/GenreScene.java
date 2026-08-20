package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.ListenerController.ListenerController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class GenreScene {
    private int limit = 4;
    private ArrayList<String> genres = new ArrayList<>();

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private Rectangle rec;

    @FXML
    private Rectangle rec1;

    @FXML
    private Rectangle rec2;

    @FXML
    private Rectangle rec3;

    @FXML
    private Rectangle rec4;

    @FXML
    private Rectangle rec5;

    @FXML
    private Rectangle rec6;

    @FXML
    private Rectangle rec7;

    @FXML
    private Rectangle rec8;

//    @FXML
//    private Button submitButton;
//
//    @FXML
//    private Button backButton;



    @FXML
    void backTo(MouseEvent event) {
        ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
        ChangeScene.stage.show();
    }

    @FXML
    void label(MouseEvent event) {
        if (limit > 0) {
            genres.add(label.getText());
            rec.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void label1(MouseEvent event) {
        if (limit > 0) {
            genres.add(label1.getText());
            rec1.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void label2(MouseEvent event) {
        if (limit > 0) {
            genres.add(label2.getText());
            rec2.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void label3(MouseEvent event) {
        if (limit > 0) {
            genres.add(label3.getText());
            rec3.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void label4(MouseEvent event) {
        if (limit > 0) {
            genres.add(label4.getText());
            rec4.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void label5(MouseEvent event) {
        if (limit > 0) {
            genres.add(label5.getText());
            rec5.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void label6(MouseEvent event) {
        if (limit > 0) {
            genres.add(label6.getText());
            rec6.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void label7(MouseEvent event) {
        if (limit > 0) {
            genres.add(label7.getText());
            rec7.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void label8(MouseEvent event) {
        if (limit > 0) {
            genres.add(label8.getText());
            rec8.setFill(Color.GREEN);
            limit--;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("you cant choose more than 4 genre");
            alert.show();
        }
    }

    @FXML
    void submitButton(MouseEvent event) {
        ListenerController.getListenerController().favoriteGenre(genres.get(0), genres.get(1), genres.get(2), genres.get(3));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("submit");
        alert.show();
        try {
            ChangeScene.homeScene();
        } catch (Exception e) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error");
            alert2.setContentText(e.getMessage());
        }
    }

}
