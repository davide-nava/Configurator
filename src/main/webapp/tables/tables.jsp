<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

        <t:_layout title="Tabelle">

            <jsp:attribute name="body_area">


                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Tabelle</h5>
                                <!-- <div class="ibox-tools">
                                    <a class="collapse-link" href="">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="#" class="dropdown-item">Config option 1</a>
                                        </li>
                                        <li><a href="#" class="dropdown-item">Config option 2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link" href="">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div> -->
                            </div>
                            <div class="ibox-content no-padding">
                                <div class="row">
                                    <div class="col-12">
                                        <div class="row">
                                            <div class="col-3">
                                                <a class="btn btn-primary btn-lg " style="width: 90%;" href="${pageContext.request.contextPath}/tables/articlearticlegrouptype/list.jsp"><i
                                                class="fa fa-table"></i> <span
                                                class="nav-label">ArticleArticleGroupType</span></a>
                                            </div>
                                            <div class="col-3">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/article/list.jsp"><i
                                                class="fa fa-table"></i> <span class="nav-label">Articoli</span></a>
                                            </div>
                                            <div class="col-3">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/articlegrouptype.j/list.jspsp"><i
                                                class="fa fa-table"></i> <span
                                                class="nav-label">ArticleGroupType</span></a>
                                            </div>
                                            <div class="col-3">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/articlemachine/list.jsp"><i
                                                class="fa fa-table"></i>
                                            <span class="nav-label">Articoli macchina</span></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-3"> <a class="btn btn-primary btn-lg" style="width: 90%;" style="width: 90%;" href="${pageContext.request.contextPath}/tables/articlemachinetype/list.jsp"><i
                                                class="fa fa-table"></i> <span
                                                class="nav-label">ArticleMachineType</span></a>
                                            </div>
                                            <div class="col-3">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/articletype/list.jsp">
                                                    <i class=" fa fa-table "></i> <span class=" nav-label ">Tipo
                                                articoli</span></a>
                                            </div>
                                            <div class=" col-3 ">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/customer/list.jsp">
                                                    <i class=" fa fa-table "></i>
                                                    <span class=" nav-label ">Clienti</span></a>
                                            </div>
                                            <div class=" col-3 ">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/invoice/list.jsp"><i
                                                class=" fa fa-table "></i>
                                            <span class=" nav-label ">Fatture</span></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class=" col-3 ">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/invoiceitem/list.jsp"><i
                                                class=" fa fa-table "></i>
                                            <span class=" nav-label ">InvoiceItem</span></a>
                                            </div>
                                            <div class=" col-3 ">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/machine/list.jsp">
                                                    <i class=" fa fa-table "></i>
                                                    <span class=" nav-label ">Macchine</span></a>
                                            </div>
                                            <div class=" col-3 ">
                                                <a class="btn btn-primary btn-lg" style="width: 90%;" href="${pageContext.request.contextPath}/tables/machinetype/list.jsp"><i
                                                class=" fa fa-table "></i>
                                            <span class=" nav-label ">Tipo macchina</span></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </jsp:attribute>

        </t:_layout>