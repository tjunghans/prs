import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShapeDeckTest {
    @Test
    public void testGetRandomShapeFromDeck() throws Exception {

        ShapeDeck deck = new ShapeDeck();

        assertTrue(deck.getRandomShapeFromDeck().getShapeType().equals("rock"));
    }
}
