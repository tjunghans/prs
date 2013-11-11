package com.ebay.game.round;

import com.ebay.game.GameType;
import com.ebay.game.Shape;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 11.11.2013
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoundResultData {
    private RoundResult result;
    private Shape firstPlayerShape;
    private Shape secondPlayerShape;
    private GameType gameType;

    public RoundResultData(RoundResult result, Shape firstPlayerShape, Shape secondPlayerShape, GameType gameType) {
        this.result = result;
        this.firstPlayerShape = firstPlayerShape;
        this.secondPlayerShape = secondPlayerShape;
        this.gameType = gameType;
    }

    public RoundResult getResult() {
        return result;
    }

    public Shape getFirstPlayerShape() {
        return firstPlayerShape;
    }

    public Shape getSecondPlayerShape() {
        return secondPlayerShape;
    }

    public GameType getGameType() {
        return gameType;
    }
}
