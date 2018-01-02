package com.company;
import java.util.List;

public class Vinyl {

  private final String albumName;
  private final String artistName;
  private final int diameterInInch;
  private final int runTimeInSeconds;
  private final int amountOfTracks;
  private final List<String> genre;

  public Vinyl(String albumName, String artistName, int diameterInInch, int runTimeInSeconds, int amountOfTracks, List<String> genre) {
    this.albumName = albumName;
    this.artistName = artistName;
    this.diameterInInch = diameterInInch;
    this.runTimeInSeconds = runTimeInSeconds;
    this.amountOfTracks = amountOfTracks;
    this.genre = genre;
  }

  public String getAlbumName() {
    return albumName;
  }

  public String getArtistName() {
    return artistName;
  }

  public int getDiameterInInch() {
    return diameterInInch;
  }

  public int getRunTimeInSeconds() {
    return runTimeInSeconds;
  }

  public int getAmountOfTracks() {
    return amountOfTracks;
  }

  public List<String> getGenre() {
    return genre;
  }

  public String toString(){
    return albumName + "-" + artistName;
  }


}
