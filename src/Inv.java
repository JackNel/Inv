import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jack on 10/12/15.
 */
public class Inv {
    static void listItems(ArrayList<Item> items) {  //Create a static method called "listItems" that uses the ArrayList titled "items" defined below.
        int objectNum = 1;
        for (Item object : items) {
            System.out.println(objectNum + ". " + object.text + " x" + object.qty);
            objectNum++;
        }//For loop
    }//listItems method

    public static void main(String[] args) {  //Begin Main Method
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
                Item addItem = new Item(pickUp, 1);
                items.add(addItem);

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
                Item toBeChanged = items.get(itemNameNum - 1);
                if (items.contains(toBeChanged)) {
                    System.out.println("Enter the updated quantity for the item: " + toBeChanged.text + " x" + toBeChanged.qty);
                    String updated = scanner.nextLine();
                    int updatedQty = Integer.valueOf(updated);
                    toBeChanged.qty = updatedQty;

                } else if (!items.contains(toBeChanged)) {
                    System.out.println("That item does not exist!");
                }

            }
        }//while loop
    }//Main Method
}//Inv class
