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

                        <div class="row mt-3 mb-3 text-center">
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary   " style="width: 100%;" href="${pageContext.request.contextPath}/tables/articlearticlegrouptype/list.jsp"><i
                                        class="fa fa-table"></i> Articoli tipo gruppo articolo</a>
                            </div>
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/article/list.jsp"><i
                                        class="fa fa-table"></i> Articoli</a>
                            </div>
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/articlegrouptype.j/list.jsp"><i
                                        class="fa fa-table"></i> Articoli gruppo articolo</a>
                            </div>
                        </div>
                        <div class="row mb-3 text-center">
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/articlemachine/list.jsp"><i
                                        class="fa fa-table"></i> Articoli macchina</a>
                            </div>
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/articlemachinetype/list.jsp"><i
                                        class="fa fa-table"></i> Articoli tipo macchina</a>
                            </div>
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/articletype/list.jsp">
                                    <i class=" fa fa-table "></i> Tipo articoli</a>
                            </div>
                        </div>
                        <div class="row mb-3 text-center">
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/customer/list.jsp">
                                    <i class=" fa fa-table "></i> Clienti</a>
                            </div>
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/invoice/list.jsp"><i
                                        class=" fa fa-table "></i> Fatture</a>
                            </div>

                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/invoiceitem/list.jsp"><i
                                        class=" fa fa-table "></i> Riga fattura</a>
                            </div>
                        </div>
                        <div class="row mb-3 text-center">
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/machine/list.jsp">
                                    <i class=" fa fa-table "></i> Macchine</a>
                            </div>
                            <div class="col-4 themed-grid-col">
                                <a class="btn btn-primary" style="width: 100%;" href="${pageContext.request.contextPath}/tables/machinetype/list.jsp"><i
                                        class=" fa fa-table "></i> Tipo macchina</a>
                            </div>
                            <div class="col-4 themed-grid-col">
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>


    </jsp:attribute>

</t:_layout>