<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo macchina">
            <jsp:attribute name="body_area">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Modifica articolo macchina</h5>
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
                                              action="${pageContext.request.contextPath}/articlemachine/update">

                                            <input type="hidden" name="frmEditNote">

                                            <input type="hidden" name="frmEditArticleMachineId"
                                                   value="${tmpVal.getArticleMachineId()}">

                                            <div class="mb-3">
                                                <label for="frmEditMachineId">Macchina</label>
                                                <div class="form-control" id="frmEditMachineId"
                                                     name="frmEditMachineId" required
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
                                                <input type="number" class="form-control" id="frmEditQta"
                                                       name="frmEditQta" required
                                                       placeholder="1" value="${tmpVal.getQta()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNote">Note</label>
                                                <div id="frmEditNote"
                                                     class="frmEditNote form-control"></div>
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

<div class="modal fade" id="frmModalDelete" tabindex="-1" aria-labelledby="frmModalDeleteLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${pageContext.request.contextPath}/articlemachine/delete" >
                <input type="hidden" name="frmEditArticleMachineId"
                       value="${tmpVal.getArticleMachineId()}">
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
                                    $(function() {
                                        $('#menuSxArticleMachine').addClass('active');
                                    });

                                    $(() => {

                                        let dataGridMachineId;
                                        let dataGridArticleId;

                                        const editorNote = $('.frmEditNote').dxHtmlEditor({
                                        height: 300,
                                        value: ${tmpVal.getNote()},
                                        toolbar: {
                                            items: [
                                                'undo', 'redo', 'separator',
                                                {
                                                    name: 'size',
                                                    acceptedValues: ['8pt', '10pt', '12pt', '14pt', '18pt', '24pt', '36pt'],
                                                },
                                                'separator', 'bold', 'italic', 'strike', 'underline', 'separator',
                                                'alignLeft', 'alignCenter', 'alignRight', 'alignJustify', 'separator',
                                                'orderedList', 'bulletList', 'separator',
                                                {
                                                    name: 'header',
                                                    acceptedValues: [false, 1, 2, 3, 4, 5],
                                                }, 'separator',
                                                'color', 'background', 'separator',
                                                'link', 'separator',
                                                'clear', 'codeBlock', 'blockquote', 'separator',
                                                'insertTable', 'deleteTable',
                                                'insertRowAbove', 'insertRowBelow', 'deleteRow',
                                                'insertColumnLeft', 'insertColumnRight', 'deleteColumn',
                                            ],
                                        },
                                        mediaResizing: {
                                            enabled: true,
                                        },
                                        onValueChanged({component, value}) {
                                            $('#frmEditNote').text(prettierFormat(value));
                                        },
                                    }).dxHtmlEditor('instance');

                                        $('#frmEditMachineId').dxDropDownBox({
                                            value: ${tmpVal.getMachineId()},
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            deferRendering: false,
                                            placeholder: 'Select a value...',
                                            showClearButton: true,
                                            dataSource: {
                                                store: {
                                                    type: 'odata',
                                                    url: '${pageContext.request.contextPath}/api/lookup/machine',
                                                    key: 'id',
                                                },
                                            },

                                            contentTemplate(e) {
                                                const value = e.component.option('value');
                                                const $dataGridMachineId = $('<div>').dxDataGrid({
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
                                                dataGridMachineId = $dataGridMachineId.dxDataGrid('instance');
                                                e.component.on('valueChanged', (args) => {
                                                    dataGridMachineId.selectRows(args.value, false);
                                                    e.component.close();
                                                });

                                                return $dataGridMachineId;
                                            },
                                        });

                                        $('#frmEditArticleId').dxDropDownBox({
                                            value: ${tmpVal.getInvoiceId()},
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

                                </script>

            </jsp:attribute>
</t:_layout>