# Command Examples
## Example 1
```java
package Commands;
import Items.Item;
import Main.Main;

public class Help extends Command {
    //Command Info
    private final String name = "Help"; //The name of the command that will be referred to in the program
    private final String description = "View Info On Commands"; //The description of the command
    private final boolean debugCommand = false; //weather to show only when debug mode is on
    private final String author = "Rave_Wyvern"; //Your name
    private final double version = 1.0; //The version of this comand

    public Help() {
        this.setName(name);
        this.setDescription(description);
        this.setDebugCommand(debugCommand);
        this.setAuthor(author);
        this.setVersion(version);
    }

    @Override
    public void run(Item[] items) {
        String[] commandNames = {"add", "remove", "view"};
        String[] commandDescriptions = {"Add an item to the inventory", "Remove an item from the inventory", "View the inventory"};
        System.out.println("Commands:");
        for (int i = 0; i < commandNames.length; i++)
        {
            if (commandNames[i].charAt(0) == 'd' && commandNames[i].charAt(2) == 'e' && commandNames[i].charAt(2) == 'b' && commandNames[i].charAt(2) == 'u' && commandNames[i].charAt(4) == 'g') {
                if (Main.debugMode)
                {
                    System.out.println(commandNames[i] + " - " + commandDescriptions[i]);
                }
            }
            else
            {
                System.out.println(commandNames[i] + " - " + commandDescriptions[i]);
            }
        }
    }
}
```
## Example 2
```java
package Commands;
import Items.Item;
import Main.Main;

public class COMMAND_NAME_HERE extends Command {
    //Command Info
    private final String name = "NAME HERE"; //The name of the command that will be referred to in the program
    private final String description = "DESCRIPTION HERE"; //The description of the command
    private final boolean debugCommand = false; //weather to show only when debug mode is on
    private final String author = "AUTHOR NAME HERE"; //Your name
    private final double version = 0.0; //The version of this comand

    public COMMAND_NAME_HERE() {
        this.setName(name);
        this.setDescription(description);
        this.setDebugCommand(debugCommand);
        this.setAuthor(author);
        this.setVersion(version);
    }

    @Override
    public void run(Item[] items) {
        /*
                This is where you would put your command that would be run
         */
    }
}
```