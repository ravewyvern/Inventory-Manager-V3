import Items.Item;

import java.util.Scanner;
import java.util.Random;

/*
TODO: add more commands to the IMS2 (like purchase item or switch items)
TODO: make the view inventory sort by catagory
TODO: add a list of catagories to choose from when adding an item
TODO: Add more classes for different types of items
TODO: turn each command into a class
TODO: make program dynamically load commands
*/

public class Main {

    //DEBUG SETTINGS
    public static final boolean debugMode = true; //set to true to enable debug mode for testing
    public static final boolean autoAddItems = true; //automatically add items when the program is run
    //END OF DEBUG SETTINGS

    public static boolean continueProgram = true;
    public static Item[] inventory;

    public static void main(String[] args)
    {

        /***** INITIALIZATION SECTION *****/
        String command;
        //initialize the inventory array with a size of 1
        inventory = new Item[1];
        inventory[0] = new Item();

        /***** OUTPUT SECTION *****/
        System.out.println("Welcome to the Inventory Management System 2.0 (IMS2)!");
        System.out.println();

        //prompt to see if user wants to add items to the inventory on startup
        char continueSetup = UtilityBelt.readChar("To get started, would you like to add some items to the inventory? (y/N): ", "YNyn");

        //loop through adding items to the inventory
        while (continueSetup == 'Y' || continueSetup == 'y')
        {
            CommandsV2.addItem();
            continueSetup = UtilityBelt.readChar("Would you like to add another item to the inventory? (y/N): ", "YNyn");
        }

        System.out.println("Setup complete, starting IMS2...");
        System.out.println();
        System.out.println("Inventory manager CLI started, type 'help' to get command list");

        if (debugMode) System.out.println("Debug mode is enabled, additional text will be displayed");
        if (debugMode && autoAddItems) commandSearch("debug-add");

        // enters a loop that will continue until the continueProgram variable is false
        while (continueProgram)
        {
            Scanner commandReader = new Scanner(System.in);

            System.out.print("C:/IMS/V2>");
            command = commandReader.nextLine();

            if (debugMode) System.out.println("C:/IMS/Debug> command submitted: " + command);

            commandSearch(command);
        }
    }
    /***** STATIC METHODS *****/
    /**
     * Searches for a command and executes the corresponding method.
     *
     * @param inputCommand The command to search for.
     */
    public static void commandSearch (String inputCommand) {
        switch (inputCommand.toLowerCase()) {
            case "help":
                CommandsV2.help();
                break;
            case "add":
                CommandsV2.addItem();
                break;
            case "view":
                CommandsV2.viewInventory(inventory);
                break;
            case "remove":
                CommandsV2.removeItem();
                break;
            case "update":
                CommandsV2.updateItem();
                break;
            case "exit":
                System.out.println("Exiting IMS2...");
                continueProgram = false;
                break;
            case "stock":
                CommandsV2.lowStock(inventory);
                break;
            case "debug-add":
                //debug commands
                if (debugMode) {
                    //useful if you want to add items to the inventory without going through the prompts
                    System.out.println("Debug mode is enabled, adding items to inventory...");
                    Random rand = new Random();
                    CommandsV2.addItem("Apple", 0.99, rand.nextInt(100), "Fruit");
                    CommandsV2.addItem("Banana", 0.49, rand.nextInt(100), "Yellow");
                    CommandsV2.addItem("Orange", 0.79, rand.nextInt(100), "Citrus");
                    CommandsV2.addItem("Grapes", 2.99, rand.nextInt(100), "Fruit");
                    break;
                }
            case "debug-resize":
                if (debugMode) {
                    //useful if you want to test the resizeArray method
                    System.out.println("Debug mode is enabled, resizing inventory array...");
                    inventory = resizeArray(inventory, 10);
                    break;
                }
            case "debug-reset":
                if (debugMode) {
                    //useful if you want to reset the inventory array without restarting the program
                    System.out.println("Debug mode is enabled, resetting inventory array...");
                    inventory = new Item[1];
                    inventory[0] = new Item();
                    break;
                }
            case "debug-empty":
                if (debugMode) {
                    //useful if you want to check when it adds items
                    int emptySlotNumber = UtilityBelt.readInt("Debug mode is enabled, please enter slot index to empty: ", 0, inventory.length - 1);
                    inventory[emptySlotNumber] = new Item();
                    break;
                }
            default:
                System.out.println("Command not found, type 'help' for a list of commands");
                break;
        }
    }

    /**
     * Checks for items with certain parameters and returns the index of the first slot with those.
     *
     * @param items The array of items to check.
     * @return The index of the first slot with the specified parameters.
     */
    public static int emptySlotChecker(Item[] items)
    {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null || items[i].getName().equals("Unknown") || items[i].isOverwriteable()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Resizes an Items.Item array by the specified amount.
     *
     * @param array      The array to resize.
     * @param changeSize The amount to resize the array by.
     * @return The resized array.
     */
    public static Item[] resizeArray(Item[] array, int changeSize) {
        //Checks if the array is being resized by 0
        if (changeSize == 0) {
            return array;
        }
        //Creates a new array with the new size and copies the elements
        //from the old array to the new array
        Item[] newArray = new Item[array.length + changeSize];

        int elementsToCopy = Math.min(array.length, newArray.length);
        for (int i = 0; i < elementsToCopy; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static String barLength(int charLength, int maxLength)
    {

        int extraLength = 0;
        StringBuilder output = new StringBuilder();

        //check if the length is greater than 500 and if so, set the extra length and the char length
        if (charLength > maxLength)
        {
            extraLength = charLength - maxLength;
            charLength = maxLength;
        }
        int saveCharLength = charLength;

        saveCharLength /= 8;

        while (saveCharLength > 0)
        {
            output.append("█");
            saveCharLength--;
        }

        charLength %= 8;

        switch (charLength)
        {
            case 0:
                break;
            case 1:
                output.append("▏");
                break;
            case 2:
                output.append("▎");
                break;
            case 3:
                output.append("▍");
                break;
            case 4:
                output.append("▌");
                break;
            case 5:
                output.append("▋");
                break;
            case 6:
                output.append("▊");
                break;
            case 7:
                output.append("▉");
                break;

        }
        if (extraLength != 0)
        {
            output.append(" + ").append(extraLength);
        }

        return output.toString();
    }
}
