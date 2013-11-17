package com.ebay.game.round;

import com.ebay.game.GameType;
import com.ebay.game.Shape;

import java.util.Random;

public abstract class Round {

    public RoundResultData play() {

        Shape firstPlayerShape = getFirstPlayerShape();
        Shape secondPlayerShape = getSecondPlayerShape();

        int resultIndex = calculateResult(firstPlayerShape, secondPlayerShape);
        RoundResult result = RoundResult.getByIndex(resultIndex);
        return new RoundResultData(result, firstPlayerShape, secondPlayerShape, getGameType());
    }

    // Used with SwingGame
    // TODO: DRY up
    public RoundResultData play(Shape firstPlayerShape) {

        Shape secondPlayerShape = getSecondPlayerShape();

        int resultIndex = calculateResult(firstPlayerShape, secondPlayerShape);
        RoundResult result = RoundResult.getByIndex(resultIndex);
        return new RoundResultData(result, firstPlayerShape, secondPlayerShape, getGameType());
    }

    protected abstract Shape getFirstPlayerShape();
    protected abstract GameType getGameType();

    protected Shape getSecondPlayerShape() {
        return getRandomShape();
    }

    protected Shape getRandomShape() {
        int randomIndex = new Random().nextInt(3);
        return Shape.getByIndex(randomIndex);
    }

    protected int calculateResult(Shape firstPlayerShape, Shape secondPlayerShape) {
        /**
         *              Rock       | Paper      | Scissors
         *  Rock          tie           loose      win
         *  Paper           win           tie         loose
         *  Scissors       loose        win               tie
         */
        Enum<RoundResult>[][] resultMatrix = new Enum[][]{
                {RoundResult.TIE, RoundResult.LOOSE, RoundResult.WIN},
                {RoundResult.WIN, RoundResult.TIE, RoundResult.LOOSE},
                {RoundResult.LOOSE, RoundResult.WIN, RoundResult.TIE}
        };


        RoundResult result = (RoundResult) resultMatrix[firstPlayerShape.getIndex()][secondPlayerShape.getIndex()];
        return result.getRoundResult();
    }

}
