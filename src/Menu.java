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
public class Menu {
    private List<String> menuItems = new ArrayList<String>();

    public Integer addMenuItem(String itemName) {
        this.menuItems.add(itemName);
        return this.menuItems.size();
    }

    public Integer printMenuWithChoice() {
        String question = "Chose menu item: ";

        Integer menuIndex = 0;

        for (String menuItem : this.menuItems) {
            menuIndex += 1;
            System.out.println(menuIndex + ") " + menuItem);

        }

        System.out.println(question);

        Scanner in = new Scanner(System.in);

        // Return selected menu index
        return Integer.parseInt(in.next());
    }
}
