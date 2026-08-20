package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Application;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.GeneralOperation;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeScene implements Initializable, GeneralOperation {
    public static Audio audio1;
    public static boolean audio1IsPlaying = false;
    private static HomeScene homeScene;
    private ArrayList<Audio> homaPlayList;

    public ArrayList<Audio> getHomaPlayList() {
        if (ListenerController.getListenerController().listener == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
            homaPlayList = AdminController.getAdminController().mostPopularAudioFileArray();
        } else {
            homaPlayList = ListenerController.getListenerController().getSuggestions();
        }
        return homaPlayList;
    }

    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private VBox vBox;

    @FXML
    private Button artistButton;

    @FXML
    private Button audioButton1;

    @FXML
    private Button backButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private Label label;

    @FXML
    private ImageView libraryButton;

    @FXML
    private VBox listsVbox;


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
    private Button signUpButton;


    @FXML
    private Label musicName;

    @FXML
    private Button login;

    @FXML
    private Button logout;
    @FXML
    private ImageView songPhoto;
    ;

    public static HomeScene getHomeScene() {
        if (homeScene == null) {
            homeScene = new HomeScene();
        }
        return homeScene;
    }

    public VBox getVBox() {
        if (vBox == null) {
            vBox = new VBox();
        }
        return vBox;
    }

    public void setVBox(VBox vBox) {
        this.vBox = vBox;
    }

    public void setAnchorpane(AnchorPane anchorpane) {
        Anchorpane = anchorpane;
    }

    public void setArtistButton(Button artistButton) {
        this.artistButton = artistButton;
    }

    public void setAudioButton1(Button audioButton1) {
        this.audioButton1 = audioButton1;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public void setHomeButton(ImageView homeButton) {
        this.homeButton = homeButton;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setLibraryButton(ImageView libraryButton) {
        this.libraryButton = libraryButton;
    }

    public void setListsVbox(VBox listsVbox) {
        this.listsVbox = listsVbox;
    }

    public void setNextButton(ImageView nextButton) {
        this.nextButton = nextButton;
    }

    public void setPlayButton(ImageView playButton) {
        this.playButton = playButton;
    }

    public void setPlayListButton(Button playListButton) {
        this.playListButton = playListButton;
    }

    public void setPreviousButton(ImageView previousButton) {
        this.previousButton = previousButton;
    }

    public void setSearchButton1(ImageView searchButton1) {
        this.searchButton1 = searchButton1;
    }

    public void setSignUpButton(Button signUpButton) {
        this.signUpButton = signUpButton;
    }

    public void setSongPhoto(ImageView songPhoto) {
        this.songPhoto = songPhoto;
    }

    public AnchorPane getAnchorpane() {
        return Anchorpane;
    }

    public Button getArtistButton() {
        return artistButton;
    }

    public Button getAudioButton1() {
        return audioButton1;
    }

    public Button getBackButton() {
        return backButton;
    }

    public ImageView getHomeButton() {
        return homeButton;
    }

    public Label getLabel() {
        return label;
    }

    public ImageView getLibraryButton() {
        return libraryButton;
    }

    public VBox getListsVbox() {
        return listsVbox;
    }


    public ImageView getNextButton() {
        if (nextButton == null) {
            nextButton = new ImageView("Screenshot 2024-05-12 224220.png");
        }
        return nextButton;
    }

    public ImageView getPlayButton() {
        String path2 = Application.class.getResource("Screenshot 2024-05-12 223937.png").toExternalForm();
        Image image1 = new Image(path2);
        if (playButton == null) {
            playButton = new ImageView(image1);
        }
        return playButton;
    }

    public ImageView getPreviousButton() {
        if (previousButton == null) {
            previousButton = new ImageView("Screenshot 2024-05-12 224034.png");
        }
        return previousButton;
    }


    public Button getPlayListButton() {
        return playListButton;
    }


    public ImageView getSearchButton1() {
        return searchButton1;
    }

    public Button getSignUpButton() {
        return signUpButton;
    }

    public ImageView getSongPhoto() {
        return songPhoto;
    }

    @FXML
    void audioButton1(MouseEvent event) throws IOException {
        System.out.println("audio");
        ChangeScene.audiosScene();
    }

    @FXML
    void playListButton(MouseEvent event) throws IOException {
        ChangeScene.plaListsScene();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (ListenerController.getListenerController().getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
            ArrayList<Audio> audios = new ArrayList<>(AdminController.getAdminController().mostPopularAudioFileArray());
            for (Audio audio : audios) {
                listsVbox.getChildren().add(fillHBox(audio));
                listsVbox.setSpacing(20);
                listsVbox.setAlignment(Pos.TOP_LEFT);
            }
        } else {
            ArrayList<Audio> suggestions = new ArrayList<>(ListenerController.getListenerController().getSuggestions());
            for (Audio audio : suggestions) {
                listsVbox.getChildren().add(fillHBox(audio));
            }
        }

    }

    @Override
    public void backTo() {
        backButton.setOnMouseClicked((e) -> {
            ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
//            ChangeScene.stage.show();
        });
    }

    @FXML
    void backTo(MouseEvent event) {
        backTo();
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
            if ((ListenerController.getListenerController().getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
                try {
                    ChangeScene.entryScene();
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
                throw new RuntimeException(ex);
            } finally {
                System.out.println("Have a good day");
            }
        });
    }

    @FXML
    public void artistButton(MouseEvent event) throws IOException {
        ChangeScene.artistsScene();
    }

    @FXML
    void musicName(MouseEvent event) throws IOException {
        PlayScene.audio4 = audio1;
        ChangeScene.playScene();
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

    @FXML
    void search(MouseEvent event) {
        search();
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
    void library(MouseEvent event) {
        library();
    }

    @FXML
    void login(MouseEvent event) {
        login();
    }

    @FXML
    void logout(MouseEvent event) {
        logout();
    }

    public HBox fillHBox(Audio audio) {
        String path2 = Application.class.getResource("Screenshot 2024-05-12 223937.png").toExternalForm();
        String path1 = Application.class.getResource("61180.png").toExternalForm();
        Image image1 = new Image(path1);
        ImageView imageView1 = new ImageView(image1);
        Image image2 = new Image(path2);
        ImageView imageView2 = new ImageView(image2);
        HBox hBox = new HBox();
        ImageView imageView = audio.getAudioPhoto();
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        Circle circle = new Circle(30, 30, 30);
        imageView.setClip(circle);
        Label label = new Label(audio.getName());
        label.setStyle(".label");
        label.setFont(new Font(20));
        label.setTextFill(Color.WHITE);
        hBox.getChildren().addAll(imageView, label);
        hBox.setSpacing(40);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setOnMouseClicked((e) -> {
            getPlayButton();
            if (audio1 != null) {
                audio1.getMediaPlayer().pause();
            } else if (SearchScene.audio5 != null) {
                SearchScene.audio5.getMediaPlayer().pause();
            } else if (ArtistInfoScene.audio3 != null) {
                ArtistInfoScene.audio3.getMediaPlayer().pause();
            } else if (AudiosOfPlaylist.audio6 != null) {
                AudiosOfPlaylist.audio6.getMediaPlayer().pause();
            } else if (AudiosScene.audio2 != null) {
                AudiosScene.audio2.getMediaPlayer().pause();
            }
            audio1 = audio;
            audio.getMediaPlayer().play();
            PlayScene.audio4 = audio;
            songPhoto.setImage(audio.getImage());
            songPhoto.setClip(new Circle(22, 22, 22));
            musicName.setText(audio.getName());
            playButton.setImage(image1);
            audio1 = audio;
            audio1IsPlaying = true;
            AudiosScene.audio2IsPlaying = false;
            ArtistInfoScene.audio3IsPlaying = false;
            AudiosOfPlaylist.audio6IsPlaying = false;
            try {
                ChangeScene.playScene();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText(ex.getMessage());
                alert.show();
            } finally {
                System.out.println("Have a good day");
            }
        });
        return hBox;
    }


    public void nextButton(MouseEvent mouseEvent) {
        int index;
        audio1.getMediaPlayer().pause();
        if (audio1IsPlaying) {
            if (ListenerController.getListenerController().getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
                index = AdminController.getAdminController().mostPopularAudioFileArray().indexOf(audio1);
                audio1 = AdminController.getAdminController().mostPopularAudioFileArray().get((++index) % getHomeScene().getHomaPlayList().size());
                System.out.println(audio1.getName());
                audio1.getMediaPlayer().play();
                PlayScene.audio4 = audio1;
                if (getHomeScene().songPhoto == null) {
                    songPhoto = new ImageView(audio1.getImage());
                } else {
                    songPhoto.setImage(audio1.getImage());
                }
                if (getHomeScene().musicName == null) {
                    musicName = new Label(audio1.getName());
                } else {
                    musicName.setText(audio1.getName());
                }
            } else {
                index = ListenerController.getListenerController().getSuggestions().indexOf(audio1);
                audio1 = ListenerController.getListenerController().getSuggestions().get((++index) % getHomeScene().getHomaPlayList().size());
                audio1.getMediaPlayer().play();
                PlayScene.audio4 = audio1;
                if (getHomeScene().songPhoto == null) {
                    songPhoto = new ImageView(audio1.getImage());
                } else {
                    songPhoto.setImage(audio1.getImage());
                }
                if (getHomeScene().musicName == null) {
                    musicName = new Label(audio1.getName());
                } else {
                    musicName.setText(audio1.getName());
                }
            }
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().nextButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().nextButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().nextButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().nextButton(mouseEvent);
        }
    }

    public void previousButton(MouseEvent mouseEvent) {
        int index;
        audio1.getMediaPlayer().pause();
        if (audio1IsPlaying) {
            if (ListenerController.getListenerController().getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
                index = AdminController.getAdminController().mostPopularAudioFileArray().indexOf(audio1);
                audio1 = AdminController.getAdminController().mostPopularAudioFileArray().get((--index) % getHomeScene().getHomaPlayList().size());
                audio1.getMediaPlayer().play();
                PlayScene.audio4 = audio1;
                if (getHomeScene().songPhoto == null) {

                    songPhoto = new ImageView(audio1.getImage());

                } else {

                    songPhoto.setImage(audio1.getImage());

                }
                if (getHomeScene().musicName == null) {
                    musicName = new Label(audio1.getName());
                } else {
                    musicName.setText(audio1.getName());
                }
            } else {
                index = ListenerController.getListenerController().getSuggestions().indexOf(audio1);
                audio1 = ListenerController.getListenerController().getSuggestions().get((--index) % getHomeScene().getHomaPlayList().size());
                audio1.getMediaPlayer().play();
                PlayScene.audio4 = audio1;
                if (getHomeScene().songPhoto == null) {
                    songPhoto = new ImageView(audio1.getImage());
                } else {
                    songPhoto.setImage(audio1.getImage());
                }
                if (getHomeScene().musicName == null) {
                    musicName = new Label(audio1.getName());
                } else {
                    musicName.setText(audio1.getName());
                }
            }
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().previousButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().previousButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().previousButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().previousButton(mouseEvent);
        }

    }

    public void playButton(MouseEvent mouseEvent) {
        String path1 = Application.class.getResource("61180.png").toExternalForm();
        String path2 = Application.class.getResource("Screenshot 2024-05-12 223937.png").toExternalForm();
        Image image1 = new Image(path1);
        Image image2 = new Image(path2);
        //System.out.println(audio1IsPlaying);
        if (audio1IsPlaying) {
            if (!audio1.getMediaPlayer().isMute()) {
                getHomeScene().getPlayButton().setImage(image2);
                audio1.getMediaPlayer().pause();
                if (getHomeScene().songPhoto == null) {
                    getHomeScene().songPhoto = new ImageView(audio1.getImage());
                } else {
                    homeScene.songPhoto.setImage(audio1.getImage());
                }
                if (getHomeScene().musicName == null) {
                    getHomeScene().musicName = new Label(audio1.getName());
                } else {
                    homeScene.musicName.setText(audio1.getName());
                }
            } else if (audio1.getMediaPlayer().isMute()) {
                getHomeScene().getPlayButton().setImage(image1);
                audio1.getMediaPlayer().play();
                PlayScene.audio4 = audio1;
                if (getHomeScene().songPhoto == null) {
                    getHomeScene().songPhoto = new ImageView(audio1.getImage());
                } else {
                    getHomeScene().songPhoto.setImage(audio1.getImage());
                }
                if (getHomeScene().musicName == null) {
                    getHomeScene().musicName = new Label(audio1.getName());
                } else {
                    getHomeScene().musicName.setText(audio1.getName());
                }

            }
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().playButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().playButton(mouseEvent);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().playButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().playButton(mouseEvent);
        }


    }

    public void audioButton(MouseEvent mouseEvent) throws IOException {
        ChangeScene.audiosScene();
    }
}
