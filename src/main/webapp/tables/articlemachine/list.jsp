<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articoli macchina">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Articoli macchina</h5>
                                <div class="ibox-tools">
                                    <a class="btn btn-primary" title="aggiungi"
                                       href="${pageContext.request.contextPath}/tables/articlemachine/create.jsp">
                                        <i class="fa-solid fa-plus"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content ">
                                <div class="row   ">
                                    <div class="col-12">
                                        <div id="gridContainer"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                    window.jsPDF = window.jspdf.jsPDF;

                    $(() => {
                        $('#gridContainer').dxDataGrid({
                            dataSource: {
                                store: {
                                    type: 'odata',
                                    url: '${pageContext.request.contextPath}/api/dx/articlemachine',
                                    key: 'articleMachineId',
                                    beforeSend(request) {
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
                                const worksheet = workbook.addWorksheet('ArticoliMacchina');

                                DevExpress.excelExporter.exportDataGrid({
                                    component: e.component,
                                    worksheet,
                                    autoFilterEnabled: true,
                                }).then(() => {
                                    workbook.xlsx.writeBuffer().then((buffer) => {
                                        saveAs(new Blob([buffer], {type: 'application/octet-stream'}), 'ArticoliMacchina.xlsx');
                                    });
                                });
                                e.cancel = true;
                            },
                            columns: [
                                {
                                    dataField: 'machineDesc',
                                    caption: 'Machina',
                                    dataType: 'string',
                                    groupIndex: 0,
                                },
                                {
                                    dataField: 'articleDesc',
                                    caption: 'Articolo',
                                    dataType: 'string',
                                },
                                {
                                    dataField: 'qta',
                                    caption: 'Qta',
                                    dataType: 'float',
                                },
                                {
                                    dataField: 'articleMachineId',
                                    caption: '',
                                    width: 40,
                                    alignment: 'center',
                                    allowFiltering: false,
                                    allowSorting: false,
                                    cellTemplate(container, options) {
                                        const link = $("<a>");
                                        link.attr("href", '${pageContext.request.contextPath}/articlemachine/read?id=' + options.value)
                                        link.attr("title", 'Apri')
                                            .append($('<i>', {class: 'fa-solid fa-eye ',}))
                                        ;
                                        return link;
                                    }
                                }
                            ],
                            summary: {
                                totalItems: [{
                                    column: 'machineDesc',
                                    summaryType: 'count',
                                }, ],},
                            onContentReady(e) {
                                if (!collapsed) {
                                    collapsed = true;
                                    e.component.expandRow(['EnviroCare']);
                                }
                            },
                        });
                    });

                    let collapsed = false;
                </script>

                <script>
                    $(function () {
                        $('#menuSxArticleMachine').addClass('active');
                    });
                </script>

            </jsp:attribute>
</t:_layout>