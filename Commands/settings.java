package Commands;
import Items.Item;
import java.util.Scanner;
import Main.Main;

public class settings extends Command {
    // Command Info
    private final String name = "settings"; // The name of the command that will be referred to in the program
    private final String description = "Edit command settings"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 1.0; // The version of this command

    public settings() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the command name to edit the settings: ");
        String commandName = input.nextLine();
        for (Command command : Main.commandList) {
            if (command.getName().equals(commandName)) {
                command.settings(items);
                return;
            }
        }
    }

    @Override
    public void settings(Item[] items) {
        System.out.println("You cannot edit the settings of the settings command dumb ass.");
    }

    public void help(Item[] items) {
        System.out.println("This command does not have a help section yet.");
    }
}
