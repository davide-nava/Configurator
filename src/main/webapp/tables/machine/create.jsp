<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Macchina">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuova macchina</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/customer/create">

          <input type="hidden" name="frmEditDesc" id="frmEditDesc" > 
                                            <input type="hidden" name="frmEditNote" id="frmEditNote" >
                                            <input type="hidden" name="frmEditMachineTypeId" id="frmEditMachineTypeId" >

                                            <div class="mb-3">
                                                <label for="frmEditNr">Numero</label>
                                                <input type="text" class="form-control" id="frmEditNr"
                                                       name="frmEditNr" required
                                                       placeholder="Nr">
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
                                                       placeholder="2022">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required
                                                       placeholder="Codice">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDescEditor">Descrizione</label>
                                                 <div   id="frmEditDescEditor"
                                                       class="form-control frmEditDesc"></div>                                                     
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditImg">Immagine</label>
                                                <input type="text" class="form-control" id="frmEditImg"
                                                       name="frmEditImg"
                                                       placeholder="immagine">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDoc">Documentazione</label>
                                                <input type="text" class="form-control" id="frmEditDoc"
                                                       name="frmEditDoc" required
                                                       placeholder="Documentazione">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditBasePrice">Prezzo base</label>
                                                <input type="number" class="form-control" id="frmEditBasePrice"
                                                       name="frmEditBasePrice" required
                                                       placeholder="100">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNoteEditor">Note</label>
                                                   <div  id="frmEditNoteEditor"
                                                       class="form-control frmEditNote"></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditAddress">Indirizzo</label>
                                                <input type="text" class="form-control" id="frmEditAddress"
                                                       name="frmEditAddress" required
                                                       placeholder="Indirizzo">
                                            </div>
                                            <div class="mb-3">
                                                <label for="frmEditProductionOrder">Commessa</label>
                                                <input type="text" class="form-control" id="frmEditProductionOrder"
                                                       name="frmEditProductionOrder" required
                                                       placeholder="Commessa">
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

                     <script>
                         $(function () {
                             $('#menuSxMachine').addClass('active');
                         });

                         $(() => {
                             const now = new Date();

                             $('#frmEditDtStartWarranty').dxDateBox({
                                 type: 'date',
                                 displayFormat: 'dd.MM.yyyy',
                                 value: now,
                             });
                             $('#frmEditDtEndWarranty').dxDateBox({
                                 type: 'date',
                                 displayFormat: 'dd.MM.yyyy',
                                 value: now,
                             });
                             $('#frmEditDtAcceptance').dxDateBox({
                                 type: 'date',
                                 displayFormat: 'dd.MM.yyyy',
                                 value: now,
                             });
                             $('#frmEditDtDelivery').dxDateBox({
                                 type: 'date',
                                 displayFormat: 'dd.MM.yyyy',
                                 value: now,
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
                                            onValueChanged({ component, value }) {
                                                $('#frmEditNote').text(prettierFormat(value) );
                                            },
                                        }).dxHtmlEditor('instance');

                                        const editorDesc = $('.frmEditDesc').dxHtmlEditor({
                                            height: 300,
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
                                            onValueChanged({ component, value }) {
                                                $('#frmEditDesc').text(prettierFormat(value) );
                                            },
                                        }).dxHtmlEditor('instance');


                         });
                     </script>

            </jsp:attribute>
</t:_layout>