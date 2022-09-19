<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>


</h1>

<%
    Class.forName("org.sqlite.JDBC");
    Connection conn =
            DriverManager.getConnection("jdbc:sqlite:DB/configurator.db");
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

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>