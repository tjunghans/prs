package com.ebay.game.players;

import com.ebay.game.players.Player;

public class HumanPlayer implements Player {
    @Override
    public String getType() {
        return "Human";
    }

    @Override
    public boolean isHuman() {
        return true;
    }
}
