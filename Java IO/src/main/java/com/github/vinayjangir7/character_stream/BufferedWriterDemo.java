package main.java.com.github.vinayjangir7.character_stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) {

        try {
            BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter("vinay.txt"));
            bufferedOutputStream.write("Hello\n");
            bufferedOutputStream.write("World");
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
