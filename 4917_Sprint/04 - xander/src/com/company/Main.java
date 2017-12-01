package com.company;

import java.io.File;
import java.io.IOException;

public class Main {
    private static File twuutFile = new File("twuuts.txt");

    public static void main(String[] args) {
        TwuutManager twuut = new TwuutManager(twuutFile);

        if (!Main.twuutFile.exists()) {
            if (!createFile(Main.twuutFile)) {
                System.out.println("File couldn't be created. Terminating program");
                System.exit(0);
            }
        }

        System.out.println("Who is the author of this Twuut?");
        twuut.userSetAuthor();
        System.out.println("Write your Twuut use the enter key to insert a new line and write submit to twuut!");
        twuut.userAddLinesToTwuut();
    }

    private static boolean createFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
