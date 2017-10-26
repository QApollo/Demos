package com.restapi.apirest.rest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;

public class FileManager {
        File file;
        FileManager(String path){
            this.file = new File(path);
        }

        FileManager(File path){
            this.file = new File(path.toString());
        }

        FileManager( ){
            file = new File("resources/files.txt");
        }

        File getFile(){
            return this.file;
        }

//    BufferedWriter createFile(String path){
//        BufferedWriter output = null;
//        try {
//            output = new BufferedWriter(new FileWriter(path, true));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return output;
//    }

    void setPath(String path){
        this.file = new File(path);
    }

    void create(String updateText){
        try(BufferedWriter output = new BufferedWriter(new FileWriter(file, true))){
            output.append(updateText + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    void create(String updateText){
//        BufferedWriter output = createFile(pathName);
//        try {
//            output.append(updateText + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    boolean delete(int line) throws IOException {
//        File inputFile = new File("resources/files.txt");
        File tempFile = new File("resources/myTempFiles.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(file)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))){
            int counter = 0;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                counter++;
                if(counter == line) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            Files.delete(file.toPath());
            boolean successful = tempFile.renameTo(file);
            return successful;
        }

    }

    boolean update(int line, String message) throws IOException {
//        File inputFile = new File("resources/files.txt");
        File tempFile = new File("resources/myTempFiles.txt");
        System.out.println(line);
        System.out.println(message);
        try(BufferedReader reader = new BufferedReader(new FileReader(file)); BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
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
            Files.delete(file.toPath());
            boolean successful = tempFile.renameTo(file);
            return successful;

        }
    }

    JSONObject read() throws IOException, JSONException {
//        File inputFile = new File("resources/files.txt");
        JSONObject json = new JSONObject();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            int counter = 0;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                counter++;
                json.put(Integer.toString(counter), currentLine);
            }

        }
        return json;

    }

    boolean mockFunction(){
        return false;
    }

}
