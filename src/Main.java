import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Rock, Paper, Scissors");
        System.out.println("=====================" + System.getProperty("line.separator"));

        // 1. Show menu
        Menu gameType = new Menu();
        gameType.addMenuItem("Human vs Computer");
        gameType.addMenuItem("Computer vs Computer");
        Integer choice = gameType.printMenuWithChoice();

        Game prsGame = new Game();

        prsGame.start();

        if (choice == 1) {
            prsGame.newRound(new Player("Human"), new ComputerPlayer());
        } else {
            prsGame.newRound(new ComputerPlayer(), new ComputerPlayer());
        }

        // Solve countdown with callback later
        //Countdown countdown = new Countdown();
        //countdown.run();
    }
}
