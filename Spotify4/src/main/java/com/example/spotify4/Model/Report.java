package com.example.spotify4.Model;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.User;


public class Report {
    private User reporterUser;
    private Artist reportedArtist;
    private String description;

    public Report(User reporterUser, Artist reportedArtist, String description) {
        this.reporterUser = reporterUser;
        this.reportedArtist = reportedArtist;
        this.description = description;
    }

    public void setReporterUser(User reporterUser) {
        this.reporterUser = reporterUser;
    }

    public void setReportedArtist(Artist reportedArtist) {
        this.reportedArtist = reportedArtist;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getReporterUser() {
        return reporterUser;
    }

    public Artist getReportedArtist() {
        return reportedArtist;
    }

    public String getDescription() {
        return description;
    }
public String toString(){
        String string="";
        string="reporter's name: "+reporterUser.getUserName()+"\nreported artist's name: "+reportedArtist+"\nreport description: "+description;
        return string;
}
}

