package com.ebay.game.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 14.11.2013
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleGui1B {

    JLabel labelTitle;
    JFrame frame;
    JPanel panelStart;
    JPanel panelShowShapeMenu;
    Container pane;

    JButton buttonGameType1;
    JButton buttonGameType2;

    // panelShowShapeMenu Buttons
    JButton buttonRock;
    JButton buttonPaper;
    JButton buttonScissors;

    public static void main (String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
    }

    public SimpleGui1B() {
        frame = new JFrame("Rock, Paper, Scissors");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        pane = frame.getContentPane();
        this.showGameTypeMenu();
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
        buttonGameType1 = new JButton("PC vs PC");
        buttonGameType2 = new JButton("Human vs PC");
        labelTitle = new JLabel("Choose game type");

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

    class GameType1Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("PC vs PC");
            panelStart.setVisible(false);
            frame.repaint();
        }
    }

    class GameType2Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Human vs PC");
            panelStart.setVisible(false);
            SimpleGui1B.this.showShapeMenu();
            frame.repaint();
        }
    }

    class ButtonRockListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Human chose rock");
        }
    }

    class ButtonPaperListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Human chose paper");
        }
    }

    class ButtonScissorsListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Human chose scissors");
        }
    }
}
