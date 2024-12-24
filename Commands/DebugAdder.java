package Commands;

import Items.Item;

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
        System.out.println("coming soon");
    }
}
