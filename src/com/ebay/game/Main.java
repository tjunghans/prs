package com.ebay.game;

import com.ebay.game.console.ConsoleGame;
import com.ebay.game.gui.SwingGame;

public class Main {

    public static void main(String[] args) {

    /*    ConsoleGame game = new ConsoleGame();
        game.showGameTypeMenu();
        game.playGameType();   */


        SwingGame game = new SwingGame();
        game.showGameTypeMenu();

    }
}
