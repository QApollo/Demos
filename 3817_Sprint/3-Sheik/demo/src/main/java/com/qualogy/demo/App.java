package com.qualogy.demo;

import bulbasaur.Bulbasaur;
import charmander.Charmander;
import ditto.Ditto;
import pikachu.Pikachu;
import pokemon.Pokemon;
import squirtle.Squirtle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    Random RANDOM = new Random();
    Scanner SCANNER = new Scanner(System.in);

    List<Pokemon> pokemonList = new ArrayList<>();

    public static void main(String[] args) {
        App app = new App();
    }

    public App() {
        startGame();
        addPokemon();
        pickPokemon();
    }

    public void startGame() {
        System.out.println("Hello World");
    }

    public void addPokemon() {
        pokemonList.add(new Bulbasaur());
        pokemonList.add(new Charmander());
        pokemonList.add(new Ditto());
        pokemonList.add(new Pikachu());
        pokemonList.add(new Squirtle());
    }

    public void pickPokemon() {
        Pokemon pokemon = pokemonList.get(RANDOM.nextInt(5));
        pokemon.speak();
    }
}
