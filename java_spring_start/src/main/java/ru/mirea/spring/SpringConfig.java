package ru.mirea.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.mirea.spring.Music.ClassicalMusic;
import ru.mirea.spring.Music.Music;
import ru.mirea.spring.Music.RockMusic;
import ru.mirea.spring.Music.SleepMusic;

import java.util.LinkedList;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
    @Bean
    public SleepMusic sleepMusic(){
        return new SleepMusic();
    }

    @Bean
    public List<Music> listMusic(){
        List <Music> music=new LinkedList<>();
        music.add(rockMusic());
        music.add(sleepMusic());
        music.add(classicalMusic());
        return music;
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(listMusic());
    }


}
