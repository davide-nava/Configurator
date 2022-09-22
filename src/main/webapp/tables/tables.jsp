<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
<!DOCTYPE html>
<html>

    <head>
        <title>JSP - Hello World</title>

        <link rel="stylesheet" href="resources/stylesheet/common.css" />
        <link rel="stylesheet" href="resources/stylesheet/index.css" />
        <script type="text/javascript" src="resources/js/validators/loginValidator.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <h1>
            <%= "Hello World!" %>


        </h1>

        <%
Class.forName("org.sqlite.JDBC");
Connection conn =
    DriverManager.getConnection("jdbc:sqlite:/Users/davide/OneDrive - nexus-schweiz.ch/Uni/LINGUAGGI DI PROGRAMMAZIONE/progetto/Configurator/DB/configurator.db");
Statement stat = conn.createStatement();

ResultSet rs = stat.executeQuery("select * from User;");

while (rs.next()) {
out.println("<tr>");
out.println("<td>" + rs.getString("UserId") + "</td>");
out.println("<td>" + rs.getString("Name") + "</td>");
out.println("</tr>");
}

rs.close();
conn.close();
        %>

        <br />
        <a href="hello-servlet">Hello Servlet</a>
    </body>

</html>