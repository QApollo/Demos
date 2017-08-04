package music;

import java.util.*;
import music.Album;


public class Artist {

    private String name;
    private List<Album> albums = new ArrayList<>();

    public Artist(String name) {
    	this.name = name;
    	setAlbums(name);
    }

    public String getArtistName() {
        return name;
    }

    private void setAlbums(String artistName) {
		switch (artistName) {
            case ("HONNE") :
            	albums.addAll(Arrays.asList(
                    new Album("Over Lover EP"),
                    new Album("Warm on a Cold Night")));
	            break;
            case ("Foster the People") :
                albums.addAll(Arrays.asList(
                    new Album("Torches"),
                    new Album("Supermodel"),
                    new Album("Sacred Hearts Club")));
	            break;
            case ("Tom Misch") :
	            albums.addAll(Arrays.asList(
                    new Album("Beats 1"),
                    new Album("Beats 2")));
	            break;
            case ("Oh Wonder") :
                albums.addAll(Arrays.asList(
                    new Album("Oh Wonder"),
                    new Album("Ultralife")));
	            break;
            default:
	            break;
        }
    }

    public List<Album> getAlbums() {
        return albums;
    }
        

}