package com.example.spotify4.View;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ArtistController.PodcasterController;
import com.example.spotify4.Controller.ArtistController.SingerController;
import com.example.spotify4.Controller.Exception.InvalidFormatException;
import com.example.spotify4.Controller.Exception.UserNotFoundException;
import com.example.spotify4.Controller.Exception.WrongPasswordException;
import com.example.spotify4.Controller.ListenerController.ListenerController;
import com.example.spotify4.Model.DataBase;
import com.example.spotify4.Model.User.Admin;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.Listener.Listener;
import com.example.spotify4.Model.User.User;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class MainView {
    public static void mainList()
    {
        Scanner sc = new Scanner(System.in);
        String[] stringcommand = new String[1000000];
        while (!Objects.equals(stringcommand[0], "Logout ")) {
            String command = sc.nextLine();
            stringcommand = command.split("[-/,]");
            if (Objects.equals(stringcommand[0], "Signup ")) {
                if (Objects.equals(stringcommand[1], "L ")) {
                    try {
                        System.out.println(ListenerController.getListenerController().signUp(stringcommand[2], stringcommand[3], stringcommand[4], stringcommand[5], stringcommand[6], Integer.parseInt(stringcommand[7]), Integer.parseInt(stringcommand[8]), Integer.parseInt(stringcommand[9]), stringcommand[10]));
                    } catch (InvalidFormatException | WrongPasswordException | InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(ListenerController.getListenerController().genre());
                    System.out.println("choose your favorite genre");
                } else if (Objects.equals(stringcommand[1], "S ")) {
                    try {
                        System.out.println(SingerController.getSingerController().signUp(stringcommand[2], stringcommand[3], stringcommand[4], stringcommand[5], stringcommand[6], Integer.parseInt(stringcommand[7]), Integer.parseInt(stringcommand[8]), Integer.parseInt(stringcommand[9]), stringcommand[10]));
                    } catch (InvalidFormatException | WrongPasswordException | InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (Objects.equals(stringcommand[1], "P ")) {
                    try {
                        System.out.println(PodcasterController.getPodcasterController().signUp(stringcommand[2], stringcommand[3], stringcommand[4], stringcommand[5], stringcommand[6], Integer.parseInt(stringcommand[7]), Integer.parseInt(stringcommand[8]), Integer.parseInt(stringcommand[9]), stringcommand[10]));
                    } catch (InvalidFormatException | WrongPasswordException | InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println(AdminController.adminController.signUp(stringcommand[2], stringcommand[3], stringcommand[4], stringcommand[5], stringcommand[6], Integer.parseInt(stringcommand[7]), Integer.parseInt(stringcommand[8]), Integer.parseInt(stringcommand[9]), stringcommand[10]));
                }
            } else if (Objects.equals(stringcommand[0], "FavoriteGenres ")) {
                ListenerController.getListenerController().favoriteGenre(stringcommand[1], stringcommand[2], stringcommand[3], stringcommand[4]);
            } else if (Objects.equals(stringcommand[0], "Login ")) {
                for (User user1 : DataBase.getDataBase().users) {
                    if (Objects.equals(stringcommand[1], user1.getUserName())) {
                        if (user1 instanceof Listener) {
                            try {
                                System.out.println(ListenerController.getListenerController().logIn(stringcommand[1], stringcommand[2]));
                            } catch (UserNotFoundException | InputMismatchException e) {
                                System.out.println(e.getMessage());
                            }
                            ListenerView.getListenerView().listenerMenu();
                        } else if (user1 instanceof Artist) {
                            try {
                                System.out.println(ArtistController.getArtistController().logIn(stringcommand[1], stringcommand[2]));
                            } catch (UserNotFoundException | InputMismatchException e) {
                                System.out.println(e.getMessage());
                            }
                            ArtistView.getArtistView().ArtistMenu();
                        } else if (user1 instanceof Admin) {
                            try {
                                System.out.println(AdminController.getAdminController().logIn(stringcommand[1], stringcommand[2]));
                            } catch (UserNotFoundException | InputMismatchException e) {
                                System.out.println(e.getMessage());
                            }
                            AdminView.getAdminView().adminMenu();
                        }
                    }
                }
            }

        }
        System.out.println("finish");
    }
}
