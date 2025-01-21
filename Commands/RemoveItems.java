package Commands;
import Items.Item;
import Main.*;

public class RemoveItems extends Command {
    // Command Info
    private final String name = "remove"; // The name of the command that will be referred to in the program
    private final String description = "Remove an item from the inventory"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 2.0; // The version of this command

    public RemoveItems() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        int itemNumber = UtilityBelt.readInt("Enter the number of the item you would like to remove: ", 1, Main.inventory.length);

        char confirm = UtilityBelt.readChar("Are you sure you want to remove " + Main.inventory[itemNumber - 1].getName() + "s? (y/N): ", "YNyn");

        if (confirm == 'Y' || confirm == 'y')
        {
            run(itemNumber - 1);
            System.out.println("Items.Item removed successfully.");
        } else {
            System.out.println("Removal cancelled.");
        }
    }

    public static void run(int indexNumber) {
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

    @Override
    public void settings(Item[] items) {
        System.out.println("This command does not have any settings.");
    }

    public void help(Item[] items) {
        System.out.println("This command does not have a help section yet.");
    }
}
