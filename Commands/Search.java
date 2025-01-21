package Commands;
import Items.Item;

import java.util.Scanner;

public class Search extends Command {
    // Command Info
    private final String name = "Search"; // The name of the command that will be referred to in the program
    private final String description = "Search through items"; // The description of the command
    private final boolean debugCommand = false; // Whether to show only when debug mode is on
    private final String author = "Rave_Wyvern"; // Your name
    private final double version = 1.0; // The version of this command

    public Search() {
        super(); // Call the Command constructor
        this.setName(name); // Setting the name in the parent class
        this.setDescription(description); // Setting the description in the parent class
        this.setDebugCommand(debugCommand); // Setting whether it is a debug command
        this.setAuthor(author); // Setting the author
        this.setVersion(version); // Setting the version
    }

    @Override
    public void run(Item[] items) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your search term: ");
        String searchTerm = scanner.nextLine();

        boolean searchForPrice = false, searchForQuantity = isInteger(searchTerm), searchForCatagory = true, searchForName = true;
        for (int i = 0; i < searchTerm.length(); i++) {
            if (searchTerm.charAt(i) == '$' || searchTerm.charAt(i) == '.') {
                searchForPrice = true;
                searchForName = false;
                searchForCatagory = false;
                return;
            }
        }

        System.out.println("Item Name Search Results:");
        if (searchForName) {
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(searchTerm)) {
                    System.out.println(item.getName() + " - " + item.getQuantity() + " - " + item.getPrice() + " - " + item.getCatagory());
                    return;
                }
            }
        }
        //TODO: Add searching for price, quantity, and catagory
        //TODO: make the search look for words instead of exact matches

    }

    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("-?\\d+");
    }

    @Override
    public void settings(Item[] items) {
        System.out.println("This command will have settings soon");
        //TODO: Add settings
    }

    public void help(Item[] items) {
        System.out.println("A help section will be coming soon.");
        //TODO: Add help section
    }
}
