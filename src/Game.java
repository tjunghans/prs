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

    // TODO: Move shape labels to external properties/i18n
    private String[] shapes = new String[]{
            "Rock", "Paper", "Scissors"
    };

    public Game() {
        for (int i = 0; i < this.shapes.length; i++) {
            this.shapeIndex.put(this.shapes[i].toLowerCase(), i);
        }

        this.deck = new ShapeDeck();
    }

    public boolean start() {
        System.out.println("Start Game" + System.getProperty("line.separator"));



        return true;
    }

    public boolean newRound(Player player1, ComputerPlayer player2) {

        Shape playerOneShape;

        if (player1.playerType.equals("Human")) {

            // The human player requires a menu
            Menu shapeType = new Menu();

            for (String shape:this.shapes) {
                shapeType.addMenuItem(shape);
            }

            Integer choice = shapeType.printMenuWithChoice();

            playerOneShape = deck.getShapeByIndex(choice - 1);

             // Show menu
        } else {
            playerOneShape = deck.getRandomShapeFromDeck();
        }

        Shape playerTwoShape = deck.getRandomShapeFromDeck();

        // Compare shapes
        int result = this.resultMatrix[this.shapeIndex.get(playerOneShape.getShapeType())][this.shapeIndex.get(playerTwoShape.getShapeType())];

        String resultText;

        // TODO: Move text to external properties/i18n file
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
        System.out.println("");

        System.out.println(resultText);
        System.out.println("");

        // Play again?

        System.out.println("Play again?");
        System.out.println("");
        Menu playAgain = new Menu();
        playAgain.addMenuItem("Yes");
        playAgain.addMenuItem("No");
        Integer playAgainChoice = playAgain.printMenuWithChoice();

        if (playAgainChoice == 1) {
            this.showMainMenu();
        }

        return true;
    }

    public void showMainMenu() {
        // 1. Show menu
        Menu gameType = new Menu();
        gameType.addMenuItem("Human vs Computer");
        gameType.addMenuItem("Computer vs Computer");
        Integer choice = gameType.printMenuWithChoice();

        this.start();

        if (choice == 1) {
            this.newRound(new Player("Human"), new ComputerPlayer());
        } else {
            this.newRound(new ComputerPlayer(), new ComputerPlayer());
        }
    }



}
