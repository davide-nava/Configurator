<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articoli">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Articoli</h5>
                                <div class="ibox-tools">
                                    <a class="btn btn-primary" title="aggiungi"
                                       href="${pageContext.request.contextPath}/tables/article/create.jsp">
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
                                    url: '${pageContext.request.contextPath}/api/dx/article',
                                    key: 'articleId',
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
                                },
                                {
                                    dataField: 'articleTypeDesc',
                                    caption: 'Tipo articolo',
                                    dataType: 'string',
                                },
                                {
                                    dataField: 'basePrice',
                                    caption: 'BasePrice',
                                    dataType: 'float',
                                },
                                {
                                    dataField: 'isMachine',
                                    caption: 'Tipo macchina',
                                    dataType: 'bool',
                                    groupIndex: 0,
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
                        $('#menuSxArticle').addClass('active');
                    });
                </script>

            </jsp:attribute>
</t:_layout>