package com.ebay.game;

import com.ebay.game.players.ComputerPlayer;
import com.ebay.game.players.HumanPlayer;
import com.ebay.game.players.Player;

import java.util.*;

import static com.ebay.game.RoundResult.*;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {


    private Map<String, Integer> shapeIndex = new HashMap<String, Integer>();

    // TODO: Move shape labels to external properties/i18n
    //good candidate for enum
    //careful! might be able to replace this string list with shape enum
    private List<String> shapes = new ArrayList<String>();

    public Game() {

        initializeShapes();

        //todo externalize
        int currentIndex = 0;
        for (String shape : shapes) {
            shapeIndex.put(shape, currentIndex++);
        }
    }

    public void showMainMenu() {
        // 1. Show menu
        SelectMenu gameType = new SelectMenu();
                                 /*
        gameType.addMenuItem("Human vs Computer");
        gameType.addMenuItem("Computer vs Computer");
        Integer choice = gameType.getUserChoice();
                                   */
        this.start();

        //if (choice == 1) {
            this.newRound(new HumanPlayer(), new ComputerPlayer());
        /*} else {
            this.newRound(new ComputerPlayer(), new ComputerPlayer());
        }*/
    }

    //todo might be unused now
    private void initializeShapes() {
        shapes.add("Rock");
        shapes.add("Paper");
        shapes.add("Scissors");
    }

    public boolean start() {
        System.out.println("Start com.ebay.game.Game" + System.getProperty("line.separator"));
        return true;
    }

    public boolean newRound(Player firstPlayer, Player secondPlayer) {
        Shape firstPlayerShape;

        if (firstPlayer.isHuman()) {
            // The human player requires a menu
            SelectMenu shapeSelectMenu = new SelectMenu();

            shapeSelectMenu.addMenuItem(Shape.PAPER);
            shapeSelectMenu.addMenuItem(Shape.ROCK);
            shapeSelectMenu.addMenuItem(Shape.SCISSORS);

            shapeSelectMenu.printUserChoise();

            firstPlayerShape = shapeSelectMenu.getUserChoice();


            //playerOneShape = deck.getShapeByIndex(chosenShape - 1);

             // Show menu
        } else {
            firstPlayerShape = getRandonShape();
        }

        Shape secondPlayerShape = getRandonShape();



        // Compare shapes
        //int result = this.resultMatrix[this.shapeIndex.get(playerOneShape.getType())][this.shapeIndex.get(secondPlayerShape.getType())];

        int result = calculateResult(firstPlayerShape, secondPlayerShape);

        String resultText;

        // TODO: Move text to external properties/i18n file
        //todo this smells for polymorphismus
        if (result > 0) {
            resultText = "com.ebay.game.players.HumanPlayer 1 wins";
        } else if (result < 0) {
            resultText = "com.ebay.game.players.HumanPlayer 2 wins";
        } else {
            resultText = "It's a tie";
        }

        System.out.println(firstPlayer.getType() + " vs " + secondPlayer.getType());
        System.out.println(firstPlayerShape.getType());
        System.out.println(secondPlayerShape.getType());
        System.out.println("");

        System.out.println(resultText);
        System.out.println("");

        // Play again?

        System.out.println("Play again?");
        System.out.println("");
        SelectMenu playAgain = new SelectMenu();

        /*playAgain.addMenuItem("Yes");
        playAgain.addMenuItem("No");
        Integer playAgainChoice = playAgain.getUserChoice();

        if (playAgainChoice == 1) {
            this.showMainMenu();
        } */

        return true;
    }

    private int calculateResult(Shape firstPlayerShape, Shape secondPlayerShape) {
        /**
         *              Paper       | Rock      | Scissors
         *  Paper          tie           loose      win
         *  Rock           win           tie         loose
         *  Scissors       loose        win               tie
         */
        Enum<RoundResult>[][] resultMatrix = new Enum[][]{
                { TIE, LOOSE, WIN },
                { WIN, TIE, LOOSE},
                { LOOSE, WIN, TIE }
        };

        RoundResult playerOneResult = RoundResult.getByIndex(firstPlayerShape.getIndex());
        RoundResult playerTwoResult = RoundResult.getByIndex(secondPlayerShape.getIndex());

        RoundResult result = (RoundResult) resultMatrix[playerOneResult.getRoundResult()][playerTwoResult.getRoundResult()];
        return result.getRoundResult();
    }


    //todo refactor
    private Shape getRandonShape() {
        int randomIndex = new Random().nextInt(2);
        return Shape.getByIndex(randomIndex);
    }


}
