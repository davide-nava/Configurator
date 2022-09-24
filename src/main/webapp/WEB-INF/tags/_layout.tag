<%@tag description="Simple Template" pageEncoding="UTF-8" %>

<%@attribute name="title" %>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>

<!DOCTYPE html>
<html lang="it">
<head>

    <jsp:include page="/shared/head.jsp"/>

    <title>${title}</title>

    <jsp:invoke fragment="head_area"/>

</head>
<body class=" pace-done fixed-nav fixed-sidebar  ">
<div class="pace  pace-inactive">
    <div class="pace-progress" data-progress-text="100%" data-progress="99" style="transform: translate3d(100%, 0px, 0px);">
    <div class="pace-progress-inner"></div>
</div>
    <div class="pace-activity"></div></div>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation" id="nabBarSx">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="block m-t-xs font-bold">Configuratore<br/>Nava Davide<br/>Mat 001452422 </span>
                        </a>
                    </div>
                    <div class="logo-element">
                        ND
                    </div>
                </li>
                <%--
                   <li>
                      <a href="${pageContext.request.contextPath}/tables/articlearticlegrouptype/list.jsp"><i class="fa fa-table"></i> <span class="nav-label">ArticleArticleGroupType</span></a>
                  </li>
                    --%>
                <li>
                    <a href="${pageContext.request.contextPath}/tables/article/list.jsp"><i class="fa fa-table"></i>
                        <span class="nav-label">Articoli</span></a>
                </li>
                <%--
                   <li>
                       <a href="${pageContext.request.contextPath}/tables/articlegrouptype.j/list.jspsp"><i class="fa fa-table"></i> <span class="nav-label">ArticleGroupType</span></a>
                   </li>
                    --%>
                <li>
                    <a href="${pageContext.request.contextPath}/tables/articlemachine/list.jsp"><i
                            class="fa fa-table"></i> <span class="nav-label">Articoli macchina</span></a>
                </li>
                <%--
                   <li>
                       <a href="${pageContext.request.contextPath}/tables/articlemachinetype/list.jsp"><i class="fa fa-table"></i> <span class="nav-label">ArticleMachineType</span></a>
                   </li>
                  --%>
                <li>
                    <a href=${pageContext.request.contextPath}/tables/articletype/list.jsp"><i class="fa fa-table"></i>
                        <span class="nav-label">Tipo articoli</span></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/tables/customer/list.jsp"><i class="fa fa-table"></i>
                        <span class="nav-label">Clienti</span></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/tables/invoice/list.jsp"><i class="fa fa-table"></i>
                        <span class="nav-label">Fatture</span></a>
                </li>
                <%--   
                 <li>
                        <a href="${pageContext.request.contextPath}/tables/invoiceitem/list.jsp"><i class="fa fa-table"></i> <span class="nav-label">InvoiceItem</span></a>
                    </li> 
                    --%>
                <li>
                    <a href="${pageContext.request.contextPath}/tables/machine/list.jsp"><i class="fa fa-table"></i>
                        <span class="nav-label">Macchine</span></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/tables/machinetype/list.jsp"><i class="fa fa-table"></i>
                        <span class="nav-label">Tipo macchina</span></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/tables/tables.jsp"><i class="fa fa-table"></i> <span
                            class="nav-label">Tabelle</span></a>
                </li>
            </ul>
        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg  ">
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