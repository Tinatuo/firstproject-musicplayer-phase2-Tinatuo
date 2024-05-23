package com.example.spotifyyyy;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Interface {
    public interface GeneralOperation {
        void backTo();

        void logout();

        void login();

        void signup() throws IOException;

        void search() throws IOException;
    }
}
    class Audio implements Comparable<Audio> {
        private int ID = makeID();
        private String name;
        private String artistName;
        private long numberOfPlay = 0;
        private long numberOfLike = 0;
        private Date release;
        private Genre genre;
        private String link;
        private String cover;
        private ImageView audioPhoto;
        private Media audio;
        private MediaPlayer mediaPlayer;
        Audio audio1;

        public void setRelease(Date release) {
            this.release = release;
        }

        public void setAudio(Media audio) {
            this.audio = audio;
        }

        public void setMediaPlayer(MediaPlayer mediaPlayer) {
            this.mediaPlayer = mediaPlayer;
        }

        public Media getAudio() {
            return audio;
        }

        public MediaPlayer getMediaPlayer() {
            return mediaPlayer;
        }

        public ImageView getAudioPhoto() {
            return audioPhoto;
        }

        public void setAudioPhoto(ImageView audioPhoto) {
            this.audioPhoto = audioPhoto;
        }

        private Image image;

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public Audio(String name, String artistName, int year, int mounth, int day, Genre genre, String link, String cover, String imageView) {
            this.name = name;
            this.artistName = artistName;
            this.release = new Date(year, mounth, day);
            this.genre = genre;
            this.link = link;
            this.cover = cover;
            String path = (Main.class.getResource(imageView)).toExternalForm();
            image = new Image(path);
            audioPhoto = new ImageView(image);
            this.audio = new Media(link);
            this.mediaPlayer = new MediaPlayer(audio);
            this.audio1 = new Audio(name, artistName, year, mounth, day, genre, link, cover, imageView);
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public void setNumberOfPlay(long numberOfPlay) {
            this.numberOfPlay = numberOfPlay;
        }

        public void setNumberOfLike(long numberOfLike) {
            this.numberOfLike = numberOfLike;
        }

        public void setRelease(int year, int mounth, int day) {
            this.release = new Date(year, mounth, day);
        }

        public void setGenre(Genre genre) {
            this.genre = genre;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getID() {
            return ID;
        }

        public String getName() {
            return name;
        }

        public String getArtistName() {
            return artistName;
        }

        public long getNumberOfPlay() {
            return numberOfPlay;
        }

        public long getNumberOfLike() {
            return numberOfLike;
        }

        public Date getRelease() {
            return release;
        }

        public Genre getGenre() {
            return genre;
        }

        public String getLink() {
            return link;
        }

        public String getCover() {
            return cover;
        }

        public String toString() {
            String string;
            string = "name:" + name + "\nID:" + ID + "\nModel.User.Artist's name:" + artistName + "\nThe number of play:" + numberOfPlay + "\nThe number of likes" + numberOfLike + "\nData of release:" + release + "\ngenre:" + genre + "\nLink:" + link + "\nCover:" + cover;
            return string;
        }

        public int makeID() {

            int id = this.name.hashCode() + this.getArtistName().hashCode();
            int length = String.valueOf(id).length();
            int Max_Length = 5;
            if (String.valueOf(id).length() > Max_Length) {
                id = (int) (id / Math.pow(10.0, length - Max_Length));
            }
            return id;
        }

        @Override
        public int compareTo(Audio audio) {
            for (int i = 0; i < audio.name.length(); i++) {
                if (this.name.charAt(i) > audio.name.charAt(i)) {
                    return 1;
                } else if (this.name.charAt(i) < audio.name.charAt(i)) {
                    return -1;
                } else if (this.name.charAt(i) == audio.name.charAt(i)) {
                    if (this.numberOfLike > audio.numberOfLike) {
                        return 1;
                    } else if (this.numberOfLike < audio.numberOfLike) {
                        return -1;
                    } else if (this.numberOfLike == audio.numberOfLike) {
                        if ((audio instanceof Podcast) && (audio1 instanceof Music)) {
                            return 1;
                        } else if ((audio instanceof Music) && (audio1 instanceof Podcast)) {
                            return -1;
                        } else {
                            if (this.numberOfPlay > audio.numberOfPlay) {
                                return 1;
                            } else if (audio.numberOfPlay > this.numberOfPlay) {
                                return -1;
                            } else if (this.numberOfPlay == audio.numberOfPlay) {
                                return 0;
                            }
                        }
                    }
                }
            }
            return 0;
        }
    }
    class PlayList implements Iterable<Audio> {
        private int ID=makeID();
        private String name;
        private String userCreatorName;
        private ArrayList<Audio> audoisList=new ArrayList<Audio>();


        public PlayList( String name, String userCreatorName) {
            this.name = name;
            this.userCreatorName = userCreatorName;
        }

        public int getID() {
            return ID;
        }

        public String getName() {
            return name;
        }

        public String getUserCreatorName() {
            return userCreatorName;
        }

        public ArrayList<Audio> getAudoisList() {
            return audoisList;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setUserCreatorName(String userCreatorName) {
            this.userCreatorName = userCreatorName;
        }

        public void setAudoisList(ArrayList<Audio> audoisList) {
            this.audoisList = audoisList;
        }
        @Override
        public String toString(){
            String string="name: "+name+"\ncreator's name: "+userCreatorName+"\nplay list's ID: "+ID+"\nAudios: ";
            for(Audio audio1:audoisList){
                string+="\n"+audio1.getName();
            }
            return string;
        }
        public int makeID() {

            int id = this.name.hashCode() + this.userCreatorName.hashCode();
            int length = String.valueOf(id).length();
            int Max_Length = 5;
            if(String.valueOf(id).length()>Max_Length)
            {
                id = (int) (id /Math.pow(10.0,length - Max_Length ));
            }
            return  id;
        }
        int index=0;
        @Override
        public Iterator<Audio> iterator() {
            return new Iterator<Audio>() {
                @Override
                public boolean hasNext() {
                    if(index<audoisList.size()){
                        return true;
                    }else{
                        return false;
                    }
                }

                @Override
                public Audio next() {
                    return audoisList.get(index++);
                }
            };
        }
    }
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
        private Button log;

        @FXML
        private ImageView nextButton;

        @FXML
        private static ImageView playButton;

        @FXML
        private Button playListButton;

        @FXML
        private ImageView previousButton;

        @FXML
        private Button reportButton;

        @FXML
        private ImageView searchButton1;

        @FXML
        private static ImageView songPhoto;

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
        private static Label musicName;
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

        public void setLog(Button log) {
            this.log = log;
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
            this.songPhoto = songPhoto;
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

        public Button getLog() {
            return log;
        }

        public ImageView getNextButton() {
            return nextButton;
        }

        public ImageView getPlayButton() {
            return playButton;
        }

        public Button getPlayListButton() {
            return playListButton;
        }

        public ImageView getPreviousButton() {
            return previousButton;
        }

        public Button getReportButton() {
            return reportButton;
        }

        public ImageView getSearchButton1() {
            return searchButton1;
        }

        public ImageView getSongPhoto() {
            return songPhoto;
        }

        public Circle getUserPhoto() {
            return userPhoto;
        }

        public VBox getvBox() {
            return vBox;
        }

        @FXML
        void followButton(MouseEvent event, Artist artist) {
            artist.followers.add(ListenerController.getListenerController().listener);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("was successfully");
            alert.setContentText("followed");
            alert.show();
        }


        @FXML
        void reportButton(MouseEvent event, Artist artist) {
            Scanner sc = new Scanner(System.in);
            ListenerController.getListenerController().artistReport(artist.getUserName(), sc.nextLine());
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
            log.setOnMouseClicked((e) -> {
                if (!(ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
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

        //todo
        @Override
        public void login() {
            log.setOnMouseClicked((e) -> {
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

        @FXML
        static void playButton(MouseEvent event) {
            String path1 = Main.class.getResource("61180").toExternalForm();
            String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
            Image image1 = new Image(path1);
            Image image2 = new Image(path2);
            if (audio3IsPlaying) {
                if (playButton.getImage() == image2) {
                    playButton.setImage(image1);
                    audio3.getMediaPlayer().play();
                    songPhoto.setImage(audio3.getImage());
                    musicName.setText(audio3.getName());
                } else if (playButton.getImage() == image1) {
                    playButton.setImage(image2);
                    audio3.getMediaPlayer().pause();
                    songPhoto.setImage(audio3.getImage());
                    musicName.setText(audio3.getName());
                }
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.playButton(event);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.playButton(event);
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.playButton(event);
            }
        }

        @FXML
        static void nextButton(MouseEvent event) {
            int index;
            if (audio3IsPlaying) {
                index = artistSongs.indexOf(audio3);
                audio3 = artistSongs.get(++index);
                audio3.getMediaPlayer().play();
                songPhoto.setImage(audio3.getImage());
                musicName.setText(audio3.getName());
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.nextButton(event);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.nextButton(event);
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.nextButton(event);
            }
        }

        @FXML
        static void previousButton(MouseEvent event) {
            int index;
            if (audio3IsPlaying) {
                index = artistSongs.indexOf(audio3);
                audio3 = artistSongs.get(--index);
                audio3.getMediaPlayer().play();
                songPhoto.setImage(audio3.getImage());
                musicName.setText(audio3.getName());
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.previousButton(event);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.previousButton(event);
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.previousButton(event);
            }
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
        void log(MouseEvent event) {
//todo
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
        void login(MouseEvent event) {
            login();
        }

        @FXML
        void logout(MouseEvent event) {
            logout();
        }

        public HBox setHBOx(Audio audio) {
            String path1 = Main.class.getResource("61180").toExternalForm();
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
                audio3 = audio;
                songPhoto = audio.getAudioPhoto();
                musicName.setText(audio.getName());
                playButton.setImage(image1);
                audio3IsPlaying = true;
                HomeScene.audio1IsPlaying = false;
                AudiosScene.audio2IsPlaying = false;
                try {
                    ChangeScene.playScene();
                } catch (IOException ex) {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error");
                    alert.setContentText("RunTime exception");
                    alert.show();
                }
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
    }
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
            return nextButton;
        }

        public ImageView getPlayButton() {
            return playButton;
        }

        public Button getPlayListButton() {
            return playListButton;
        }

        public ImageView getPreviousButton() {
            return previousButton;
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
        void musicName(MouseEvent event) throws IOException {
            ChangeScene.playScene();
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

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            for (User user : DataBase.getDataBase().users) {
                if (user instanceof Artist) {
                    vBox.getChildren().add(setHBOx((Artist) user));
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
            imageView.setFitHeight(40);
            imageView.setFitWidth(40);
            Circle circle = new Circle(20, 20, 20);
            imageView.setClip(circle);
            Label artistName = new Label();
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
    public class AudiosOfPlaylist implements Initializable, GeneralOperation {

        @FXML
        private AnchorPane Anchorpane;

        @FXML
        private Button audiosButton1;

        @FXML
        private Button backButton;
        @FXML
        private static ImageView playButton;


        @FXML
        private ImageView homeButton;

        @FXML
        private ImageView libraryButton;

        @FXML
        private VBox listsVbox;


        @FXML
        private ImageView nextButton;


        @FXML
        private Button playListButton;

        @FXML
        private Label playlistName;

        @FXML
        private ImageView previousButton;

        @FXML
        private ImageView searchButton1;

        @FXML
        private Button login;

        @FXML
        private Button logout;

        @FXML
        private Button signUpButton;

        @FXML
        private static ImageView songPhoto;

        @FXML
        private VBox vBox;

        static Audio audio6;
        static boolean audio6IsPlaying = false;

        @FXML
        private static Label musicName;
        private static PlayList playList;

        public static PlayList getPlayList() {
            return playList;
        }

        public static void setPlayList(PlayList playList) {
            AudiosOfPlaylist.playList = playList;
        }

        @FXML
        void audiosButton1(MouseEvent event) throws IOException {
            ChangeScene.audiosScene();
        }

        @FXML
        void playListButton(MouseEvent event) throws IOException {
            ChangeScene.plaListsScene();
        }

        @FXML
        void backTo(MouseEvent event) {
            backTo();
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
                if (!(ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
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
                    throw new RuntimeException(ex);
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

        @FXML
        void homeButton(MouseEvent event) throws IOException {
            ChangeScene.homeScene();
        }

        @FXML
        void signup(MouseEvent event) {
            signup();
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

        @FXML
        void search(MouseEvent event) {
            search();
        }

        @FXML
        void library(MouseEvent event) {
            library();
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

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            vBox = setVBOX(playList);
        }

        public HBox setHBOx(Audio audio) {
            String path1 = Main.class.getResource("61180").toExternalForm();
            Image image1 = new Image(path1);
            ImageView imageView = audio.getAudioPhoto();
            imageView.setFitHeight(40);
            imageView.setFitWidth(40);
            Circle circle = new Circle(20, 20, 20);
            imageView.setClip(circle);
            Label audioName = new Label();
            audioName.setText(audio.getName());
            audioName.setStyle(".label");
            HBox hBox = new HBox(imageView, audioName);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(15);
            hBox.setOnMouseClicked((e) -> {
                audio.getMediaPlayer().play();
                songPhoto = audio.getAudioPhoto();
                musicName.setText(audio.getName());
                playButton.setImage(image1);
                audio6 = audio;
                audio6IsPlaying = true;
                AudiosScene.audio2IsPlaying = false;
                HomeScene.audio1IsPlaying = false;
                ArtistInfoScene.audio3IsPlaying = false;
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

        public VBox setVBOX(PlayList playList) {
            for (Audio audio : playList) {
                vBox.getChildren().add(setHBOx(audio));
            }
            return vBox;
        }


        public void backButton(MouseEvent mouseEvent) {
        }



        @FXML
        void musicName(MouseEvent event) throws IOException {
            ChangeScene.playScene();
        }
        public static void playButton(MouseEvent mouseEvent) {
            String path1 = Main.class.getResource("61180").toExternalForm();
            String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
            Image image1 = new Image(path1);
            Image image2 = new Image(path2);
            if (audio6IsPlaying) {
                if (Objects.equals(playButton.getImage(), image2)) {
                    playButton.setImage(image1);
                    audio6.getMediaPlayer().play();
                    songPhoto.setImage(audio6.getImage());
                    musicName.setText(audio6.getName());
                } else if (Objects.equals(playButton.getImage(), image1)) {
                    playButton.setImage(image2);
                    audio6.getMediaPlayer().pause();
                    songPhoto.setImage(audio6.getImage());
                    musicName.setText(audio6.getName());
                }
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.playButton(mouseEvent);
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.playButton(mouseEvent);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.playButton(mouseEvent);
            }

        }

        public static void previousButton(MouseEvent mouseEvent) {
            int index;
            if (audio6IsPlaying) {
                index = playList.getAudoisList().indexOf(audio6);
                audio6 = playList.getAudoisList().get(--index);
                audio6.getMediaPlayer().play();
                songPhoto.setImage(audio6.getImage());
                musicName.setText(audio6.getName());
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.previousButton(mouseEvent);
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.previousButton(mouseEvent);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.previousButton(mouseEvent);
            }
        }

        public static void nextButton(MouseEvent mouseEvent) {
            int index;
            if (audio6IsPlaying) {
                index = playList.getAudoisList().indexOf(audio6);
                audio6 = playList.getAudoisList().get(++index);
                audio6.getMediaPlayer().play();
                songPhoto.setImage(audio6.getImage());
                musicName.setText(audio6.getName());
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.nextButton(mouseEvent);
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.nextButton(mouseEvent);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.nextButton(mouseEvent);
            }
        }
    }
    public class AudiosScene implements Initializable, GeneralOperation {
        public static Audio audio2;
        public static boolean audio2IsPlaying = false;
        public static AudiosScene audiosScene=new AudiosScene();

        @FXML
        private AnchorPane Anchorpane;

        @FXML
        private Button login;

        @FXML
        private Button logout;

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
        private ImageView nextButton;

        @FXML
        private static ImageView playButton;

        @FXML
        private Button playListButton;

        @FXML
        private ImageView previousButton;

        @FXML
        private ImageView searchButton1;

        @FXML
        private static ImageView songPhoto;

        @FXML
        private VBox vBox;

        @FXML
        private Button signUpButton;

        @FXML
        private static Label musicName;

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
            return nextButton;
        }

        public ImageView getPlayButton() {
            return playButton;
        }

        public Button getPlayListButton() {
            return playListButton;
        }

        public ImageView getPreviousButton() {
            return previousButton;
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
            this.homeButton = homeButton;
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

        public void setVBox(VBox vBox) {
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
        void login(MouseEvent event) {
            login();
        }

        @FXML
        void logout(MouseEvent event) {
            logout();
        }

        @FXML
        void signup(MouseEvent event) {
            signup();
        }


//    @FXML
//   static void nextButton(MouseEvent event) {
//        int index;
//        if (audio2IsPlaying) {
//            index = DataBase.getDataBase().audios.indexOf(audio2);
//            audio2 = DataBase.getDataBase().audios.get(++index);
//            audio2.getMediaPlayer().play();
//            songPhoto.setImage(audio2.getImage());
//            musicName.setText(audio2.getName());
//        } else if (HomeScene.audio1IsPlaying) {
//            HomeScene.nextButton(event);
//        } else if (ArtistInfoScene.audio3IsPlaying) {
//            ArtistInfoScene.nextButton(event);
//        } else if (AudiosOfPlaylist.audio6IsPlaying) {
//            AudiosOfPlaylist.nextButton(event);
//        }
//    }

//    @FXML
//    static void playButton(MouseEvent event) {
//        String path1 = Main.class.getResource("61180").toExternalForm();
//        String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
//        Image image1 = new Image(path1);
//        Image image2 = new Image(path2);
//        if (audio2IsPlaying) {
//            if (Objects.equals(playButton.getImage(), image2)) {
//                playButton.setImage(image1);
//                audio2.getMediaPlayer().play();
//                songPhoto.setImage(audio2.getImage());
//                musicName.setText(audio2.getName());
//            } else if (Objects.equals(playButton.getImage(), image1)) {
//                playButton.setImage(image2);
//                audio2.getMediaPlayer().pause();
//                songPhoto.setImage(audio2.getImage());
//                musicName.setText(audio2.getName());
//            }
//        } else if (HomeScene.audio1IsPlaying) {
//            HomeScene.playButton(event);
//        } else if (ArtistInfoScene.audio3IsPlaying) {
//            ArtistInfoScene.playButton(event);
//        } else if (AudiosOfPlaylist.audio6IsPlaying) {
//            AudiosOfPlaylist.playButton(event);
//        }
//
//    }

        @FXML
        void playListButton(MouseEvent event) throws IOException {
            ChangeScene.plaListsScene();
        }

//    @FXML
//   static void previousButton(MouseEvent event) {
//        int index;
//        if (audio2IsPlaying) {
//            index = DataBase.getDataBase().audios.indexOf(audio2);
//            audio2 = DataBase.getDataBase().audios.get(--index);
//            audio2.getMediaPlayer().play();
//            songPhoto.setImage(audio2.getImage());
//            musicName.setText(audio2.getName());
//        } else if (HomeScene.audio1IsPlaying) {
//            HomeScene.previousButton(event);
//        } else if (ArtistInfoScene.audio3IsPlaying) {
//            ArtistInfoScene.previousButton(event);
//        } else if (AudiosOfPlaylist.audio6IsPlaying) {
//            AudiosOfPlaylist.previousButton(event);
//        }
//    }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            for (Audio audio : DataBase.getDataBase().audios) {
                vBox.getChildren().add(setHBOx(audio));
            }
        }

        @Override
        public void backTo() {
            backButton.setOnMouseClicked((e) -> {
                ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
                ChangeScene.stage.show();
            });

        }

        @Override
        public void logout() {
            logout.setOnMouseClicked((e) -> {
                if (!(ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
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
                }
            });
        }
        @FXML
        void musicName(MouseEvent event) throws IOException {
            ChangeScene.playScene();
        }

        public HBox setHBOx(Audio audio) {
            ImageView imageView = audio.getAudioPhoto();
            String path1 = Main.class.getResource("61180").toExternalForm();
            Image image1 = new Image(path1);
            imageView.setFitHeight(40);
            imageView.setFitWidth(40);
            Circle circle = new Circle(20, 20, 20);
            imageView.setClip(circle);
            Label audioName = new Label();
            audioName.setText(audio.getName());
            audioName.setStyle(".label");
            HBox hBox = new HBox(imageView, audioName);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(15);
            hBox.setOnMouseClicked((e) -> {
                audio.getMediaPlayer().play();
                audio2 = audio;
                songPhoto = audio.getAudioPhoto();
                musicName.setText(audio2.getName());
                playButton.setImage(image1);
                audio2IsPlaying = true;
                HomeScene.audio1IsPlaying = false;
                ArtistInfoScene.audio3IsPlaying = false;
                AudiosOfPlaylist.audio6IsPlaying = false;
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


        @FXML
        void homeButton(MouseEvent event) throws IOException {
            ChangeScene.homeScene();
        }

        @FXML
        void search(MouseEvent event) {
            search();
        }

        @FXML
        void library(MouseEvent event) {
            library();
        }

        @FXML
        void backTo(MouseEvent event) {
            backTo();
        }




        public  void playButton(MouseEvent mouseEvent) {
            String path1 = Main.class.getResource("61180").toExternalForm();
            String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
            Image image1 = new Image(path1);
            Image image2 = new Image(path2);
            if (audio2IsPlaying) {
                if (Objects.equals(playButton.getImage(), image2)) {
                    playButton.setImage(image1);
                    audio2.getMediaPlayer().play();
                    songPhoto.setImage(audio2.getImage());
                    musicName.setText(audio2.getName());
                } else if (Objects.equals(playButton.getImage(), image1)) {
                    playButton.setImage(image2);
                    audio2.getMediaPlayer().pause();
                    songPhoto.setImage(audio2.getImage());
                    musicName.setText(audio2.getName());
                }
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.playButton(mouseEvent);
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.playButton(mouseEvent);
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.playButton(mouseEvent);
            }

        }

        public  void nextButton(MouseEvent mouseEvent) {
            int index;
            if (audio2IsPlaying) {
                index = DataBase.getDataBase().audios.indexOf(audio2);
                audio2 = DataBase.getDataBase().audios.get(++index);
                audio2.getMediaPlayer().play();
                songPhoto.setImage(audio2.getImage());
                musicName.setText(audio2.getName());
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.nextButton(mouseEvent);
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.nextButton(mouseEvent);
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.nextButton(mouseEvent);
            }
        }

        public  void previousButton(MouseEvent mouseEvent) {
            int index;
            if (audio2IsPlaying) {
                index = DataBase.getDataBase().audios.indexOf(audio2);
                audio2 = DataBase.getDataBase().audios.get(--index);
                audio2.getMediaPlayer().play();
                songPhoto.setImage(audio2.getImage());
                musicName.setText(audio2.getName());
            } else if (HomeScene.audio1IsPlaying) {
                HomeScene.previousButton(mouseEvent);
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.previousButton(mouseEvent);
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.previousButton(mouseEvent);
            }
        }
    }
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
    public class HomeScene implements Initializable, GeneralOperation {
        public static Audio audio1;
        public static boolean audio1IsPlaying = false;
        @FXML
        private AnchorPane Anchorpane;

        @FXML
        private VBox vBox;

        @FXML
        private Button artistButton;

        @FXML
        private Button audioButton1;

        @FXML
        private Button backButton;

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
        private static ImageView playButton;

        @FXML
        private Button playListButton;

        @FXML
        private ImageView previousButton;

        @FXML
        private ImageView searchButton1;

        @FXML
        private Button signUpButton;

        @FXML
        private static ImageView songPhoto;

        @FXML
        private static Label musicName;

        @FXML
        private Button login;

        @FXML
        private Button logout;

        public VBox getVBox() {
            return vBox;
        }

        public void setVBox(VBox vBox) {
            this.vBox = vBox;
        }

        public void setAnchorpane(AnchorPane anchorpane) {
            Anchorpane = anchorpane;
        }

        public void setArtistButton(Button artistButton) {
            this.artistButton = artistButton;
        }

        public void setAudioButton1(Button audioButton1) {
            this.audioButton1 = audioButton1;
        }

        public void setBackButton(Button backButton) {
            this.backButton = backButton;
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

        public void setSearchButton1(ImageView searchButton1) {
            this.searchButton1 = searchButton1;
        }

        public void setSignUpButton(Button signUpButton) {
            this.signUpButton = signUpButton;
        }

        public void setSongPhoto(ImageView songPhoto) {
            this.songPhoto = songPhoto;
        }

        public AnchorPane getAnchorpane() {
            return Anchorpane;
        }

        public Button getArtistButton() {
            return artistButton;
        }

        public Button getAudioButton1() {
            return audioButton1;
        }

        public Button getBackButton() {
            return backButton;
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


        public ImageView getNextButton() {
            return nextButton;
        }

        public ImageView getPlayButton() {
            return playButton;
        }

        public Button getPlayListButton() {
            return playListButton;
        }

        public ImageView getPreviousButton() {
            return previousButton;
        }

        public ImageView getSearchButton1() {
            return searchButton1;
        }

        public Button getSignUpButton() {
            return signUpButton;
        }

        public ImageView getSongPhoto() {
            return songPhoto;
        }

        @FXML
        void audioButton1(MouseEvent event) throws IOException {
            ChangeScene.audiosScene();
        }

        @FXML
        void playListButton(MouseEvent event) throws IOException {
            ChangeScene.plaListsScene();
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            if (ListenerController.getListenerController().getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
                for (Audio audio : AdminController.getAdminController().mostPopularAudioFileArray()) {
                    vBox.getChildren().add(fillHBox(audio));
                }
            } else {
                for (Audio audio : ListenerController.getListenerController().getSuggestions()) {
                    vBox.getChildren().add(fillHBox(audio));
                }
            }

        }

        @Override
        public void backTo() {
            backButton.setOnMouseClicked((e) -> {
                ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
//            ChangeScene.stage.show();
            });
        }

        @FXML
        void backTo(MouseEvent event) {
            backTo();
        }


        @Override
        public void logout() {
            logout.setOnMouseClicked((e) -> {
                if (!(ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
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
                if ((ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
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
                }
            });
        }

        @FXML
        void signup(MouseEvent event) {
            signup();
        }

        @Override
        public void signup() {
            signUpButton.setOnMouseClicked((e) -> {
                try {
                    ChangeScene.signUpScene();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    System.out.println("Have a good day");
                }
            });
        }

        @FXML
        public void artistButton(MouseEvent event) throws IOException {
            ChangeScene.artistsScene();
        }

        @FXML
        void musicName(MouseEvent event) throws IOException {
            ChangeScene.playScene();
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

        @FXML
        void search(MouseEvent event) {
            search();
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
        void library(MouseEvent event) {
            library();
        }

        @FXML
        void login(MouseEvent event) {
            login();
        }

        @FXML
        void logout(MouseEvent event) {
            logout();
        }

        public HBox fillHBox(Audio audio) {
            String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
            String path1 = Main.class.getResource("61180").toExternalForm();
            Image image1 = new Image(path1);
            ImageView imageView1 = new ImageView(image1);
            Image image2 = new Image(path2);
            ImageView imageView2 = new ImageView(image2);
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
                songPhoto = audio.getAudioPhoto();
                musicName.setText(audio.getName());
                playButton.setImage(image1);
                audio1 = audio;
                audio1IsPlaying = true;
                AudiosScene.audio2IsPlaying = false;
                ArtistInfoScene.audio3IsPlaying = false;
                AudiosOfPlaylist.audio6IsPlaying = false;
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


        public static void nextButton(MouseEvent mouseEvent) {
            int index;
            audio1.getMediaPlayer().pause();
            if (audio1IsPlaying) {
                if (ListenerController.listenerController.getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
                    index = AdminController.getAdminController().mostPopularAudioFileArray().indexOf(audio1);
                    audio1 = AdminController.getAdminController().mostPopularAudioFileArray().get(++index);
                    audio1.getMediaPlayer().play();
                    songPhoto.setImage(audio1.getImage());
                    musicName.setText(audio1.getName());
                } else {
                    index = ListenerController.getListenerController().getSuggestions().indexOf(audio1);
                    audio1 = ListenerController.getListenerController().getSuggestions().get(++index);
                    audio1.getMediaPlayer().play();
                    songPhoto.setImage(audio1.getImage());
                    musicName.setText(audio1.getName());
                }
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.nextButton(mouseEvent);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.nextButton(mouseEvent);
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.nextButton(mouseEvent);
            }
        }

        public static void previousButton(MouseEvent mouseEvent) {
            int index;
            audio1.getMediaPlayer().pause();
            if (audio1IsPlaying) {
                if (ListenerController.listenerController.getListener() == null && ArtistController.getArtistController().getArtist1() == null && AdminController.getAdminController().getAdmin() == null) {
                    index = AdminController.getAdminController().mostPopularAudioFileArray().indexOf(audio1);
                    audio1 = AdminController.getAdminController().mostPopularAudioFileArray().get(--index);
                    audio1.getMediaPlayer().play();
                    songPhoto.setImage(audio1.getImage());
                    musicName.setText(audio1.getName());
                } else {
                    index = ListenerController.getListenerController().getSuggestions().indexOf(audio1);
                    audio1 = ListenerController.getListenerController().getSuggestions().get(--index);
                    audio1.getMediaPlayer().play();
                    songPhoto.setImage(audio1.getImage());
                    musicName.setText(audio1.getName());
                }
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.previousButton(mouseEvent);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.previousButton(mouseEvent);
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.previousButton(mouseEvent);
            }

        }

        public static void playButton(MouseEvent mouseEvent) {
            String path1 = Main.class.getResource("61180").toExternalForm();
            String path2 = Main.class.getResource("Screenshot_2024-05-12_223937-removebg-preview (2)").toExternalForm();
            Image image1 = new Image(path1);
            Image image2 = new Image(path2);
            if (audio1IsPlaying) {
                if (Objects.equals(playButton.getImage(), image2)) {
                    playButton.setImage(image1);
                    audio1.getMediaPlayer().play();
                    songPhoto.setImage(audio1.getImage());
                    musicName.setText(audio1.getName());
                } else if (Objects.equals(playButton.getImage(), image1)) {
                    playButton.setImage(image2);
                    audio1.getMediaPlayer().pause();
                    songPhoto.setImage(audio1.getImage());
                    musicName.setText(audio1.getName());
                }
            } else if (AudiosOfPlaylist.audio6IsPlaying) {
                AudiosOfPlaylist.playButton(mouseEvent);
            } else if (AudiosScene.audio2IsPlaying) {
                AudiosScene.audiosScene.playButton(mouseEvent);
            } else if (ArtistInfoScene.audio3IsPlaying) {
                ArtistInfoScene.playButton(mouseEvent);
            }


        }

        public void audioButton(MouseEvent mouseEvent) throws IOException {
            ChangeScene.audiosScene();
        }
    }
    public class ListenerPanelScene implements GeneralOperation, Initializable {
        @FXML
        private AnchorPane Anchorpane;

        @FXML
        private VBox VBoxFollowing;

        @FXML
        private Button artistButton;

        @FXML
        private Button artistButton1;

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
        private Label musicName;

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
        private Circle userPhoto;
        @FXML
        private Label nameLabel;

        @FXML
        private Label usernameLabel;

        @FXML
        private ChoiceBox<String> playListChoice;

        @FXML
        private TextField playListNameBox;


        @FXML
        private Button addPlayList;


        @FXML
        private Button backButton;

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
        void addPlayList(MouseEvent event) {
            if(ListenerController.getListenerController().listener instanceof FreeListener){
                playListNameBox.textProperty().addListener((p, o, n) -> {
                    try {
                        FreeListenerController.getFreeListenerController().makePlayList(playListNameBox.getText());
                        playListChoice.getItems().add(playListNameBox.getText());
                    } catch (FreeAccountLimitException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setContentText("You don't have enough free playlists to add playlist");
                    }finally {
                        System.out.println("Have a good day");
                    }
                });
            } else if (ListenerController.getListenerController().listener instanceof Premium) {
                playListNameBox.textProperty().addListener((p, o, n) -> {
                    PremiumController.getPremiumController().makePlayList(playListNameBox.getText());
                    playListChoice.getItems().add(playListNameBox.getText());
                });
            }
        }

        @FXML
        void artistButton1(MouseEvent event) throws IOException {
            ChangeScene.artistsScene();
        }

        @FXML
        void buyButton(MouseEvent event) throws IOException {
            ChangeScene.buyScene();
        }

        @FXML
        void playListButton(MouseEvent event) throws IOException {
            ChangeScene.plaListsScene();
        }

        @Override
        public void backTo() {
            backButton.setOnMouseClicked((e)->{
                ChangeScene.stage.setScene(SceneStack.sceneStack.pop());
            });
        }

        @Override
        public void logout() {
            logout.setOnMouseClicked((e) -> {
                if (!(ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
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
                if ((ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
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
                }
            });
        }

        @Override
        public void signup() throws IOException {
            ChangeScene.signUpScene();
        }

        @Override
        public void search() throws IOException {
            ChangeScene.searchScene();
        }

        public HBox setHBOx(Artist artist) {
            ImageView imageView = artist.getUserPhoto();
            imageView.setFitHeight(40);
            imageView.setFitWidth(40);
            Circle circle = new Circle(20, 20, 20);
            imageView.setClip(circle);
            Label artistName = new Label();
            artistName.setText(artist.getUserName());
            HBox hBox = new HBox(imageView, artistName);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(15);
            return hBox;
        }
        @FXML
        void musicName(MouseEvent event) throws IOException {
            ChangeScene.playScene();
        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            ImageView imageView = new ImageView(ListenerController.getListenerController().listener.getImage());
            imageView.setClip(userPhoto);
            usernameLabel.setText(ListenerController.getListenerController().listener.getUserName());
            nameLabel.setText(ListenerController.getListenerController().listener.getFirstAndLastname());
            for (PlayList play : ListenerController.getListenerController().listener.playLists) {
                playListChoice.getItems().add(play.getName());
                playListChoice.setOnAction((e) -> {
                    for (PlayList play2 : ListenerController.getListenerController().listener.playLists) {
                        if (play2.getName().equals(playListChoice.getSelectionModel().getSelectedItem())) {
                            AudiosOfPlaylist.setPlayList(play2);
                        }
                    }
                    try {
                        ChangeScene.audioOfPlayListScene();
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
            for (User artist : ListenerController.getListenerController().arrayFollowing()) {
                VBoxFollowing.getChildren().add(setHBOx((Artist) artist));
                VBoxFollowing.setOnMouseClicked((e) -> {
                    ArtistInfoScene.setArtist1((Artist) artist);
                    try {
                        ChangeScene.artistInfoScene();
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
    }
    public class PlayListsScene implements Initializable , GeneralOperation {

        @FXML
        private AnchorPane Anchorpane;

        @FXML
        private Button login;

        @FXML
        private Button logout;

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
        private Label musicName;

        @FXML
        private ImageView nextButton;

        @FXML
        private ImageView playButton;

        @FXML
        private Button playListButton;

        @FXML
        private Label playLists;

        @FXML
        private ImageView previousButton;

        @FXML
        private ImageView searchButton1;

        @FXML
        private Button signUpButton;

        @FXML
        private ImageView songPhoto;

        @FXML
        private ImageView songPhoto1;

        @FXML
        private VBox vBox;


        @FXML
        void audiosButton1(MouseEvent event) throws IOException {
            ChangeScene.audiosScene();
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
        void musicName(MouseEvent event) throws IOException {
            ChangeScene.playScene();
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
                if((ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1()==null)) {
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
                }
            });
        }

        @Override
        public void signup() throws IOException {
            ChangeScene.signUpScene();
        }

        @Override
        public void search() throws IOException {
            ChangeScene.searchScene();
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
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            for(PlayList playList:ListenerController.getListenerController().getListener().getPlayLists()) {
                vBox.getChildren().add(setHBOx(playList));
                vBox.setOnMouseClicked((e)->{
                    AudiosOfPlaylist.setPlayList(playList);
                    try {
                        ChangeScene.audioOfPlayListScene();
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
        public HBox setHBOx(PlayList playList) {
            Label playListName = new Label();
            playListName.setText(playList.getName());
            HBox hBox = new HBox(playListName);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(15);
            return hBox;
        }

        public void log(MouseEvent mouseEvent) {
        }

        public void backButton(MouseEvent mouseEvent) {

        }
    }
    public class PlayScene implements  GeneralOperation {
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
            return nextButton;
        }

        public ImageView getPlayButton() {
            return playButton;
        }

        public Button getPlayListButton() {
            return playListButton;
        }

        public ImageView getPreviousButton() {
            return previousButton;
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
                HomeScene.nextButton(event);
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
                AudiosScene.audiosScene.nextButton(event);
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
                ArtistInfoScene.nextButton(event);
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
                AudiosOfPlaylist.nextButton(event);
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
            if (HomeScene.audio1IsPlaying) {
                HomeScene.playButton(event);
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
                AudiosScene.audiosScene.playButton(event);
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
                ArtistInfoScene.playButton(event);
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
                AudiosOfPlaylist.playButton(event);
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
        void playListButton(MouseEvent event) throws IOException {
            ChangeScene.plaListsScene();
        }

        @FXML
        void previousButton(MouseEvent event) {
            if (HomeScene.audio1IsPlaying) {
                HomeScene.previousButton(event);
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
                AudiosScene.audiosScene.previousButton(event);
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
                ArtistInfoScene.previousButton(event);
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
                AudiosOfPlaylist.previousButton(event);
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
                if (!(ListenerController.listenerController.getListener() == null && AdminController.getAdminController().getAdmin() == null && ArtistController.getArtistController().getArtist1() == null)) {
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


    }



