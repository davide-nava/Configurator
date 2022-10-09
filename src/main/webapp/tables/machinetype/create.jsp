<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Tipo macchina">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuovo tipo macchina</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                           <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/machinetype/create">

                                            <input type="hidden" name="frmEditDt" id="frmEditDt">

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required
                                                       placeholder="Codice">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDesc">Descrizione</label>
                                                <textarea id="frmEditDesc" name="frmEditDesc" rows="5"
                                                          style="height: 250px;"
                                                          class="form-control text-start"></textarea>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDtDx">Data</label>
                                                <div id="frmEditDtDx" class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNr">Numero</label>
                                                <input type="text" class="form-control" id="frmEditNr"
                                                       name="frmEditNr" required
                                                       placeholder="Numero">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditAxes">Assi</label>
                                                <input type="number" class="form-control" id="frmEditAxes"
                                                       name="frmEditAxes" required
                                                       placeholder="1">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditCnc">CNC</label>
                                                <input type="text" class="form-control" id="frmEditCnc"
                                                       name="frmEditCnc" required
                                                       placeholder="NUM">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditSpindles">Mandrini</label>
                                                <input type="number" class="form-control" id="frmEditSpindles"
                                                       name="frmEditSpindles" required
                                                       placeholder="3">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNote">Note</label>
                                                <textarea id="frmEditNote" name="frmEditNote" rows="5"
                                                          style="height: 250px;"
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
                                        $('#menuSxMachineType').addClass('active');
                                    });

                                    $(() => {
                                        const now = new Date();

                                        $('#frmEditDt').val(now.toISOString());

                                        $('#frmEditDtDx').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value: now,
                                            onValueChanged(data) {
                                                $('#frmEditDt').val(data.value.toISOString());
                                            },
                                        });

                                    });
                                </script>

            </jsp:attribute>
</t:_layout>