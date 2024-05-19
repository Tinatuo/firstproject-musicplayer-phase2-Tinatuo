package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Main;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.GeneralOperation;
import com.example.spotify4.Model.User.Admin;
import com.example.spotify4.View.SceneStack;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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

public class HomeScene implements Initializable, GeneralOperation {
    public static Audio audio1;
    public static boolean audio1IsPlaying = false;
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
    private static ImageView playButton;

    @FXML
    private Button playListButton;

    @FXML
    private ImageView previousButton;

    @FXML
    private ImageView searchButton1;

    @FXML
    private Button signUpButton;

    @FXML
    private static ImageView songPhoto;

    @FXML
    private static Label musicName;

    @FXML
    private Button login;

    @FXML
    private Button logout;

    public VBox getVBox() {
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
        return nextButton;
    }

    public ImageView getPlayButton() {
        return playButton;
    }

    public Button getPlayListButton() {
        return playListButton;
    }

    public ImageView getPreviousButton() {
        return previousButton;
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
        ChangeScene.audiosScene();
    }

    @FXML
    void playListButton(MouseEvent event) throws IOException {
        ChangeScene.plaListsScene();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (ListenerController.getListenerController().getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
            for (Audio audio : AdminController.getAdminController().mostPopularAudioFileArray()) {
                vBox.getChildren().add(fillHBox(audio));
            }
        } else {
            for (Audio audio : ListenerController.getListenerController().getSuggestions()) {
                vBox.getChildren().add(fillHBox(audio));
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
            }
        });
    }

    @FXML
    public void artistButton(MouseEvent event) throws IOException {
        ChangeScene.artistsScene();
    }

    @FXML
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
    }


    @Override
    public void search() {
        searchButton1.setOnMouseClicked((e) -> {
            try {
                ChangeScene.searchScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
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
        String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
        String path1 = Main.class.getResource("61180").toExternalForm();
        Image image1 = new Image(path1);
        ImageView imageView1 = new ImageView(image1);
        Image image2 = new Image(path2);
        ImageView imageView2 = new ImageView(image2);
        HBox hBox = new HBox();
        ImageView imageView = audio.getAudioPhoto();
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Circle circle = new Circle(imageView.getFitWidth() / 2);
        imageView.setClip(circle);
        Label label = new Label(audio.getName());
        hBox.getChildren().addAll(imageView, label);
        hBox.setSpacing(15);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setOnMouseClicked((e) -> {
            audio.getMediaPlayer().play();
            songPhoto = audio.getAudioPhoto();
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
                throw new RuntimeException(ex);
            }
        });
        return hBox;
    }


    public static void nextButton(MouseEvent mouseEvent) {
        int index;
        audio1.getMediaPlayer().pause();
        if (audio1IsPlaying) {
            if (ListenerController.listenerController.getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
                index = AdminController.getAdminController().mostPopularAudioFileArray().indexOf(audio1);
                audio1 = AdminController.getAdminController().mostPopularAudioFileArray().get(++index);
                audio1.getMediaPlayer().play();
                songPhoto.setImage(audio1.getImage());
                musicName.setText(audio1.getName());
            } else {
                index = ListenerController.getListenerController().getSuggestions().indexOf(audio1);
                audio1 = ListenerController.getListenerController().getSuggestions().get(++index);
                audio1.getMediaPlayer().play();
                songPhoto.setImage(audio1.getImage());
                musicName.setText(audio1.getName());
            }
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.nextButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.nextButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.nextButton(mouseEvent);
        }
    }

    public static void previousButton(MouseEvent mouseEvent) {
        int index;
        audio1.getMediaPlayer().pause();
        if (audio1IsPlaying) {
            if (ListenerController.listenerController.getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
                index = AdminController.getAdminController().mostPopularAudioFileArray().indexOf(audio1);
                audio1 = AdminController.getAdminController().mostPopularAudioFileArray().get(--index);
                audio1.getMediaPlayer().play();
                songPhoto.setImage(audio1.getImage());
                musicName.setText(audio1.getName());
            } else {
                index = ListenerController.getListenerController().getSuggestions().indexOf(audio1);
                audio1 = ListenerController.getListenerController().getSuggestions().get(--index);
                audio1.getMediaPlayer().play();
                songPhoto.setImage(audio1.getImage());
                musicName.setText(audio1.getName());
            }
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.previousButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.previousButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.previousButton(mouseEvent);
        }

    }

    public static void playButton(MouseEvent mouseEvent) {
        String path1 = Main.class.getResource("61180").toExternalForm();
        String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
        Image image1 = new Image(path1);
        Image image2 = new Image(path2);
        if (audio1IsPlaying) {
            if (Objects.equals(playButton.getImage(), image2)) {
                playButton.setImage(image1);
                audio1.getMediaPlayer().play();
                songPhoto.setImage(audio1.getImage());
                musicName.setText(audio1.getName());
            } else if (Objects.equals(playButton.getImage(), image1)) {
                playButton.setImage(image2);
                audio1.getMediaPlayer().pause();
                songPhoto.setImage(audio1.getImage());
                musicName.setText(audio1.getName());
            }
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.playButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.playButton(mouseEvent);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.playButton(mouseEvent);
        }


    }

    public void audioButton(MouseEvent mouseEvent) throws IOException {
        ChangeScene.audiosScene();
    }
}
