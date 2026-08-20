package com.example.spotify4.View.Scenes;

import com.example.spotify4.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeScene {
    public static Stage stage;

    private static Scene loadScene(String fxml, int width, int height, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(Application.class.getResource(fxml));
        Scene scene = new Scene(loader.load(), width, height);
        SceneStack.sceneStack.push(scene);
        String css = Application.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle(title);
        return scene;
    }

    public static void artistsScene() throws IOException {
        loadScene("ArtistsScene.fxml", 747, 529, "Artists");
    }

    public static void homeScene() throws IOException {
        loadScene("Home.fxml", 747, 529, "Home");
    }

    public static void entryScene() throws IOException {
        loadScene("Entry.fxml", 747, 529, "Log in");
    }

    public static void signUpScene() throws IOException {
        loadScene("SignUp.fxml", 747, 700, "Sign Up");
    }

    public static void searchScene() throws IOException {
        loadScene("SearchScene.fxml", 687, 559, "Search");
    }

    public static void audiosScene() throws IOException {
        loadScene("AudiosScene.fxml", 747, 529, "Audios");
    }

    public static void playScene() throws IOException {
        loadScene("PlayScene.fxml", 747, 529, "Music");
    }

    public static void buyScene() throws IOException {
        loadScene("BuyScene.fxml", 747, 529, "Buy");
    }

    public static void audioOfPlayListScene() throws IOException {
        loadScene("AudiosOfPlayList.fxml", 747, 529, "Audios of Play List");
    }

    public static void artistInfoScene() throws IOException {
        loadScene("ArtistInfoScene.fxml", 747, 529, "Artist Information");
    }

    public static void plaListsScene() throws IOException {
        loadScene("PlayLists.fxml", 747, 529, "PlayLists");
    }

    public static void genreScene() throws IOException {
        loadScene("GenreScene.fxml", 747, 600, "Genres");
    }

    public static void ListenerPanelScene() throws IOException {
        loadScene("ListenerPanel.fxml", 747, 529, "Listener Panel");
    }
}
