<%@tag description="Simple Template" pageEncoding="UTF-8" %>

<%@attribute name="title" %>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>

<!DOCTYPE html>
<html lang="it" data-lt-installed="true" >
<head>

    <jsp:include page="/shared/head.jsp"/>

    <title>${title}</title>

    <jsp:invoke fragment="head_area"/>

</head>
<body class=" pace-done fixed-nav mini-navbar  ">
<script>
    DevExpress.localization.locale(navigator.language);
</script>
<div class="pace  pace-inactive">
    <div class="pace-progress" data-progress-text="100%" data-progress="99"
         style="transform: translate3d(100%, 0px, 0px);">
        <div class="pace-progress-inner"></div>
    </div>
    <div class="pace-activity"></div>
</div>

<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation" id="nabBarSx">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="${pageContext.request.contextPath}/index.jsp">
                            <span class="block m-t-xs font-bold">Configuratore<br/>Nava Davide<br/>Mat 001452422 </span>
                        </a>
                    </div>
                    <div class="logo-element">
                        <a   href="${pageContext.request.contextPath}/index.jsp">   ND </a>
                    </div>
                </li>
                <li>
                    <a id="menuSxArticle" href="${pageContext.request.contextPath}/tables/article/list.jsp"><i class="fa-solid fa-gear"></i>
                        <span class="nav-label">Articoli</span></a>
                </li>
                <li>
                    <a id="menuSxArticleMachine" href="${pageContext.request.contextPath}/tables/articlemachine/list.jsp"><i class="fa-solid fa-list"></i> <span class="nav-label">Articoli macchina</span></a>
                </li>
                <li>
                    <a id="menuSxArticleType" href=${pageContext.request.contextPath}/tables/articletype/list.jsp"><i class="fa-solid fa-microchip"></i>
                        <span class="nav-label">Tipo articoli</span></a>
                </li>
                <li>
                    <a id="menuSxCustomer" href="${pageContext.request.contextPath}/tables/customer/list.jsp"><i class="fa-solid fa-users"></i>
                        <span class="nav-label">Clienti</span></a>
                </li>
                <li>
                    <a id="menuSxInvoice" href="${pageContext.request.contextPath}/tables/invoice/list.jsp"><i class="fa-solid fa-receipt"></i>
                        <span class="nav-label">Fatture</span></a>
                </li>
                <li>
                    <a id="menuSxMachine" href="${pageContext.request.contextPath}/tables/machine/list.jsp"><i class="fa-solid fa-industry"></i>
                        <span class="nav-label">Macchine</span></a>
                </li>
                <li>
                    <a id="menuSxMachineType" href="${pageContext.request.contextPath}/tables/machinetype/list.jsp"><i class="fa-solid fa-microchip"></i>
                        <span class="nav-label">Tipo macchina</span></a>
                </li>
                <li>
                    <a id="menuSxTables" href="${pageContext.request.contextPath}/tables/tables.jsp"><i class="fa fa-table"></i> <span
                            class="nav-label">Tabelle</span></a>
                </li>
            </ul>
        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg  " style="padding-left: 12px; padding-right: 0px; ">
        <div class="row border-bottom border-bottom-blue">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0px; height: 62px;">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li style="padding: 20px">
                        <span class="m-r-sm welcome-message txt-blue">Configura la tua macchina</span>
                    </li>
                </ul>

            </nav>
        </div>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <jsp:invoke fragment="body_area"/>
                </div>

            </div>
        </div>
    </div>
</div>

<jsp:include page="/shared/js.jsp"/>

</body>
</html>