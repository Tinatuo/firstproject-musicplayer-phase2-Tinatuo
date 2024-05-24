package com.example.spotify4.View.Scenes;

import com.example.spotify4.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeScene {
    public static Stage stage;


    public static void artistsScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("ArtistsScene.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Artists");
//        stage.show();
    }

    public static void homeScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Home.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Home");
//        stage.show();
    }

    public static void entryScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Entry.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Log in");
//        stage.show();
    }

    public static void signUpScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("signUp.fxml"));
        Scene scene = new Scene(loader.load(), 747, 700);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.show();
    }

    public static void searchScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("SearchScene.fxml"));
        Scene scene = new Scene(loader.load(), 687, 559);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Search");
//        stage.show();
    }

    public static void audiosScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AudiosScene.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Audios");
//        stage.show();
    }

    public static void playScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("PlayScene.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Music");
//        stage.show();
    }

    public static void buyScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("BuyScene.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Buy");
//        stage.show();
    }

    public static void audioOfPlayListScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("AudioOfPlayListScene.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Audios of Play List");
//        stage.show();
    }

    public static void artistInfoScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("ArtistInfoScene.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Artist Information");
//        stage.show();
    }

    public static void plaListsScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("PlayLists.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("PlayLists");
//        stage.show();
    }

    public static void genreScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("GenreScene.fxml"));
        Scene scene = new Scene(loader.load(), 747, 600);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        System.out.println("bye");
        stage.setScene(scene);
        stage.setTitle("Genres");
//        stage.show();
    }
    public static void ListenerPanelScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("ListenerPanel.fxml"));
        Scene scene = new Scene(loader.load(), 747, 529);
        SceneStack.sceneStack.push(scene);
        String css=Main.class.getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Listener Panel");
//        stage.show();
    }
}
