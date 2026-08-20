package com.example.spotify4.View.Scenes;

import com.example.spotify4.Application;
import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Model.DataBase;
import com.example.spotify4.Model.GeneralOperation;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.User;
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
import java.util.ResourceBundle;

public class ArtistsScene implements Initializable, GeneralOperation {

    @FXML
    private AnchorPane Anchorpane;
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
    private ImageView songPhoto;

    @FXML
    private VBox vBox;

    @FXML
    private Button signUpButton;

    @FXML
    private Label musicName;

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

    public void setvBox(VBox vBox) {
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
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
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
        } else if (SearchScene.audio5IsPlaying) {
            SearchScene.getSearchScene().previousButton(event);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (User user : DataBase.getDataBase().users) {
            if (user instanceof Artist) {
                vBox.getChildren().add(setHBOx((Artist) user));
                vBox.setSpacing(15);
            }
        }

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
            }
        });
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

    public HBox setHBOx(Artist artist) {
        ImageView imageView = artist.getUserPhoto();
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        Circle circle = new Circle(30, 30, 30);
        imageView.setClip(circle);
        Label artistName = new Label();
        artistName.setTextFill(Color.WHITE);
        artistName.setFont(new Font(20));
        artistName.setText(artist.getUserName());
        HBox hBox = new HBox(imageView, artistName);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(15);
        return hBox;
    }


    public void backButton(MouseEvent mouseEvent) {
        backTo();
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


}
