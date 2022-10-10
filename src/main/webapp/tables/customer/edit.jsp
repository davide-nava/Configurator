<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Cliente">
            <jsp:attribute name="body_area">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Modifica cliente</h5>
                                <div class="ibox-tools">
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#frmModalDelete">
                                        <i class="fa-solid fa-trash"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="ibox-content  ">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/customer/update">

                                            <input type="hidden" name="frmEditCustomerId"
                                                   value="${tmpVal.getCustomerId()}">

                                            <div class="mb-3">
                                                <label for="frmEditName">Nome</label>
                                                <input type="text" class="form-control" id="frmEditName"
                                                       name="frmEditName" required
                                                       placeholder="Nome" value="${tmpVal.getName()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required
                                                       placeholder="Codice" value="${tmpVal.getCode()}">
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

                   <div class="row">
                       <div class="col-lg-12">
                           <div class="ibox ">
                               <div class="ibox-title">
                                   <h5>Articoli</h5>
                               </div>
                               <div class="ibox-content ">
                                   <div class="row   ">
                                       <div class="col-12">
                                           <div id="gridContainerArticle"></div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                       </div>
                   </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Macchine</h5>
                            </div>
                            <div class="ibox-content ">
                                <div class="row   ">
                                    <div class="col-12">
                                        <div id="gridContainerMachine"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


<div class="modal fade" id="frmModalDelete" tabindex="-1" aria-labelledby="frmModalDeleteLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${pageContext.request.contextPath}/customer/delete" >
                <input type="hidden" name="frmEditCustomerId"
                       value="${tmpVal.getCustomerId()}">
                <div class="modal-header">
                    <h5 class="modal-title" id="frmModalDeleteLabel">Eliminazione</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Sicuro di voler procedere?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Chiudi</button>
                    <button type="submit" class="btn btn-danger"><i class="fa-solid fa-trash"></i></button>
                </div>
            </form>
        </div>
    </div>
</div>

                                <script>
                                    $(() => {
                                        $('#menuSxCustomer').addClass('active');

                                        window.jsPDF = window.jspdf.jsPDF;

                                        $('#gridContainerArticle').dxDataGrid({
                                            dataSource: {
                                                store: {
                                                    type: 'odata',
                                                    url: '${pageContext.request.contextPath}/api/dx/article-customer',
                                                    key: 'articleId',
                                                    beforeSend(request) {
                                                        request.params = {
                                                            "customerId": "${tmpVal.getCustomerId()}",
                                                        };
                                                    },
                                                },
                                            },
                                            filterRow: {
                                                visible: true,
                                                applyFilter: 'auto',
                                            },
                                            headerFilter: {
                                                visible: true,
                                            },
                                            sorting: {
                                                mode: 'multiple',
                                            },
                                            selection: {
                                                mode: 'single',
                                            },
                                            paging: {
                                                pageSize: 20,
                                            },
                                            pager: {
                                                showPageSizeSelector: true,
                                                allowedPageSizes: [15, 30, 50, 100],
                                            },
                                            remoteOperations: false,
                                            searchPanel: {
                                                visible: true,
                                                highlightCaseSensitive: true,
                                            },
                                            groupPanel: {
                                                visible: true
                                            },
                                            grouping: {
                                                autoExpandAll: false,
                                            },
                                            allowColumnReordering: true,
                                            rowAlternationEnabled: true,
                                            showBorders: true,
                                            export: {
                                                enabled: true,
                                                allowExportSelectedData: true,
                                            },

                                            onExporting(e) {
                                                const workbook = new ExcelJS.Workbook();
                                                const worksheet = workbook.addWorksheet('Articoli');

                                                DevExpress.excelExporter.exportDataGrid({
                                                    component: e.component,
                                                    worksheet,
                                                    autoFilterEnabled: true,
                                                }).then(() => {
                                                    workbook.xlsx.writeBuffer().then((buffer) => {
                                                        saveAs(new Blob([buffer], {type: 'application/octet-stream'}), 'Articoli.xlsx');
                                                    });
                                                });
                                                e.cancel = true;
                                            },
                                            columns: [{
                                                dataField: 'code',
                                                caption: 'Codice',
                                                dataType: 'string',
                                            },
                                                {
                                                    dataField: 'name',
                                                    caption: 'Name',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'doc',
                                                    caption: 'Doc',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'desc',
                                                    caption: 'Descrizione',
                                                    dataType: 'string',
                                                    cellTemplate(container, options) {
                                                        $('<div>')
                                                            .append( options.value )
                                                            .appendTo(container);
                                                    },
                                                },
                                                {
                                                    dataField: 'articleTypeDesc',
                                                    caption: 'Tipo articolo',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'articleId',
                                                    caption: '',
                                                    width: 40,
                                                    alignment: 'center',
                                                    allowFiltering: false,
                                                    allowSorting: false,
                                                    cellTemplate(container, options) {
                                                        const link = $("<a>");
                                                        link.attr("href", '${pageContext.request.contextPath}/article/read?id=' + options.value)
                                                        link.attr("title", 'Apri')
                                                            .append($('<i>', {class: 'fa-solid fa-eye ',}))
                                                        ;
                                                        return link;
                                                    }
                                                }
                                            ],
                                            summary: {
                                                totalItems: [{
                                                    column: 'code',
                                                    summaryType: 'count',
                                                }, ],},
                                            onContentReady(e) {
                                                if (!collapsed) {
                                                    collapsed = true;
                                                    e.component.expandRow(['EnviroCare']);
                                                }
                                            },
                                        });

                                        $('#gridContainerMachine').dxDataGrid({
                                            dataSource: {
                                                store: {
                                                    type: 'odata',
                                                    url: '${pageContext.request.contextPath}/api/dx/machine-customer',
                                                    key: 'machineId',
                                                    beforeSend(request) {
                                                        request.params = {
                                                            "customerId": "${tmpVal.getCustomerId()}",
                                                        };
                                                    },
                                                },
                                            },
                                            filterRow: {
                                                visible: true,
                                                applyFilter: 'auto',
                                            },
                                            headerFilter: {
                                                visible: true,
                                            },
                                            sorting: {
                                                mode: 'multiple',
                                            },
                                            selection: {
                                                mode: 'single',
                                            },
                                            paging: {
                                                pageSize: 20,
                                            },
                                            pager: {
                                                showPageSizeSelector: true,
                                                allowedPageSizes: [15, 30, 50, 100],
                                            },
                                            remoteOperations: false,
                                            searchPanel: {
                                                visible: true,
                                            },
                                            columnsAutoWidth:true,
                                            groupPanel: {
                                                visible: true
                                            },
                                            grouping: {
                                                autoExpandAll: false,
                                            },
                                            allowColumnReordering: true,
                                            rowAlternationEnabled: true,
                                            showBorders: true,
                                            export: {
                                                enabled: true,
                                                allowExportSelectedData: true,
                                            },

                                            onExporting(e) {
                                                const workbook = new ExcelJS.Workbook();
                                                const worksheet = workbook.addWorksheet('Macchine');

                                                DevExpress.excelExporter.exportDataGrid({
                                                    component: e.component,
                                                    worksheet,
                                                    autoFilterEnabled: true,
                                                }).then(() => {
                                                    workbook.xlsx.writeBuffer().then((buffer) => {
                                                        saveAs(new Blob([buffer], {type: 'application/octet-stream'}), 'Macchine.xlsx');
                                                    });
                                                });
                                                e.cancel = true;
                                            },
                                            columns: [

                                                {
                                                    dataField: 'nr',
                                                    caption: 'Nr',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'year',
                                                    caption: 'Anno',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'code',
                                                    caption: 'Codice',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'desc',
                                                    caption: 'Desc',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'doc',
                                                    caption: 'Doc',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'productionOrder',
                                                    caption: 'ProductionOrder',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'machineTypeDesc',
                                                    caption: 'Tipo macchina',
                                                    dataType: 'string',
                                                },
                                                {
                                                    dataField: 'machineId',
                                                    caption: '',
                                                    width: 40,
                                                    alignment: 'center',
                                                    allowFiltering: false,
                                                    allowSorting: false,
                                                    cellTemplate(container, options) {
                                                        const link = $("<a>");
                                                        link.attr("href", '${pageContext.request.contextPath}/machine/read?id=' + options.value)
                                                        link.attr("title", 'Apri')
                                                            .append($('<i>', {class: 'fa-solid fa-eye ',}))
                                                        ;
                                                        return link;
                                                    }
                                                }
                                            ],
                                            summary: {
                                                totalItems: [{
                                                    column: 'nr',
                                                    summaryType: 'count',
                                                }, ],},
                                            onContentReady(e) {
                                                if (!collapsed) {
                                                    collapsed = true;
                                                    e.component.expandRow(['EnviroCare']);
                                                }
                                            },
                                        });



                                        let collapsed = false;

                                    });

                                </script>

            </jsp:attribute>
</t:_layout>