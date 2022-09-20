<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@tag description="Simple Template" pageEncoding="UTF-8"  %>

<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>

<!DOCTYPE html>

<html lang="it">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="description" content="Configuratore">
    <meta name="author" content="Davide Nava">
    <meta property="og:title" content="Configuratore">
    <meta property="og:type" content="website">
    <!-- <meta property="og:url" content="https://www.sitepoint.com/a-basic-html5-template/"> -->
    <meta property="og:description" content="Configuratore">
    <!-- <meta property="og:image" content="image.png"> -->
    <link rel="icon" href="/img/favicon.ico">
    <link rel="icon" href="/img/favicon.svg" type="image/svg+xml">
    <link rel="apple-touch-icon" href="/apple-touch-icon.png">


    <script src="/script/jquery.min.js"></script>

    <script>window.jQuery || document.write(decodeURIComponent('%3Cscript src="js/jquery.min.js"%3E%3C/script%3E'))</script>

    <link rel="stylesheet" type="text/css" href="/lib/devepress/css/dx.common.css" />
    <link rel="stylesheet" type="text/css" href="/lib/devepress/css/dx.light.css" />
    <script src="/lib/devepress/js/dx.all.js"></script>

    <link rel="stylesheet" href="/css/configurator.css">

    <title>${title}</title>

    <jsp:invoke fragment="head_area"/>
</head>
<body>

<jsp:invoke fragment="body_area"/>

<script type="text/javascript" src="/script/configurator.js"></script>

</body>
</html>

















<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
<!DOCTYPE html>
<html>

<head>
    <title>JSP - Hello World</title>

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