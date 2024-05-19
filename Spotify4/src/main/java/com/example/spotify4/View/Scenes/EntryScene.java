package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.Exception.UserNotFoundException;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.View.SceneStack;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
        if (Objects.equals(ListenerController.getListenerController().logIn(nameBox.getText(), passwordBox.getText()), "Successful login enter")) {
            ListenerController.getListenerController().logIn(nameBox.getText(), passwordBox.getText());
            ChangeScene.homeScene();
        } else if (Objects.equals(ArtistController.getArtistController().logIn(nameBox.getText(), passwordBox.getText()), "Successful login enter")) {
            ArtistController.getArtistController().logIn(nameBox.getText(), passwordBox.getText());
            ChangeScene.homeScene();
        } else if (Objects.equals(AdminController.getAdminController().logIn(nameBox.getText(), passwordBox.getText()), "Successful login enter")) {
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
