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

@Component
public class MusicPlayer {
    @Autowired
    @Qualifier("classicalMusic")
    Music music1;
    @Autowired
    @Qualifier("rockMusic")
    Music music2;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int value;

    enum Ch{
        CLASSICAL, ROCK;
    }
    void playMusic(Ch e){
        if(e==Ch.CLASSICAL) System.out.println(music1.getMusic());
        else System.out.println(music2.getMusic());

    }
    @PreDestroy
    @PostConstruct
    private void initdo(){
        System.out.println(name + " : " + value);

    }


}
