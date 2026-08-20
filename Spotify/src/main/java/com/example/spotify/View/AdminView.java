package com.example.spotify4.View;
import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Model.DataBase;
import com.example.spotify4.Model.User.Artist.Artist;


import java.util.Objects;
import java.util.Scanner;

public class AdminView {
    private static AdminView adminView;

    private AdminView() {
    }

    public static AdminView getAdminView() {
        if (adminView == null)
            adminView = new AdminView();
        return adminView;
    }
    public void adminMenu() {
        System.out.println("1)View the statistics of the most popular audio files(use Statistics) \n2)View the list of audio files and their information if selected(use  Audios) \n3)View the list of artists and their information if selected \n4)View reports(use  Reports)");
        Scanner sc = new Scanner(System.in);
        String command7 = sc.nextLine();
        String[] strCommand7 = command7.split("-");
        if (Objects.equals(strCommand7[0], "Statistics ")) {
            System.out.println(AdminController.getAdminController().mostPopularAudioFile());
        } else if (Objects.equals(strCommand7[0], " Audios ")) {
            for (int i = 0; i < DataBase.getDataBase().audios.size(); i++) {
                System.out.println((i + 1) + DataBase.getDataBase().audios.get(i).getName());
            }
            System.out.println("which audio file information do you want?(use  Audio -[audio’s ID])");
            String command8 = sc.nextLine();
            String[] strCommand8 = command8.split("-");
            System.out.println(AdminController.getAdminController().showAudioInfo(Integer.parseInt(strCommand8[1])));
        }
       else if (Objects.equals(strCommand7[0], "Artists ")) {
            for (int i = 0; i < DataBase.getDataBase().audios.size(); i++) {
                if (DataBase.getDataBase().users.get(i) instanceof Artist) {
                    System.out.println((i + 1) + DataBase.getDataBase().users.get(i).getUserName());
                }
            }
            System.out.println("which audio file information do you want?(use Artist -[username])");
            String command9 = sc.nextLine();
            String[] strCommand9 = command9.split("-");
            System.out.println(AdminController.getAdminController().showArtistInfo(strCommand9[1]));
        } else if (Objects.equals(strCommand7[0], "Reports ")) {
            System.out.println(AdminController.getAdminController().showReports());
        }

    }
}
