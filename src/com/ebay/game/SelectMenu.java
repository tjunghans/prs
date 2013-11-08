package com.ebay.game;

import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;


 /**
 * The menu class is used for generating console menus
 *
 *
 * User: tjunghans
 * Date: 3.11.2013
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectMenu {
    private List<Shape> menuItems = new ArrayList<Shape>();

    public void addMenuItem(Shape shape) {
        this.menuItems.add(shape);
    }

    public void printUserChoise() {
        String question = "Choose menu item: ";

        for (Shape menuItem : this.menuItems) {
            System.out.println(menuItem.getIndex() + ") " + menuItem.getType());
        }
        System.out.println(question);
    }

    public Shape getUserChoice() {

        Scanner in = new Scanner(System.in);
        // Return selected menu index
        int returnIndex = Integer.parseInt(in.next());

        //not so dirty hack, but still dirty
        Shape selectedShape = Shape.INVALID;
        for (Shape menuItem : this.menuItems) {
            if (menuItem.getIndex() == returnIndex) {
                selectedShape = menuItem;
            }
        }
        return selectedShape;
    }
}
