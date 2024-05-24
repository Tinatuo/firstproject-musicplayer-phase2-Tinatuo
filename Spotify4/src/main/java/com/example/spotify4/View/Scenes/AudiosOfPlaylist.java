package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Application;
import com.example.spotify4.Model.Audio.Audio;
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
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AudiosOfPlaylist implements Initializable, GeneralOperation {

    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private Button audiosButton1;

    @FXML
    private Button backButton;
    @FXML
    private ImageView playButton;


    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView libraryButton;

    @FXML
    private VBox listsVbox;


    @FXML
    private ImageView nextButton;


    @FXML
    private Button playListButton;

    @FXML
    private Label playlistName;

    @FXML
    private ImageView previousButton;

    @FXML
    private ImageView searchButton1;

    @FXML
    private Button login;

    @FXML
    private Button logout;

    @FXML
    private Button signUpButton;

    @FXML
    private ImageView songPhoto;

    @FXML
    private VBox vBox;

    static Audio audio6;
    static boolean audio6IsPlaying = false;

    @FXML
    private Label musicName;
    private static PlayList playList;
    private static AudiosOfPlaylist audiosOfPlaylist;

    public static AudiosOfPlaylist getAudiosOfPlaylist() {
        if(audiosOfPlaylist==null){
            audiosOfPlaylist=new AudiosOfPlaylist();
            return audiosOfPlaylist;
        }else {
            return audiosOfPlaylist;
        }
    }

    public static PlayList getPlayList() {
        return playList;
    }

    public static void setPlayList(PlayList playList) {
        AudiosOfPlaylist.playList = playList;
    }

    @FXML
    void audiosButton1(MouseEvent event) throws IOException {
        ChangeScene.audiosScene();
    }

    @FXML
    void playListButton(MouseEvent event) throws IOException {
        ChangeScene.plaListsScene();
    }

    @FXML
    void backTo(MouseEvent event) {
        backTo();
    }

    @Override
    public void backTo() {
        backButton.setOnMouseClicked((e) -> {
            ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
//            ChangeScene.stage.show();
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
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                } finally {
                    System.out.println("Have a good day");
                }
            }
        });
    }

    @Override
    public void login() {
        login.setOnMouseClicked((e) -> {
            try {
                ChangeScene.entryScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
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
    void homeButton(MouseEvent event) throws IOException {
        ChangeScene.homeScene();
    }

    @FXML
    void signup(MouseEvent event) {
        signup();
    }

    @Override
    public void signup() {
        signUpButton.setOnMouseClicked((e) -> {
            try {
                ChangeScene.signUpScene();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("RunTime exception");
                alert.show();
            } finally {
                System.out.println("Have a good day");
            }
        });
    }

    @FXML
    void search(MouseEvent event) {
        search();
    }

    @FXML
    void library(MouseEvent event) {
        library();
    }

    @Override
    public void search() {
        searchButton1.setOnMouseClicked((e) -> {
            try {
                ChangeScene.searchScene();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("RunTime exception");
                alert.show();
            } finally {
                System.out.println("Have a good day");
            }
        });
    }

    public void library() {
        libraryButton.setOnMouseClicked((e) -> {
            try {
                ChangeScene.ListenerPanelScene();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("RunTime exception");
                alert.show();
            } finally {
                System.out.println("Have a good day");
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBox = setVBOX(playList);
    }

    public HBox setHBOx(Audio audio) {
        String path1 = Application.class.getResource("61180.png").toExternalForm();
        Image image1 = new Image(path1);
        ImageView imageView = audio.getAudioPhoto();
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        Circle circle = new Circle(20, 20, 20);
        imageView.setClip(circle);
        Label audioName = new Label();
        audioName.setText(audio.getName());
        audioName.setStyle(".label");
        HBox hBox = new HBox(imageView, audioName);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(15);
        hBox.setOnMouseClicked((e) -> {
            audio.getMediaPlayer().play();
            PlayScene.audio4 = audio;
            songPhoto = audio.getAudioPhoto();
            musicName.setText(audio.getName());
            playButton.setImage(image1);
            audio6 = audio;
            audio6IsPlaying = true;
            AudiosScene.audio2IsPlaying = false;
            HomeScene.audio1IsPlaying = false;
            ArtistInfoScene.audio3IsPlaying = false;
            try {
                ChangeScene.playScene();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("RunTime exception");
                alert.show();
            } finally {
                System.out.println("Have a good day");
            }
        });
        return hBox;
    }

    public VBox setVBOX(PlayList playList) {
        for (Audio audio : playList) {
            vBox.getChildren().add(setHBOx(audio));
        }
        return vBox;
    }


    public void backButton(MouseEvent mouseEvent) {
    }


    @FXML
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
    }

    public void playButton(MouseEvent mouseEvent) {
        String path1 = Application.class.getResource("61180.png").toExternalForm();
        String path2 = Application.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
        Image image1 = new Image(path1);
        Image image2 = new Image(path2);
        if (audio6IsPlaying) {
            if (Objects.equals(audiosOfPlaylist.playButton.getImage(), image2)) {
                audiosOfPlaylist.playButton.setImage(image1);
                audio6.getMediaPlayer().play();
                PlayScene.audio4 = audio6;
                audiosOfPlaylist.songPhoto.setImage(audio6.getImage());
                audiosOfPlaylist.musicName.setText(audio6.getName());
            } else if (Objects.equals(audiosOfPlaylist.playButton.getImage(), image1)) {
                audiosOfPlaylist.playButton.setImage(image2);
                audio6.getMediaPlayer().pause();
                audiosOfPlaylist.songPhoto.setImage(audio6.getImage());
                audiosOfPlaylist.musicName.setText(audio6.getName());
            }
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.playButton(mouseEvent);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().playButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().playButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().playButton(mouseEvent);
        }

    }

    public void previousButton(MouseEvent mouseEvent) {
        int index;
        if (audio6IsPlaying) {
            index = playList.getAudoisList().indexOf(audio6);
            audio6 = playList.getAudoisList().get(--index);
            audio6.getMediaPlayer().play();
            PlayScene.audio4 = audio6;
            audiosOfPlaylist.songPhoto.setImage(audio6.getImage());
            audiosOfPlaylist.musicName.setText(audio6.getName());
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.previousButton(mouseEvent);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().previousButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().previousButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().previousButton(mouseEvent);
        }
    }

    public  void nextButton(MouseEvent mouseEvent) {
        int index;
        if (audio6IsPlaying) {
            index = playList.getAudoisList().indexOf(audio6);
            audio6 = playList.getAudoisList().get(++index);
            audio6.getMediaPlayer().play();
            PlayScene.audio4 = audio6;
            audiosOfPlaylist.songPhoto.setImage(audio6.getImage());
            audiosOfPlaylist.musicName.setText(audio6.getName());
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.nextButton(mouseEvent);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().nextButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().nextButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().nextButton(mouseEvent);
        }
    }
}
