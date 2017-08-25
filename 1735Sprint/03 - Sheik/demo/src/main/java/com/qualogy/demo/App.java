package com.qualogy.demo;

import debug.Debug;
import deck.Deck;
import deck.Deck.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner SCANNER = new Scanner(System.in);
    private final Deck DECK = new Deck();

    private Card card;
    private List<Card> cardList = new ArrayList<>();
    private int score = 0;

    public static void main( String[] args ) {
        App app = new App();
    }

    public App() {
        boolean gameOver = false;
        startGame();
        while(!gameOver) {
            String playerChoice = playerChoice();
            drawCard();
            showCard();
            gameOver = calcResult(playerChoice);
            overview();
        }
        endGame();
    }

    private void startGame() {
        DECK.createDeck();
        greeting();
        drawCard();
        showCard();
    }

    private void greeting() {
        System.out.println("Welcome! Ready to play HILO?");
    }

    private void drawCard() {
        card = DECK.drawCard();
        cardList.add(card);
    }

    private void showCard() {
        System.out.println("Your card:");
        System.out.println(card);
    }

    private String playerChoice() {
        System.out.println("Is the next card higher (h) or Lower (l)?");

        String input = "";
        boolean playerInputReq = true;

        while(playerInputReq) {
            input = SCANNER.next();
			if(input.equals("h") || input.equals("l")) {
				playerInputReq = false;
			} else {
				System.out.println("Invalid choice.");
			}
		}
        return input;
    }

    public boolean calcResult(String playerChoice) {
        Card prevCard = cardList.get(cardList.size() - 2);
        boolean gameOver = false;

        if(playerChoice.equals("h")) {
            if(card.number.compareTo(prevCard.number) > 0) {
                System.out.println("Player is correct.");
                score++;
            } else {
                System.out.println("Player is incorrect.");
                gameOver = true;
            }
        } else {
            if(card.number.compareTo(prevCard.number) < 0) {
                System.out.println("Player is correct.");
                score++;
            } else {
                System.out.println("Player is incorrect.");
                gameOver = true;
            }
        }

        return gameOver;
    }

    private void overview() {
        System.out.println("\n Your score is: " + score);
        System.out.println("\n Cards drawn until now:");
        cardList.forEach(System.out::println);
    }

    private void endGame() {
        System.out.println("\n GAME OVER! \n");
        System.out.println("Final score: " + score);
        System.exit(0);
    }
}
