<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo tipo macchina">
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
                                              action="${pageContext.request.contextPath}/articlemachinetype/create">

                                            <input type="hidden" name="frmEditMachineTypeId" id="frmEditMachineTypeId">
                                            <input type="hidden" name="frmEditArticleId" id="frmEditArticleId">

                                            <div class="mb-3">
                                                <label for="frmEditArticleIdLookup">Articolo</label>
                                                <div class="form-control" id="frmEditArticleIdLookup"
                                                     required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditMachineTypeIdLookup">Tipo macchina</label>
                                                <div class="form-control" id="frmEditMachineTypeIdLookup" required
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
                                          }).dxValidator({
                                              validationRules: [{type: 'required'}]
                                          });

                                      });
                                  </script>

            </jsp:attribute>
</t:_layout>