package Commands;
import Items.Item;
import Main.Main;

import java.util.Objects;

public abstract class Command {
    private String name;
    private String description;
    private boolean debugCommand;
    private String author;
    private double version;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDebugCommand() {
        return debugCommand;
    }

    public String getAuthor() {
        return author;
    }

    public double getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDebugCommand(boolean debugCommand) {
        this.debugCommand = debugCommand;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return debugCommand == command.debugCommand && Double.compare(version, command.version) == 0 && Objects.equals(name, command.name) && Objects.equals(description, command.description) && Objects.equals(author, command.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, debugCommand, author, version);
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", debugCommand=" + debugCommand +
                ", author='" + author + '\'' +
                ", version=" + version +
                '}';
    }

    public Command() {
        this.name = "Failed to Load";
        this.description = "Failed to Load";
        this.debugCommand = false;
        this.author = "Failed to Load";
        this.version = 0.0;
    }

    public abstract void run(Item[] items);

    public abstract void settings(Item[] items);

    public abstract void help(Item[] items);
}
