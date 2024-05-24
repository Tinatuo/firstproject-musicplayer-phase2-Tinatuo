package com.example.spotify4.View.Scenes;

import com.example.spotify4.Application;
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
import com.example.spotify4.Model.User.Listener.Listener;
import com.example.spotify4.Model.User.Listener.Premium;
import com.example.spotify4.Model.User.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
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
    //todo artist tarif kon
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
    private Listener listener;
    public ImageView getNextButton() {
        if(nextButton==null){
            nextButton=new ImageView("Screenshot 2024-05-12 224220.png");
        }
        return nextButton;
    }

    public ImageView getPlayButton() {
        String path2 = Application.class.getResource("Screenshot 2024-05-12 223937.png").toExternalForm();
        Image image1 = new Image(path2);
        if(playButton==null){
            playButton=new ImageView(image1);
        }
        return playButton;
    }

    public ImageView getPreviousButton() {
        if(previousButton==null){
            previousButton=new ImageView("Screenshot 2024-05-12 224034.png");
        }
        return previousButton;
    }
    public Listener getListener() {
        if(listener == null) {
            this.listener=ListenerController.getListenerController().getListener();
        }
        return listener;
    }

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
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText(ex.getMessage());
                alert.show();
            }finally {
                System.out.println("Have a good day");
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
                }finally {
                    System.out.println("Have a good day");
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
            if (!(ListenerController.getListenerController().getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
                ListenerController.getListenerController().setListener(null);
                ArtistController.getArtistController().setArtist1(null);
                AdminController.adminController.setAdmin(null);
                try {
                    ChangeScene.homeScene();
                } catch (IOException ex) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }finally {
                    System.out.println("Have a good day");
                }
            }
        });
    }

    @Override
    public void login() {
        login.setOnMouseClicked((e) -> {
            if ((ListenerController.getListenerController().getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
                try {
                    ChangeScene.entryScene();
                } catch (IOException ex) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }finally {
                    System.out.println("Have a good day");
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
        hBox.setOnMouseClicked((e) -> {
            ArtistInfoScene.setArtist1(artist);
            try {
                ChangeScene.artistInfoScene();
            } catch (IOException ex) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("RunTime exception");
                alert.show();
            }finally {
                System.out.println("Have a good day");
            }
        });
        return hBox;
    }
    @FXML
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getListener();
        ImageView imageView = new ImageView(this.listener.getImage());
        imageView.setClip(userPhoto);
        usernameLabel.setText(this.listener.getUserName());
        nameLabel.setText(this.listener.getFirstAndLastname());
        for (PlayList play : this.listener.playLists) {
            playListChoice.getItems().add(play.getName());
            playListChoice.setOnAction((e) -> {
                for (PlayList play2 : this.listener.playLists) {
                    if (play2.getName().equals(playListChoice.getSelectionModel().getSelectedItem())) {
                        AudiosOfPlaylist.setPlayList(play2);
                    }
                }
                try {
                    ChangeScene.audioOfPlayListScene();
                } catch (IOException ex) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText(ex.getMessage());
                    alert.show();
                }finally {
                    System.out.println("Have a good day");
                }
            });
        }
        for (User artist : ListenerController.getListenerController().arrayFollowing()) {
            VBoxFollowing.getChildren().add(setHBOx((Artist) artist));
            VBoxFollowing.setSpacing(20);
        }
    }
}
