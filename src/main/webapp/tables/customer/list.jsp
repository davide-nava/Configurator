<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

        <t:_layout title="Cliente">

            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Clienti</h5>
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
                                    url: '${pageContext.request.contextPath}/api/dx/customer',
                                    key: 'customerId',
                                    beforeSend(request) {
                                        // request.params.startDate = '2020-05-10';
                                        //  request.params.endDate = '2020-05-15';
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
      // formats: ['pdf', 'xls'],
       allowExportSelectedData: true,
     },
    // onExporting(e) {
    //   const doc = new jsPDF();

    //   DevExpress.pdfExporter.exportDataGrid({
    //     jsPDFDocument: doc,
    //     component: e.component,
    //     indent: 5,
    //   }).then(() => {
    //     doc.save('Clienti.pdf');
    //   });
    // },
    //   export: {
    //   enabled: true,
    //   allowExportSelectedData: true,
    // },
     onExporting(e) {
       const workbook = new ExcelJS.Workbook();
       const worksheet = workbook.addWorksheet('Clienti');

       DevExpress.excelExporter.exportDataGrid({
         component: e.component,
         worksheet,
         autoFilterEnabled: true,
       }).then(() => {
         workbook.xlsx.writeBuffer().then((buffer) => {
         saveAs(new Blob([buffer], { type: 'application/octet-stream' }), 'Clienti.xlsx');
         });
      });
      e.cancel = true;
     },
                            columns: [  {
                                dataField: 'name',
                                caption: 'Nome',
                                dataType: 'string',
                            }, {
                                dataField: 'code',
                                caption: 'Codice',
                                dataType: 'string',
                            },
                           {
                              dataField: 'customerId',
                                caption: '',
                                width: 40,
                                   alignment: 'center',
      allowFiltering: false,
      allowSorting: false,      
      cellTemplate(container, options) {
        //$('<div>')
          //.append($('<a>', { href: '${pageContext.request.contextPath}/tables/customer/read.jsp?id=1'  }))
          ///.append($('<i>', { class: 'fa-solid fa-eye ',  }))
        //  .appendTo(container);
      //},
                                       const link = $("<a>");
                                       link.attr("href", '${pageContext.request.contextPath}/tables/customer/read.jsp?id=' + options.value)
                                       link.attr("title", 'Apri')
                                           .append($('<i>', { class: 'fa-solid fa-eye ',  }))
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

            </jsp:attribute>

        </t:_layout>