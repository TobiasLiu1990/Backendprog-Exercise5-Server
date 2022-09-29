package database.jdbc;

import server.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCManager {

    private final String DB_URL = "jdbc:mysql://localhost:3306/quizDB";
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
    public void addItemToDatabase(Item item) throws SQLException {
        String query = "INSERT INTO items (item_name, price, category_id) VALUES (?, ?, ?)";

        try (PreparedStatement pStmt = conn.prepareStatement(query)) {
            pStmt.setString(1, item.getName());
            pStmt.setInt(2, item.getPrice());
            pStmt.setString(3, item.getCategory());
            pStmt.executeUpdate();

            System.out.println("Item added to db");
        }
    }

    //Method to retrieve item from database
    public Item getItemFromDatabase() {
        return null;
    }



    //Method to search for item.

    //Method to show a category


}










