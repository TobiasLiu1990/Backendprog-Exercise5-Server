package server;

public class Item {
    private final String name;
    private final int price;
    private final int quantity;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item: " + name + "\n" +
                "Price: " + price + "\n" +
                "Quantity: " + quantity;
    }
}