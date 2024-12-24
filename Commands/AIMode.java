package Commands;

import Items.Item;
import Main.*;

public class AIMode extends Command {
    // Command Info
    private final String name = "chatbot"; // The name of the command that will be referred to in the program
    private final String description = "Use language to run commands"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 0.5; // The version of this command

    public AIMode() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        System.out.println("Welcome To chatbot Mode");
        System.out.println("You can use language to run commands");
        System.out.println("you can ask it to exit or list current supported commands");
    }
}
