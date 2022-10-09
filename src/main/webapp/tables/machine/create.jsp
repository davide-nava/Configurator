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
                                              action="${pageContext.request.contextPath}/machine/create">

                                            <input type="hidden" name="frmEditMachineTypeId" id="frmEditMachineTypeId">
                                            <input type="hidden" name="frmEditDtDelivery" id="frmEditDtDelivery" >
                                            <input type="hidden" name="frmEditDtAcceptance" id="frmEditDtAcceptance" >
                                            <input type="hidden" name="frmEditDtStartWarranty" id="frmEditDtStartWarranty" >
                                            <input type="hidden" name="frmEditDtEndWarranty" id="frmEditDtEndWarranty" >

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
                                                <input type="number" class="form-control" id="frmEditYear"
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
                                                <textarea id="frmEditDesc" name="frmEditDesc" rows="5" style="height: 250px;"
                                                          class="form-control text-start"></textarea>
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
                                                <textarea id="frmEditNote" name="frmEditNote" rows="5" style="height: 250px;"
                                                          class="form-control text-start"></textarea>
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
                                                <label for="frmEditDtDeliveryDx">Dt consegna</label>
                                                <div id="frmEditDtDeliveryDx"
                                                     class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDtAcceptanceDx">Dt accettazione</label>
                                                <div id="frmEditDtAcceptanceDx"
                                                     class="form-control" required></div>
                                            </div>
                                            <div class="mb-3">
                                                <label for="frmEditDtStartWarrantyDx">Dt inizio garanzia</label>
                                                <div id="frmEditDtStartWarrantyDx"
                                                     class="form-control" required></div>
                                            </div>
                                            <div class="mb-3">
                                                <label for="frmEditDtEndWarrantyDx">Dt fine garanzia</label>
                                                <div id="frmEditDtEndWarrantyDx"
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

                             $('#frmEditDtStartWarranty').val(now.toISOString());
                             $('#frmEditDtEndWarranty').val(now.toISOString());
                             $('#frmEditDtAcceptance').val(now.toISOString());
                             $('#frmEditDtDelivery').val(now.toISOString());

                             $('#frmEditDtStartWarrantyDx').dxDateBox({
                                 type: 'date',
                                 displayFormat: 'dd.MM.yyyy',
                                 value: now,
                                 onValueChanged(data) {
                                     $('#frmEditDtStartWarranty').val(data.value.toISOString());
                                 },
                             });
                             $('#frmEditDtEndWarrantyDx').dxDateBox({
                                 type: 'date',
                                 displayFormat: 'dd.MM.yyyy',
                                 value: now,
                                 onValueChanged(data) {
                                     $('#frmEditDtEndWarranty').val(data.value.toISOString());
                                 },
                             });
                             $('#frmEditDtAcceptanceDx').dxDateBox({
                                 type: 'date',
                                 displayFormat: 'dd.MM.yyyy',
                                 value: now,
                                 onValueChanged(data) {
                                     $('#frmEditDtAcceptance').val(data.value.toISOString());
                                 },
                             });
                             $('#frmEditDtDeliveryDx').dxDateBox({
                                 type: 'date',
                                 displayFormat: 'dd.MM.yyyy',
                                 value: now,
                                 onValueChanged(data) {
                                     $('#frmEditDtDelivery').val(data.value.toISOString());
                                 },
                             });

                             $('#frmEditMachineTypeIdLookup').dxSelectBox({
                                 dataSource: '${pageContext.request.contextPath}/api/lookup/machinetype',
                                 searchMode: "contains",
                                 valueExpr: 'id',
                                 displayExpr: 'desc',
                                 searchEnabled: true,
                                 onValueChanged(e) {
                                     $('#frmEditMachineTypeId').val(e.value);
                                 },

                             }).dxValidator({
                                 validationRules: [{ type: 'required' }]
                             });


                         });
                     </script>

            </jsp:attribute>
</t:_layout>