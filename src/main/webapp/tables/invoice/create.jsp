<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Fattura">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuova fattura</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/customer/create">
                                            <input type="hidden" name="frmEditCustomerId"  id="frmEditCustomerId"      >

                                            <div class="mb-3">
                                                <label for="frmEditDt">Data</label>
                                                <div id="frmEditDt" name="frmEditDt"
                                                     class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditCustomerIdLookup">Cliente</label>
                                                <div class="form-control" id="frmEditCustomerIdLookup"
                                                    required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditTotal">Numero</label>
                                                <input type="text" class="form-control" id="frmEditNr"
                                                       name="frmEditNr" required
                                                       >
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditTotal">Totale</label>
                                                <input type="number" class="form-control" id="frmEditTotal"
                                                       name="frmEditTotal" required
                                                       placeholder="1000"  >
                                            </div>

                                            <div class="d-grid gap-1">
                                                <button type="submit" class="btn btn-primary"><i
                                                        class="fa-solid fa-floppy-disk"></i></button>
                                            </div>

                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                                <script>
                                    $(() => {
                                        const now = new Date();

                                        $('#frmEditDt').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: now,
                                        });

                                        $('#frmEditCustomerIdLookup').dxLookup({
                                            dataSource: {
                                                store: {
                                                    type: 'odata',
                                                    url: '${pageContext.request.contextPath}/api/lookup/customer',
                                                    key: 'id',
                                                },
                                            },
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            value: '${tmpVal.getArticleTypeId()}',
                                            onValueChanged(e) {
                                                $('#frmEditCustomerId').val(e.value);
                                            },
                                        });

                                    });

                                    $(function () {
                                        $('#menuSxInvoice').addClass('active');
                                    });
                                </script>

            </jsp:attribute>
</t:_layout>