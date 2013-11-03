 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;


 /**
 * Created with IntelliJ IDEA.
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

        Integer index = 0;

        for (String menuItem : this.menuItems) {
            index += 1;
            System.out.println(index + ") " + menuItem);

        }

        System.out.println(question);

        Scanner in = new Scanner(System.in);

        Integer choice = Integer.parseInt(in.next());

        return choice;
    }
}
