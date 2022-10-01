<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Riga fattura">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuova riga fattura</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/invoiceitem/create">

          <input type="hidden" name="frmEditInvoiceId" id="frmEditInvoiceId" > 
          <input type="hidden" name="frmEditArticleId" id="frmEditArticleId" > 

                                            <div class="mb-3">
                                                <label for="frmEditDt">Data</label>
                                                <div id="frmEditDt" name="frmEditDt"
                                                     class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditInvoiceIdLookup">Fattura</label>
                                                <div class="form-control" id="frmEditInvoiceIdLookup"
                                                     required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditArticleIdLookup">Articolo</label>
                                                <div class="form-control" id="frmEditArticleIdLookup"
                                                      required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditQta">Qta</label>
                                                <input type="text" class="form-control" id="frmEditQta"
                                                       name="frmEditQta" required
                                                       >
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

                                           let dataGridInvoiceId;
                                           let dataGridArticleId;

                                           $('#frmEditInvoiceIdLookup').dxLookup({
                                dataSource: {
                                    store: {
                                        type: 'odata',
                                        url: '${pageContext.request.contextPath}/api/lookup/invoice',
                                        key: 'id',
                                    },
                                },
                                searchMode: "contains",
                                valueExpr: 'id',
                                displayExpr: 'desc',
                                value: '${tmpVal.getArticleTypeId()}',
                                onValueChanged(e) {
                                    $('#frmEditInvoiceId').val(e.value);
                                },
                            });
                                                       

                                           $('#frmEditArticleIdLookup').dxLookup({
                                dataSource: {
                                    store: {
                                        type: 'odata',
                                        url: '${pageContext.request.contextPath}/api/lookup/article',
                                        key: 'id',
                                    },
                                },
                                searchMode: "contains",
                                valueExpr: 'id',
                                displayExpr: 'desc',
                                value: '${tmpVal.getArticleTypeId()}',
                                onValueChanged(e) {
                                    $('#frmEditArticleId').val(e.value);
                                },
                            });
                                                   
                                       });

                                       $(function () {
                                           $('#menuSxInvoiceItem').addClass('active');
                                       });
                                   </script>

            </jsp:attribute>
</t:_layout>