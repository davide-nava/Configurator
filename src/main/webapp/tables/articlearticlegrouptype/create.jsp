<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo gruppo articolo">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuovo articolo gruppo articolo</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/articlearticlegrouptype/create">

                                            <input type="hidden" name="frmEditArticleGroupTypeId"
                                                   id="frmEditArticleGroupTypeId">
                                            <input type="hidden" name="frmEditArticleId" id="frmEditArticleId">

                                            <div class="mb-3">
                                                <label for="frmEditArticleGroupTypeIdLookup">Tipo gruppo
                                                    articolo</label>
                                                <div class="form-control" id="frmEditArticleGroupTypeIdLookup"
                                                     required
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
                                                       placeholder="1">
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
                                        $('#menuSxArticleArticleGroupType').addClass('active');
                                    });

                                    $(() => {

                                        $('#frmEditArticleIdLookup').dxSelectBox({
                                            dataSource: '${pageContext.request.contextPath}/api/lookup/article',
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            searchEnabled: true,
                                            onValueChanged(e) {
                                                $('#frmEditArticleId').val(e.value);
                                            },
                                        }).dxValidator({
                                            validationRules: [{ type: 'required' }]
                                        });

                                        $('#frmEditArticleGroupTypeIdLookup').dxSelectBox({
                                            dataSource: '${pageContext.request.contextPath}/api/lookup/articlegrouptype',
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            searchEnabled: true,
                                            onValueChanged(e) {
                                                $('#frmEditArticleGroupTypeId').val(e.value);
                                            },
                                        }).dxValidator({
                                            validationRules: [{ type: 'required' }]
                                        });

                                    });

                                </script>

            </jsp:attribute>
</t:_layout>