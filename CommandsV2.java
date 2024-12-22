import Items.Item;

/**
 * 	AUTHORS:	Katelyn Nova Powers
 *	LAST MODIFIED:	12/3/2024
 *
 * commands.java
 * Contains all the commands to be used in the Inventory Management System
 *
 * UML CLASS DIAGRAM:
 * -----------------------------------------
 * Commands.java
 * -----------------------------------------
 * + help(): void
 * + viewInventory(items: Items.Item[]): void
 * + getTotalItems(items: Items.Item[]): int
 * + getTotalPrice(items: Items.Item[]): double
 * + addItem(name: String, price: double, quantity: int, catagory: String): void
 * + addItem(): void
 * + removeItem(): void
 * + removeItem(indexNumber: int): void
 * + updateItem(): void
 * -----------------------------------------
 */

public class CommandsV2 {

    /**
     * Displays a list of all available commands.
     */
    public static void help() {
        System.out.println("Commands:");
        System.out.println("add - Add an item to the inventory");
        System.out.println("remove - Remove an item from the inventory");
        System.out.println("view - View the inventory");
        System.out.println("update - Update an item in the inventory");
        System.out.println("help - Display this message");
        System.out.println("exit - Exit the program");

        if (Main.debugMode) {
            System.out.println();
            System.out.println("Debug Commands:");
            System.out.println("debug-add - Add items to the inventory for testing");
            System.out.println("debug-resize - Resize the inventory array for testing");
            System.out.println("debug-reset - Reset the inventory array for testing");
            System.out.println("debug-empty - Empty a slot in the inventory array for testing");
        }
    }

    /**
     * Displays all the items in the inventory array.
     * @param items the array of items
     */
    public static void viewInventory(Item[] items) {
        System.out.println("Inventory:");
        System.out.println("you have " + getTotalItems(items) + " items with a total value of $" + getTotalPrice(items));
        System.out.println();
        System.out.println("Items.Item Name Quantity Price Catagory");

        //find the items in the inventory and displays them
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null && items[i].isOverwriteable())
            {
                System.out.println((i + 1) + ". " + items[i].getName() + " " + items[i].getQuantity() + " $" + items[i].getPrice() + " " + items[i].getCatagory());
                if (i < items.length - 1)
                {
                    System.out.println("--------------------");
                }
            }
        }
    }

    /**
     * Calculates the total number of items in the inventory.
     * @param items the array of items
     * @return the total number of items
     */
    public static int getTotalItems(Item[] items) {
        int totalItems = 0;

        //find the items in the inventory and adds up the total quantity
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null && !items[i].getName().equals("Unknown"))
            {
                totalItems += items[i].getQuantity();
            }
        }
        return totalItems;
    }

    /**
     * Calculates the total value of the inventory.
     * @param items the array of items
     * @return the total value of the inventory
     */
    public static double getTotalPrice(Item[] items) {
        double totalValue = 0;

        //find the items in the inventory and adds up the total value
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null && !items[i].getName().equals("Unknown"))
            {
                totalValue += items[i].getPrice() * items[i].getQuantity();
            }
        }
        totalValue = (int) (totalValue * 100);
        totalValue /= 100;
        return totalValue;
    }

    /**
     * Adds an item to the inventory.
     * @param name the name of the item
     * @param price the price of the item
     * @param quantity the quantity of the item
     * @param catagory the catagory of the item
     */
    public static void addItem(String name, double price, int quantity, String catagory) {
        int emptySlotNumber = Main.emptySlotChecker(Main.inventory);

        //if there is an empty slot in the inventory, add the item to that slot
        if (emptySlotNumber != -1) {
            Main.inventory[emptySlotNumber] = new Item(name, price, quantity, catagory, false);
            if (Main.debugMode) System.out.println("Items.Item added to index " + emptySlotNumber + "with the data: " + Main.inventory[emptySlotNumber].toString());
        } else {
            //since there are no empty slots, resize the array and add the item to the new slot
            Main.inventory = Main.resizeArray(Main.inventory, 1);
            if (Main.debugMode) System.out.println("Resized array to " + Main.inventory.length);

            emptySlotNumber = Main.emptySlotChecker(Main.inventory);
            Main.inventory[emptySlotNumber] = new Item(name, price, quantity, catagory, false);

            if (Main.debugMode) System.out.println("Items.Item added to index " + emptySlotNumber + "with the data: " + Main.inventory[emptySlotNumber].toString());
        }
    }

    /**
     * Adds an item by prompting the user for the item's information.
     */
    public static void addItem() {
        String name = UtilityBelt.readString("Enter the name of the item: ", 1, 50);
        int quantity = UtilityBelt.readInt("Enter the quantity of " + name + "s: ", 1, 1000);
        double price = UtilityBelt.readDouble("Enter the price of " + name + "s: ", 1, 1000);
        String catagory = UtilityBelt.readString("Enter the catagory of " + name + "s: ", 1, 50);

        addItem(name, price, quantity, catagory);
    }

    /**
     * Removes an item from the inventory by prompting the user for the item number.
     */
    public static void removeItem() {
        int itemNumber = UtilityBelt.readInt("Enter the number of the item you would like to remove: ", 1, Main.inventory.length);

        char confirm = UtilityBelt.readChar("Are you sure you want to remove " + Main.inventory[itemNumber - 1].getName() + "s? (y/N): ", "YNyn");

        if (confirm == 'Y' || confirm == 'y')
        {
            removeItem(itemNumber - 1);
            System.out.println("Items.Item removed successfully.");
        } else {
            System.out.println("Removal cancelled.");
        }
    }

    /**
     * Removes an item from the inventory by index number.
     * @param indexNumber the index number of the item to remove
     */
    public static void removeItem(int indexNumber) {
        //moves each item in the inventory array down one slot to fill the gap
        for (int i = indexNumber; i < Main.inventory.length - 1; i++)
        {
            if (Main.debugMode) System.out.println("Moving item " + (i + 1) + " to " + i);
            Main.inventory[i] = Main.inventory[i + 1];
        }
        //resizes the inventory array to remove the last slot
        Main.inventory = Main.resizeArray(Main.inventory, -1);
        if (Main.debugMode) System.out.println("inventory array resized to " + Main.inventory.length);
    }

    /**
     * Updates an item in the inventory by prompting the user for the item number and part to update.
     */
    public static void updateItem() {
        int itemNumber = UtilityBelt.readInt("Enter the number of the item you would like to update: ", 1, Main.inventory.length);
        System.out.println("What part of " + Main.inventory[itemNumber - 1].getName() +" do you want to update?");

        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Quantity");
        System.out.println("4. Catagory");

        int editNumber = UtilityBelt.readInt("Enter the number of the part you want to update: ", 1, 4);

        //switch statement to determine which part of the item to update
        switch (editNumber) {
            case 1:
                Main.inventory[itemNumber - 1].setName(UtilityBelt.readString("Enter the new name: ", 1, 50));
                break;
            case 2:
                Main.inventory[itemNumber - 1].setPrice(UtilityBelt.readDouble("Enter the new price: ", 1, 1000));
                break;
            case 3:
                Main.inventory[itemNumber - 1].setQuantity(UtilityBelt.readInt("Enter the new quantity: ", 1, 1000));
                break;
            case 4:
                Main.inventory[itemNumber - 1].setCatagory(UtilityBelt.readString("Enter the new catagory: ", 1, 50));
                break;
        }
        if (Main.debugMode) System.out.println("Items.Item updated to: " + Main.inventory[itemNumber - 1].toString());
        System.out.println(Main.inventory[itemNumber - 1].getName() + " updated successfully.");
    }
}