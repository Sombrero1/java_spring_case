package com.company;

import java.io.*;
import java.net.Inet4Address;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stream {
    private Map<String,StringBuffer> data = new HashMap<>();

    public void readFile(String nameFile) throws IOException {
        FileReader fileReader=new FileReader(nameFile);//для символьного считывание текста
        Scanner scanner=new Scanner(fileReader);

        while (scanner.hasNext()){
            String [] strings=scanner.nextLine().split(" ");//размер не меньше 4
            if(strings.length!=3) throw new IllegalArgumentException("неправильный формат данных в исходном файле");
            String word=strings[0];//ключ
            Pattern pattern=Pattern.compile("^\\d{5}\\z");
            Matcher matcher= pattern.matcher(word);
            if(!matcher.find()) throw new IllegalArgumentException("неправильный формат данных в исходном файле");//проверка, что ключ - пятизначное число
            StringBuffer text=new StringBuffer();//информация
            for (int i = 1; i < strings.length; i++) text.append(" " +strings[i]);//остальная информация
            data.put(word,text);
        }
        fileReader.close();
    }

    public void readFileBinary(String nameFile) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(nameFile);//для байтового считывания текста

        while (fileInputStream.available()!=0){
            List<Byte> bytes=new LinkedList<>();
            byte first;
            while ((first= (byte) fileInputStream.read())!='\n') {
                bytes.add(first);
            }
            String [] strings=decode(bytes).split(" ",3);//размер не меньше 4
            if(strings.length!=3) throw new IllegalArgumentException("неправильный формат данных в исходном файле");
            String word=strings[0];//ключ
            Pattern pattern=Pattern.compile("^\\d{5}\\z");
            Matcher matcher= pattern.matcher(word);
            if(!matcher.find()) throw new IllegalArgumentException("неправильный формат данных в исходном файле");//проверка, что ключ - пятизначное число
            StringBuffer text=new StringBuffer();//информация
            for (int i = 1; i < strings.length; i++) text.append(" " +strings[i]);//остальная информация
            data.put(word,text);
        }
        fileInputStream.close();
    }

    public void delete(String key){
        System.out.println("Удаление: "+ key);
        data.remove(key);
    }
    public void clearData(){
        System.out.println("Очищаем данные");
        data.clear();
    }


    private byte[] code(String n){
        return n.getBytes();
    }
    private String decode(byte[] t){
        return new String(t);
    }
    private String decode(List<Byte> t){
        byte [] m=new byte[t.toArray().length];
        for (int i = 0; i < t.toArray().length ; i++) {
            m[i]=t.get(i);
        }
        return decode(m);
    }



    public void saveToFileBinary(String name) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream(name);

        for (String t:data.keySet()
             ) {
                byte[] binaryKey=code(t);
                fileOutputStream.write(binaryKey);
                byte[] binaryText=code(data.get(t).toString());
                fileOutputStream.write(binaryText);
                fileOutputStream.write('\n');

        }

        fileOutputStream.close();
    }

    public void show(){
        if(data.size()==0){
            System.out.println("Нет данных");
            return;
        }

        System.out.println("Вывод:");
        for (String t: data.keySet()
             ) {
            System.out.println(t + ":" + data.get(t));
        }
    }
    //delete
}
