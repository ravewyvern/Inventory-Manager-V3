package Commands;
import Items.Item;

import java.util.Objects;

public class Command {
    private String name;
    private String Description;
    private boolean DebugCommand;

    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isDebugCommand() {
        return DebugCommand;
    }

    public void setDebugCommand(boolean debugCommand) {
        DebugCommand = debugCommand;
    }

    //tostring
    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                ", DebugCommand=" + DebugCommand +
                '}';
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return DebugCommand == command.DebugCommand && Objects.equals(name, command.name) && Objects.equals(Description, command.Description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Description, DebugCommand);
    }

    //constructors
    public Command(String name, String description, boolean debugCommand) {
        this.name = name;
        Description = description;
        DebugCommand = debugCommand;
    }

    public Command() {
        this.name = "None";
        Description = "Empty description";
        DebugCommand = false;
    }

    public void run(Item[] items) {
        System.out.println("You shouldnt be seeing this");
    }
}
