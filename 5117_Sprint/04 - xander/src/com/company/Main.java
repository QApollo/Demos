package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.company.Constants.TWUUTS_DIR;

public class Main {

    public static void main(String[] args) {
        Main.createDir();
        TwuutManager twuut = TwuutManager.getInstance();

        System.out.println("Who is the author of this Twuut?");
        twuut.userSetAuthor();
        System.out.println("Write your Twuut use the enter key to insert a new line and write submit to twuut!");
        twuut.userAddLinesToTwuut();
    }

    private static void createDir() {
        Path twuutDir = Paths.get(TWUUTS_DIR);
        if (!Files.isDirectory(twuutDir)) {
            try {
                Files.createDirectory(twuutDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
