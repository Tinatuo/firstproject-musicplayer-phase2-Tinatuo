module com.example.spotify4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spotify4 to javafx.fxml;
    exports com.example.spotify4;
    exports com.example.spotify4.View;
    opens com.example.spotify4.View to javafx.fxml;
}