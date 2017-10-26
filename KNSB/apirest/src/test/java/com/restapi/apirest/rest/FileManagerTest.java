package com.restapi.apirest.rest;

import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileManagerTest {

    @Test
    public void create() throws Exception {
        // Prepare
        String fileText = "Aditionasdfsfdsl Line Test";
        File inputFile = mock(File.class);
        when(inputFile.exists()).thenReturn(true);
        when(inputFile.toString()).thenReturn(("resources/testfiles.txt"));
        FileManager testObj = new FileManager(inputFile);

        File testFile = testObj.getFile();
        // Execute
        testObj.create(fileText);

        // Assert
        try(BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line = "";
            String last = "";
            while ((line = reader.readLine()) != null) {
                last = line;
            }
            assertEquals(fileText,last);

        }
    }

    @Test
    public void delete() throws Exception {
        // Prepare
        int lineNumber = 1;
        FileManager testObj = new FileManager("resources/testfiles.txt");
        // Execute
        boolean success = testObj.delete(lineNumber);

        // Assert
        assertTrue(success);

    }

    @Test
    public void update() throws Exception {
        // Prepare
        int lineNumber = 1;
        String fileText = "Additional Line Test";
        String compareText = "";
        FileManager testObj = new FileManager("resources/testfiles.txt");
        File testFile = testObj.file;

        // Execute
        boolean success = testObj.update(lineNumber, fileText);

        // Assert
        assertTrue(success);
        try(BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line = "";
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                counter++;
                if(counter == lineNumber){
                    compareText = line;
                }
            }
        }
        assertEquals(fileText,compareText);
    }

    @Test
    public void read() throws Exception {
        // Prepare
        FileManager testObj = new FileManager("resources/testfiles.txt");
        // Assert
        JSONObject json = testObj.read();
        // Execute
        assertFalse(json.length()==0);

    }

}