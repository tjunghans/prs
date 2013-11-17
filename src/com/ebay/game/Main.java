package com.ebay.game;

import com.ebay.game.console.ConsoleGame;
import com.ebay.game.gui.SwingGame;

public class Main {

    public static void main(String[] args) {

        // Uncomment to play console version
    /*    ConsoleGame game = new ConsoleGame();
        game.showGameTypeMenu();
        game.playGameType();   */

        SwingGame game = new SwingGame();
        game.showGameTypeMenu();

    }
}
