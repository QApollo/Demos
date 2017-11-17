package com.company;


import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Demo {

    public static void main(String[] args) throws IOException, DontShowException {

        File file;
        try {
          file = Demo.createFile();
        } catch(IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        String[] lines = {"Multiple","things","to","write","to","file","yo"};
        Demo.writeStringToFile("Single",file);
        Demo.writeStringToFile(lines,file);
        Demo.readFromFile(file).forEach(System.out::println);

        try {
            int z = divideBy(10,0);
            LocalDateTime time = LocalDateTime.parse("test");
        } catch (ArithmeticException | DateTimeException e) {
            throw new DontShowException("No details available");
        }
    }

    private static int divideBy(int x, int y) {
        return x/y;
    }


    private static File createFile() throws IOException {
        File file = new File("./textfilestorage/test.txt");
        if (file.createNewFile()){
            System.out.println("Created successfully");
        } else {
           System.out.println("File exists");
        }

        return file;
    }

    private static void writeStringToFile(String message, File file) throws IOException {
        try (FileWriter writer = new FileWriter(file,true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeStringToFile(String[] messages, File file) throws IOException {
        try (FileWriter writer = new FileWriter(file,true)) {
            for ( String message: messages ) {
                writer.write(message + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readFromFile(File file) throws IOException{
        List<String> lines;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            lines = reader.lines().collect(Collectors.toList());
        }

        return lines;
    }
}
