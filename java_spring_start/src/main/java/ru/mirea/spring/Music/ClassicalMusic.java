package ru.mirea.spring.Music;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music{
    protected List<String> songs=new ArrayList<>();
    public ClassicalMusic(){
        songs.add("classic1");
        songs.add("classic2");
        songs.add("classic3");
    }
    @Override
    public String getMusic(){
        Random rand=new Random();
        return songs.get(rand.nextInt(3));
    }
}
