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

                                            <div class="mb-3">
                                                <label for="frmEditDt">Data</label>
                                                <div id="frmEditDt" name="frmEditDt"
                                                     class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditInvoiceId">Fattura</label>
                                                <div class="form-control" id="frmEditInvoiceId"
                                                     name="frmEditInvoiceId" required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditArticleId">Articolo</label>
                                                <div class="form-control" id="frmEditArticleId"
                                                     name="frmEditArticleId" required
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

                                           $('#frmEditInvoiceId').dxDropDownBox({
                                               valueExpr: 'id',
                                               displayExpr: 'desc',
                                               deferRendering: false,
                                               placeholder: 'Select a value...',
                                               showClearButton: true,
                                               dataSource: {
                                                   store: {
                                                       type: 'odata',
                                                       url: '${pageContext.request.contextPath}/api/lookup/invoice',
                                                       key: 'id',
                                                   },
                                               },

                                               contentTemplate(e) {
                                                   const value = e.component.option('value');
                                                   const $dataGridInvoiceId = $('<div>').dxDataGrid({
                                                       dataSource: e.component.getDataSource(),
                                                       columns: ['Desc'],
                                                       hoverStateEnabled: true,
                                                       paging: {enabled: true, pageSize: 10},
                                                       filterRow: {visible: true},
                                                       scrolling: {mode: 'virtual'},
                                                       selection: {mode: 'single'},
                                                       selectedRowKeys: [value],
                                                       height: '100%',
                                                       onSelectionChanged(selectedItems) {
                                                           const keys = selectedItems.selectedRowKeys;
                                                           const hasSelection = keys.length;
                                                           e.component.option('value', hasSelection ? keys[0] : null);
                                                       },
                                                   });
                                                   dataGridInvoiceId = $dataGridInvoiceId.dxDataGrid('instance');
                                                   e.component.on('valueChanged', (args) => {
                                                       dataGridInvoiceId.selectRows(args.value, false);
                                                       e.component.close();
                                                   });

                                                   return $dataGridInvoiceId;
                                               },
                                           });

                                           $('#frmEditArticleId').dxDropDownBox({
                                               valueExpr: 'id',
                                               displayExpr: 'desc',
                                               deferRendering: false,
                                               placeholder: 'Select a value...',
                                               showClearButton: true,
                                               dataSource: {
                                                   store: {
                                                       type: 'odata',
                                                       url: '${pageContext.request.contextPath}/api/lookup/article',
                                                       key: 'id',
                                                   },
                                               },

                                               contentTemplate(e) {
                                                   const value = e.component.option('value');
                                                   const $dataGridArticleId = $('<div>').dxDataGrid({
                                                       dataSource: e.component.getDataSource(),
                                                       columns: ['Desc'],
                                                       hoverStateEnabled: true,
                                                       paging: {enabled: true, pageSize: 10},
                                                       filterRow: {visible: true},
                                                       scrolling: {mode: 'virtual'},
                                                       selection: {mode: 'single'},
                                                       selectedRowKeys: [value],
                                                       height: '100%',
                                                       onSelectionChanged(selectedItems) {
                                                           const keys = selectedItems.selectedRowKeys;
                                                           const hasSelection = keys.length;
                                                           e.component.option('value', hasSelection ? keys[0] : null);
                                                       },
                                                   });
                                                   dataGridArticleId = $dataGridArticleId.dxDataGrid('instance');
                                                   e.component.on('valueChanged', (args) => {
                                                       dataGridArticleId.selectRows(args.value, false);
                                                       e.component.close();
                                                   });

                                                   return $dataGridArticleId;
                                               },
                                           });

                                       });

                                       $(function () {
                                           $('#menuSxInvoiceItem').addClass('active');
                                       });
                                   </script>

            </jsp:attribute>
</t:_layout>