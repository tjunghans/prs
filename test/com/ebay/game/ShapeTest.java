package com.ebay.game;

import com.ebay.game.Shape;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShapeTest {

    @Test
    public void testShape() {
        Shape rock = Shape.ROCK;
        assertTrue(rock.getType().equals("Rock"));
    }
}
