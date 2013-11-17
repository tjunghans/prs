package com.ebay.game.round;

import com.ebay.game.GameType;
import com.ebay.game.Shape;
import com.ebay.game.ui.SelectMenu;

import javax.swing.*;

public class HumanRound extends Round {

    @Override
    protected Shape getFirstPlayerShape() {
        // The human player requires a menu
        SelectMenu shapeSelectMenu = new SelectMenu();

        shapeSelectMenu.addShapeMenuItem(Shape.ROCK);
        shapeSelectMenu.addShapeMenuItem(Shape.PAPER);
        shapeSelectMenu.addShapeMenuItem(Shape.SCISSORS);

        shapeSelectMenu.printMenu();

        int selectedIndex = shapeSelectMenu.getUserChoice();
        return Shape.getByIndex(selectedIndex);
    }

    @Override
    protected GameType getGameType() {
        return GameType.PLAYER_VS_COMPUTER;
    }
}
