package Commands;
import Items.Item;
import Main.*;

public class LowStock extends Command {
    // Command Info
    private final String name = "stock"; // The name of the command that will be referred to in the program
    private final String description = "View items with a quantity below a certain amount"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 2.0; // The version of this command

    public LowStock() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        int lowStockNumber = UtilityBelt.readInt("Look for items with equal or less than: ", 1, 500000);
        System.out.println("Looking for items with equal or less than quantity than " + lowStockNumber);
        for (int i = 0; i < items.length; i++) {
            if (lowStockNumber >= items[i].getQuantity()) {
                System.out.println("Low Stock: " + items[i].getName() + " has only " + items[i].getQuantity() + " items left");
            }
        }
    }
}
