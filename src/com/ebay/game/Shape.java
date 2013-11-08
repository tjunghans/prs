package com.ebay.game;

/**
 * Created with IntelliJ IDEA.
 * User: tjunghans
 * Date: 29.10.2013
 * Time: 10:38 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Shape {
    ROCK("Rock", 0),
    PAPER("Paper", 1),
    SCISSORS("Scissors", 2),
    INVALID("Invalid", 3);

    private String type;
    private Integer index;

    Shape(String type, Integer index) {
        this.type = type;
        this.index = index;
    }

    public String getType() {
        return this.type;
    }

    public Integer getIndex() {
        return index;
    }

    //todo refactor
    public static Shape getByIndex(int index) {
        Shape returnShape = Shape.INVALID;
        for (Shape s : Shape.values()) {
            if (s.getIndex() == index) {
                returnShape = s;
            }
        }
        return returnShape;
    }
}
