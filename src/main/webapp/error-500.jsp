<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>

    <jsp:include page="/shared/head.jsp" />

</head>

<body class="gray-bg">

    <div class="middle-box text-center animated fadeInDown">
        <h1>500</h1>
        <h3 class="font-bold">Internal Server Error</h3>

        <div class="error-desc">
            <br><a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary m-t">Home</a>
        </div>
    </div>

    <jsp:include page="/shared/js.jsp" />

</body>
</html>