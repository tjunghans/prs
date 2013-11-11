package com.ebay.game;

import com.ebay.game.console.ConsoleGame;

public class Main {

    public static void main(String[] args) {

        ConsoleGame game = new ConsoleGame();
        game.showGameTypeMenu();
        game.playGameType();

/*
        JFrame frame = new JFrame();
        JButton button = new JButton("Human vs Computer");
        JButton button2 = new JButton("Computer vs Computer");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);
        frame.getContentPane().add(button2);

        frame.setSize(400, 300);
        frame.setVisible(true);
*/




        // Solve countdown with callback later
        //com.ebay.game.Countdown countdown = new com.ebay.game.Countdown();
        //countdown.run();
    }
}
