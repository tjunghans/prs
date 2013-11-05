import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Rock, Paper, Scissors");
        System.out.println("=====================" + System.getProperty("line.separator"));

        Game prsGame = new Game();

        prsGame.showMainMenu();

        // Solve countdown with callback later
        //Countdown countdown = new Countdown();
        //countdown.run();
    }
}
