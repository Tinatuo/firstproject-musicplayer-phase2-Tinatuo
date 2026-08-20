package com.example.spotify4.View.Scenes;

import com.example.spotify4.Application;
import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Model.GeneralOperation;
import com.example.spotify4.Model.PlayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayListsScene implements Initializable , GeneralOperation {

    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private Button login;

    @FXML
    private Button logout;

    @FXML
    private Button audiosButton1;

    @FXML
    private Button backButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView libraryButton;

    @FXML
    private VBox listsVbox;


    @FXML
    private Label musicName;

    @FXML
    private ImageView nextButton;

    @FXML
    private ImageView playButton;

    @FXML
    private Button playListButton;

    @FXML
    private Label playLists;

    @FXML
    private ImageView previousButton;

    @FXML
    private ImageView searchButton1;

    @FXML
    private Button signUpButton;

    @FXML
    private ImageView songPhoto;

    @FXML
    private ImageView songPhoto1;

    @FXML
    private VBox vBox;

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

    @FXML
    void audiosButton1(MouseEvent event) throws IOException {
        ChangeScene.audiosScene();
    }


    @FXML
    void nextButton(MouseEvent event) {
        if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().nextButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().nextButton(event);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().nextButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().nextButton(event);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().nextButton(event);
        }
    }

    @FXML
    void playButton(MouseEvent event) {
        if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().playButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().playButton(event);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().playButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().playButton(event);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().playButton(event);
        }
    }

    @FXML
    void playListButton(MouseEvent event) throws IOException {
        ChangeScene.plaListsScene();
    }

    @FXML
    void previousButton(MouseEvent event) {
        if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().previousButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().previousButton(event);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().previousButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().previousButton(event);
        }else if(SearchScene.audio5IsPlaying){
            SearchScene.getSearchScene().previousButton(event);
        }
    }
    @FXML
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
    }
    @Override
    public void backTo() {
        backButton.setOnMouseClicked((e)->{
            ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
        });
    }

    @Override
    public void logout() {
        logout.setOnMouseClicked((e)->{
            if(!(ListenerController.getListenerController().getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1()==null)) {
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
            if((ListenerController.getListenerController().getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1()==null)) {
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
    public void library() {
        libraryButton.setOnMouseClicked((e) -> {
            try {
                ChangeScene.ListenerPanelScene();
            } catch (IOException ex) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("RunTime exception");
                alert.show();
            }finally {
                System.out.println("Have a good day");
            }
        });
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var listener = ListenerController.getListenerController().getListener();
        if (listener == null) {
            Label emptyState = new Label("Log in as a listener to view playlists.");
            emptyState.getStyleClass().add("Label");
            vBox.getChildren().add(emptyState);
            return;
        }

        for(PlayList playList: listener.getPlayLists()) {
            vBox.getChildren().add(setHBOx(playList));
            vBox.setOnMouseClicked((e)->{
                AudiosOfPlaylist.setPlayList(playList);
                try {
                    ChangeScene.audioOfPlayListScene();
                } catch (IOException ex) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }finally {
                    System.out.println("Have a good day");
                }
            });
        }
    }
    public HBox setHBOx(PlayList playList) {
        Label playListName = new Label();
        playListName.setText(playList.getName());
        HBox hBox = new HBox(playListName);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(15);
        return hBox;
    }

    public void log(MouseEvent mouseEvent) {
    }

    public void backButton(MouseEvent mouseEvent) {

    }
}
