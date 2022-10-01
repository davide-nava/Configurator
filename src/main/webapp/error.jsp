<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>

    <jsp:include page="/shared/head.jsp"/>

    <title>Errore</title>
</head>

<body class="white-bg">
<div class="wrapper wrapper-content" style="">
    <div class="row" style="">
        <div class="col" style="margin: 20% 0; ">
            <div class="row">
                <div class="col text-center">
                    <h1>Errore</h1>
                    <h3 class="font-bold">Internal Server Error</h3>

                    <div class="error-desc">
                        <%=exception.getMessage() %><br>
                        <br><a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary m-t">Home</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/shared/js.jsp"/>

</body>
</html>