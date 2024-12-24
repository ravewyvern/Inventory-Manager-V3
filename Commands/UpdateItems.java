package Commands;
import Items.Item;
import Main.*;

public class UpdateItems extends Command {
    // Command Info
    private final String name = "update"; // The name of the command that will be referred to in the program
    private final String description = "Update an item in the inventory"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 2.0; // The version of this command

    public UpdateItems() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
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
