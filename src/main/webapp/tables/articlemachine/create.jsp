<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo macchina">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuovo articolo macchina</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/articlemachine/create">

                                            <input type="hidden" name="frmEditArticleId" id="frmEditArticleId" >
                                            <input type="hidden" name="frmEditMachineId" id="frmEditMachineId" >

                                            <div class="mb-3">
                                                <label for="frmEditMachineIdLookup">Macchina</label>
                                                <div class="form-control" id="frmEditMachineIdLookup" required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditArticleIdLookup">Articolo</label>
                                                <div class="form-control" id="frmEditArticleIdLookup"
                                                     required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditQta">Qta</label>
                                                <input type="number" class="form-control" id="frmEditQta"
                                                       name="frmEditQta" required step="0.01"
                                                       placeholder="1">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNote">Note</label>
                                                <textarea id="frmEditNote" name="frmEditNote" rows="5" style="height: 250px;"
                                                          class="form-control text-start"></textarea>
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
                                        $('#menuSxArticleMachine').addClass('active');
                                    });

                                    $(() => {

                                        $('#frmEditMachineIdLookup').dxSelectBox({
                                            dataSource: '${pageContext.request.contextPath}/api/lookup/machine',
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            searchEnabled: true,
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