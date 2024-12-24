package Commands;
import Items.Item;
import Main.Main;

public class Help extends Command {
    // Command Info
    private final String name = "help"; // The name of the command that will be referred to in the program
    private final String description = "View Info On Commands"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 1.0; // The version of this command

    public Help() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        System.out.println("Commands:");

        // Loop through all the loaded commands and display their names and descriptions
        for (Command command : Main.commandList) {
            // Only show debug commands if debugMode is enabled
            if (!command.isDebugCommand() || Main.debugMode) {
                System.out.println(command.getName() + " - " + command.getDescription());
            }
        }
    }
}
