package com.restapi.apirest.rest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;

import static java.lang.System.out;

public class FileManager {
    //    File file = new File("resources/file.txt");
    static public void create(String updateText){

        try(BufferedWriter output = new BufferedWriter(new FileWriter("resources/files.txt", true))){
            out.println("I'm here");
            output.append(updateText + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public void delete(int line) throws IOException {
        File inputFile = new File("resources/files.txt");
        File tempFile = new File("resources/myTempFiles.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))){
            int counter = 0;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                counter++;
                if(counter == line) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            Files.delete(inputFile.toPath());
            boolean successful = tempFile.renameTo(inputFile);
        }

    }

    static public void update(int line, String message) throws IOException {
        File inputFile = new File("resources/files.txt");
        File tempFile = new File("resources/myTempFiles.txt");
        System.out.println(line);
        System.out.println(message);
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            int counter = 0;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                counter++;
                if (counter == line) {
                    System.out.println("I AM IN COUNTER IS LINE");
                    writer.write(message + System.getProperty("line.separator"));
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            Files.delete(inputFile.toPath());
            boolean successful = tempFile.renameTo(inputFile);

        }
    }

    static public JSONObject read(int line) throws IOException, JSONException {
        File inputFile = new File("resources/files.txt");
        JSONObject json = new JSONObject();

        try(BufferedReader reader = new BufferedReader(new FileReader(new File("resources/files.txt")))){
            int counter = 0;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                counter++;
                json.put(Integer.toString(counter), currentLine);
            }

        }
        return json;

    }

}
