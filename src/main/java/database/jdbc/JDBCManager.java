package database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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





}










