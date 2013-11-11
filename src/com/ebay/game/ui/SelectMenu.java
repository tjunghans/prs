package com.ebay.game.ui;

import com.ebay.game.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The menu class is used for generating console menus
 * <p/>
 * <p/>
 * User: tjunghans
 * Date: 3.11.2013
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectMenu {
    private List<SelectMenuItem> menuItems = new ArrayList<SelectMenuItem>();

    public void addShapeMenuItem(Shape shape) {
        this.addMenuItem(new SelectMenuItem(shape.getIndex(), shape.getType()));
    }

    public void addMenuItem(int index, String text) {
        this.menuItems.add(new SelectMenuItem(index, text));
    }

    protected void addMenuItem(SelectMenuItem item) {
        this.menuItems.add(item);
    }

    public void printMenu() {
        String question = "Choose menu item: ";

        for (SelectMenuItem menuItem : this.menuItems) {
            System.out.println(menuItem.getIndex() + ") " + menuItem.getName());
        }
        System.out.println(question);
    }

    public int getUserChoice() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            return Integer.parseInt(in.next());
        }
        return -1;
    }
}
