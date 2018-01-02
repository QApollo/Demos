package deck;

import debug.Debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private Random RANDOM = new Random();

    private List<Card> deck = new ArrayList<>();

    public void createDeck() {
        for(Suite suite : Suite.values()) {
            for (CardNumber number : CardNumber.values()) {
                Card card = new Card(number, suite);
                deck.add(card);
            }
        }
    }

    public Card drawCard() {
        Card drawnCard = deck.get(RANDOM.nextInt(deck.size() - 1));
        deck.remove(drawnCard);
        return drawnCard;
    }

    private enum Suite {
        CLOBES("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

        private final String value;

        private Suite(String cardSuite) {
            this.value = cardSuite;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum CardNumber {
        ACE(1) { @Override public String toString() { return "A";} },
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11) { @Override public String toString() { return "J";} },
        QUEEN(12) { @Override public String toString() { return "Q";} },
        KING(13) { @Override public String toString() { return "K";} };

        private final int value;

        private CardNumber(int cardValue) {
            this.value = cardValue;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public class Card {
        public final CardNumber number;
        private final Suite suite;

        private Card(CardNumber number, Suite suite) {
            this.number = number;
            this.suite = suite;
        }

        @Override
        public String toString() {
            return number.toString() + suite.toString();
        }
    }
}
