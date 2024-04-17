import game.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import game.Card;
import game.CardTrick;
import static game.CardTrick.readFromFile;
import static game.CardTrick.sortCards;

public class TestCardTrick {
    @Test
    public void testReading(){
        ArrayList<Card>  plan = new ArrayList<>();
        plan.add(new Card(Color.CLUBS, "10"));

        ArrayList<Card>  fact = readFromFile("test1.txt");
        Assertions.assertIterableEquals(plan, fact);
    }
    @Test
    public void testReading2(){
        ArrayList<Card>  plan = new ArrayList<>();
        plan.add(new Card(Color.CLUBS, "10"));
        plan.add(new Card(Color.SPADES, "Queen"));
        plan.add(new Card(Color.HEARTS, "Queen"));
        plan.add(new Card(Color.DIAMONDS, "King"));
        ArrayList<Card>  fact = readFromFile("test 2.txt");
        //10 Clubs
        //Queen Spades
        //Queen hearts
        //King DIMOND
        Assertions.assertIterableEquals(plan, fact);
    }

    @Test
    public void testSort1(){
        ArrayList<Card>  fact = new ArrayList<>();
        fact.add(new Card(Color.HEARTS, "Queen"));
        fact.add(new Card(Color.CLUBS, "10"));
        fact.add(new Card(Color.DIAMONDS, "King"));
        fact.add(new Card(Color.SPADES, "Queen"));

        sortCards(fact);

        ArrayList<Card>  plan = new ArrayList<>();
        plan.add(new Card(Color.CLUBS, "10"));
        plan.add(new Card(Color.HEARTS, "Queen"));
        plan.add(new Card(Color.SPADES, "Queen"));
        plan.add(new Card(Color.DIAMONDS, "King"));

        Assertions.assertIterableEquals(plan, fact);
    }
}
