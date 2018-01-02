package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwuutManager {
  private File path;
  private String author;
  private List<String> twuutLines = new ArrayList<>();
  private static Scanner sc = new Scanner(System.in);

   TwuutManager(File path) {
    if (path != null) {
      this.path = path;
    } else {
      throw new IllegalArgumentException("Path cannot be null");
    }

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
      writeTwuutToFile();
    }
  }

   private void writeTwuutToFile() {
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

      writer.write(author + "\n");
      for (String s : twuutLines) {
        writer.write(s + "\n");
      }
      writer.write("§");
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
