package server;

public class Item {

    private final String name;
    private final int price;
    private final String category;

    public Item(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }


    @Override
    public String toString() {
        return "Item: " + name + "\n" +
                "Price: " + price + "\n" +
                "Category: " + category;
    }
}
