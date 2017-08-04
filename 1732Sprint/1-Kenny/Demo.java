import music.*;

import java.util.*;

public  class Demo {
    private List<Artist> artists = new ArrayList<Artist>();

    Scanner sc = new Scanner(System.in);

    // Main
    public static void main(String args[]) {
        Demo demo = new Demo();
    }

    // Constructor
    public Demo() {
        greeting();
        createList();
        showArtists();
        checkInput();
    }

    private void greeting() {
        System.out.println("Hi there, Here's a small list of artist.");
    }

    private void createList() {
        artists.addAll(Arrays.asList(new Artist("HONNE"),new Artist("Foster the People"),new Artist("Tom Misch"),new Artist("Oh Wonder")));
    }

    private void showArtists() {
        System.out.println("Please select one of the artist:");
        
        for (int i = 0; i < artists.size(); i++) {
            System.out.println(i + ") " + artists.get(i).getArtistName());

        }
        System.out.println("------------------------------------------------");
    }

    private void checkInput() {
        boolean validInput = false;
        String choosenArtist = "";

        do {
            String input = sc.next();

            // It should be something like (If input matches with index)
            if (input.toLowerCase().matches("0|1|2|3")) {
                choosenArtist += input;
                validInput = true;
            } else {
                System.out.println("Please enter a valid command.");
                showArtists();
            }
        } while (!validInput);
        // TODO: Once input is correct. Do show albums
        int artistNumber = Integer.parseInt(choosenArtist);
        showAlbums(artistNumber);
    }

    private void showAlbums(int artistNumber) {
        for (Album a : artists.get(artistNumber).getAlbums()) {
            System.out.println(a.getAlbumName());
        }
    }

}