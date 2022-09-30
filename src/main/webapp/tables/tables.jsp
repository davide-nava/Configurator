<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Tabelle">

    <jsp:attribute name="body_area">

        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>Tabelle</h5>

                    </div>
                    <div class="ibox-content ">

                        <div class="row ">

                            <div class="col-4">
                                <div class="d-grid gap-4 text-center">
                                    <a class="btn btn-primary   "
                                       href="${pageContext.request.contextPath}/tables/articlearticlegrouptype/list.jsp"><i
                                            class="fa-solid fa-microchip"></i><br/>Articoli tipo gruppo articolo</a>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/articlemachine/list.jsp"><i
                                            class="fa-solid fa-list"></i><br/>Articoli macchina</a>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/customer/list.jsp">
                                        <i class="fa-solid fa-users"></i><br/>Clienti</a>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/machine/list.jsp">
                                        <i class="fa-solid fa-industry"></i><br/>Macchine</a>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="d-grid gap-4 text-center">
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/article/list.jsp"><i
                                            class="fa-solid fa-gear"></i><br/>Articoli</a>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/articlemachinetype/list.jsp"><i
                                            class="fa-solid fa-microchip"></i><br/>Articoli tipo macchina</a>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/invoice/list.jsp"><i
                                            class="fa-solid fa-receipt"></i><br/>Fatture</a>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/machinetype/list.jsp"><i
                                            class="fa-solid fa-microchip"></i><br/>Tipo macchina</a>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="d-grid gap-4 text-center">
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/articlegrouptype.j/list.jsp"><i
                                            class="fa-solid fa-microchip"></i><br/>Articoli gruppo articolo</a>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/articletype/list.jsp"><i
                                            class="fa-solid fa-microchip"></i><br/>Tipo articoli</a>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath}/tables/invoiceitem/list.jsp"><i
                                            class="fa-solid fa-list-check"></i><br/>Riga fattura</a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

                        <script>
                            $(function () {
                                $('#menuSxTables').addClass('active');
                            });
                        </script>

    </jsp:attribute>

</t:_layout>