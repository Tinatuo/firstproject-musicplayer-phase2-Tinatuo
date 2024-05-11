package com.example.spotify4.Controller.ListenerController;

import com.example.spotify4.Model.*;
import com.example.spotify4.Model.Audio.Audio;
import com.example.spotify4.Model.User.Listener.FreeListener;
import com.example.spotify4.Model.User.Listener.Listener;
import com.example.spotify4.Model.User.Listener.Premium;

import java.util.Objects;

public class PremiumController extends ListenerController {
    public static PremiumController premiumController;
    public static PremiumController getPremiumController() {
        if (premiumController == null)
            premiumController = new PremiumController();
        return premiumController;
    }

    @Override
    public void makePlayList(String playListName) {
        PlayList newPlay=new PlayList(playListName,getListener().getUserName());
        getListener().playLists.add(newPlay);
    }

    @Override
    public void addAudioToPlayList(String playListName, int ID) {
    for (PlayList playList1: getListener().playLists){
        if(Objects.equals(playList1.getName(), playListName)){
            for(Audio audio2: playList1.getAudoisList()){
                if(playList1.getAudoisList().equals(ID)){
                    playList1.getAudoisList().add(audio2);
                }
            }
        }
    }
    }

    @Override
    public Listener purchaseOrRenewSubscription(String packageName) {
        Premium premium = null;
        PackageType package1=null;
        for (PackageType package2:PackageType.values()){
            if(package2.name().equals(packageName)){
                package1=package2;
            }
        }
        double credit = getListener().getAccountCredit();
        if (getListener().getAccountCredit() >= package1.value) {
            if (package1.value == 5) {
                Premium premiumListener = new Premium(getListener().getAccountCredit(), date.getYear(), date.getMonth() + 1, date.getDay(), getListener().getFavoriteGenre(), getListener().getUserName(), getListener().getPassword(), getListener().getFirstAndLastname(), getListener().getPhoneNumber(), getListener().getBirthDate().getYear(), getListener().getBirthDate().getMonth(), getListener().getBirthDate().getDay(), getListener().getEmail(), 30);
                premiumListener.setFavoriteGenre(getListener().getFavoriteGenre());
                premiumListener.setAccountCredit(getListener().getAccountCredit());
                premiumListener.setPlayLists(getListener().getPlayLists());
                getListener().setAccountCredit(credit - 5);
                return premiumListener;
            } else if (package1.value == 9) {
                Premium premiumListener = new Premium(getListener().getAccountCredit(), date.getYear(), date.getMonth() + 2, date.getDay(), getListener().getFavoriteGenre(), getListener().getUserName(), getListener().getPassword(), getListener().getFirstAndLastname(), getListener().getPhoneNumber(), getListener().getBirthDate().getYear(), getListener().getBirthDate().getMonth(), getListener().getBirthDate().getDay(), getListener().getEmail(), 30);
                premiumListener.setFavoriteGenre(getListener().getFavoriteGenre());
                premiumListener.setAccountCredit(getListener().getAccountCredit());
                premiumListener.setPlayLists(getListener().getPlayLists());
                getListener().setAccountCredit(credit - 9);
                return premiumListener;
            } else if (package1.value == 14) {
                Premium premiumListener = new Premium(getListener().getAccountCredit(), date.getYear(), date.getMonth() + 6, date.getDay(), getListener().getFavoriteGenre(), getListener().getUserName(), getListener().getPassword(), getListener().getFirstAndLastname(), getListener().getPhoneNumber(), getListener().getBirthDate().getYear(), getListener().getBirthDate().getMonth(), getListener().getBirthDate().getDay(), getListener().getEmail(), 30);
                premiumListener.setFavoriteGenre(getListener().getFavoriteGenre());
                premiumListener.setAccountCredit(getListener().getAccountCredit());
                premiumListener.setPlayLists(getListener().getPlayLists());
                getListener().setAccountCredit(credit - 14);
                return premiumListener;
            }
        }
        int remainingDays1= premium.getRemainingDays();
        premium.setRemainingDays(remainingDays1--);
        if(remainingDays1==0){
            FreeListener freeListener=new FreeListener(getListener().getAccountCredit(), date.getYear(), date.getMonth() + 1, date.getDay(), getListener().getFavoriteGenre(), getListener().getUserName(), getListener().getPassword(), getListener().getFirstAndLastname(), getListener().getPhoneNumber(), getListener().getBirthDate().getYear(), getListener().getBirthDate().getMonth(), getListener().getBirthDate().getDay(), getListener().getEmail());
            freeListener.setPlayLists(premium.getPlayLists());
            freeListener.setAccountCredit(premium.getAccountCredit());
            freeListener.setFavoriteGenre(premium.getFavoriteGenre());
            DataBase.getDataBase().users.set(index,freeListener);
            return freeListener;
        }
        return premium;
    }

    @Override
    public void increaseCredit(double value) {
        double credit;
        credit = getListener().getAccountCredit();
        getListener().setAccountCredit(credit + value);
    }
}
