package com.example.spotify4.Controller.ListenerController;

import com.example.spotify4.Controller.*;
import com.example.spotify4.Controller.Exception.*;
import com.example.spotify4.Model.*;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.Audio.Music;
import com.example.spotify4.Model.Audio.Podcast;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.Listener.FreeListener;
import com.example.spotify4.Model.User.Listener.Listener;
import com.example.spotify4.Model.User.Listener.Premium;
import com.example.spotify4.Model.User.User;
import javafx.scene.control.Alert;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListenerController extends UserController {
    public Listener listener;
    private static ListenerController listenerController;
    public Date date = new Date();
    public int index;
    private ArrayList<Genre> favGenre = new ArrayList<Genre>();

    public static ListenerController getListenerController() {
        if (listenerController == null)
            listenerController = new ListenerController();
        return listenerController;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public ListenerController() {
    }

    public Listener getListener() {
        return this.listener;
    }

    public String signUp(String userName, String password, String firstAndLastname, String email, String phoneNumber, int year, int mounth, int day, String biography,String link) throws WrongPasswordException, InvalidFormatException {
        Date endDate = new Date(this.date.getYear(), this.date.getMonth() + 1, this.date.getDay());
        boolean flag = true;
        String string = null;
        Pattern pattern1 = Pattern.compile(User.regexPassword);
        Matcher matcher1 = pattern1.matcher(password);
        Pattern pattern2 = Pattern.compile(User.regexEmail);
        Matcher matcher2 = pattern2.matcher(email);
        Pattern pattern3 = Pattern.compile(User.phoneNumberRegex);
        Matcher matcher3 = pattern3.matcher(phoneNumber);
        for (User userUserName : DataBase.getDataBase().users) {
            if (Objects.equals(userUserName.getUserName(), userName)) {
                flag = false;
                string = "Duplicate Username";
                break;
            } else {
                flag = true;
            }
        }
        if (flag) {
            if ((matcher1.matches() && matcher2.matches()) && matcher3.matches()) {
                double accountCredit = 50;
                FreeListener newListener = new FreeListener(accountCredit, date.getYear(), date.getMonth() + 1, date.getDay(), favGenre, userName, password, firstAndLastname, phoneNumber, year, mounth, day, email,link);
                DataBase.getDataBase().users.add(newListener);
                this.index = DataBase.getDataBase().users.indexOf(newListener);
                string = "the registration operation was successful";
            } else if (!matcher1.matches()) {
                throw new WrongPasswordException();
            } else if (!matcher2.matches()) {
                throw new InvalidFormatException();
            } else if (!matcher3.matches()) {
                throw new InvalidFormatException();
            }
        }

        return string;
    }

    public String genre() {
        String string = "Genre: ";
        for (int i = 0; i < Genre.values().length; i++) {
            string += "\n" + String.valueOf(i + 1) + "-" + Genre.values()[i];
        }
        return string;
    }

    public ArrayList<Genre> favoriteGenre(String genre1Name, String genre2Name, String genre3Name, String genre4Name) {
//if you want choose less than 4 Genre you should put null
        ArrayList<Genre> favoriteGenre1 = new ArrayList<Genre>();
        for (Genre genre : Genre.values()) {
            if (genre.name().equals(genre1Name)) {
                favoriteGenre1.add(genre);
            } else if (genre.name().equals(genre2Name)) {
                favoriteGenre1.add(genre);
            } else if (genre.name().equals(genre3Name)) {
                favoriteGenre1.add(genre);
            } else if (genre.name().equals(genre4Name)) {
                favoriteGenre1.add(genre);
            }
        }

        favGenre = favoriteGenre1;
        return favoriteGenre1;
    }

    public boolean logIn(String userName, String password) throws UserNotFoundException {
        boolean flag=false;
        for (User user : DataBase.getDataBase().users) {
            if (user instanceof Listener) {
                if (Objects.equals(((Listener) user).getUserName(), userName) && Objects.equals(((Listener) user).getPassword(), password)) {
                    this.listener = ((Listener) user);
                    this.listener.setFavoriteGenre(favGenre);
                    flag=true;
                } else {
                    flag=false;
                    throw new UserNotFoundException();
                }
            }
        }
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("you logged in");
        alert.show();
        return flag;
    }

    public void makePlayList(String playListName) throws FreeAccountLimitException {

    }

    public void addAudioToPlayList(String playListName, int ID) throws FreeAccountLimitException {

    }

    public void playAudio(int ID) {
        for (int i = 0; i < DataBase.getDataBase().audios.size(); i++) {
            if (DataBase.getDataBase().audios.get(i).getID() == ID) {
                long l = DataBase.getDataBase().audios.get(i).getNumberOfPlay();
                DataBase.getDataBase().audios.get(i).setNumberOfPlay(l++);
                listener.numberOfPlayingAudio.putIfAbsent(DataBase.getDataBase().audios.get(i), 0);
                int p = listener.numberOfPlayingAudio.get(DataBase.getDataBase().audios.get(i));
                listener.numberOfPlayingAudio.put(DataBase.getDataBase().audios.get(i), p++);
            }
        }
    }

    public ArrayList<Audio> likeAudio(int ID) {
        for (int i = 0; i < DataBase.getDataBase().audios.size(); i++) {
            if (DataBase.getDataBase().audios.get(i).getID() == ID) {
                long l = DataBase.getDataBase().audios.get(i).getNumberOfLike();
                DataBase.getDataBase().audios.get(i).setNumberOfLike(l++);
            }
        }
        return DataBase.getDataBase().audios;
    }

    public ArrayList<Audio> searchAudio(String artistOrAudioName) {
        ArrayList<Audio> audioFiles = new ArrayList<Audio>();
        for (User users : DataBase.getDataBase().users) {
            if (users instanceof Artist) {
                if (Objects.equals(users.getUserName(), artistOrAudioName)) {
                    for (Audio audio : DataBase.getDataBase().audios) {
                        if (Objects.equals(audio.getArtistName(), artistOrAudioName)) {
                            audioFiles.add(audio);
                        }
                    }
                }
            }
        }
        for (Audio audio1 : DataBase.getDataBase().audios) {
            if (Objects.equals(audio1.getName(), artistOrAudioName)) {
                audioFiles.add(audio1);
            }
        }
        return audioFiles;
    }

    public ArrayList<Audio> sort(String sortingMethod) {
        Audio audio;
        if (Objects.equals(sortingMethod, "L")) {
            for (int i = 0; i < DataBase.getDataBase().audios.size() - 1; i++) {
                for (int k = 1; k < DataBase.getDataBase().audios.size(); k++) {
                    if (DataBase.getDataBase().audios.get(i).getNumberOfLike() < DataBase.getDataBase().audios.get(k).getNumberOfLike()) {
                        audio = DataBase.getDataBase().audios.get(i);
                        DataBase.getDataBase().audios.set(i, DataBase.getDataBase().audios.get(k));
                        DataBase.getDataBase().audios.set(k, audio);
                    }
                }
            }
        }
        if (Objects.equals(sortingMethod, "P")) {
            for (int j = 0; j < DataBase.getDataBase().audios.size() - 1; j++) {
                for (int p = 1; p < DataBase.getDataBase().audios.size(); p++) {
                    if (DataBase.getDataBase().audios.get(j).getNumberOfPlay() < DataBase.getDataBase().audios.get(p).getNumberOfPlay()) {
                        audio = DataBase.getDataBase().audios.get(j);
                        DataBase.getDataBase().audios.set(j, DataBase.getDataBase().audios.get(p));
                        DataBase.getDataBase().audios.set(p, audio);
                    }
                }
            }
        }
        return DataBase.getDataBase().audios;
    }
    public ArrayList<Audio> sort2(ArrayList<Audio> audios){
        Collections.sort(audios);
 //   } {
//            @Override
//            public int compare(Audio o1, Audio o2) {
//                for (int i = 0; i < o2.getName().length(); i++) {
//                    if (o1.getName().charAt(i) > o2.getName().charAt(i)) {
//                        return 1;
//                    } else if (o1.getName().charAt(i) <o2.getName().charAt(i)) {
//                        return -1;
//                    } else if (o1.getName().charAt(i) == o2.getName().charAt(i)) {
//                        if (o1.getNumberOfLike()> o2.getNumberOfLike()) {
//                            return 1;
//                        } else if (o1.getNumberOfLike() < o2.getNumberOfLike()) {
//                            return -1;
//                        } else if (o1.getNumberOfLike() == o2.getNumberOfLike()) {
//                            if ((o2 instanceof Podcast) && (o1 instanceof Music)) {
//                                return 1;
//                            } else if ((o2 instanceof Music) && (o1 instanceof Podcast)) {
//                                return -1;
//                            } else {
//                                if (o1.getNumberOfPlay() > o2.getNumberOfPlay()) {
//                                    return 1;
//                                } else if (o2.getNumberOfPlay() > o1.getNumberOfPlay()) {
//                                    return -1;
//                                } else if (o1.getNumberOfPlay() == o2.getNumberOfPlay()) {
//                                    return 0;
//                                }
//                            }
//                        }
//                    }
//            }
//                return 0;
//        }
//    });
    return audios;
    }

    public ArrayList<Audio> filter(String filteringMethod, Object obj) {
        ArrayList<Audio> audio = new ArrayList<>();
        if (Objects.equals(filteringMethod, "A")) {
            for (Audio audios : DataBase.getDataBase().audios) {
                if (audios.getArtistName().equals(obj)) {
                    audio.add(audios);
                }
            }
        } else if (Objects.equals(filteringMethod, "G")) {
            for (Audio audio1 : DataBase.getDataBase().audios) {
                if (audio1.getGenre().name().equals(obj)) {
                    audio.add(audio1);
                }
            }
        }
        return audio;
    }

    public String showFollowing() {
        String string = "followings:";
        for (User user : DataBase.getDataBase().users) {
            if (user instanceof Artist) {
                for (User user1 : ((Artist) user).followers) {
                    if (Objects.equals(user1.getUserName(), this.listener.getUserName())) {
                        string += "\n" + user1.getUserName();
                    }
                }
            }
        }
        return string;
    }
public ArrayList<User> arrayFollowing(){
        ArrayList<User> arrayFollowing = new ArrayList<>();
    for (User user : DataBase.getDataBase().users) {
        if (user instanceof Artist) {
            for (User user1 : ((Artist) user).followers) {
                if (Objects.equals(user1.getUserName(), this.listener.getUserName())) {
                    arrayFollowing.add(user1);
                }
            }
        }
    }
    return arrayFollowing;
}
    public Report artistReport(String artistUserName, String explanation) {
        Report report1 = null;
        for (User user : DataBase.getDataBase().users) {
            if (user instanceof Artist) {
                if (((Artist) user).getUserName() == artistUserName) {
                    Report report = new Report(this.listener, ((Artist) user), explanation);
                    return report;
                }
            }
        }
        return report1;
    }

    public String listOfArtist() {
        String string = "";
        for (User user : DataBase.getDataBase().users) {
            if (user instanceof Artist) {
                string += "\n" + ((Artist) user).getUserName();
            }
        }
        return string;
    }

    public String artistInfo(String userName) {
        String string = "";
        for (User user : DataBase.getDataBase().users) {
            if (user instanceof Artist) {
                if (((Artist) user).getUserName() == userName) {

                    string = "First and lastName: " + ((Artist) user).getFirstAndLastname() + "\nUsername: " + ((Artist) user).getUserName() + "\nBiography: " + ((Artist) user).getBiography() + "\nArtist works: ";
                    for (Audio audio : DataBase.getDataBase().audios) {
                        if (Objects.equals(audio.getArtistName(), ((Artist) user).getUserName())) {
                            string += "\n" + audio.getName();
                        }
                    }
                }
            }
        }
        return string;
    }

    public String showPlayLists() {
        String string = "Playlist:";
        for (int j = 0; j < this.listener.playLists.size(); j++) {
            string += "\n" + j + this.listener.playLists.get(j);
        }
        return string;
    }

    public int indexOfPlayList(String playListName) {
        int index = 0;
        for (int i = 0; i < this.listener.playLists.size(); i++) {
            if (this.listener.playLists.get(i).getName().equals(playListName)) {
                index = i;
            }
        }
        return index;
    }


    public String inSideOfPlayList(String playListName) {
        String string = "Audios:";
        for (PlayList playList : this.listener.playLists) {
            if (playListName == playList.getName()) {
                for (Audio audio : playList.getAudoisList()) {
                    string += "\n" + audio.getName();
                }
            }
        }
        return string;
    }

    public String showUserInfo() {
        String string = "UserName: " + this.listener.getUserName() + "\nfirstname and lastname: " + this.listener.getFirstAndLastname() + "\nphone number: " + this.listener.getPhoneNumber() + "\nEmail: " + this.listener.getEmail() + "\nBirth date: " + this.listener.getBirthDate() + "\nAccount credit: " + this.listener.getAccountCredit();
        return string;
    }

    public Listener purchaseOrRenewSubscription(String package1) throws LackOfCredit {
        Premium premium = null;
        return premium;
    }

    public void increaseCredit(double value) {

    }

    public String showPackages() {
        String string = "Packages: ";
        for (PackageType package1 : PackageType.values()) {
            string += "\n" + package1;
        }
        return string;
    }

    public ArrayList<Audio> getSuggestions() {
        String string = "Suggestions: ";
        ArrayList<Audio> suggestAudio = new ArrayList<>();
        for (Audio audios : DataBase.getDataBase().audios) {
            for (Genre genre : favGenre) {
                if (audios.getGenre() == genre) {
                    suggestAudio.add(audios);
                }
            }
        }
        for (User user : DataBase.getDataBase().users) {
            if (user instanceof Artist) {
                for (User listener1 : ((Artist) user).followers) {
                    if (Objects.equals(listener1.getUserName(), this.listener.getUserName())) {
                        for (Audio audio : DataBase.getDataBase().audios) {
                            if (Objects.equals(audio.getArtistName(), ((Artist) user).getUserName())) {
//                                    for (int i =5; i > 0; i--) {
                                for (int j = 0; j < 5; j++) {
                                    for (Audio audio1Tekrar : suggestAudio) {
                                        if (audio1Tekrar != likeAudio(audio.getID()).get(j))
                                            suggestAudio.add(likeAudio(audio.getID()).get(j));
                                    }
                                    //  }
                                }
                            }
                        }
                    }
                }
            } else {
                continue;
            }
        }
//            for (int k = 0; k < 10; k++) {
//                string += "\n" + suggestAudio.get(k).getName();
//            }
        return suggestAudio;
//        return string;
    }


}
