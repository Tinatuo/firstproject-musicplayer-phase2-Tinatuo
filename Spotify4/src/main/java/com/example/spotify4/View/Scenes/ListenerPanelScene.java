package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.Exception.FreeAccountLimitException;
import com.example.spotify4.Controller.ListenerController.FreeListenerController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Controller.ListenerController.PremiumController;
import com.example.spotify4.Model.GeneralOperation;
import com.example.spotify4.Model.PlayList;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.Listener.FreeListener;
import com.example.spotify4.Model.User.Listener.Premium;
import com.example.spotify4.Model.User.User;
import com.example.spotify4.View.SceneStack;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanelScene implements GeneralOperation, Initializable {
    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private VBox VBoxFollowing;

    @FXML
    private Button artistButton;

    @FXML
    private Button artistButton1;

    @FXML
    private Button buyButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView libraryButton;

    @FXML
    private VBox listsVbox;

    @FXML
    private Button login;

    @FXML
    private Button logout;

    @FXML
    private Label musicName;

    @FXML
    private ImageView nextButton;

    @FXML
    private ImageView playButton;

    @FXML
    private Button playListButton;

    @FXML
    private ImageView previousButton;

    @FXML
    private ImageView searchButton1;

    @FXML
    private ImageView songPhoto;

    @FXML
    private Circle userPhoto;
    @FXML
    private Label nameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private ChoiceBox<String> playListChoice;

    @FXML
    private TextField playListNameBox;


    @FXML
    private Button addPlayList;


    @FXML
    private Button backButton;

    @FXML
    void login(MouseEvent event) {
        login();
    }

    @FXML
    void logout(MouseEvent event) {
        logout();
    }

    @FXML
    void signup(MouseEvent event) throws IOException {
        signup();
    }
    @FXML
    void homeButton(MouseEvent event) throws IOException {
        ChangeScene.homeScene();
    }
    @FXML
    void search(MouseEvent event) throws IOException {
        search();
    }
    @FXML
    void backTo(MouseEvent event) {
        backTo();
    }
    @FXML
    void library(MouseEvent event) {
        library();
    }
    public void library() {
        libraryButton.setOnMouseClicked((e) -> {
            try {
                ChangeScene.ListenerPanelScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    @FXML
    void addPlayList(MouseEvent event) {
        if(ListenerController.getListenerController().listener instanceof FreeListener){
            playListNameBox.textProperty().addListener((p, o, n) -> {
                try {
                    FreeListenerController.getFreeListenerController().makePlayList(playListNameBox.getText());
                    playListChoice.getItems().add(playListNameBox.getText());
                } catch (FreeAccountLimitException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("You don't have enough free playlists to add playlist");
                }
            });
        } else if (ListenerController.getListenerController().listener instanceof Premium) {
            playListNameBox.textProperty().addListener((p, o, n) -> {
                PremiumController.getPremiumController().makePlayList(playListNameBox.getText());
                playListChoice.getItems().add(playListNameBox.getText());
            });
        }
    }

    @FXML
    void artistButton1(MouseEvent event) throws IOException {
        ChangeScene.artistsScene();
    }

    @FXML
    void buyButton(MouseEvent event) throws IOException {
        ChangeScene.buyScene();
    }

    @FXML
    void playListButton(MouseEvent event) throws IOException {
        ChangeScene.plaListsScene();
    }

    @Override
    public void backTo() {
        backButton.setOnMouseClicked((e)->{
            ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
        });
    }

    @Override
    public void logout() {
        logout.setOnMouseClicked((e) -> {
            if (!(ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
                ListenerController.listenerController.setListener(null);
                ArtistController.getArtistController().setArtist1(null);
                AdminController.adminController.setAdmin(null);
                try {
                    ChangeScene.homeScene();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    @Override
    public void login() {
        login.setOnMouseClicked((e) -> {
            if ((ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
                try {
                    ChangeScene.entryScene();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    @Override
    public void signup() throws IOException {
        ChangeScene.signUpScene();
    }

    @Override
    public void search() throws IOException {
        ChangeScene.searchScene();
    }

    public HBox setHBOx(Artist artist) {
        ImageView imageView = artist.getUserPhoto();
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        Circle circle = new Circle(20, 20, 20);
        imageView.setClip(circle);
        Label artistName = new Label();
        artistName.setText(artist.getUserName());
        HBox hBox = new HBox(imageView, artistName);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(15);
        return hBox;
    }
    @FXML
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView imageView = new ImageView(ListenerController.getListenerController().listener.getImage());
        imageView.setClip(userPhoto);
        usernameLabel.setText(ListenerController.getListenerController().listener.getUserName());
        nameLabel.setText(ListenerController.getListenerController().listener.getFirstAndLastname());
        for (PlayList play : ListenerController.getListenerController().listener.playLists) {
            playListChoice.getItems().add(play.getName());
            playListChoice.setOnAction((e) -> {
                for (PlayList play2 : ListenerController.getListenerController().listener.playLists) {
                    if (play2.getName().equals(playListChoice.getSelectionModel().getSelectedItem())) {
                        AudiosOfPlaylist.setPlayList(play2);
                    }
                }
                try {
                    ChangeScene.audioOfPlayListScene();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        for (User artist : ListenerController.getListenerController().arrayFollowing()) {
            VBoxFollowing.getChildren().add(setHBOx((Artist) artist));
            VBoxFollowing.setOnMouseClicked((e) -> {
                ArtistInfoScene.setArtist1((Artist) artist);
                try {
                    ChangeScene.artistInfoScene();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }
}
