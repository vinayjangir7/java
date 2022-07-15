package main.java.com.github.vinayjangir7.character_stream;

import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
