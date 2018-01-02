package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.company.Constants.*;

public class TwuutRetriever {
  private static Path twuutsDir = Paths.get(TWUUTS_DIR);

  public static void main(String args[]) {
    TwuutRetriever tr = new TwuutRetriever();
    tr.getAllTwuuts()
        .forEach(t -> System.out.println(t.getAuthor() + NEW_LINE + t.getTwuutText() + NEW_LINE));
  }

  private List<TwuutDTO> getAllTwuuts() {
    List<TwuutDTO> twuuts = new ArrayList<>();

    String splitTwuuts[] = readTwuutsIntoString().split(SQUIGGLY_CHAR);
    for (int i = 0; i < splitTwuuts.length -1; i++) { //-1 because splitting on § leaves a new line as array element we don't have to consider it.
      twuuts.add(assembleTwuutDTO(splitTwuuts[i]));
    }

    return twuuts;
  }

  private TwuutDTO assembleTwuutDTO(String twuut) {
    TwuutDTO assembledTwuut = new TwuutDTO();

    if (twuut != null) {
      assembledTwuut.setAuthor(
        twuut.substring(0,twuut.indexOf(NEW_LINE))
      );

      assembledTwuut.setTwuutText(
      twuut.replace(
          assembledTwuut.getAuthor(),"").trim()
      );
    }

    return assembledTwuut;
  }

  private String readTwuutsIntoString() {
    StringBuffer buffer = new StringBuffer();
    if (Files.exists(twuutsDir)) {
      try {
        Files.list(twuutsDir).forEach(p -> {
          try (BufferedReader reader = Files.newBufferedReader(p)) {
            String tempHolder;
            while ((tempHolder = reader.readLine()) != null) {
              tempHolder = tempHolder + System.lineSeparator();
              buffer.append(tempHolder);
            }
          } catch (IOException e) {
            e.printStackTrace();
          }
        });
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("No twuuts found");
      System.exit(0);
    }

    return buffer.toString();
  }

}
