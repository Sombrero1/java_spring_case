package ru.mirea.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String [] args){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
        musicPlayer.playMusic(MusicPlayer.Ch.CLASSICAL);
        musicPlayer.playMusic(MusicPlayer.Ch.ROCK);


    context.close();
    }
}
