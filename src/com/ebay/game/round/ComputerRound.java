package com.ebay.game.round;


import com.ebay.game.GameType;
import com.ebay.game.Shape;


public class ComputerRound extends Round {

    @Override
    protected Shape getFirstPlayerShape() {
        return getRandomShape();
    }

    @Override
    protected GameType getGameType() {
        return GameType.COMPUTER_VS_COMPUTER;
    }
}
