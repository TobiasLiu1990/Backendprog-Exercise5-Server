package server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AddItemServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AddItemServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get input from web
        String itemName = req.getParameter("itemName");
        int itemPrice = Integer.parseInt(req.getParameter("itemPrice"));
        int itemQuantity = Integer.parseInt(req.getParameter("itemQuantity"));

        //Save the input to item object.
        Item item = new Item(itemName, itemPrice, itemQuantity);

        //Save the item object to storage
        new Storage().saveItemToStorage(item);

//        System.out.println(item + "\n\n");

        logger.info("\nAdded Item: \n" +
                        "Item name={} \n" +
                        "Item price={} \n" +
                        "Item quantity={}",
                itemName, itemPrice, itemQuantity);
    }
}
