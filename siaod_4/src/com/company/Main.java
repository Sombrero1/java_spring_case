package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Stream stream=new Stream();
        stream.readFile("file.txt");
        stream.show();
        stream.saveToFileBinary("output.txt");
        stream.delete("45545");
        stream.show();
        stream.clearData();
        stream.show();
        stream.readFileBinary("output.txt");
        stream.show();
    }
}
