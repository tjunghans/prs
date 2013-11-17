package com.ebay.game.round;


import com.ebay.game.GameType;

public class RoundFactory {

    public static Round getRound(GameType type){
        switch (type) {
            case COMPUTER_VS_COMPUTER:
                return new ComputerRound();
            case PLAYER_VS_COMPUTER:
                default:
                return new HumanRound();
        }
    }


}
