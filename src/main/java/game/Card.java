package game;

import java.util.Objects;

public class Card {
    Color suit;
    String rank;

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank='" + rank + '\'' +
                '}';
    }

    public Card(Color suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}

