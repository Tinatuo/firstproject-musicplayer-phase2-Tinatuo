package com.example.spotify4.Data;

import com.example.spotify4.Model.Audio.Music;
import com.example.spotify4.Model.DataBase;
import com.example.spotify4.Model.Genre;
import com.example.spotify4.Model.User.Artist.Artist;

public final class SampleData {
    private static final String DEFAULT_COVER = "Screenshot_2024-05-12_223937-removebg-preview (2).png";

    private SampleData() {
    }

    public static void load() {
        DataBase dataBase = DataBase.getDataBase();
        if (!dataBase.audios.isEmpty() || !dataBase.users.isEmpty()) {
            return;
        }

        dataBase.audios.add(new Music(
                "Neon Drive",
                "Luna Bay",
                2024,
                3,
                7,
                Genre.POP,
                "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
                "Demo stream",
                "Lyrics are intentionally not bundled in this demo.",
                DEFAULT_COVER
        ));
        dataBase.audios.add(new Music(
                "Midnight Archive",
                "Farhad Studio",
                2023,
                8,
                15,
                Genre.SOCIETY,
                "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3",
                "Demo stream",
                "Lyrics are intentionally not bundled in this demo.",
                DEFAULT_COVER
        ));
        dataBase.audios.add(new Music(
                "Green Room",
                "Darya",
                2025,
                1,
                22,
                Genre.POP,
                "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3",
                "Demo stream",
                "Lyrics are intentionally not bundled in this demo.",
                DEFAULT_COVER
        ));

        dataBase.users.add(new Artist("Luna Bay", "@LunaBay2024", "Luna Bay", "09877777777", 2000, 11, 5, "luna@example.com", "Synth pop artist", DEFAULT_COVER));
        dataBase.users.add(new Artist("Farhad Studio", "@FarhadStudio", "Farhad Studio", "09876666666", 1998, 5, 4, "farhad@example.com", "Alternative producer", DEFAULT_COVER));
        dataBase.users.add(new Artist("Darya", "@Darya2025", "Darya", "09999999999", 2001, 8, 2, "darya@example.com", "Pop singer", DEFAULT_COVER));
    }
}
