package com.qualogy.demo;

import bulbasaur.Bulbasaur;
import charmander.Charmander;
import ditto.Ditto;
import isgrasstype.IsGrassType;
import ispokemon.IsPokemon;
import pikachu.Pikachu;
import squirtle.Squirtle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    private final Random RANDOM = new Random();
    private final Scanner SCANNER = new Scanner(System.in);

    List<IsPokemon> pokemonList = new ArrayList<>();
    IsPokemon pokemon;

    public static void main(String[] args) {
        App app = new App();
    }

    public App() {
        gameManager();
    }

    public void gameManager() {
        startGame();
        addPokemon();
        pickPokemon();
        displayOptions();
        playerTurn();
    }

    public void startGame() {
        System.out.println("Who is that pokemon?!");
    }

    public void addPokemon() {
        pokemonList.add(new Bulbasaur());
        pokemonList.add(new Charmander());
        pokemonList.add(new Ditto());
        pokemonList.add(new Pikachu());
        pokemonList.add(new Squirtle());
    }

    public void pickPokemon() {
        pokemon = pokemonList.get(RANDOM.nextInt(pokemonList.size()));
        pokemon.speak();
    }

    public void displayOptions() {
        System.out.println();
        for (IsPokemon p : pokemonList) {
            System.out.println(pokemonList.indexOf(p) + " " + p.getName());
        }
    }

    public void playerTurn() {
        checkInput(SCANNER.nextInt());
    }

    public void checkInput(int input) {
        if (pokemonList.get(input).getName().equals(pokemon.getName())) {
            System.out.println("You are correct!");
        }
        else {
            System.out.println("You are incorrect. Better luck next time.");
        }
    }
}
