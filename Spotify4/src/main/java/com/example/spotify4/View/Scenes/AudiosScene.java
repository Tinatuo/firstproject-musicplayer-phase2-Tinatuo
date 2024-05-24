package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Application;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.DataBase;
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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AudiosScene implements Initializable, GeneralOperation {
    public static Audio audio2;
    public static boolean audio2IsPlaying = false;


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
    private VBox vBox;

    @FXML
    private Button signUpButton;

    @FXML
    private Label musicName;

    private static AudiosScene audiosScene;

    public static AudiosScene getAudiosScene() {
        if (audiosScene == null) {
            audiosScene = new AudiosScene();
            return audiosScene;
        } else {
            return audiosScene;
        }
    }

    public AnchorPane getAnchorpane() {
        return Anchorpane;
    }

    public Button getAudiosButton1() {
        return audiosButton1;
    }

    public Button getBackButton() {
        return backButton;
    }

    public ImageView getHomeButton() {
        return homeButton;
    }

    public ImageView getLibraryButton() {
        return libraryButton;
    }

    public VBox getListsVbox() {
        return listsVbox;
    }

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

    public Button getPlayListButton() {
        return playListButton;
    }

    public ImageView getSearchButton1() {
        return searchButton1;
    }

    public ImageView getSongPhoto() {
        return songPhoto;
    }

    public VBox getvBox() {
        return vBox;
    }

    public Button getSignUpButton() {
        return signUpButton;
    }

    public void setAnchorpane(AnchorPane anchorpane) {
        Anchorpane = anchorpane;
    }

    public void setAudiosButton1(Button audiosButton1) {
        this.audiosButton1 = audiosButton1;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public void setHomeButton(ImageView homeButton) {
        this.homeButton = homeButton;
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

    public void setSongPhoto(ImageView songPhoto) {
        this.songPhoto = songPhoto;
    }

    public void setVBox(VBox vBox) {
        this.vBox = vBox;
    }

    public void setSignUpButton(Button signUpButton) {
        this.signUpButton = signUpButton;
    }

    @FXML
    void audiosButton1(MouseEvent event) throws IOException {
        ChangeScene.audiosScene();
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
    void signup(MouseEvent event) {
        signup();
    }


    @FXML
    void playListButton(MouseEvent event) throws IOException {
        ChangeScene.plaListsScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Audio audio : DataBase.getDataBase().audios) {
            vBox.getChildren().add(setHBOx(audio));
        }
    }

    @Override
    public void backTo() {
        backButton.setOnMouseClicked((e) -> {
            ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
            ChangeScene.stage.show();
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
            }
        });
    }

    @FXML
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
    }

    public HBox setHBOx(Audio audio) {
        ImageView imageView = audio.getAudioPhoto();
        String path1 = Application.class.getResource("61180.png").toExternalForm();
        Image image1 = new Image(path1);
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        Circle circle = new Circle(30, 30, 30);
        imageView.setClip(circle);
        Label audioName = new Label();
        audioName.setFont(new Font(20));
        audioName.setTextFill(Color.WHITE);
        audioName.setText(audio.getName());
        audioName.setStyle(".label");
        HBox hBox = new HBox(imageView, audioName);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(15);
        hBox.setOnMouseClicked((e) -> {
            if(audio2!=null) {
                audio2.getMediaPlayer().pause();
            }else if(SearchScene.audio5!=null){
                SearchScene.audio5.getMediaPlayer().pause();
            } else if (ArtistInfoScene.audio3!=null) {
                ArtistInfoScene.audio3.getMediaPlayer().pause();
            } else if (AudiosOfPlaylist.audio6!=null) {
                AudiosOfPlaylist.audio6.getMediaPlayer().pause();
            } else if (HomeScene.audio1!=null) {
                HomeScene.audio1.getMediaPlayer().pause();
            }
            audio.getMediaPlayer().play();
            PlayScene.audio4 = audio;
            audio2 = audio;
            songPhoto = audio.getAudioPhoto();
            musicName.setText(audio2.getName());
            playButton.setImage(image1);
            audio2IsPlaying = true;
            HomeScene.audio1IsPlaying = false;
            ArtistInfoScene.audio3IsPlaying = false;
            AudiosOfPlaylist.audio6IsPlaying = false;
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


    @FXML
    void homeButton(MouseEvent event) throws IOException {
        ChangeScene.homeScene();
    }

    @FXML
    void search(MouseEvent event) {
        search();
    }

    @FXML
    void library(MouseEvent event) {
        library();
    }

    @FXML
    void backTo(MouseEvent event) {
        backTo();
    }


    public void playButton(MouseEvent mouseEvent) {
        String path1 = Application.class.getResource("61180.png").toExternalForm();
        String path2 = Application.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
        Image image1 = new Image(path1);
        Image image2 = new Image(path2);
        if (audio2IsPlaying) {
            if (Objects.equals(playButton.getImage(), image2)) {
                playButton.setImage(image1);
                audio2.getMediaPlayer().play();
                PlayScene.audio4 = audio2;
                songPhoto.setImage(audio2.getImage());
                musicName.setText(audio2.getName());
            } else if (Objects.equals(playButton.getImage(), image1)) {
                playButton.setImage(image2);
                audio2.getMediaPlayer().pause();
                songPhoto.setImage(audio2.getImage());
                musicName.setText(audio2.getName());
            }
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().playButton(mouseEvent);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().playButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().playButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().playButton(mouseEvent);
        }

    }

    public void nextButton(MouseEvent mouseEvent) {
        int index;
        if (audio2IsPlaying) {
            index = DataBase.getDataBase().audios.indexOf(audio2);
            audio2 = DataBase.getDataBase().audios.get(++index);
            audio2.getMediaPlayer().play();
            PlayScene.audio4 = audio2;
            songPhoto.setImage(audio2.getImage());
            musicName.setText(audio2.getName());
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().nextButton(mouseEvent);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().nextButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().nextButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().nextButton(mouseEvent);
        }
    }

    public void previousButton(MouseEvent mouseEvent) {
        int index;
        if (audio2IsPlaying) {
            index = DataBase.getDataBase().audios.indexOf(audio2);
            audio2 = DataBase.getDataBase().audios.get(--index);
            audio2.getMediaPlayer().play();
            PlayScene.audio4 = audio2;
            songPhoto.setImage(audio2.getImage());
            musicName.setText(audio2.getName());
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().previousButton(mouseEvent);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().previousButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().previousButton(mouseEvent);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().previousButton(mouseEvent);
        }
    }
}
