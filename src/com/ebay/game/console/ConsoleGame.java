package com.ebay.game.console;

import com.ebay.game.GameType;
import com.ebay.game.round.Round;
import com.ebay.game.round.RoundFactory;
import com.ebay.game.round.RoundResultData;
import com.ebay.game.ui.SelectMenu;

import static com.ebay.game.GameType.COMPUTER_VS_COMPUTER;
import static com.ebay.game.GameType.PLAYER_VS_COMPUTER;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleGame {


    private SelectMenu gameMenu = new SelectMenu();
    private static final String SEPARATOR = System.getProperty("line.separator");

    public ConsoleGame() {
        gameMenu.addMenuItem(PLAYER_VS_COMPUTER.getIndex(), "Human vs Computer");
        gameMenu.addMenuItem(COMPUTER_VS_COMPUTER.getIndex(), "Computer vs Computer");

        System.out.println("Rock, Paper, Scissors");
        System.out.println("=====================" + SEPARATOR);
    }

    public void showGameTypeMenu() {
        gameMenu.printMenu();
    }

    public void playGameType() {
        int choice = gameMenu.getUserChoice();
        System.out.println("Choose Shape ");
        System.out.println(SEPARATOR);

        Round round = RoundFactory.getRound(GameType.getByIndex(choice));
        RoundResultData roundResult = round.play();
        printResult(roundResult);
    }

    public void showPlayAgainMenu() {
        System.out.println("Play again?");
        System.out.println(SEPARATOR);
        SelectMenu playAgain = new SelectMenu();

        playAgain.addMenuItem(0, "No");
        playAgain.addMenuItem(1, "Yes");

        playAgain.printMenu();

        int playAgainChoice = playAgain.getUserChoice();

        if (playAgainChoice == 1) {
            this.showGameTypeMenu();
            this.playGameType();
        }
    }

    protected void printResult(RoundResultData result) {
        System.out.println(result.getGameType());
        System.out.println(result.getFirstPlayerShape());
        System.out.println(result.getSecondPlayerShape());
        System.out.println(SEPARATOR);
        System.out.println(result.getResult());
        System.out.println(SEPARATOR);
        showPlayAgainMenu();
    }

}
