<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Macchina">
            <jsp:attribute name="body_area">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Modifica macchina</h5>
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
                                              action="${pageContext.request.contextPath}/machine/update">

                                            <input type="hidden" name="frmEditMachineTypeId" id="frmEditMachineTypeId">
                                            <input type="hidden" name="frmEditDesc" id="frmEditDesc">
                                            <input type="hidden" name="frmEditNote" id="frmEditNote">

                                            <input type="hidden" name="frmEditMachineId"
                                                   value="${tmpVal.getMachineId()}">

                                            <div class="mb-3">
                                                <label for="frmEditNr">Numero</label>
                                                <input type="text" class="form-control" id="frmEditNr"
                                                       name="frmEditNr" required
                                                       placeholder="Nr" value="${tmpVal.getNr()}">
                                            </div>


                                            <div class="mb-3">
                                                <label for="frmEditMachineTypeIdLookup">Tipo macchina</label>
                                                <div class="form-control" id="frmEditMachineTypeIdLookup"
                                                     required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditYear">Anno</label>
                                                <input type="text" class="form-control" id="frmEditYear"
                                                       name="frmEditYear" required
                                                       placeholder="2022" value="${tmpVal.getYear()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required
                                                       placeholder="Codice" value="${tmpVal.getCode()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDescEditor">Descrizione</label>
                                                <div id="frmEditDescEditor"
                                                     class="form-control frmEditDesc"></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditImg">Immagine</label>
                                                <input type="text" class="form-control" id="frmEditImg"
                                                       name="frmEditImg"
                                                       placeholder="immagine" value="${tmpVal.getImg()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDoc">Documentazione</label>
                                                <input type="text" class="form-control" id="frmEditDoc"
                                                       name="frmEditDoc" required
                                                       placeholder="Documentazione" value="${tmpVal.getDoc()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditBasePrice">Prezzo base</label>
                                                <input type="number" class="form-control" id="frmEditBasePrice"
                                                       name="frmEditBasePrice" required
                                                       placeholder="100" value="${tmpVal.getBasePrice()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNoteEditor">Note</label>
                                                <div id="frmEditNoteEditor"
                                                     class="frmEditNote form-control"></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditAddress">Indirizzo</label>
                                                <input type="text" class="form-control" id="frmEditAddress"
                                                       name="frmEditAddress" required
                                                       placeholder="Indirizzo" value="${tmpVal.getAddress()}">
                                            </div>
                                            <div class="mb-3">
                                                <label for="frmEditProductionOrder">Commessa</label>
                                                <input type="text" class="form-control" id="frmEditProductionOrder"
                                                       name="frmEditProductionOrder" required
                                                       placeholder="Commessa" value="${tmpVal.getProductionOrder()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDtDelivery">Dt consegna</label>
                                                <div id="frmEditDtDelivery" name="frmEditDtDelivery"
                                                     class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDtAcceptance">Dt accettazione</label>
                                                <div id="frmEditDtAcceptance" name="frmEditDtAcceptance"
                                                     class="form-control" required></div>
                                            </div>
                                            <div class="mb-3">
                                                <label for="frmEditDtStartWarranty">Dt inizio garanzia</label>
                                                <div id="frmEditDtStartWarranty" name="frmEditDtStartWarranty"
                                                     class="form-control" required></div>
                                            </div>
                                            <div class="mb-3">
                                                <label for="frmEditDtEndWarranty">Dt fine garanzia</label>
                                                <div id="frmEditDtEndWarranty" name="frmEditDtEndWarranty"
                                                     class="form-control" required></div>
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
            <form method="post" action="${pageContext.request.contextPath}/machine/delete">
                <input type="hidden" name="frmEditMachineId"
                       value="${tmpVal.getMachineId()}">
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
                                    $(function () {
                                        $('#menuSxMachine').addClass('active');
                                    });

                                    $(() => {

                                        $('#frmEditDtStartWarranty').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: ${tmpVal.getDtStartWarranty()},
                                        });
                                        $('#frmEditDtEndWarranty').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: ${tmpVal.getDtEndWarranty()},
                                        });
                                        $('#frmEditDtAcceptance').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: ${tmpVal.getDtAcceptance()},
                                        });
                                        $('#frmEditDtDelivery').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: ${tmpVal.getDtDelivery()},
                                        });

                                        $('#frmEditMachineTypeIdLookup').dxLookup({
                                            dataSource: {
                                                store: {
                                                    type: 'odata',
                                                    url: '${pageContext.request.contextPath}/api/lookup/machinetype',
                                                    key: 'id',
                                                },
                                            },
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            value: '${tmpVal.getArticleTypeId()}',
                                            onValueChanged(e) {
                                                $('#frmEditMachineTypeId').val(e.value);
                                            },
                                        });


                                        const editorNote = $('.frmEditNote').dxHtmlEditor({
                                            height: 300,
                                            value: '${tmpVal.getNote()}',
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

                                        const editorDesc = $('.frmEditDesc').dxHtmlEditor({
                                            height: 300,
                                            value: '${tmpVal.getDesc()}',
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
                                                $('#frmEditDesc').text(prettierFormat(value));
                                            },
                                        }).dxHtmlEditor('instance');


                                    });
                                </script>

            </jsp:attribute>
</t:_layout>