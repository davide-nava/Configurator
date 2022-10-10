<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo tipo macchina">
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
                                              action="${pageContext.request.contextPath}/articlemachinetype/update">

                                            <input type="hidden" name="frmEditArticleId" id="frmEditArticleId"
                                                   value="${tmpVal.getArticleId()}">
                                            <input type="hidden" name="frmEditMachineTypeId" id="frmEditMachineTypeId"
                                                   value="${tmpVal.getMachineTypeId()}">

                                            <input type="hidden" name="frmEditArticleMachineTypeId"
                                                   value="${tmpVal.getArticleMachineTypeId()}">

                                            <div class="mb-3">
                                                <label for="frmEditArticleIdLookup">Articolo</label>
                                                <div class="form-control" id="frmEditArticleIdLookup"
                                                     required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditMachineTypeIdLookup">Tipo macchina</label>
                                                <div class="form-control" id="frmEditMachineTypeIdLookup"
                                                     required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditQta">Qta</label>
                                                <input type="number" class="form-control" id="frmEditQta"
                                                       name="frmEditQta" required step="0.01"
                                                       placeholder="1" value="${tmpVal.getQta()}">
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
            <form method="post" action="${pageContext.request.contextPath}/articlemachinetype/delete">
                <input type="hidden" name="frmEditArticleMachineTypeId"
                       value="${tmpVal.getArticleMachineTypeId()}">
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
                                        $('#menuSxArticleMachineType').addClass('active');

                                        $('#frmEditArticleIdLookup').dxSelectBox({
                                            dataSource: '${pageContext.request.contextPath}/api/lookup/article',
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            searchEnabled: true,
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
                                            validationRules: [{type: 'required'}]
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
                                            onInitialized: function (e) {
                                                const v = e.component.option("value");
                                                if (v === null) {
                                                    e.component.option("value", "${tmpVal.getMachineTypeId()}");
                                                }
                                            }
                                        }).dxValidator({
                                            validationRules: [{type: 'required'}]
                                        });

                                    });
                                </script>

            </jsp:attribute>
</t:_layout>