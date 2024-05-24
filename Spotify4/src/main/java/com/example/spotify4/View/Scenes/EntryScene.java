package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.Exception.UserNotFoundException;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;

public class EntryScene {

    @FXML
    private TextField nameBox;

    @FXML
    private TextField passwordBox;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    @FXML
    void backButton(MouseEvent event) {
        ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
        ChangeScene.stage.show();
    }

    @FXML
    void submitButton(MouseEvent event) throws UserNotFoundException, IOException {
        if (nameBox.getText().isEmpty() || passwordBox.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }
        if (ListenerController.getListenerController().logIn(nameBox.getText(),passwordBox.getText())) {
            ListenerController.getListenerController().logIn(nameBox.getText(), passwordBox.getText());
            ChangeScene.homeScene();
        } else if (ArtistController.artistController.logIn(nameBox.getText(),passwordBox.getText())) {
            ArtistController.getArtistController().logIn(nameBox.getText(), passwordBox.getText());
            ChangeScene.homeScene();
        } else if (AdminController.getAdminController().logIn(nameBox.getText(),passwordBox.getText())) {
            AdminController.adminController.logIn(nameBox.getText(), passwordBox.getText());
            ChangeScene.homeScene();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("User not found");
        }
    }
//todo
}
