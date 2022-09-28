package server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ItemStorageServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ItemStorageServlet.class);
//    private ItemRepository storage = new ItemRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println(storage.getItems());

//        for (Item i : storage.getItems()) {
//            resp.getWriter().println(
//                    i.getName() + "\n" +
//                    i.getName() + "\n" +
//                    i.getQuantity());
//        }
//
//        storage.showAllItemsInStorage();

        logger.info("Should list all items");
    }

    public void addItemToStorage() {

    }

}
