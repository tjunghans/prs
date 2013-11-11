package com.ebay.game.round;

import com.ebay.game.Shape;
import org.junit.Before;
import org.junit.Test;

import static com.ebay.game.round.RoundResult.LOOSE;
import static com.ebay.game.Shape.*;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 11.11.2013
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoundTest {

    private Round round;

    @Before
    public void setup() {
        round = new HumanRound();
    }

    @Test
    public void rockVsPaperShouldLoose() {
        Shape first = ROCK;
        Shape second = PAPER;
        int expected = LOOSE.getRoundResult();
        assertEquals(expected, round.calculateResult(first, second));
    }

    @Test
    public void rockVsScissorsShouldWin() {
        Shape first = ROCK;
        Shape second = SCISSORS;
        int expected = RoundResult.WIN.getRoundResult();
        assertEquals(expected, round.calculateResult(first, second));
    }

    @Test
    public void rockVsRockShouldTie() {
        Shape first = ROCK;
        Shape second = ROCK;
        int expected = RoundResult.TIE.getRoundResult();
        assertEquals(expected, round.calculateResult(first, second));
    }

    @Test
    public void paperVsRockShouldWin() {
        Shape first = PAPER;
        Shape second = ROCK;
        int expected = RoundResult.WIN.getRoundResult();
        assertEquals(expected, round.calculateResult(first, second));
    }

}
