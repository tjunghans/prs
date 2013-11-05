import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShapeDeck {

    private List<Shape> deck;
    private Random randomGenerator;

    public ShapeDeck() {
        deck = new ArrayList<Shape>();
        randomGenerator = new Random();

        deck.add(new Shape("rock"));
        deck.add(new Shape("paper"));
        deck.add(new Shape("scissors"));
    }

    public Shape getShapeByIndex(int index) {
        return this.deck.get(index);
    }

    public Shape getRandomShapeFromDeck() {
        int index = randomGenerator.nextInt(deck.size());
        return deck.get(index);
    }
}
