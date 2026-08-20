package com.example.spotify4.View;
import com.example.spotify4.Controller.ArtistController.ArtistController;
import com.example.spotify4.Controller.ArtistController.PodcasterController;
import com.example.spotify4.Controller.ArtistController.SingerController;
import com.example.spotify4.Model.User.Artist.Podcaster;
import com.example.spotify4.Model.User.Artist.Singer;


import java.util.Objects;
import java.util.Scanner;

public class ArtistView {
    private static ArtistView artistView;

    private ArtistView() {
    }

    public static ArtistView getArtistView() {
        if (artistView == null)
            artistView = new ArtistView();
        return artistView;
    }

    public void ArtistMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("1)View followers(use Followers) \n2)Viewing the amount of plays of the works(use ViewsStatistics) \n3)Income calculation(use CalculateEarnings) \n4)View user account information(use AccountInfo) \n5)create an album for singer(use NewAlbum -[name]) \n6)Publish a podcast or song(use Publish -M|P -[title] -[genre] -[lyric|caption] -[link] -[cover] -[album ID ])");
        Scanner sc = new Scanner(System.in);
        String command10 = sc.nextLine();
        String[] strCommand10 = command10.split("-");
        if (Objects.equals(strCommand10[0], "Followers ")) {
            System.out.println(ArtistController.getArtistController().showFollowers());
        } else if (Objects.equals(strCommand10[0], "ViewsStatistics ")) {
            System.out.println(ArtistController.getArtistController().numberOfPlay());
        } else if (Objects.equals(strCommand10[0], "CalculateEarnings ")) {
            if (ArtistController.getArtistController().getArtist1() instanceof Singer) {
                System.out.println(SingerController.getSingerController().calculateIncome());
            } else if (ArtistController.getArtistController().getArtist1() instanceof Podcaster) {
                System.out.println(PodcasterController.getPodcasterController().calculateIncome());
            }
        } else if (Objects.equals(strCommand10[0], "AccountInfo ")) {
            System.out.println(ArtistController.getArtistController().showArtistInfo());
        } else if (Objects.equals(strCommand10[0], "NewAlbum ")) {
            if (ArtistController.getArtistController().getArtist1() instanceof Singer) {
                System.out.println("Album ID:");
                System.out.println(SingerController.getSingerController().makeAlbum(strCommand10[1]).getID());
            }
        } else if (Objects.equals(strCommand10[0], "Publish ")) {
            if (Objects.equals(strCommand10[1], "M ")) {
                System.out.println("Music ID:");
                System.out.println(SingerController.getSingerController().publishMusic(strCommand10[2], strCommand10[3], strCommand10[4], strCommand10[5], strCommand10[6], Integer.parseInt(strCommand10[7]),strCommand10[8]));
            } else if (Objects.equals(strCommand10[1], "P ")) {
                PodcasterController.getPodcasterController().publishPodcast(strCommand10[2], strCommand10[3], strCommand10[4], strCommand10[5], strCommand10[6],strCommand10[7]);
            }
        }
    }
}
