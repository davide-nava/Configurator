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
                                    url: '${pageContext.request.contextPath}/SalesViewer/odata/DaySaleDtoes',
                                    key: 'Id',
                                    beforeSend(request) {
                                        // request.params.startDate = '2020-05-10';
                                        //  request.params.endDate = '2020-05-15';
                                    },
                                },
                            },
                            paging: {
                                pageSize: 10,
                            },
                            pager: {
                                showPageSizeSelector: true,
                                allowedPageSizes: [10, 25, 50, 100],
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
                                dataField: 'Product',
                                groupIndex: 0,
                            }, {
                                dataField: 'Amount',
                                caption: 'Sale Amount',
                                dataType: 'number',
                                format: 'currency',
                                alignment: 'right',
                            }, {
                                dataField: 'Discount',
                                caption: 'Discount %',
                                dataType: 'number',
                                format: 'percent',
                                alignment: 'right',
                                allowGrouping: false,
                                cellTemplate: discountCellTemplate,
                                cssClass: 'bullet',
                            }, {
                                dataField: 'SaleDate',
                                dataType: 'date',
                            }, {
                                dataField: 'Region',
                                dataType: 'string',
                            }, {
                                dataField: 'Sector',
                                dataType: 'string',
                            }, {
                                dataField: 'Channel',
                                dataType: 'string',
                            }, {
                                dataField: 'Customer',
                                dataType: 'string',
                                width: 150,
                            }, ],
                            onContentReady(e) {
                                if (!collapsed) {
                                    collapsed = true;
                                    e.component.expandRow(['EnviroCare']);
                                }
                            },
                        });
                    });?
                    const discountCellTemplate = function(container, options) {
                        $('<div/>').dxBullet({
                            onIncidentOccurred: null,
                            size: {
                                width: 150,
                                height: 35,
                            },
                            margin: {
                                top: 5,
                                bottom: 0,
                                left: 5,
                            },
                            showTarget: false,
                            showZeroLevel: true,
                            value: options.value * 100,
                            startScaleValue: 0,
                            endScaleValue: 100,
                            tooltip: {
                                enabled: true,
                                font: {
                                    size: 18,
                                },
                                paddingTopBottom: 2,
                                customizeTooltip() {
                                    return {
                                        text: options.text
                                    };
                                },
                                zIndex: 5,
                            },
                        }).appendTo(container);
                    };?
                    let collapsed = false;
                </script>

            </jsp:attribute>

        </t:_layout>