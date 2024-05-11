package com.example.spotify4;
import java.util.Objects;
import java.util.Scanner;

import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ArtistController.PodcasterController;
import com.example.spotify4.Controller.ArtistController.SingerController;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Model.*;
import com.example.spotify4.Controller.*;
import com.example.spotify4.Model.User.Admin;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.Listener.Listener;
import com.example.spotify4.Model.User.User;
import com.example.spotify4.View.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stringcommand = new String[1000000];
        while (!Objects.equals(stringcommand[0], "Logout ")) {
            String command = sc.nextLine();
            stringcommand = command.split("[-/,]");
            if (Objects.equals(stringcommand[0], "Signup ")) {
                if (Objects.equals(stringcommand[1], "L ")) {
                    System.out.println(ListenerController.getListenerController().signUp(stringcommand[2], stringcommand[3], stringcommand[4], stringcommand[5], stringcommand[6], Integer.parseInt(stringcommand[7]), Integer.parseInt(stringcommand[8]), Integer.parseInt(stringcommand[9]), stringcommand[10]));
                    System.out.println(ListenerController.getListenerController().genre());
                    System.out.println("choose your favorite genre");
                } else if (Objects.equals(stringcommand[1], "S ")) {
                    System.out.println(SingerController.getSingerController().signUp(stringcommand[2], stringcommand[3], stringcommand[4], stringcommand[5], stringcommand[6], Integer.parseInt(stringcommand[7]), Integer.parseInt(stringcommand[8]), Integer.parseInt(stringcommand[9]), stringcommand[10]));
                } else if (Objects.equals(stringcommand[1], "P ")) {
                    System.out.println(PodcasterController.getPodcasterController().signUp(stringcommand[2], stringcommand[3], stringcommand[4], stringcommand[5], stringcommand[6], Integer.parseInt(stringcommand[7]), Integer.parseInt(stringcommand[8]), Integer.parseInt(stringcommand[9]), stringcommand[10]));
                } else {
                    System.out.println(AdminController.adminController.signUp(stringcommand[2], stringcommand[3], stringcommand[4], stringcommand[5], stringcommand[6], Integer.parseInt(stringcommand[7]), Integer.parseInt(stringcommand[8]), Integer.parseInt(stringcommand[9]), stringcommand[10]));
                }
            } else if (Objects.equals(stringcommand[0], "FavoriteGenres ")) {
                ListenerController.getListenerController().favoriteGenre(stringcommand[1], stringcommand[2], stringcommand[3], stringcommand[4]);
            } else if (Objects.equals(stringcommand[0], "Login ")) {
                for (User user1 : DataBase.getDataBase().users) {
                    if (Objects.equals(stringcommand[1], user1.getUserName())) {
                        if (user1 instanceof Listener) {
                            System.out.println(ListenerController.getListenerController().logIn(stringcommand[1],stringcommand[2]));
                            ListenerView.getListenerView().listenerMenu();
                        } else if (user1 instanceof Artist) {
                            System.out.println(ArtistController.getArtistController().logIn(stringcommand[1],stringcommand[2]));
                            ArtistView.getArtistView().ArtistMenu();
                        } else if (user1 instanceof Admin) {
                            System.out.println(AdminController.getAdminController().logIn(stringcommand[1],stringcommand[2]));
                            AdminView.getAdminView().adminMenu();
                        }
                    }
                }
            }

        }
        System.out.println("finish");
    }
}