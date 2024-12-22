package Items;

import java.util.Objects;

/**
 * Represents an item in the inventory.
 *
 * @author Katelyn Nova Powers
 *
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
Items.Item.java
-----------------------------------------
- name: String
- price: double
- quantity: int
- Catagory: String
- isOverwriteable: boolean
-----------------------------------------
+ Items.Item()
+ Items.Item(name: String, price: double, quantity: int, Catagory: String, isOverwriteable: boolean)
+ getName(): String
+ getPrice(): double
+ getQuantity(): int
+ getCatagory(): String
+ isOverwriteable(): boolean
+ setName(name: String): void
+ setPrice(price: double): void
+ setQuantity(quantity: int): void
+ setCatagory(Catagory: String): void
+ setOverwriteable(isOverwriteable: boolean): void
+ toString(): String
+ equals(o: Object): boolean
+ setAll(name: String, price: double, quantity: int, Catagory: String, isOverwriteable: boolean): void
-----------------------------------------
*/

public class Item
{
    /***** STATIC VARIABLES *****/

    /***** INSTANCE VARIABLES *****/
    private String name;
    private double price;
    private int quantity;
    private String Catagory;
    private boolean isOverwriteable;

    /***** CONSTRUCTORS *****/
    /**
     * Creates a new Items.Item with the given name, price, quantity, catagory, and overwriteable status.
     * @param name the name of the item
     * @param price the price of the item
     * @param quantity the quantity of the item
     * @param catagory the catagory of the item
     * @param isOverwriteable the overwriteable status of the item
     */
    public Item(String name, double price, int quantity, String catagory, boolean isOverwriteable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        Catagory = catagory;
        this.isOverwriteable = isOverwriteable;
    }

    /**
     * Creates a new Items.Item with default values.
     */
    public Item() {
        this.name = "Unknown";
        this.price = 0;
        this.quantity = 0;
        Catagory = "Unknown";
        this.isOverwriteable = true;
    }

    /***** ACCESSORS *****/
    /**
     * Returns the name of the item.
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the item.
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the quantity of the item.
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the catagory of the item.
     * @return the catagory of the item
     */
    public String getCatagory() {
        return Catagory;
    }

    /**
     * Returns the overwriteable status of the item.
     * @return the overwriteable status of the item
     */
    public boolean isOverwriteable() {
        return isOverwriteable;
    }
    /***** MUTATORS *****/

    /**
     * Sets the name of the item.
     * @param name the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the item.
     * @param price the price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the quantity of the item.
     * @param quantity the quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the catagory of the item.
     * @param catagory the catagory of the item
     */
    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    /**
     * Sets the overwriteable status of the item.
     * @param overwriteable the overwriteable status of the item
     */
    public void setOverwriteable(boolean overwriteable) {
        isOverwriteable = overwriteable;
    }
    /***** OTHER REQUIRED METHODS *****/
    @Override
    /**
     * Returns a string representation of the item.
     * @return a string representation of the item
     */
    public String toString() {
        return "Items.Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", Catagory='" + Catagory + '\'' +
                ", isOverwriteable=" + isOverwriteable +
                '}';
    }

    @Override
    /**
     * Determines if two items are equal.
     * @param o the object to compare
     * @return true if the items are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(price, item.price) == 0 && quantity == item.quantity && isOverwriteable == item.isOverwriteable && Objects.equals(name, item.name) && Objects.equals(Catagory, item.Catagory);
    }

    /**
     * Sets all the values of the item.
     * @param name the name of the item
     * @param price the price of the item
     * @param quantity the quantity of the item
     * @param catagory the catagory of the item
     * @param isOverwriteable the overwriteable status of the item
     */
    public void setAll(String name, double price, int quantity, String catagory, boolean isOverwriteable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.Catagory = catagory;
        this.isOverwriteable = isOverwriteable;
    }
    /***** HELPER METHODS *****/

}