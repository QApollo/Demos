package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Constants.*;
import static java.nio.charset.StandardCharsets.UTF_8;

public class TwuutManager {
  private static TwuutManager instance = null;

  private Path twuutDir = Paths.get(TWUUTS_DIR);
  private Path twuutFileToWrite;
  private String author;
  private List<String> twuutLines = new ArrayList<>();
  private static Scanner sc = new Scanner(System.in);

  private TwuutManager() {}

  private static void createInstance() {
    if(instance == null) {
      instance = new TwuutManager();
    }
  }

  public static TwuutManager getInstance() {
    if(instance == null) {
      createInstance();
    }
    return instance;
  }

   void userSetAuthor() {
    this.author = "@" + sc.nextLine();
  }

   void userAddLinesToTwuut() {
    String input = sc.nextLine();
    if (!"submit".equals(input)) {
      twuutLines.add(input);
      userAddLinesToTwuut();
    } else {
      createNewTwuutFile();
      writeTwuutToFile();
    }
  }

  private Path generateNewFilePath() {
    int numberOfTwuuts = 0;
    try {
      numberOfTwuuts = (int) Files.list(twuutDir).count();
    } catch (IOException e) {
      e.printStackTrace();
    }
   return Paths.get( numberOfTwuuts + "_" + this.author + TXT_EXTENSION);
  }

  private void createNewTwuutFile() {
    try {
      Path newFilePath = Paths.get(twuutDir.toString(),generateNewFilePath().toString());
      Files.createFile(newFilePath);
      twuutFileToWrite = newFilePath;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

   private void writeTwuutToFile() {
    if(twuutFileToWrite != null) {
      if (!Files.exists(twuutFileToWrite)) {
        System.out.println("Non existent File");
        System.exit(0);
      }

      try (BufferedWriter writer = Files.newBufferedWriter(twuutFileToWrite, UTF_8, StandardOpenOption.APPEND) ) {

        writer.write(author + NEW_LINE);
        for (String s : twuutLines) {
          writer.write(s + NEW_LINE);
          }
        writer.write(SQUIGGLY_CHAR);
        writer.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
