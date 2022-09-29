package server;

import database.jdbc.JDBCManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

public class AddItemServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AddItemServlet.class);
    private final ItemRepository itemRepository;
    private final JDBCManager jdbcManager;

    public AddItemServlet(ItemRepository itemRepository, JDBCManager jdbcManager) {
        this.itemRepository = itemRepository;
        this.jdbcManager = jdbcManager;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get input from web
        String itemName = req.getParameter("itemName");
        int itemPrice = Integer.parseInt(req.getParameter("itemPrice"));
        String itemCategory = req.getParameter("itemCategory");

        //Save the input to item object.
        Item item = new Item(itemName, itemPrice, itemCategory);

        //Save the item object to storage
        itemRepository.addItem(item);


        //DB (Can remove itemRepository if DB is added?)
        try {
            jdbcManager.addItemToDatabase(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        logger.info("\nAdded Item:" + item);
    }
}
