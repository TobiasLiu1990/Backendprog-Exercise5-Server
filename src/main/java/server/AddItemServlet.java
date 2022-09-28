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
        String itemName = req.getParameter("itemName");
        String itemPrice = req.getParameter("itemPrice");
        String itemQuantity = req.getParameter("itemQuantity");

        logger.info("\nAdded Item: \n" +
                        "Item name={} \n" +
                        "Item price={} \n" +
                        "Item quantity={}",
                itemName, itemPrice, itemQuantity);
    }
}
