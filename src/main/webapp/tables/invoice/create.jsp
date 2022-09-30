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

                                            <div class="mb-3">
                                                <label for="frmEditDt">Data</label>
                                                <div id="frmEditDt" name="frmEditDt"
                                                     class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditCustomerId">Cliente</label>
                                                <div class="form-control" id="frmEditCustomerId"
                                                     name="frmEditCustomerId" required
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

                                        let dataGridCustomerID;

                                        $('#frmEditCustomerId').dxDropDownBox({
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            deferRendering: false,
                                            placeholder: 'Select a value...',
                                            showClearButton: true,
                                            dataSource: {
                                                store: {
                                                    type: 'odata',
                                                    url: '${pageContext.request.contextPath}/api/lookup/customer',
                                                    key: 'id',
                                                },
                                            },

                                            contentTemplate(e) {
                                                const value = e.component.option('value');
                                                const $dataGridCustomerID = $('<div>').dxDataGrid({
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
                                                dataGridCustomerID = $dataGridCustomerID.dxDataGrid('instance');
                                                e.component.on('valueChanged', (args) => {
                                                    dataGridCustomerID.selectRows(args.value, false);
                                                    e.component.close();
                                                });

                                                return $dataGridCustomerID;
                                            },
                                        });

                                    });

                                    $(function () {
                                        $('#menuSxInvoice').addClass('active');
                                    });
                                </script>

            </jsp:attribute>
</t:_layout>