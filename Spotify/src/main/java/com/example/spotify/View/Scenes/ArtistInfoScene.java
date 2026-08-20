package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Application;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.Audio.Podcast;
import com.example.spotify4.Model.DataBase;
import com.example.spotify4.Model.GeneralOperation;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.Artist.Podcaster;
import com.example.spotify4.Model.User.Artist.Singer;
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
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ArtistInfoScene implements Initializable, GeneralOperation {
    public static Audio audio3;
    public static boolean audio3IsPlaying = false;
    public static ArrayList<Audio> artistSongs = new ArrayList<>();
    private Artist artist1;

    public Artist getArtist1() {
        return artist1;
    }

    public static void setArtist1(Artist artist1) {
        artist1 = artist1;
    }

    public static void setAudio3(Audio audio3) {
        ArtistInfoScene.audio3 = audio3;
    }

    private static ArtistInfoScene artistInfoScene;

    public static ArtistInfoScene getArtistInfoScene() {
        if (artistInfoScene == null) {
            artistInfoScene = new ArtistInfoScene();
            return artistInfoScene;
        }else {
            return artistInfoScene;
        }
    }

    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private Button artistButton;
    @FXML
    private Button audioButton;

    @FXML
    private Label biographyBox;

    @FXML
    private Button followButton;

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
    private Button reportButton;

    @FXML
    private ImageView searchButton1;

    @FXML
    private ImageView songPhoto1;

    @FXML
    private Circle userPhoto;

    @FXML
    private VBox vBox;
    @FXML
    private Button signUpButton;

    @FXML
    private Button backButton;
    @FXML
    private Label usernameLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label birthdateLabel;
    @FXML
    private Label musicName;
    @FXML
    private Button login;

    @FXML
    private Button logout;


    public void setAnchorpane(AnchorPane anchorpane) {
        Anchorpane = anchorpane;
    }

    public void setArtistButton(Button artistButton) {
        this.artistButton = artistButton;
    }


    public void setBiographyBox(Label biographyBox) {
        this.biographyBox = biographyBox;
    }

    public void setFollowButton(Button followButton) {
        this.followButton = followButton;
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

    public void setReportButton(Button reportButton) {
        this.reportButton = reportButton;
    }

    public void setSearchButton1(ImageView searchButton1) {
        this.searchButton1 = searchButton1;
    }

    public void setSongPhoto(ImageView songPhoto) {
        this.songPhoto1 = songPhoto;
    }

    public void setUserPhoto(Circle userPhoto) {
        this.userPhoto = userPhoto;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public AnchorPane getAnchorpane() {
        return Anchorpane;
    }

    public Button getArtistButton() {
        return artistButton;
    }


    public Label getBiographyBox() {
        return biographyBox;
    }

    public Button getFollowButton() {
        return followButton;
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


    public Button getPlayListButton() {
        return playListButton;
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

    public Button getReportButton() {
        return reportButton;
    }

    public ImageView getSearchButton1() {
        return searchButton1;
    }

    public ImageView getSongPhoto() {
        return songPhoto1;
    }

    public Circle getUserPhoto() {
        return userPhoto;
    }

    public VBox getvBox() {
        return vBox;
    }

    @FXML
    void followButton(MouseEvent event) {
        this.artist1.followers.add(ListenerController.getListenerController().listener);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("was successfully");
        alert.setContentText("followed");
        alert.show();
    }


    @FXML
    void reportButton(MouseEvent event) {
        Scanner sc = new Scanner(System.in);
        ListenerController.getListenerController().artistReport(this.artist1.getUserName(), sc.nextLine());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("was successfully");
        alert.setContentText("Report was recorded");
        alert.show();
    }

    @FXML
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
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

    //todo
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

    @FXML
     void playButton(MouseEvent event) {
        String path1 = Application.class.getResource("61180.png").toExternalForm();
        String path2 = Application.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
        Image image1 = new Image(path1);
        Image image2 = new Image(path2);
        if (audio3IsPlaying) {
            if (artistInfoScene.playButton.getImage() == image2) {
                artistInfoScene.playButton.setImage(image1);
                audio3.getMediaPlayer().play();
                PlayScene.audio4 = audio3;
                artistInfoScene.songPhoto1.setImage(audio3.getImage());
                artistInfoScene.musicName.setText(audio3.getName());
            } else if (artistInfoScene.playButton.getImage() == image1) {
                artistInfoScene.playButton.setImage(image2);
                audio3.getMediaPlayer().pause();
                artistInfoScene.songPhoto1.setImage(audio3.getImage());
                artistInfoScene.musicName.setText(audio3.getName());
            }
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().playButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().playButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().playButton(event);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().playButton(event);
        }
    }

    @FXML
     void nextButton(MouseEvent event) {
        int index;
        if (audio3IsPlaying) {
            index = artistSongs.indexOf(audio3);
            audio3 = artistSongs.get(++index);
            audio3.getMediaPlayer().play();
            PlayScene.audio4 = audio3;
            artistInfoScene.songPhoto1.setImage(audio3.getImage());
            artistInfoScene.musicName.setText(audio3.getName());
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().nextButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().nextButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().nextButton(event);
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().nextButton(event);
        }
    }

    @FXML
     void previousButton(MouseEvent event) {
        int index;
        if (audio3IsPlaying) {
            index = artistSongs.indexOf(audio3);
            audio3 = artistSongs.get(--index);
            audio3.getMediaPlayer().play();
            PlayScene.audio4 = audio3;
            artistInfoScene.songPhoto1.setImage(audio3.getImage());
            artistInfoScene.musicName.setText(audio3.getName());
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().previousButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().previousButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().previousButton(event);
        }
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
            } finally {
                System.out.println("Have a good day");
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usernameLabel.setText(artist1.getUserName());
        usernameLabel.setStyle(".label");
        nameLabel.setText(artist1.getFirstAndLastname());
        nameLabel.setStyle(".label");
        ImageView imageView = artist1.getUserPhoto();
        imageView.setClip(userPhoto);
        if (artist1 instanceof Singer) {
            label.setText("Musics : ");
            label.setStyle(".label");
            for (Audio audio : DataBase.getDataBase().audios) {
                if (Objects.equals(audio.getArtistName(), artist1.getUserName())) {
                    artistSongs.add(audio);
                    vBox.getChildren().add(setHBOx(audio));
                }
            }
        } else if (artist1 instanceof Podcaster) {
            label.setText("Podcasts : ");
            label.setStyle(".label");
            for (Audio audio : DataBase.getDataBase().audios) {
                if (audio instanceof Podcast) {
                    if (Objects.equals(audio.getArtistName(), artist1.getUserName())) {
                        artistSongs.add(audio);
                        vBox.getChildren().add(setHBOx(audio));
                    }
                }
            }
        }
    }

    @FXML
    void search(MouseEvent event) {
        search();
    }

    @FXML
    void signup(MouseEvent event) {
        signup();
    }

    @FXML
    void library(MouseEvent event) {
        library();
    }

    @FXML
    void artistButton(MouseEvent event) throws IOException {
        ChangeScene.artistsScene();
    }

    @FXML
    void audioButton(MouseEvent event) throws IOException {
        ChangeScene.audiosScene();
    }

    @FXML
    void homeButton(MouseEvent event) throws IOException {
        ChangeScene.homeScene();
    }

    @FXML
    void playListButton(MouseEvent event) throws IOException {
        ChangeScene.plaListsScene();
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

    @FXML
    void login(MouseEvent event) {
        login();
    }

    @FXML
    void logout(MouseEvent event) {
        logout();
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
        HBox hBox = new HBox(imageView, audioName);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(15);
        hBox.setOnMouseClicked((e) -> {
            audio.getMediaPlayer().play();
            PlayScene.audio4 = audio;
            audio3 = audio;
            songPhoto1 = audio.getAudioPhoto();
            musicName.setText(audio.getName());
            playButton.setImage(image1);
            audio3IsPlaying = true;
            HomeScene.audio1IsPlaying = false;
            AudiosScene.audio2IsPlaying = false;
            AudiosOfPlaylist.audio6IsPlaying = false;
            try {
                ChangeScene.playScene();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("RunTime exception");
                alert.show();
            }
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
}


