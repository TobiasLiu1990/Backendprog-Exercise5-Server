package server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ListItemServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ListItemServlet.class);
    private final Storage storage = new Storage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(storage.getItems());

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
}
