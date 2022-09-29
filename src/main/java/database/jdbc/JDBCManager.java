package database.jdbc;

import server.Item;

import java.sql.*;

public class JDBCManager {

    private final String DB_URL = "jdbc:mysql://localhost:3306/onlinestore";
    private final String USER = "temp_oob";
    private final String PW = "temp";
    private Connection conn = null;

    public JDBCManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PW);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Method to save an item to database
    public void addItemToDatabase(Item item) {
        String query = "INSERT INTO items (item_name, price, category_id) VALUES (?, ?, ?)";

        try (PreparedStatement pStmt = conn.prepareStatement(query)) {
            pStmt.setString(1, item.getName());
            pStmt.setInt(2, item.getPrice());
            pStmt.setString(3, item.getCategory());
            pStmt.executeUpdate();

            System.out.println(item.getName() + " added to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Method to retrieve all item from database
    public Item getItemFromDatabase(int index) {
        String query = "SELECT * FROM items WHERE item_id = ?";

        try (PreparedStatement pStmt = conn.prepareStatement(query)) {
            pStmt.setInt(1, index);
            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                String itemName = rs.getString(2);
                int itemPrice = rs.getInt(3);
                String itemCategory = rs.getString(4);

                return new Item(itemName, itemPrice, itemCategory);
            } else {
                System.out.println("NO ITEM!");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int countAllEntriesInDatabase() {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT COUNT(item_id) FROM items");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    //Method to search for item.

    //Method to show a category


}










