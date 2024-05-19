package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.Exception.InvalidFormatException;
import com.example.spotify4.Controller.Exception.WrongPasswordException;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.View.SceneStack;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignUpScene implements Initializable {

    @FXML
    private TextField biographyBox;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private Button backButton;

    @FXML
    private TextField emailBox;

    @FXML
    private TextField nameBox;

    @FXML
    private PasswordField passwordBox;

    @FXML
    private TextField phonenumberBox;

    @FXML
    private Button submitButton;

    @FXML
    private ChoiceBox<String> typeOfUser;


    @FXML
    private TextField usernameBox;

    public TextField getBiographyBox() {
        return biographyBox;
    }

    public DatePicker getDataPicker() {
        return dataPicker;
    }

    public TextField getEmailBox() {
        return emailBox;
    }

    public TextField getNameBox() {
        return nameBox;
    }

    public PasswordField getPasswordBox() {
        return passwordBox;
    }

    public TextField getPhonenumberBox() {
        return phonenumberBox;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public ChoiceBox<?> getTypeOfUser() {
        return typeOfUser;
    }

    public TextField getUsernameBox() {
        return usernameBox;
    }

    public void setBiographyBox(TextField biographyBox) {
        this.biographyBox = biographyBox;
    }

    public void setDataPicker(DatePicker dataPicker) {
        this.dataPicker = dataPicker;
    }

    public void setEmailBox(TextField emailBox) {
        this.emailBox = emailBox;
    }

    public void setNameBox(TextField nameBox) {
        this.nameBox = nameBox;
    }

    public void setPasswordBox(PasswordField passwordBox) {
        this.passwordBox = passwordBox;
    }

    public void setPhonenumberBox(TextField phonenumberBox) {
        this.phonenumberBox = phonenumberBox;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public void setTypeOfUser(ChoiceBox<String> typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public void setUsernameBox(TextField usernameBox) {
        this.usernameBox = usernameBox;
    }


    public void backTo() {
        backButton.setOnMouseClicked((e) -> {
            ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
        });
    }

    @FXML
    void backTo(MouseEvent event) {
        backTo();
    }

    @FXML
    void submitButton(MouseEvent event) throws IOException {
//        LocalDate date = dataPicker.getValue();
//        if (usernameBox.getText().isEmpty() || passwordBox.getText().isEmpty() || phonenumberBox.getText().isEmpty() || emailBox.getText().isEmpty() || biographyBox.getText().isEmpty() || nameBox.getText().isEmpty() || dataPicker.getValue() == null) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setContentText("Please fill all the fields");
//            alert.showAndWait();
//        }
//        if (Objects.equals(typeOfUser.getSelectionModel().getSelectedItem(), "Listener")) {
//            try {
//                ListenerController.getListenerController().signUp(usernameBox.getText(), passwordBox.getText(), nameBox.getText(), emailBox.getText(), phonenumberBox.getText(), date.getYear(), date.getMonthValue(), date.getDayOfMonth(), biographyBox.getText());
//            } catch (WrongPasswordException | InvalidFormatException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                ChangeScene.genreScene();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else if (Objects.equals(typeOfUser.getSelectionModel().getSelectedItem(), "Artist")) {
//            try {
//                ArtistController.getArtistController().signUp(usernameBox.getText(), passwordBox.getText(), nameBox.getText(), emailBox.getText(), phonenumberBox.getText(), date.getYear(), date.getMonthValue(), date.getDayOfMonth(), biographyBox.getText());
//            } catch (WrongPasswordException | InvalidFormatException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                ChangeScene.homeScene();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else if (Objects.equals(typeOfUser.getSelectionModel().getSelectedItem(), "Admin")) {
//
//            try {
//                ArtistController.getArtistController().signUp(usernameBox.getText(), passwordBox.getText(), nameBox.getText(), emailBox.getText(), phonenumberBox.getText(), date.getYear(), date.getMonthValue(), date.getDayOfMonth(), biographyBox.getText());
//            } catch (WrongPasswordException | InvalidFormatException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                ChangeScene.homeScene();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//        ChangeScene.homeScene();
    }

    public void submitButton(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        LocalDate date = dataPicker.getValue();
        if (usernameBox.getText().isEmpty() || passwordBox.getText().isEmpty() || phonenumberBox.getText().isEmpty() || emailBox.getText().isEmpty() || biographyBox.getText().isEmpty() || nameBox.getText().isEmpty() || dataPicker.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        } else {
            if (Objects.equals(typeOfUser.getSelectionModel().getSelectedItem(), "Listener")) {
                try {
                    ListenerController.getListenerController().signUp(usernameBox.getText(), passwordBox.getText(), nameBox.getText(), emailBox.getText(), phonenumberBox.getText(), date.getYear(), date.getMonthValue(), date.getDayOfMonth(), biographyBox.getText());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Success");
                    alert.setContentText("successfully signed up");
                    alert.show();
                } catch (WrongPasswordException | InvalidFormatException e) {
                  System.out.println("RunTime");
                }
                try {
                    ChangeScene.genreScene();
                } catch (IOException e) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }
            } else if (Objects.equals(typeOfUser.getSelectionModel().getSelectedItem(), "Artist")) {
                try {
                    ArtistController.getArtistController().signUp(usernameBox.getText(), passwordBox.getText(), nameBox.getText(), emailBox.getText(), phonenumberBox.getText(), date.getYear(), date.getMonthValue(), date.getDayOfMonth(), biographyBox.getText());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Success");
                    alert.setContentText("successfully signed up");
                    alert.show();
                } catch (WrongPasswordException | InvalidFormatException e) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }
                try {
                    ChangeScene.homeScene();
                } catch (IOException e) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }
            } else if (Objects.equals(typeOfUser.getSelectionModel().getSelectedItem(), "Admin")) {

                try {
                    ArtistController.getArtistController().signUp(usernameBox.getText(), passwordBox.getText(), nameBox.getText(), emailBox.getText(), phonenumberBox.getText(), date.getYear(), date.getMonthValue(), date.getDayOfMonth(), biographyBox.getText());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Success");
                    alert.setContentText("successfully signed up");
                    alert.show();
                } catch (WrongPasswordException | InvalidFormatException e) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }
                try {
                    ChangeScene.homeScene();
                } catch (IOException e) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }

            }
            ChangeScene.homeScene();
        }
    }

    public void backButton(javafx.scene.input.MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeOfUser.getItems().add("Listener");
        typeOfUser.getItems().add("Admin");
        typeOfUser.getItems().add("Artist");
    }
}
