package com.xander.ch6;

import java.util.*;
import java.io.*;

public class App {
    final static String BREAK = "\n";

    public static void main( String[] args ) {
      App app = new App();
      app.greeting();

      app.showCaseInputMismatchException();
      app.readFromFile();
    }


    private void greeting() {
      System.out.println("Welcome to a very \"useful\" demo about exceptions" + BREAK);
    }

    private void showCaseInputMismatchExceptionMessage() {
      System.out.println("Some basic input handling how about you try a String?" + BREAK);
    }

    private void showCaseInputMismatchException() {
      showCaseInputMismatchExceptionMessage();

      Scanner sc = new Scanner(System.in);
      boolean valid = false;
      int result = 0;

      while(!valid) {
        try {
          result = sc.nextInt();
          valid = true;
        } catch(InputMismatchException e) {
          sc.nextLine();
          System.out.println(e + BREAK);
          System.out.println("String didn't work so well did it? Maybe try an int" + BREAK);
        }
      }
    }

    private Scanner setScannerFile() throws IOException {
      Scanner sc = new Scanner(new File("test.txt"));
      return sc;
    }

    private void readFromFile() {
      Scanner sc = null;
      try {
        sc = setScannerFile();
      } catch(IOException e) {
        System.out.println(e + BREAK);
        System.out.println("No file found here");
      } finally {
          try {
            sc.nextLine();
          } catch (NoSuchElementException e) {
            System.out.println(e + BREAK);
            System.out.println("Don't try and force things");
          }
      }
    }
}
