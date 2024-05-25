package com.example.spotify4;

import com.example.spotify4.Controller.AdminController;
import com.example.spotify4.Model.Audio.Music;
import com.example.spotify4.Model.DataBase;
import com.example.spotify4.Model.Genre;
import com.example.spotify4.Model.User.Artist.Artist;
import com.example.spotify4.Model.User.Listener.FreeListener;
import com.example.spotify4.View.Scenes.ChangeScene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws Exception {
        ChangeScene.stage = stage;
        ChangeScene.homeScene();
        ChangeScene.stage.show();
    }

    @Override
    public void init() throws Exception {
        Music music1 = new Music("Ayene", "Farhad Mehrad", 1367, 3, 7, Genre.SOCIETY, "https://dl.mahanmusics.com/Song/farhad/Farhad%20Mehrad%20-%20Ayne-128.mp3", "", "می\u200Cبینم صورتمو تو آینه\n" +
                "با لبی خسته می\u200Cپرسم از خودم\n" +
                "این غریبه کیه ؟ از من چی می\u200Cخواد ؟\n" +
                "اون به من یا من به اون خیره شدم ؟\n" +
                "\n" +
                "باورم نمیشه هر چی می بینم\n" +
                "چشامو یه لحظه رو هم میذارم\n" +
                "به خودم میگم که این صورتکه\n" +
                "می\u200Cتونم از صورتم ورش دارم\n" +
                "\n" +
                "می\u200Cکشم دستمو روی صورتم\n" +
                "هر چی باید بدونم دستم میگه\n" +
                "من\u200Cو توی آینه نشون می\u200Cده\n" +
                "میگه این توای، نه هیچ کس دیگه\n" +
                "\n" +
                "جای پاهای تموم قصه\u200Cها\n" +
                "رنگ غربت تو تموم لحظه\u200Cها\n" +
                "مونده روی صورتت تا بدونی\n" +
                "حالا امروز چی ازت مونده به جا\n" +
                "\n" +
                "آینه میگه تو همونی که یه روز\n" +
                "می\u200Cخواستی خورشیدو با دست بگیری\n" +
                "ولی امروز شهر شب خونه\u200Cت شده\n" +
                "داری بی\u200Cصدا تو قلبت می\u200Cمیری\n" +
                "\n" +
                "می\u200Cشکنم آینه رو تا دوباره\n" +
                "نخواد از گذشته\u200Cها حرف بزنه\n" +
                "آینه می\u200Cشکنه هزار تیکه می\u200Cشه\n" +
                "اما باز تو هر تیکه\u200Cش عکس منه", "ab6761610000e5eb7af76b827df15f2342833123.jpg");
        Music music = new Music("Boye Gandom", "Daryosh", 1360, 11, 12, Genre.POP, "https://dl.musiceto.com/Music/1401/10/Dariush%20-%20Boye%20Khobe%20Gandom_musiceto.com.mp3?_=1", "", "بوی گندم مال من، هر چی که دارم مال تو\n" +
                "یه وجب خاک مال من، هر چی میکارم مال تو\n" +
                "بوی گندم مال من، هر چی که دارم مال تو\n" +
                "یه وجب خاک مال من، هر چی میکارم مال تو\n" +
                "اهل طاعونی این قبیله مشرقی ام\n" +
                "تویی این مسافر شیشه ای شهر فرنگ\n" +
                "پوستم از جنس شبه، پوست تو از مخمل سرخ\n" +
                "رختم از تاوله، تن پوش تو از پوست پلنگ\n" +
                "بوی گندم مال من، هر چی که دارم مال تو\n" +
                "یه وجب خاک مال من، هر چی میکارم مال تو\n" +
                "بوی گندم مال من، هر چی که دارم مال تو\n" +
                "یه وجب خاک مال من، هر چی میکارم مال تو\n" +
                "تو به فکر جنگل آهن و آسمون خراش\n" +
                "من به فکر یه اتاق اندازه تو، واسه خواب\n" +
                "تن من خاک منه، ساقه گندم، تن تو\n" +
                "تن ما تشنه ترین، تشنه یک قطره آب\n" +
                "بوی گندم مال من، هر چی که دارم مال تو\n" +
                "یه وجب خاک مال من، هر چی میکارم مال تو\n" +
                "بوی گندم مال من، هر چی که دارم مال تو\n" +
                "یه وجب خاک مال من، هر چی میکارم مال تو\n" +
                "شهر تو شهر فرنگ، آدماش ترمه قبا\n" +
                "شهر من شهر دعا، همه گنبداش طلا\n" +
                "تن تو مثل تبر، تن من ریشه سخت\n" +
                "تپش عکس یه قلب، مونده اما رو درخت\n" +
                "بوی گندم مال من، هر چی که دارم مال تو\n" +
                "یه وجب خاک مال من، هر چی میکارم مال تو\n" +
                "بوی گندم مال من، هر چی که دارم مال تو\n" +
                "یه وجب خاک مال من، هر چی میکارم مال تو\n" +
                "نباید مرثیه گو باشم، واسه خاک تنم\n" +
                "تو آخه مسافری، خون رگ این جا منم\n" +
                "تن من دوست نداره، زخمی دست تو بشه\n" +
                "حالا با هر کی که هست، هر کی که نیست داد میزنم\n" +
                "بوی گندم مال من، هر چی که دارم مال من\n" +
                "یه وجب خاک مال من، هر چی ميکارم مال من\n" +
                "بوی گندم مال من، هر چی که دارم مال من\n" +
                "یه وجب خاک مال من، هر چی میکارم مال من\n", "artworks-000027572578-vwqqj7-t500x500.jpg");
        Music music2=new Music("Bavar kon","googoosh",1360,5,4,Genre.POP,"https://xx.sahand-music.ir/Archive/G/Googoosh/Googoosh%20-%20Pol/02%20Baavar%20Kon.mp3","","باور کن ، صدامو باور کن\n" +
                "صدایی که تلخ و خسته ست\n" +
                "باور کن ، قلبمو باور کن\n" +
                "قلبی که کوهه اما شکسته ست\n" +
                "شکسته ست\n" +
                "باور کن ، دستامو باور کن\n" +
                "که ساقهء نوازشه\n" +
                "باور کن ، چشم منو باور کن\n" +
                "که یک قصیده خواهشه\n" +
                "وسوسهء عاشق شدن\n" +
                "التهاب لحظه هامه\n" +
                "حسرت فریاد کردنه\n" +
                "اسم کسی با صدامه\n" +
                "اسم تو هر اسمی که هست\n" +
                "مثل غزل چه عاشقانه ست\n" +
                "پر وسوسه مثل سفر\n" +
                "مثل غربت صادقانه ست\n" +
                "باور کن اسممو باور کن\n" +
                "من فصل بارون برگم\n" +
                "مطرود باغ و گل و شبنم\n" +
                "درختم درخت خشکی\n" +
                "تو دست تگرگم\n" +
                "\n" +
                "باور کن همیشه باور کن\n" +
                "که من به عشق صادقم\n" +
                "باور کن حرف منو باور کن\n" +
                "که من همیشه عاشقم","Googoosh - Pol.jpg");
        DataBase.getDataBase().audios.add(music2);
        DataBase.getDataBase().audios.add(music1);
        DataBase.getDataBase().audios.add(music);
        //      ListenerController.getListenerController().getSuggestions().add(music);
        //   AdminController.getAdminController().mostPopularAudioFileArray().add(music);
        Artist artist=new Artist("googoosh","@Googoosh1300","Faeghe Atashin","09877777777",1300,11,5,"googoosh@gmail.com","Iranian Singer","Googoosh - Pol.jpg");
        Artist artist1=new Artist("Farhad","@Farhad1300","Farhad Mehrad","09876666666",1300,5,4,"farhad@gmail.com","Iranian Singer","ab6761610000e5eb7af76b827df15f2342833123.jpg");
        Artist artist2=new Artist("Daryosh","@Daryosh1300","Daryosh Eghbali","09999999999",1300,8,2,"Dar@gmail.com","Iranian Singer","artworks-000027572578-vwqqj7-t500x500.jpg");
        DataBase.getDataBase().users.add(artist);
        DataBase.getDataBase().users.add(artist1);
        DataBase.getDataBase().users.add(artist2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}