package server;

import java.util.ArrayList;

public class ItemRepository {

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void showAllItemsInStorage() {
        for (Item i : items) {
            System.out.println(i);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
