package com.ebay.game.gui;

import com.ebay.game.*;
import com.ebay.game.Shape;
import com.ebay.game.round.Round;
import com.ebay.game.round.RoundFactory;
import com.ebay.game.round.RoundResultData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 17.11.2013
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */

// TODO: Break class into separate classes for each panel to simplify
public class SwingGame {
    JFrame gui = new JFrame();

    JFrame frame;
    JPanel panelStart;
    JPanel panelShowShapeMenu;
    JPanel panelResult;
    Container pane;

    // panelStart Buttons
    JButton buttonGameType1;
    JButton buttonGameType2;

    // panelShowShapeMenu Buttons
    JButton buttonRock;
    JButton buttonPaper;
    JButton buttonScissors;

    // panelResult Buttons
    JButton buttonPlayAgain;
    private int shapeIndex;

    public SwingGame() {

        frame = new JFrame("Rock, Paper, Scissors");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        pane = frame.getContentPane();

    }

    public void showShapeMenu() {
        panelShowShapeMenu = new JPanel();

        // Declare components
        JLabel panelLabel = new JLabel("Choose shape");
        buttonRock = new JButton("Rock");
        buttonPaper = new JButton("Paper");
        buttonScissors = new JButton("Scissors");

        // Add listeners
        buttonRock.addActionListener(new ButtonRockListener());
        buttonPaper.addActionListener(new ButtonPaperListener());
        buttonScissors.addActionListener(new ButtonScissorsListener());

        // Add components to panel
        panelShowShapeMenu.add(BorderLayout.NORTH, panelLabel);

        panelShowShapeMenu.setLayout(new BoxLayout(panelShowShapeMenu, BoxLayout.Y_AXIS));
        panelShowShapeMenu.add(BorderLayout.CENTER, buttonRock);
        panelShowShapeMenu.add(BorderLayout.CENTER, buttonPaper);
        panelShowShapeMenu.add(BorderLayout.CENTER, buttonScissors);

        // Add panel to frame
        pane.add(BorderLayout.CENTER, panelShowShapeMenu);

        pane.revalidate();
        pane.repaint();
    }

    public void showGameTypeMenu() {

        panelStart = new JPanel();

        // Declare components
        JLabel labelTitle = new JLabel("Choose game type");
        buttonGameType1 = new JButton("PC vs PC");
        buttonGameType2 = new JButton("Human vs PC");

        // Add listeners
        buttonGameType1.addActionListener(new GameType1Listener());
        buttonGameType2.addActionListener(new GameType2Listener());

        // Add components to panel
        panelStart.add(BorderLayout.NORTH, labelTitle);
        panelStart.setLayout(new BoxLayout(panelStart, BoxLayout.Y_AXIS));
        panelStart.add(BorderLayout.CENTER, buttonGameType1);
        panelStart.add(BorderLayout.CENTER, buttonGameType2);

        // Add panel to frame
        pane.add(BorderLayout.CENTER, panelStart);

        pane.revalidate();
        pane.repaint();

    }

    public void showResult(RoundResultData resultData) {

        panelResult = new JPanel();

        // Declare components
        JLabel labelGameType = new JLabel("Game Type: " + resultData.getGameType());
        JLabel labelFirstPlayerShape = new JLabel("Player 1 shape: " + resultData.getFirstPlayerShape());
        JLabel labelSecondPlayerShape = new JLabel("Player 2 shape: " + resultData.getSecondPlayerShape());
        JLabel labelResult = new JLabel("Result: " + resultData.getResult());
        buttonPlayAgain = new JButton("Play again");

        // Add listeners
        buttonPlayAgain.addActionListener(new PlayAgainListener());

        // Add components to panel
        panelResult.add(BorderLayout.NORTH, labelGameType);
        panelResult.add(BorderLayout.NORTH, labelFirstPlayerShape);
        panelResult.add(BorderLayout.NORTH, labelSecondPlayerShape);
        panelResult.add(BorderLayout.NORTH, labelResult);
        panelResult.setLayout(new BoxLayout(panelResult, BoxLayout.Y_AXIS));
        panelResult.add(BorderLayout.CENTER, buttonPlayAgain);

        // Add panel to frame
        pane.add(BorderLayout.CENTER, panelResult);

        pane.revalidate();
        pane.repaint();

    }

    public void playGameType(int choice) {

        // TODO: This if-else needs refactoring
        if (choice == 0) {
            showShapeMenu();
        } else {
            Round round = RoundFactory.getRound(GameType.getByIndex(choice));
            RoundResultData roundResult = round.play();
            showResult(roundResult);
        }
    }

    // TODO: Refactor
    public void playHumanGame(Shape selectedShape) {

        Round round = RoundFactory.getRound(GameType.getByIndex(0));
        RoundResultData roundResult = round.play(selectedShape);

        // TODO: Toggling panels needs improvement
        panelShowShapeMenu.setVisible(false);

        showResult(roundResult);
    }

    // panelShowGameTypeMenu Buttons
    class GameType1Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            SwingGame.this.playGameType(1);
            panelStart.setVisible(false);

        }
    }

    class GameType2Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            SwingGame.this.playGameType(0);
            panelStart.setVisible(false);
        }
    }

    // panelShowShapeMenu Buttons
    class ButtonRockListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            SwingGame.this.playHumanGame(Shape.ROCK);
        }
    }

    class ButtonPaperListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            SwingGame.this.playHumanGame(Shape.PAPER);
        }
    }

    class ButtonScissorsListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            SwingGame.this.playHumanGame(Shape.SCISSORS);
        }
    }

    // panelResult Buttons
    class PlayAgainListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            panelResult.setVisible(false);
            SwingGame.this.showGameTypeMenu();
        }
    }
}
