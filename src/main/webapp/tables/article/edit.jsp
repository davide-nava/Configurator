<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo">
    <jsp:attribute name="body_area">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>Modifica articolo</h5>
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
                                      action="${pageContext.request.contextPath}/article/update">

                                    <input type="hidden" name="frmEditArticleTypeId" id="frmEditArticleTypeId" value="${tmpVal.getArticleTypeId()}">
                                    <input type="hidden" name="frmEditIsMachine" id="frmEditIsMachine" value="${tmpVal.getIsMachine()}">

                                    <input type="hidden" name="frmEditArticleId"
                                           value="${tmpVal.getArticleId()}">

                                    <div class="mb-3">
                                        <label for="frmEditName">Nome</label>
                                        <input type="text" class="form-control" id="frmEditName"
                                               name="frmEditName" required
                                               placeholder="1" value="${tmpVal.getName()}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="frmEditCode">Codice</label>
                                        <input type="text" class="form-control" id="frmEditCode"
                                               name="frmEditCode" required
                                               placeholder="1" value="${tmpVal.getCode()}">
                                    </div>


                                    <div class="mb-3">
                                        <label for="frmEditArticleTypeIdLookup">Tipo articolo</label>
                                        <div class="form-control" id="frmEditArticleTypeIdLookup"
                                             required
                                             ></div>
                                    </div>

                                    <div class="mb-3">
                                        <label for="frmEditDoc">Documentazione</label>
                                        <input type="text" class="form-control" id="frmEditDoc"
                                               name="frmEditDoc"  
                                               placeholder="1" value="${tmpVal.getDoc()}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="frmEditBasePrice">Prezzo base</label>
                                        <input type="number" class="form-control" id="frmEditBasePrice"
                                               name="frmEditBasePrice" required step="0.01"
                                               placeholder="1" value="${tmpVal.getBasePrice()}">
                                    </div>

                                    <div class="mb-3">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox"
                                                    id="frmEditIsMachineDx"                                                   >
                                            <label class="form-check-label" for="frmEditIsMachineDx">
                                                Tipo macchina
                                            </label>
                                        </div>
                                    </div>

                                    <div class="mb-3">
                                        <label for="frmEditDesc">Descrizione</label>
                                        <textarea id="frmEditDesc" name="frmEditDesc" rows="5" style="height: 250px;"
                                             class="form-control text-start">${tmpVal.getDesc()}</textarea>
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
                    <form method="post" action="${pageContext.request.contextPath}/article/delete">
                        <input type="hidden" name="frmEditArticleId"
                               value="${tmpVal.getArticleId()}">
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
                $('#menuSxArticle').addClass('active');
            });

            $(() => {

                $('#frmEditArticleTypeIdLookup').dxSelectBox({
                    dataSource: '${pageContext.request.contextPath}/api/lookup/articletype',
                    searchMode: "contains",
                    valueExpr: 'id',
                    displayExpr: 'desc',
                    searchEnabled: true,
                    value: '${tmpVal.getArticleTypeId()}',
                    onValueChanged(e) {
                        $('#frmEditArticleTypeId').val(e.value);
                    },
                    onInitialized: function (e) {
                        const v = e.component.option("value");
                        if (v === null) {
                            e.component.option("value", "${tmpVal.getArticleTypeId()}");
                        }
                    }
                }).dxValidator({
                    validationRules: [{ type: 'required' }]
                });

                $('#frmEditIsMachineDx').dxCheckBox({
                    onValueChanged(data) {
                        var chkVal = data.value;
                       chkVal=!chkVal;

                        $('#frmEditIsMachine').val(chkVal);
                    },
                });

                if(${tmpVal.getIsMachine()} == true)
                $("#frmEditIsMachineDx").prop( "checked", true );
            });

        </script>

    </jsp:attribute>
</t:_layout>