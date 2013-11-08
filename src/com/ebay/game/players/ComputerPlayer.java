package com.ebay.game.players;


public class ComputerPlayer implements Player {

    @Override
    public String getType() {
        return "Computer";
    }

    @Override
    public boolean isHuman() {
        return false;
    }
}
