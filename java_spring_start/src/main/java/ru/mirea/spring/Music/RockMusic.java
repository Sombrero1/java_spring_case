package ru.mirea.spring.Music;

import org.springframework.stereotype.Component;
import ru.mirea.spring.MusicPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RockMusic implements Music {
    protected List<String> songs=new ArrayList<>();
    public RockMusic(){
        songs.add("rock1");
        songs.add("rock2");
        songs.add("rock3");

    }

    @Override
    public String getMusic(){
        Random rand=new Random();
        return songs.get(rand.nextInt(3));

    }
}
