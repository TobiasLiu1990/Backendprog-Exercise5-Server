package server;

import java.util.ArrayList;

public class ItemRepository {

    private ArrayList<Item> items = new ArrayList<>();

    //For JSP
    private static ItemRepository instance = new ItemRepository();
    //For JSP


    //For JSP
    public static ItemRepository getInstance() {
        return instance;
    }
    //For JSP


    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
