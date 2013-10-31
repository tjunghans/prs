import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private ShapeDeck deck;

    private int[][] resultMatrix = new int[][]{
            { 0, -1, 1 },
            { 1, 0, -1 },
            { -1, 1, 0 }
    };

    private Map<String, Integer> shapeIndex = new HashMap<String, Integer>();

    public Game() {
        this.shapeIndex.put("rock", 0);
        this.shapeIndex.put("paper", 1);
        this.shapeIndex.put("scissors", 2);
    }

    public boolean start() {
        System.out.println("Start Game");

        deck = new ShapeDeck();

        return true;
    }

    public boolean newRound(Player player1, Player player2) {

        Shape playerOneShape = deck.getRandomShapeFromDeck();
        Shape playerTwoShape = deck.getRandomShapeFromDeck();

        // Compare shapes
        int result = this.resultMatrix[this.shapeIndex.get(playerOneShape.getShapeType())][this.shapeIndex.get(playerTwoShape.getShapeType())];

        String resultText;

        if (result > 0) {
            resultText = "Player 1 wins";
        } else if (result < 0) {
            resultText = "Player 2 wins";
        } else {
            resultText = "It's a tie";
        }

        System.out.println(player1.getPlayerType() + " vs " + player2.getPlayerType());
        System.out.println(playerOneShape.getShapeType());
        System.out.println(playerTwoShape.getShapeType());
        System.out.println(resultText);

        return true;
    }



}
