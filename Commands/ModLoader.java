package Commands;

import Items.Item;
import Main.Main;

public class ModLoader extends Command {
    //Command Info
    private final String name = "mods"; //The name of the command that will be referred to in the program
    private final String description = "Loads commands and mods"; //The description of the command
    private final boolean debugCommand = false; //weather to show only when debug mode is on
    private final String author = "Rave_Wyvern"; //Your name
    private final double version = 1.0; //The version of this comand

    public ModLoader() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        System.out.println("Currently Installed Commands");
        System.out.println();
        System.out.println("System Commands:");
        for (Command command : Main.commandList) {
            // Only show debug commands if debugMode is enabled
            if (command.getAuthor().equals("Rave_Wyvern")) {
                System.out.println(command.getName() + " v" + command.getVersion());
                System.out.println("- " + command.getDescription());
                System.out.println();
            }
        }
        System.out.println("Additional Commands:");
        for (Command command : Main.commandList) {
            // Only show debug commands if debugMode is enabled
            if (!command.getAuthor().equals("Rave_Wyvern")) {
                System.out.println(command.getName() + " v" + command.getVersion() + " by " + command.getAuthor());
                System.out.println("- " + command.getDescription());
                System.out.println();
            }
        }
    }

    @Override
    public void settings(Item[] items) {
        System.out.println("This command does not have any settings.");
    }

    public void help(Item[] items) {
        System.out.println("This command does not have a help section yet.");
    }
}
