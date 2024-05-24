package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.Audio.Music;
import com.example.spotify4.Model.Audio.Podcast;
import com.example.spotify4.Model.GeneralOperation;
import com.example.spotify4.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayScene implements  GeneralOperation , Initializable {
    public static Audio audio4;
    @FXML
    private Button artistButton;

    @FXML
    private ImageView likeButton;


    @FXML
    private Button audioButton1;

    @FXML
    private Label artistID;

    @FXML
    private Button backButton;

    @FXML
    private Label genreID;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView libraryButton;


    @FXML
    private Label lyricLabel;

    @FXML
    private Label musicID;

    @FXML
    private Button login;

    @FXML
    private Button logout;

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
    private ImageView songCover;

//    public static void setAudio1(Audio audio1) {
//        PlayScene.audio1 = audio1;
//    }

    public void setArtistButton(Button artistButton) {
        this.artistButton = artistButton;
    }

    public void setAudioButton1(Button audioButton1) {
        this.audioButton1 = audioButton1;
    }

    public void setArtistID(Label artistID) {
        this.artistID = artistID;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public void setGenreID(Label genreID) {
        this.genreID = genreID;
    }

    public void setHomeButton(ImageView homeButton) {
        this.homeButton = homeButton;
    }

    public void setLibraryButton(ImageView libraryButton) {
        this.libraryButton = libraryButton;
    }



    public void setLyricLabel(Label lyricLabel) {
        this.lyricLabel = lyricLabel;
    }

    public void setMusicID(Label musicID) {
        this.musicID = musicID;
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

    public void setSongCover(ImageView songCover) {
        this.songCover = songCover;
    }

//    public static Audio getAudio1() {
//        return audio1;
//    }

    public Button getArtistButton() {
        return artistButton;
    }

    public Button getAudioButton1() {
        return audioButton1;
    }

    public Label getArtistID() {
        return artistID;
    }

    public Button getBackButton() {
        return backButton;
    }

    public Label getGenreID() {
        return genreID;
    }

    public ImageView getHomeButton() {
        return homeButton;
    }

    public ImageView getLibraryButton() {
        return libraryButton;
    }


    public Label getLyricLabel() {
        return lyricLabel;
    }

    public Label getMusicID() {
        return musicID;
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

    public Button getSignUpButton() {
        return signUpButton;
    }

    public ImageView getSongCover() {
        return songCover;
    }

    @FXML
    void artistButton(MouseEvent event) throws IOException {
        ChangeScene.artistsScene();
    }

    @FXML
    void audioButton1(MouseEvent event) throws IOException {
        ChangeScene.audiosScene();
    }

    @FXML
    void homeButton(MouseEvent event) throws IOException {
        ChangeScene.homeScene();
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
    void likeButton(MouseEvent event) {
        ListenerController.getListenerController().likeAudio(audio4.getID());
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("liked");
        alert.setContentText("you liked");
        alert.show();
    }
    @FXML
    void nextButton(MouseEvent event) {
        if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().nextButton(event);
            audio4 = HomeScene.audio1;
            songCover.setImage(audio4.getImage());
            musicID.setText(audio4.getName());
            musicID.setStyle(".label");
            artistID.setText(audio4.getArtistName());
            artistID.setStyle(".label");
            genreID.setText(String.valueOf(audio4.getGenre()));
            genreID.setStyle(".label");
            if (audio4 instanceof Music) {
                lyricLabel.setText(((Music) audio4).getLyric());
            } else if (audio4 instanceof Podcast) {
                lyricLabel.setText(((Podcast) audio4).getCaption());
            }
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().nextButton(event);
            audio4 = AudiosScene.audio2;
            songCover.setImage(audio4.getImage());
            musicID.setText(audio4.getName());
            musicID.setStyle(".label");
            artistID.setText(audio4.getArtistName());
            artistID.setStyle(".label");
            genreID.setText(String.valueOf(audio4.getGenre()));
            genreID.setStyle(".label");
            if (audio4 instanceof Music) {
                lyricLabel.setText(((Music) audio4).getLyric());
            } else if (audio4 instanceof Podcast) {
                lyricLabel.setText(((Podcast) audio4).getCaption());
            }
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().nextButton(event);
            audio4 = ArtistInfoScene.audio3;
            songCover.setImage(audio4.getImage());
            musicID.setText(audio4.getName());
            musicID.setStyle(".label");
            artistID.setText(audio4.getArtistName());
            artistID.setStyle(".label");
            genreID.setText(String.valueOf(audio4.getGenre()));
            genreID.setStyle(".label");
            if (audio4 instanceof Music) {
                lyricLabel.setText(((Music) audio4).getLyric());
            } else if (audio4 instanceof Podcast) {
                lyricLabel.setText(((Podcast) audio4).getCaption());
            }
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().nextButton(event);
            audio4 = AudiosOfPlaylist.audio6;
            songCover.setImage(audio4.getImage());
            musicID.setText(audio4.getName());
            musicID.setStyle(".label");
            artistID.setText(audio4.getArtistName());
            artistID.setStyle(".label");
            genreID.setText(String.valueOf(audio4.getGenre()));
            genreID.setStyle(".label");
            if (audio4 instanceof Music) {
                lyricLabel.setText(((Music) audio4).getLyric());
            } else if (audio4 instanceof Podcast) {
                lyricLabel.setText(((Podcast) audio4).getCaption());
            }
        }
    }

    @FXML
    void playButton(MouseEvent event) {
//        if (HomeScene.audio1IsPlaying) {
//            HomeScene.playButton(event);
//            audio4 = HomeScene.audio1;
//            songCover.setImage(audio4.getImage());
//            musicID.setText(audio4.getName());
//            musicID.setStyle(".label");
//            artistID.setText(audio4.getArtistName());
//            artistID.setStyle(".label");
//            genreID.setText(String.valueOf(audio4.getGenre()));
//            genreID.setStyle(".label");
//            if (audio4 instanceof Music) {
//                lyricLabel.setText(((Music) audio4).getLyric());
//            } else if (audio4 instanceof Podcast) {
//                lyricLabel.setText(((Podcast) audio4).getCaption());
//            }
//        } else if (AudiosScene.audio2IsPlaying) {
//            AudiosScene.getAudiosScene().playButton(event);
//            audio4 = AudiosScene.audio2;
//            songCover.setImage(audio4.getImage());
//            musicID.setText(audio4.getName());
//            musicID.setStyle(".label");
//            artistID.setText(audio4.getArtistName());
//            artistID.setStyle(".label");
//            genreID.setText(String.valueOf(audio4.getGenre()));
//            genreID.setStyle(".label");
//            if (audio4 instanceof Music) {
//                lyricLabel.setText(((Music) audio4).getLyric());
//            } else if (audio4 instanceof Podcast) {
//                lyricLabel.setText(((Podcast) audio4).getCaption());
//            }
//        } else if (ArtistInfoScene.audio3IsPlaying) {
//            ArtistInfoScene.getArtistInfoScene().playButton(event);
//            audio4 = ArtistInfoScene.audio3;
//            songCover.setImage(audio4.getImage());
//            musicID.setText(audio4.getName());
//            musicID.setStyle(".label");
//            artistID.setText(audio4.getArtistName());
//            artistID.setStyle(".label");
//            genreID.setText(String.valueOf(audio4.getGenre()));
//            genreID.setStyle(".label");
//            if (audio4 instanceof Music) {
//                lyricLabel.setText(((Music) audio4).getLyric());
//            } else if (audio4 instanceof Podcast) {
//                lyricLabel.setText(((Podcast) audio4).getCaption());
//            }
//        } else if (AudiosOfPlaylist.audio6IsPlaying) {
//            AudiosOfPlaylist.getAudiosOfPlaylist().playButton(event);
//            audio4 = AudiosOfPlaylist.audio6;
//            songCover.setImage(audio4.getImage());
//            musicID.setText(audio4.getName());
//            musicID.setStyle(".label");
//            artistID.setText(audio4.getArtistName());
//            artistID.setStyle(".label");
//            genreID.setText(String.valueOf(audio4.getGenre()));
//            genreID.setStyle(".label");
//            if (audio4 instanceof Music) {
//                lyricLabel.setText(((Music) audio4).getLyric());
//            } else if (audio4 instanceof Podcast) {
//                lyricLabel.setText(((Podcast) audio4).getCaption());
//            }
//        }
        if (HomeScene.audio1IsPlaying) {
            HomeScene.getHomeScene().playButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().playButton(event);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().playButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().playButton(event);
        }else if(SearchScene.audio5IsPlaying){
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
            audio4 = HomeScene.audio1;
            songCover.setImage(audio4.getImage());
            musicID.setText(audio4.getName());
            musicID.setStyle(".label");
            artistID.setText(audio4.getArtistName());
            artistID.setStyle(".label");
            genreID.setText(String.valueOf(audio4.getGenre()));
            genreID.setStyle(".label");
            if (audio4 instanceof Music) {
                lyricLabel.setText(((Music) audio4).getLyric());
            } else if (audio4 instanceof Podcast) {
                lyricLabel.setText(((Podcast) audio4).getCaption());
            }
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.getAudiosScene().previousButton(event);
            audio4 = AudiosScene.audio2;
            songCover.setImage(audio4.getImage());
            musicID.setText(audio4.getName());
            musicID.setStyle(".label");
            artistID.setText(audio4.getArtistName());
            artistID.setStyle(".label");
            genreID.setText(String.valueOf(audio4.getGenre()));
            genreID.setStyle(".label");
            if (audio4 instanceof Music) {
                lyricLabel.setText(((Music) audio4).getLyric());
            } else if (audio4 instanceof Podcast) {
                lyricLabel.setText(((Podcast) audio4).getCaption());
            }
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.getArtistInfoScene().previousButton(event);
            audio4 = ArtistInfoScene.audio3;
            songCover.setImage(audio4.getImage());
            musicID.setText(audio4.getName());
            musicID.setStyle(".label");
            artistID.setText(audio4.getArtistName());
            artistID.setStyle(".label");
            genreID.setText(String.valueOf(audio4.getGenre()));
            genreID.setStyle(".label");
            if (audio4 instanceof Music) {
                lyricLabel.setText(((Music) audio4).getLyric());
            } else if (audio4 instanceof Podcast) {
                lyricLabel.setText(((Podcast) audio4).getCaption());
            }
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.getAudiosOfPlaylist().previousButton(event);
            audio4 = AudiosOfPlaylist.audio6;
            songCover.setImage(audio4.getImage());
            musicID.setText(audio4.getName());
            musicID.setStyle(".label");
            artistID.setText(audio4.getArtistName());
            artistID.setStyle(".label");
            genreID.setText(String.valueOf(audio4.getGenre()));
            genreID.setStyle(".label");
            if (audio4 instanceof Music) {
                lyricLabel.setText(((Music) audio4).getLyric());
            } else if (audio4 instanceof Podcast) {
                lyricLabel.setText(((Podcast) audio4).getCaption());
            }
        }
    }

    @Override
    public void backTo() {
        backButton.setOnMouseClicked((e) -> {
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
        });
    }

    @Override
    public void signup() {
        signUpButton.setOnMouseClicked((e) -> {
            try {
                ChangeScene.signUpScene();
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

    @Override
    public void search() {
        searchButton1.setOnMouseClicked((e) -> {
            try {
                ChangeScene.searchScene();
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getPlayButton();
        String path= Application.class.getResource("61180.png").toExternalForm();
        Image image1 = new Image(path);
        if(!HomeScene.audio1.getMediaPlayer().isMute()) {
            playButton.setImage(image1);
        }
        else if(!AudiosScene.audio2.getMediaPlayer().isMute()){
            playButton.setImage(image1);
        } else if (!AudiosOfPlaylist.audio6.getMediaPlayer().isMute()) {
            playButton.setImage(image1);
        } else if (!SearchScene.audio5.getMediaPlayer().isMute()) {
            playButton.setImage(image1);
        } else if (!ArtistInfoScene.audio3.getMediaPlayer().isMute()) {
            playButton.setImage(image1);
        }
        songCover.setImage(audio4.getImage());
        musicID.setText(audio4.getName());
        musicID.setStyle(".label");
        musicID.setTextFill(Color.WHITE);
        artistID.setText(audio4.getArtistName());
        artistID.setStyle(".label");
        artistID.setTextFill(Color.WHITE);
        genreID.setText(String.valueOf(audio4.getGenre()));
        genreID.setStyle(".label");
        genreID.setTextFill(Color.WHITE);
        if (audio4 instanceof Music) {
            lyricLabel.setText(((Music) audio4).getLyric());
        } else if (audio4 instanceof Podcast) {
            lyricLabel.setText(((Podcast) audio4).getCaption());
        }
    }
}
