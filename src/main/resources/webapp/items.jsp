<%@ page import="server.Item" %>
<%@ page import="server.ItemRepository" %>
<!DOCTYPE html>
<html lang="eng">
<head>
    <meta charset="UTF-8">
    <title>Testing JSP</title>
</head>
<body>
<h2>Show all items using JSP</h2>

<ul>
    <% for (Item item : ItemRepository.getInstance().getItems()) { %>
    <li><%= item %>
    </li>
    <% } %>
</ul>

</body>
</html>