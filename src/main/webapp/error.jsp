<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Errore</title>

        <style data-merge-styles="true"></style>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body class="gray-bg">

        <div class="middle-box text-center animated fadeInDown">
            <h1>Errore</h1>
            <h3 class="font-bold">Internal Server Error</h3>

            <div class="error-desc">
                <%=exception.getMessage() %><br>
                <br><a href="/" class="btn btn-primary m-t">Home</a>
            </div>
        </div>

        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.js"></script>

    </body>
</html>