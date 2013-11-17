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
    JButton buttonGameType1;
    JButton buttonGameType2;
    JLabel labelTitle;
    JFrame frame;
    JPanel panelStart;

    public static void main (String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go() {
        frame = new JFrame("Rock, Paper, Scissors");
        panelStart = new JPanel();

        frame.setResizable(false);

        Container pane = frame.getContentPane();

        buttonGameType1 = new JButton("PC vs PC");

        buttonGameType2 = new JButton("Human vs PC");

        labelTitle = new JLabel("Choose game type");


        buttonGameType1.addActionListener(new GameType1Listener());
        buttonGameType2.addActionListener(new GameType2Listener());

        pane.add(BorderLayout.NORTH, labelTitle);

        //panelStart.setLayout(new BoxLayout(panelStart, BoxLayout.Y_AXIS));
        panelStart.add(BorderLayout.CENTER, buttonGameType1);
        panelStart.add(BorderLayout.CENTER, buttonGameType2);

        pane.add(BorderLayout.CENTER, panelStart);

        buttonGameType1.setSize(150, 30);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setSize(300, 300);

        frame.setVisible(true);

    }

    class GameType1Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("PC vs PC");
            frame.remove(panelStart);
            frame.repaint();
        }
    }

    class GameType2Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Human vs PC");
            frame.remove(panelStart);
            frame.repaint();
        }
    }




}
