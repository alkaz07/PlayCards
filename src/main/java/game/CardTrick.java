package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CardTrick {
    public static ArrayList<Card> readFromFile(String fname){
        ArrayList<Card> cards = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                String rank = parts[0];
                String suit = parts[1].toUpperCase();
                Card card = new Card(Color.valueOf(suit), rank);
                cards.add(card);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cards;
    }

    public static void sortCards(ArrayList<Card> cards){
        cards.sort((o1, o2) -> {
            String rank1 = o1.rank;
            String rank2 = o2.rank;
            if(rank1.equals(rank2))     return 0;

            if(rank1.equals("Joker"))  return 1;
            if(rank2.equals("Joker"))  return -1;
            if(rank1.equals("Ace"))     return 1;
            if(rank2.equals("Ace"))     return -1;
            if(rank1.equals("King"))    return 1;
            if(rank2.equals("King"))    return -1;
            if(rank1.equals("Queen"))    return 1;
            if(rank2.equals("Queen"))    return -1;
            if(rank1.equals("Jack"))    return 1;
            if(rank2.equals("Jack"))    return -1;
            int r1 = Integer.parseInt(rank1);
            int r2 = Integer.parseInt(rank2);
            return r1-r2;
        });
    }

}
