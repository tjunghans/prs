package com.ebay.game.ui;

public class SelectMenuItem {

    private int index;
    private String name;

    public SelectMenuItem(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
