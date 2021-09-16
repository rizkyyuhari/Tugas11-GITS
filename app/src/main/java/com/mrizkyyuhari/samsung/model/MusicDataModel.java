package com.mrizkyyuhari.samsung.model;

import java.util.ArrayList;
import java.util.List;

public class MusicDataModel {
    public static List<MusicModel> MusicPlayer() {
        MusicModel a = new MusicModel("Coldrain","No Escape");
        MusicModel b = new MusicModel("Surface","Sheesh!!");
        MusicModel c = new MusicModel("Avenged Sevenfold","Carry On");

        List<MusicModel> musicPlayer = new ArrayList<>();
        musicPlayer.add(a);
        musicPlayer.add(b);
        musicPlayer.add(c);

        return musicPlayer;
    }
}
