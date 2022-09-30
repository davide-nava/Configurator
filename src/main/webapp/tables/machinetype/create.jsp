<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Cliente">
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

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required
                                                       placeholder="Codice">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDesc">Descrizione</label>
                                                <div class="html-editor" id="frmEditDesc"
                                                     name="frmEditDesc" class="form-control"></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDt">Data</label>
                                                <div id="frmEditDt" name="frmEditDt"  class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNr">Numero</label>
                                                <input type="text" class="form-control" id="frmEditNr"
                                                       name="frmEditNr" required
                                                       placeholder="Numero">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditImg">Immagine</label>
                                                <input type="text" class="form-control" id="frmEditImg"
                                                       name="frmEditImg"
                                                       placeholder="Immagine">
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
                                                <div class="html-editor" id="frmEditNote"
                                                     name="frmEditNote" class="form-control"></div>
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

                                        $('#frmEditDt').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value:  now,
                                        });
                                    });
                                </script>

            </jsp:attribute>
</t:_layout>