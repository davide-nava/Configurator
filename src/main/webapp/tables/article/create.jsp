<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo">
    <jsp:attribute name="body_area">

        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>Nuovo articolo</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row ">
                            <div class="col ">

                                <form id="frmEdit" method="post"
                                      action="${pageContext.request.contextPath}/article/create">

                                    <input type="hidden" name="frmEditArticleTypeId" id="frmEditArticleTypeId">
                                    <input type="hidden" name="frmEditIsMachine" id="frmEditIsMachine"  >

                                    <div class="mb-3">
                                        <label for="frmEditName">Nome</label>
                                        <input type="text" class="form-control" id="frmEditName"
                                               name="frmEditName" required
                                               placeholder="Nome">
                                    </div>

                                    <div class="mb-3">
                                        <label for="frmEditCode">Codice</label>
                                        <input type="text" class="form-control" id="frmEditCode"
                                               name="frmEditCode" required
                                               placeholder="Codice">
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
                                               placeholder="c:\">
                                    </div>

                                    <div class="mb-3">
                                        <label for="frmEditBasePrice">Prezzo base</label>
                                        <input type="number" class="form-control" id="frmEditBasePrice"
                                               name="frmEditBasePrice" required  step="0.01"
                                               placeholder="10.00">
                                    </div>

                                    <div class="mb-3">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox"
                                                   id="frmEditIsMachineDx">
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
                    onValueChanged(e) {
                        $('#frmEditArticleTypeId').val(e.value);
                    },
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

            });

        </script>

    </jsp:attribute>
</t:_layout>