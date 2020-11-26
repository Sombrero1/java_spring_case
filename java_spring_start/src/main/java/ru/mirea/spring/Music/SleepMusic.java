package ru.mirea.spring.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SleepMusic implements  Music {
    protected List<String> songs=new ArrayList<>();
    public SleepMusic(){
        songs.add("sleep1");
        songs.add("sleep2");
        songs.add("sleep3");

    }
    @Override
    public String getMusic() {
        Random rand=new Random();
        return songs.get(rand.nextInt(3));
    }
}
