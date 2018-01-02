package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TwuutRetriever {
  private static File path = new File("twuuts.txt");

  public static void main(String args[]) {
    TwuutRetriever tr = new TwuutRetriever();

    tr.getAllTwuuts()
        .forEach(t -> System.out.println(t.getAuthor() + "\n" + t.getTwuutText() + "\n"));
  }

  private List<TwuutDAO> getAllTwuuts() {
    List<TwuutDAO> twuuts = new ArrayList<>();

    String splitTwuuts[] = readTwuutsIntoString().split("§");
    for (int i = 0; i < splitTwuuts.length -1; i++) { //-1 because splitting on § leaves a new line as array element we don't have to consider it.
      twuuts.add(assembleTwuutDAO(splitTwuuts[i]));
    }

    return twuuts;
  }

  private TwuutDAO assembleTwuutDAO(String twuut) {
    TwuutDAO assembledTwuut = new TwuutDAO();

    if (twuut != null) {
      assembledTwuut.setAuthor(
        twuut.substring(0,twuut.indexOf("\n"))
      );

      assembledTwuut.setTwuutText(
      twuut.replace(
          assembledTwuut.getAuthor(),"").trim()
      );
    }

    return assembledTwuut;
  }

  private String readTwuutsIntoString() {
    String allData = "";
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String tempHolder;

      while ((tempHolder = reader.readLine()) != null) {
        tempHolder = tempHolder + System.lineSeparator();
        allData = allData.concat(tempHolder);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return allData;
  }
}
