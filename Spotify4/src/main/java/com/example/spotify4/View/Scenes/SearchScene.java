package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Main;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.View.SceneStack;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class SearchScene implements Initializable {
    public static Audio audio5;
    public static boolean audio5IsPlaying = false;
    static ArrayList<Audio> searchArray=new ArrayList<>();
    @FXML
    private TextArea searchBox = new TextArea();
    @FXML
    private Button backButton;
    @FXML
    private ImageView nextButton;

    @FXML
    private static ImageView playButton;

    @FXML
    private ImageView previousButton;
    @FXML
    private static Label musicName;

    @FXML
    private static ImageView songPhoto;

    public TextArea getSearchBox() {
        return searchBox;
    }

    public void setSearchBox(TextArea searchBox) {
        this.searchBox = searchBox;
    }

    @FXML
    private VBox vBox;

    public VBox getVBox() {
        return vBox;
    }

    public void setVBox(VBox vBox) {
        this.vBox = vBox;
    }

    @FXML
    void backButton(MouseEvent event) {
            ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
            ChangeScene.stage.show();
    }


    public HBox setHBox(Audio audio) {
        String path1 = Main.class.getResource("61180").toExternalForm();
        Image image1 = new Image(path1);
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
            audio5 = audio;
            songPhoto = audio.getAudioPhoto();
            musicName.setText(audio.getName());
            playButton.setImage(image1);
            HomeScene.audio1IsPlaying = false;
            AudiosScene.audio2IsPlaying = false;
            ArtistInfoScene.audio3IsPlaying = false;
            audio5IsPlaying = true;
            try {
                ChangeScene.playScene();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchBox.textProperty().addListener((p, o, n) -> {
            String search = searchBox.getText();
            searchArray=ListenerController.getListenerController().searchAudio(search);
            for (Audio audio : ListenerController.listenerController.searchAudio(search)) {
                vBox.getChildren().add(setHBox(audio));
            }
        });
    }

    public void backButton(javafx.scene.input.MouseEvent mouseEvent) {
        ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
    }

    public void nextButton(javafx.scene.input.MouseEvent mouseEvent) {
        int index;
        if (audio5IsPlaying) {
            index =searchArray.indexOf(audio5);
            audio5 = searchArray.get(++index);
            audio5.getMediaPlayer().play();
            songPhoto.setImage(audio5.getImage());
            musicName.setText(audio5.getName());
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.nextButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.nextButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.nextButton(mouseEvent);
        }
    }

    public void previousButton(javafx.scene.input.MouseEvent mouseEvent) {
        int index;
        if (audio5IsPlaying) {
            index =searchArray.indexOf(audio5);
            audio5 = searchArray.get(--index);
            audio5.getMediaPlayer().play();
            songPhoto.setImage(audio5.getImage());
            musicName.setText(audio5.getName());
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.previousButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.previousButton(mouseEvent);
        } else if (AudiosOfPlaylist.audio6IsPlaying){
            AudiosOfPlaylist.previousButton(mouseEvent);
        }
    }

    public void playButton(javafx.scene.input.MouseEvent mouseEvent) {
        String path1 = Main.class.getResource("61180").toExternalForm();
        String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
        Image image1 = new Image(path1);
        Image image2 = new Image(path2);
        if (audio5IsPlaying) {
            if (playButton.getImage() == image2) {
                playButton.setImage(image1);
                audio5.getMediaPlayer().play();
                songPhoto.setImage(audio5.getImage());
                musicName.setText(audio5.getName());
            } else if (playButton.getImage() == image1) {
                playButton.setImage(image2);
                audio5.getMediaPlayer().pause();
                songPhoto.setImage(audio5.getImage());
                musicName.setText(audio5.getName());
            }
        } else if (HomeScene.audio1IsPlaying) {
            HomeScene.playButton(mouseEvent);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.playButton(mouseEvent);
        } else if(AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.playButton(mouseEvent);
        }
    }
}
