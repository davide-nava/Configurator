<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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

                                            <input type="hidden" name="frmEditMachineId" id="frmEditMachineId" value="${tmpVal.getMachineId()}">
                                            <input type="hidden" name="frmEditArticleId" id="frmEditArticleId" value="${tmpVal.getArticleId()}">

                                            <input type="hidden" name="frmEditArticleMachineId" id="frmEditArticleMachineId"
                                                   value="${tmpVal.getArticleMachineId()}">

                                            <div class="mb-3">
                                                <label for="frmEditMachineIdLookup">Macchina</label>
                                                <div class="form-control" id="frmEditMachineIdLookup" required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditArticleIdLookup">Articolo</label>
                                                <div class="form-control" id="frmEditArticleIdLookup" required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditQta">Qta</label>
                                                <input type="number" class="form-control" id="frmEditQta"
                                                       name="frmEditQta" required step="0.01"
                                                       placeholder="1" value="${tmpVal.getQta()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNote">Note</label>
                                                <textarea id="frmEditNote" name="frmEditNote" rows="5" style="height: 250px;"
                                                          class="form-control text-start">${tmpVal.getNote()}</textarea>
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

                                        $('#frmEditMachineIdLookup').dxSelectBox({
                                            dataSource: '${pageContext.request.contextPath}/api/lookup/machine',
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            searchEnabled: true,
                                            value: '${tmpVal.getMachineId()}',
                                            onValueChanged(e) {
                                                $('#frmEditMachineId').val(e.value);
                                            },
                                            onInitialized: function (e) {
                                                const v = e.component.option("value");
                                                if (v === null) {
                                                    e.component.option("value", "${tmpVal.getMachineId()}");
                                                }
                                            }
                                        }).dxValidator({
                                            validationRules: [{ type: 'required' }]
                                        });

                                        $('#frmEditArticleIdLookup').dxSelectBox({
                                            dataSource: '${pageContext.request.contextPath}/api/lookup/article',
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            searchEnabled: true,
                                            value: '${tmpVal.getArticleId()}',
                                            onValueChanged(e) {
                                                $('#frmEditArticleId').val(e.value);
                                            },
                                            onInitialized: function (e) {
                                                const v = e.component.option("value");
                                                if (v === null) {
                                                    e.component.option("value", "${tmpVal.getArticleId()}");
                                                }
                                            }
                                        }).dxValidator({
                                            validationRules: [{ type: 'required' }]
                                        });

                                    });

                                </script>

            </jsp:attribute>
</t:_layout>