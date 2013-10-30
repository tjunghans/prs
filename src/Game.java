/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private ShapeDeck deck;

    public boolean start() {
        System.out.println("Start Game");

        deck = new ShapeDeck();

        return true;
    }

    public boolean newRound(Player player1, Player player2) {

        Shape playerOneShape = deck.getRandomShapeFromDeck();
        Shape playerTwoShape = deck.getRandomShapeFromDeck();

        System.out.println(player1.getPlayerType() + " vs " + player2.getPlayerType());
        System.out.println(playerOneShape.getShapeType());
        System.out.println(playerTwoShape.getShapeType());

        return true;
    }

}
