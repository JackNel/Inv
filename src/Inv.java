import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jack on 10/12/15.
 */
public class Inv {
    static void listItems(ArrayList<Item> items) {  //Create a static method called "listItems" that uses the ArrayList titled "items" defined below.
        int objectNum = 1;
        for (Item object : items) {
            System.out.println(String.format("%d. %s %s x%d ", objectNum, object.category, object.text, object.qty));
            objectNum++;
        }//For loop
    }//listItems method

    public static void main(String[] args) throws Exception {  //Begin Main Method
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList();  //My ArrayList called "items" contains objects of the class "Item"

        while (true) {
            listItems(items);
            System.out.println("Inventory Actions:");
            System.out.println("[1] Create a New Item");
            System.out.println("[2] Remove an Item");
            System.out.println("[3] Update an item's quantity");

            String choice = scanner.nextLine();
            int choiceNum = Integer.valueOf(choice);

            if (choiceNum == 1) {
                System.out.println("Enter the name of the item you would like to create.");
                String pickUp = scanner.nextLine();
                System.out.println(String.format("What type of item is %s?", pickUp));
                String type = scanner.nextLine();
                Item itemCat = createItem(pickUp, 1, type);
                items.add(itemCat);

            } else if (choiceNum == 2) {
                System.out.println("Enter the number of the item you would like to get rid of.");
                String loseIt = scanner.nextLine();
                try {
                    int loseItNum = Integer.valueOf(loseIt);
                    Item lost = items.remove(loseItNum - 1);
                    System.out.println("You have dropped the " + lost.text);
                } catch (Exception e) {
                    System.out.println("That item does not exist!");
                }

            } else if (choiceNum == 3) {
                System.out.println("Enter the number of the item you would like to change the quantity of.");
                String itemName = scanner.nextLine();
                int itemNameNum = Integer.valueOf(itemName);
                try {
                    Item toBeChanged = items.get(itemNameNum - 1);
                    if (items.contains(toBeChanged)) {
                        System.out.println(String.format("Enter the updated quantity for the item: %s x%d", toBeChanged.text, toBeChanged.qty));
                        String updated = scanner.nextLine();
                        int updatedQty = Integer.valueOf(updated);
                        toBeChanged.qty = updatedQty;
                    }
                } catch (Exception e) {
                    System.out.println("Not a valid option");
                }
            }
        }//while loop
    }//Main Method

    static Item createItem(String text, int qty, String category) throws Exception {
        if (category.equals("headwear")) {
            return new Headwear(text, 1);
        }
        else if (category.equals("footwear")) {
            return new Footwear(text, 1);
        }
        else if (category.equals("armor")) {
            return new Armor(text, 1);
        }
        else if (category.equals("weapon")) {
            return new Weapon(text, 1);
        }
        else if (category.equals("misc")) {
            return new Misc(text, 1);
        }
        else {
            throw new Exception("That category does not exist.");
        }
    }//static method createItem
}//Inv class
