package ru.mirea.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.mirea.spring.Music.Music;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;


public class MusicPlayer {
    private List<Music> music;

    private String name;
    private int value;


    public MusicPlayer (List<Music> music){
        this.music=music;


    }

    void playMusic(){
        Random random=new Random();
        System.out.println(music.get(random.nextInt(3)).getMusic());


    }

    private void initdo(){
        System.out.println(name + " : " + value);

    }


}
