module com.example.spotify4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spotify4 to javafx.fxml;
    exports com.example.spotify4;
}