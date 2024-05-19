package com.example.spotify4.View.Scenes;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.Exception.LackOfCredit;
import com.example.spotify4.Controller.ListenerController.FreeListenerController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Controller.ListenerController.PremiumController;
import com.example.spotify4.Model.GeneralOperation;
import com.example.spotify4.Model.User.Listener.FreeListener;
import com.example.spotify4.Model.User.Listener.Premium;
import com.example.spotify4.View.SceneStack;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class BuyScene implements GeneralOperation {

    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private Label ThirtyDayLabel;

    @FXML
    private Label sixtyDayLabel;

    @FXML
    private Button audiosButton1;

    @FXML
    private Button backButton;

    @FXML
    private Button buyButton;

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
    private Label oneHundredEightyDays;

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
    private ImageView songPhoto;

    @FXML
    private VBox vBox;

    @FXML
    private Label musicName;

    @FXML
    void ThirtyDayLabel(MouseEvent event) {
        buyButton(event,"THIRTYDAYS");
    }

    @FXML
    void audiosButton1(MouseEvent event) throws IOException {
        ChangeScene.artistsScene();
    }


    @FXML
    void buyButton(MouseEvent event , String packageSpotify) {
        if(ListenerController.getListenerController().listener instanceof FreeListener) {
            try {
                ListenerController.getListenerController().listener = FreeListenerController.getFreeListenerController().purchaseOrRenewSubscription(packageSpotify);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("successfully");
                alert.setContentText("You have successfully purchased");
            } catch (LackOfCredit e) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("you don't have enough credits");
                alert.setTitle("error!!");
                alert.showAndWait();
            }
        } else if (ListenerController.getListenerController().listener instanceof Premium) {
            try {
                ListenerController.getListenerController().listener=PremiumController.getPremiumController().purchaseOrRenewSubscription(packageSpotify);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("successfully");
                alert.setContentText("You have successfully purchased");
            }
            catch (LackOfCredit e) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("you don't have enough credits");
                alert.setTitle("error!!");
                alert.showAndWait();
            }finally {
                System.out.println("Have a good day");
            }
        }
    }

    @FXML
    void nextButton(MouseEvent event) {
        if (HomeScene.audio1IsPlaying) {
            HomeScene.nextButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.nextButton(event);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.nextButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.nextButton(event);
        }
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
    void homeButton(MouseEvent event) throws IOException {
        ChangeScene.homeScene();
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
    @FXML
    void oneHundredEightyDays(MouseEvent event) {
        buyButton(event,"ONEHUNDREDEIGHTYDAYS");
    }

    @FXML
    void playButton(MouseEvent event) {
        if (HomeScene.audio1IsPlaying) {
            HomeScene.playButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.playButton(event);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.playButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.playButton(event);
        }
    }

    @FXML
    void playListButton(MouseEvent event) throws IOException {
        ChangeScene.plaListsScene();
    }

    @FXML
    void previousButton(MouseEvent event) {
        if (HomeScene.audio1IsPlaying) {
            HomeScene.previousButton(event);
        } else if (AudiosScene.audio2IsPlaying) {
            AudiosScene.audiosScene.previousButton(event);
        } else if (ArtistInfoScene.audio3IsPlaying) {
            ArtistInfoScene.previousButton(event);
        } else if (AudiosOfPlaylist.audio6IsPlaying) {
            AudiosOfPlaylist.previousButton(event);
        }
    }
    @FXML
    void sixtyDayLabel(MouseEvent event) {
        buyButton(event,"SIXTYDAYS");
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
            if(!(ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1()==null)) {
                ListenerController.listenerController.setListener(null);
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
            }
        });
    }

    @Override
    public void signup() throws IOException {
        signUpButton.setOnMouseClicked((e)->{
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
    @FXML
    void musicName(MouseEvent event) throws IOException {
        ChangeScene.playScene();
    }
    @Override
    public void search() throws IOException {
        searchButton1.setOnMouseClicked((e)->{
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

}
