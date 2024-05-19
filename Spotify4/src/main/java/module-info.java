module com.example.spotify4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens com.example.spotify4 to javafx.fxml;
    exports com.example.spotify4;
    exports com.example.spotify4.View;
    opens com.example.spotify4.View to javafx.fxml;
    exports com.example.spotify4.View.Scenes;
    opens com.example.spotify4.View.Scenes to javafx.fxml;
}