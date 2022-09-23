<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

        <t:_layout title="Cliente">

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

                                <div class="row mt-3 mb-3 ">
                                    <div id="gridContainer"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                    $(() => {
                        $('#gridContainer').dxDataGrid({
                            dataSource: {
                                store: {
                                    type: 'odata',
                                    url: '${pageContext.request.contextPath}/WEB-INF/resources/v1.0/SalesViewer/odata/DaySaleDtoes',
                                    key: 'Id',
                                    beforeSend(request) {
                                        // request.params.startDate = '2020-05-10';
                                        //  request.params.endDate = '2020-05-15';
                                    },
                                },
                            },
                            paging: {
                                pageSize: 20,
                            },
                            pager: {
                                showPageSizeSelector: true,
                                allowedPageSizes: [20, 40, 50, 100],
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
                            columns: [{
                                dataField: 'CustomerId',
                                caption: 'Id',
                                dataType: 'string',
                                visible: false,
                            }, {
                                dataField: 'Name',
                                caption: 'Nome',
                                dataType: 'string',
                            }, {
                                dataField: 'Code',
                                caption: 'Codice',
                                dataType: 'string',
                            }],
                            onContentReady(e) {
                                if (!collapsed) {
                                    collapsed = true;
                                    e.component.expandRow(['EnviroCare']);
                                }
                            },
                        });
                    }); ?

                    let collapsed = false;
                </script>

            </jsp:attribute>

        </t:_layout>