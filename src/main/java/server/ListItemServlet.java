package server;

import com.mysql.cj.xdevapi.JsonArray;
import database.jdbc.JDBCManager;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ListItemServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ListItemServlet.class);
    private final ItemRepository itemRepository;
    private final JDBCManager jdbcManager;

    public ListItemServlet(ItemRepository itemRepository, JDBCManager jdbcManager) {
        this.itemRepository = itemRepository;
        this.jdbcManager = jdbcManager;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("Here are the books at path: " + req.getPathInfo());

//        resp.getWriter().write("<ul>");
//        for (Item item : itemRepository.getItems()) {
//            resp.getWriter().write("<li>" + item + "</li>");
//        }
//        resp.getWriter().write("<ul>");


        //Use DB instead to find item
        int allItems = jdbcManager.countAllEntriesInDatabase();

        //L6 - JSON
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (int i = 1; i <= allItems; i++) {
            Item tempItem = jdbcManager.getItemFromDatabase(i);

            arrayBuilder.add(Json.createObjectBuilder()
                    .add("name", tempItem.getName())
                    .add("price", tempItem.getPrice())
                    .add("category", tempItem.getCategory()));
        }

        if ("application/json".equals(req.getHeader("Accept"))) {
            resp.getWriter().write(arrayBuilder.build().toString());
        } else {
            resp.getWriter().write("<ul>");
            for (int i = 1; i <= allItems; i++) {
                Item tempItem = jdbcManager.getItemFromDatabase(i);

                resp.getWriter().write("<li>" + tempItem + "</li>");
                resp.getWriter().write("<hr>");
            }
            resp.getWriter().write("</ul>");
        }

        logger.info("Should list all items");
    }
}
