<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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

                                            <input type="hidden" name="frmEditMachineTypeId" id="frmEditMachineTypeId"
                                                   value="${tmpVal.getMachineTypeId()}">
                                            <input type="hidden" name="frmEditDtDelivery" id="frmEditDtDelivery"
                                                   value="${tmpVal.getDtDelivery()}">
                                            <input type="hidden" name="frmEditDtAcceptance" id="frmEditDtAcceptance"
                                                   value="${tmpVal.getDtAcceptance()}">
                                            <input type="hidden" name="frmEditDtStartWarranty"
                                                   id="frmEditDtStartWarranty" value="${tmpVal.getDtStartWarranty()}">
                                            <input type="hidden" name="frmEditDtEndWarranty" id="frmEditDtEndWarranty"
                                                   value="${tmpVal.getDtEndWarranty()}">

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
                                                <input type="number" class="form-control" id="frmEditYear"
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
                                                <label for="frmEditDesc">Descrizione</label>
                                                <textarea id="frmEditDesc" name="frmEditDesc" rows="5"
                                                          style="height: 250px;"
                                                          class="form-control text-start">${tmpVal.getDesc()}</textarea>
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
                                                <label for="frmEditNote">Note</label>
                                                <textarea id="frmEditNote" name="frmEditNote" rows="5"
                                                          style="height: 250px;"
                                                          class="form-control text-start">${tmpVal.getNote()}</textarea>
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

                                        $('#frmEditDtStartWarrantyDx').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: ${tmpVal.getDtStartWarranty()},
                                            onValueChanged(data) {
                                                $('#frmEditDtStartWarranty').val(data.value.toString("yyyy-MM-dd"));
                                            },
                                        });
                                        $('#frmEditDtEndWarrantyDx').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: ${tmpVal.getDtEndWarranty()},
                                            onValueChanged(data) {
                                                $('#frmEditDtEndWarranty').val(data.value.toString("yyyy-MM-dd"));
                                            },
                                        });
                                        $('#frmEditDtAcceptanceDx').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: ${tmpVal.getDtAcceptance()},
                                            onValueChanged(data) {
                                                $('#frmEditDtAcceptance').val(data.value.toString("yyyy-MM-dd"));
                                            },
                                        });
                                        $('#frmEditDtDeliveryDx').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: ${tmpVal.getDtDelivery()},
                                            onValueChanged(data) {
                                                $('#frmEditDtDelivery').val(data.value.toString("yyyy-MM-dd"));
                                            },
                                        });

                                        $('#frmEditMachineTypeIdLookup').dxSelectBox({
                                            dataSource: '${pageContext.request.contextPath}/api/lookup/machinetype',
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            searchEnabled: true,
                                            value: '${tmpVal.getMachineTypeId()}',
                                            onValueChanged(e) {
                                                $('#frmEditMachineTypeId').val(e.value);
                                            },
                                            onInitialized: function (e) {
                                                const v = e.component.option("value");
                                                if (v === null) {
                                                    e.component.option("value", "${tmpVal.getMachineTypeId()}");
                                                }
                                            }
                                        }).dxValidator({
                                            validationRules: [{ type: 'required' }]
                                        });


                                    });
                                </script>

            </jsp:attribute>
</t:_layout>