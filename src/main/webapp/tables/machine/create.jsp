<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Cliente">
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

                                            <div class="mb-3">
                                                <label for="frmEditNr">Numero</label>
                                                <input type="text" class="form-control" id="frmEditNr"
                                                       name="frmEditNr" required
                                                       placeholder="Nr">
                                            </div>


                                            <div class="mb-3">
                                                <label for="frmEditMachineTypeId">Tipo macchina</label>
                                                <div class="form-control" id="frmEditMachineTypeId"
                                                     name="frmEditMachineTypeId" required
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
                                                <label for="frmEditDesc">Descrizione</label>
                                                <div class="html-editor" id="frmEditDesc"
                                                     name="frmEditDesc" class="form-control"></div>
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
                                                <label for="frmEditNote">Note</label>
                                                <div class="html-editor" id="frmEditNote"
                                                     name="frmEditNote" class="form-control"></div>
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

                             let dataGridMachineTypeId;

                             $('#frmEditMachineTypeId').dxDropDownBox({
                                 value: 1,
                                 valueExpr: 'id',
                                 displayExpr: 'desc',
                                 deferRendering: false,
                                 placeholder: 'Select a value...',
                                 showClearButton: true,
                                 dataSource: {
                                     store: {
                                         type: 'odata',
                                         url: '${pageContext.request.contextPath}/api/lookup/machinetype',
                                         key: 'id',
                                     },
                                 },

                                 contentTemplate(e) {
                                     const value = e.component.option('value');
                                     const $dataGridMachineTypeId = $('<div>').dxDataGrid({
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
                                     dataGridMachineTypeId = $dataGridMachineTypeId.dxDataGrid('instance');
                                     e.component.on('valueChanged', (args) => {
                                         dataGridMachineTypeId.selectRows(args.value, false);
                                         e.component.close();
                                     });

                                     return $dataGridMachineTypeId;
                                 },
                             });

                         });
                     </script>

            </jsp:attribute>
</t:_layout>