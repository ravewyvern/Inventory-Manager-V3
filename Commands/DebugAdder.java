package Commands;

import Items.Item;
import java.util.Random;

public class DebugAdder extends Command {
    // Command Info
    private final String name = "debug-add"; // The name of the command that will be referred to in the program
    private final String description = "Auto add a bunch of items"; // The description of the command
    private final boolean debugCommand = true; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 1.0; // The version of this command

    public DebugAdder() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        System.out.println("Adding items...");
        Random random = new Random();
        AddItems.run("Apple", random.nextInt(9) + .99, random.nextInt(100), "Fruit");
        AddItems.run("Banana", random.nextInt(4) + .99, random.nextInt(100), "Fruit");
        AddItems.run("Orange", random.nextInt(5) + .99, random.nextInt(100), "Fruit");
        AddItems.run("Shirt", random.nextInt(40) + .99, random.nextInt(100), "Clothing");
        AddItems.run("Pants", random.nextInt(50) + .99, random.nextInt(100), "Clothing");
        AddItems.run("Apple iPhone", random.nextInt(1200) + .99, random.nextInt(100), "Electronics");
        AddItems.run("Samsung Galaxy", random.nextInt(1100) + .99, random.nextInt(100), "Electronics");
    }

    @Override
    public void settings(Item[] items) {
        System.out.println("This command will have settings soon");
    }

    public void help(Item[] items) {
        System.out.println("This is a debug command which will add pre-defined items to the inventory.");
    }
}
