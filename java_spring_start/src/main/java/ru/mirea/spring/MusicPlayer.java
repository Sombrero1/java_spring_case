package ru.mirea.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.mirea.spring.Music.Music;

@Component
public class MusicPlayer {
    @Autowired
    @Qualifier("classicalMusic")
    Music music1;
    @Autowired
    @Qualifier("rockMusic")
    Music music2;

    enum Ch{
        CLASSICAL, ROCK;
    }
    void playMusic(Ch e){
        if(e==Ch.CLASSICAL) System.out.println(music1.getMusic());
        else System.out.println(music2.getMusic());

    }
    private void initdo(){

    }
}
