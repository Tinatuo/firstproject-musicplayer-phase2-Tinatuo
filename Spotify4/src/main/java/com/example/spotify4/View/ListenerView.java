package com.example.spotify4.View;



import com.example.spotify4.Controller.ListenerController.FreeListenerController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Controller.ListenerController.PremiumController;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.Audio.Music;
import com.example.spotify4.Model.DataBase;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.Listener.FreeListener;
import com.example.spotify4.Model.User.Listener.Premium;
import com.example.spotify4.Model.User.User;

import java.util.Objects;
import java.util.Scanner;

public class ListenerView {
    private static ListenerView listenerView=new ListenerView();

    private ListenerView() {
    }

    public static ListenerView getListenerView() {
        if (listenerView == null)
            listenerView = new ListenerView();
        return listenerView;
    }

    Scanner sc = new Scanner(System.in);

    public void listenerMenu() {
        System.out.println("1)View suggested audio files(Use  [GetSuggestions]) \n2)Viewing artists(Use [Artists]) \n3)Search, sort and filter audio files(Use [Search -[artist name OR audio’s title]] or Sort -L|P or  Filter -A|G|D -[filter by]) \n4)Library section \n5)View user account information(Use  AccountInfo)");
        String command1 = sc.nextLine();
        String[] strCommand1 = command1.split("-");
        if (Objects.equals(strCommand1[0], "GetSuggestions ")) {
            System.out.println(ListenerController.getListenerController().getSuggestions());
        } else if (Objects.equals(strCommand1[0], "Artists ")) {
            artistList();
            selectArtist();
        } else if (Objects.equals(strCommand1[0], "Search ") || Objects.equals(strCommand1[0], "Sort ") || Objects.equals(strCommand1[0], "Filter ")) {
            searchSortFilter(strCommand1[0], strCommand1[1], strCommand1[2], strCommand1[3]);
        } else if (Objects.equals(strCommand1[0], "ShowPlaylists ") || Objects.equals(strCommand1[0], "NewPlaylist ") || Objects.equals(strCommand1[0], "Add ") || Objects.equals(strCommand1[0], "Followings ")) {
            library(strCommand1);
        } else if (Objects.equals(strCommand1[0], "AccountInfo ")) {
             ListenerController.getListenerController().showUserInfo();
        }
    }

    public void searchSortFilter(String string1, String string2, String string3, String string4) {
        if (Objects.equals(string1, "Search ")) {
            ListenerController.getListenerController().searchAudio(string2);
            System.out.println(ListenerController.getListenerController().searchAudio(string2).toString());
        } else if (Objects.equals(string1, "Sort ")) {
            for (Audio audio : ListenerController.getListenerController().sort(string2)) {
                System.out.println(audio.getName());
            }
        } else if (Objects.equals(string1, "Filter ")) {
            for (Audio audio : ListenerController.getListenerController().filter(string2, string3)) {
                System.out.println(audio.getName());
            }
        }
        System.out.println("------------------------------------------------");
        System.out.println("1)Add audio file to playlist \n2)Select the audio file to play");
        String command2 = sc.nextLine();
        String[] strCommand2 = command2.split("-");
        if (Objects.equals(strCommand2[0], "Add ")) {
            ListenerController.getListenerController().addAudioToPlayList(string2, Integer.parseInt(string3));
        } else if (Objects.equals(strCommand2[0], "Play ")) {
            ListenerController.getListenerController().playAudio(Integer.parseInt(strCommand2[1]));
            System.out.println("you can: \n1)like the Audio \n2)see the lyric");
            String command3 = sc.nextLine();
            String[] strCommand3 = command3.split("-");
            if (Objects.equals(strCommand3[0], "Like ")) {
                ListenerController.getListenerController().likeAudio(Integer.valueOf(string1));
            } else if (Objects.equals(strCommand3[0], "Lyric ")) {
                for (Audio audio : DataBase.getDataBase().audios) {
                    if (audio.getID() == Integer.valueOf(strCommand3[1])) {
                        if (audio instanceof Music) {
                            System.out.println(((Music) audio).getLyric());
                        }
                    }
                }
            }

        }
    }

    public void library(String[] strCommand1) {
        System.out.println("----------------------------------");
        System.out.println("1)Show Playlist(use ShowPlaylists) \n2)Creat Playlist(use NewPlaylist -[playlist’s name]) \n3)add audio in playlist(use Add -[playlist’s name] -[audio’s ID]) \n4)Show followings \n5)Show user information(AccountInfo)");
        if (Objects.equals(strCommand1[0], "ShowPlaylists ")) {
            System.out.println(ListenerController.getListenerController().showPlayLists());
            System.out.println("Select the audio file to play");
            String command4 = sc.nextLine();
            String[] strCommand4 = command4.split("-");
            ListenerController.getListenerController().playAudio(Integer.parseInt(strCommand4[1]));
            System.out.println("you can: \n1)like the Audio \n2)see the lyric");
            String command5 = sc.nextLine();
            String[] strCommand5 = command5.split("-");
            if (Objects.equals(strCommand5[0], "Like ")) {
                ListenerController.getListenerController().likeAudio(Integer.parseInt(strCommand5[1]));
            } else if (Objects.equals(strCommand5[0], "Lyric ")) {
                for (Audio audio : DataBase.getDataBase().audios) {
                    if (audio.getID() == Integer.parseInt(strCommand5[1])) {
                        if (audio instanceof Music) {
                            System.out.println(((Music) audio).getLyric());
                        }
                    }
                }
            }
        } else if (Objects.equals(strCommand1[0], "NewPlaylist ")) {
            if (ListenerController.getListenerController().listener instanceof Premium) {
                PremiumController.getPremiumController().makePlayList(strCommand1[1]);
            } else if (ListenerController.getListenerController().listener instanceof FreeListener) {
                FreeListenerController.getFreeListenerController().makePlayList(strCommand1[1]);
            }
        } else if (Objects.equals(strCommand1[0], "Add ")) {
            if (ListenerController.getListenerController().listener instanceof Premium) {
                PremiumController.getPremiumController().addAudioToPlayList(strCommand1[1], Integer.valueOf(strCommand1[2]));
            } else if (ListenerController.getListenerController().listener instanceof FreeListener) {
                FreeListenerController.getFreeListenerController().addAudioToPlayList(strCommand1[1], Integer.valueOf(strCommand1[2]));
            }
        } else if (Objects.equals(strCommand1[0], "Followings ")) {
            System.out.println(ListenerController.getListenerController().showFollowing());
            System.out.println("reort artist(use Report -[artist’s username] -[explanation])");
            String command6 = sc.nextLine();
            String[] strCommand6 = command6.split("-");
            if (Objects.equals(strCommand6[0], "Report ")) {
                ListenerController.getListenerController().artistReport(strCommand6[1], strCommand6[2]);
            }
        } else if (Objects.equals(strCommand1[0], "AccountInfo ")) {
            if (ListenerController.getListenerController().listener instanceof FreeListener) {
                System.out.println(((FreeListener) ListenerController.getListenerController().listener).toString());
            } else if (ListenerController.getListenerController().listener instanceof Premium) {
                System.out.println(((Premium) ListenerController.getListenerController().listener).toString());
            }
            System.out.println("1)Increase user account credit(use IncreaseCredit -[value]) \n2)Purchase or renew subscription(use GetPremium -[package])");
            String command7 = sc.nextLine();
            String[] strCommand7 = command7.split("-");
            if (ListenerController.getListenerController().listener instanceof FreeListener) {
                if (Objects.equals(strCommand7[0], "IncreaseCredit ")) {
                    FreeListenerController.getFreeListenerController().increaseCredit(Double.valueOf(strCommand7[1]));
                } else if (Objects.equals(strCommand7[0], "GetPremium ")) {
                    FreeListenerController.getFreeListenerController().purchaseOrRenewSubscription(strCommand7[1]);
                }
            } else if (ListenerController.getListenerController().listener instanceof Premium) {
                if (Objects.equals(strCommand7[0], "IncreaseCredit ")) {
                    PremiumController.getPremiumController().increaseCredit(Double.parseDouble(strCommand7[1]));
                } else if (Objects.equals(strCommand7[0], "GetPremium ")) {
                    PremiumController.getPremiumController().purchaseOrRenewSubscription(strCommand7[1]);
                }
            }
        }
    }

    public void artistList() {
        System.out.println("Artists:");
        for (User user1 : DataBase.getDataBase().users) {
            if (user1 instanceof Artist) {
                System.out.println(user1.getUserName());
            }
        }
    }

    public void selectArtist() {
        System.out.println("1)Show information about the artist and her works(use Artist -[username]) \n2)Follow the artist(use Follow -[username])");
        String command11 = sc.nextLine();
        String[] strCommand11 = command11.split("-");
        if (Objects.equals(strCommand11[0], "Artist ")) {
            ListenerController.getListenerController().artistInfo(strCommand11[1]);
        } else if (Objects.equals(strCommand11[0], "Follow ")) {
            for (User user2 : DataBase.getDataBase().users) {
                if (Objects.equals(user2.getUserName(), strCommand11[1])) {
                  if(user2 instanceof Artist){
                      ((Artist) user2).followers.add(ListenerController.getListenerController().listener);
                  }
                }
            }
        }
    }
}

