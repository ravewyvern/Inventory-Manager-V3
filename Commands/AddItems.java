package Commands;
import Items.Item;
import Main.*;

public class AddItems extends Command {
    // Command Info
    private final String name = "add"; // The name of the command that will be referred to in the program
    private final String description = "Add an item to the inventory"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 2.0; // The version of this command

    public AddItems() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        String name = UtilityBelt.readString("Enter the name of the item: ", 1, 50);
        int quantity = UtilityBelt.readInt("Enter the quantity of " + name + "s: ", 1, 1000);
        double price = UtilityBelt.readDouble("Enter the price of " + name + "s: ", 1, 1000);
        String catagory = UtilityBelt.readString("Enter the catagory of " + name + "s: ", 1, 50);

        run(name, price, quantity, catagory);
    }

    public static void run(String name, double price, int quantity, String catagory) {
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
}
