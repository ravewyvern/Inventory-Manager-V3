package Commands;
import Items.Item;
import java.util.Scanner;
import Main.Main;

public class viewInventory extends Command {
    // Command Info
    private final String name = "view"; // The name of the command that will be referred to in the program
    private final String description = "View the inventory"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 2.0; // The version of this command

    public viewInventory() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    private int maxBarLength = 500;
    private boolean showBarGraph = true;

    @Override
    public void run(Item[] items) {
        System.out.println("Inventory:");
        System.out.println("you have " + getTotalItems(items) + " items with a total value of $" + getTotalPrice(items));
        System.out.println();
        System.out.println("Number Name Quantity Price Catagory");

        //find the items in the inventory and displays them
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null && !items[i].isOverwriteable())
            {
                System.out.println((i + 1) + ". " + items[i].getName() + " " + items[i].getQuantity() + " $" + items[i].getPrice() + " " + items[i].getCatagory());
                if (showBarGraph) System.out.println(Main.barLength(items[i].getQuantity(), maxBarLength));
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

    @Override
    public void settings(Item[] items) {
        System.out.println("Settings for View Command:");
        System.out.println("1. Show Bar Graph | Currently: " + showBarGraph);
        System.out.println("2. Maximum bar graph value | Currently: " + maxBarLength);
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the setting you would like to change: ");
        switch (scanner.nextInt())
        {
            case 1:
                showBarGraph = !showBarGraph;
                System.out.println("Bar graph is now " + (showBarGraph ? "on" : "off"));
                break;
            case 2:
                System.out.print("Enter the maximum value for the bar graph: ");
                maxBarLength = scanner.nextInt();
                System.out.println("Bar graph maximum value is now " + maxBarLength);
                break;
            default:
                System.out.println("Invalid setting number.");
                break;
        }
    }

    public void help(Item[] items) {
        System.out.println("This command does not have a help section yet.");
    }
}
