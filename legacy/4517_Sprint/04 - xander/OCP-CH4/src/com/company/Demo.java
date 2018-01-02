package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {

  public static Comparator<Vinyl> sortOnAlbumName = Comparator.comparing(Vinyl::getAlbumName);
  public static Comparator<Vinyl> sortOnArtistName = Comparator.comparing(Vinyl::getArtistName);

    public static void main(String[] args) {
      Individual kenny = new Individual("Kenny",23);
      Individual haoran = new Individual("Haoran",23);
      Individual aeron = new Individual("Aeron",25);
      Individual sheik = new Individual("Sheik",28);
      Individual xander = new Individual("Xander",19);

      populateIndiviualCollection(kenny, 50);
      populateIndiviualCollection(haoran, 5);
      populateIndiviualCollection(aeron, 42);
      populateIndiviualCollection(sheik, 10);
      populateIndiviualCollection(xander, 10);

      List<Vinyl> KennySortedCollection;
      KennySortedCollection = kenny.getVinylCollection().stream()
                                .sorted(sortOnAlbumName)
                                .collect(Collectors.toList());

      System.out.println(KennySortedCollection);

      List<Vinyl> AeronKpopCollection;
      AeronKpopCollection = aeron.getVinylCollection().stream()
                                  .filter(v -> v.getGenre().contains("kpop"))
                                  .peek(v -> System.out.println(v.getGenre()))
                                  .sorted(sortOnArtistName)
                                  .collect(Collectors.toList());

      System.out.println(AeronKpopCollection);

      int hoaranAmountOfpopRecords = (int)haoran.getVinylCollection().stream()
                                          .filter(v -> v.getGenre()
                                          .contains("pop"))
                                          .count();

      System.out.println("Haoron has " + hoaranAmountOfpopRecords + " Pop records");

      Optional<Vinyl> sheikRandomJazzRapRecord;
      sheikRandomJazzRapRecord = sheik.getVinylCollection()
                                .stream()
                                .filter(v -> v.getGenre()
                                .contains("jazz"))
                                .filter(v -> v.getGenre()
                                .contains("rap"))
                                .findFirst();

      if(sheikRandomJazzRapRecord.isPresent()) {
        System.out.println("Xander steals " + sheikRandomJazzRapRecord.get() + " and adds it to his own collection");
        xander.addVinylToCollection(sheikRandomJazzRapRecord.get());
      } else {
        System.out.println("Sheik does not own a jazz rap record, Xander fails to steal it");
      }

    }

    public static void populateIndiviualCollection(Individual individual, int amount) {
      individual.addVinylToCollection(generateVinylArray(amount));
    }

    public static Vinyl[] generateVinylArray(int amountOfVinyls) {
      Vinyl[] vinylArray = new Vinyl[amountOfVinyls];
      Random r = new Random();

      for(int i = 0; i < amountOfVinyls; i++) {
        vinylArray[i] = new Vinyl(getRandomAlbum(),getRandomArtist(),i % 2 == 0 ? 12 : 7,
                  r.nextInt(3600)+1200, r.nextInt(30)+7,
                  generateListOfRandomGenres());
      }

      return vinylArray;
    }

    public static String getRandomArtist() {
      String[] artists = {"Michael Jackson","AC/DC","Pink Floyd","Whitney Houston","Meat Loaf","Eagles","Fleetwood Mac"
          ,"Shania Twain","Led zeppelin", "Celine Dion", "The Beatles", "Adele", "Metallica", "Nirvana"
          ,"Guns N' Roses", "ABBA", "Linkin Park", "Bob Marley", "Queen", "Tommpabeats"};

      Random r = new Random();

      return artists[r.nextInt(artists.length)];
    }


  public static String getRandomAlbum() {
    String[] albumNames = {"Thriller","Harbor","Back in Black","The Dark Side of the Moon","The Bodyguard"
        ,"Bat Out of Hell","Rumours","Come On Over","Led zeppelin IV","Bad"
        ,"Sgt. Pepper's Lonely Hearts Club Band","Dangerous","21","Dirty Dancing","1","Abbey Road"
        ,"Born in the U.S.A","Metallica","Nevermind"};

    Random r = new Random();

    return albumNames[r.nextInt(albumNames.length)];
  }

  public static List<String> generateListOfRandomGenres() {
  String[] genres = {"jazz","funk", "pop", "low-fi", "metal", "rap", "hip-hop", "vaporwave", "trap", "kpop", "rock"
                      ,"death-metal", "dubstep", "ska", "soul", "blues"};

    Random r = new Random();

    return new ArrayList<String>() {{
      add(genres[r.nextInt(genres.length)]);
      add(genres[r.nextInt(genres.length)]);
    }};
  }

}
