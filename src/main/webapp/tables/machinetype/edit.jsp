<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Cliente">
            <jsp:attribute name="body_area">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Modifica tipo macchina</h5>
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
                                              action="${pageContext.request.contextPath}/machinetype/update">

                                            <input type="hidden" name="frmEditMachineTypeId"
                                                   value="${tmpVal.getMachineTypeId()}">

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required value="${tmpVal.getCode()}"
                                                       placeholder="Codice">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDesc">Descrizione</label>
                                                <div class="html-editor" id="frmEditDesc" value="${tmpVal.getDesc()}"
                                                     name="frmEditDesc" class="form-control"></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDt">Data</label>
                                                <div id="frmEditDt" name="frmEditDt"  class="form-control" required></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNr">Numero</label>
                                                <input type="text" class="form-control" id="frmEditNr"
                                                       value="${tmpVal.getNr()}"
                                                       name="frmEditNr" required
                                                       placeholder="Numero">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditImg">Immagine</label>
                                                <input type="text" class="form-control" id="frmEditImg"
                                                       value="${tmpVal.getImg()}"
                                                       name="frmEditImg"
                                                       placeholder="Immagine">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditAxes">Assi</label>
                                                <input type="number" class="form-control" id="frmEditAxes"
                                                       value="${tmpVal.getAxes()}"
                                                       name="frmEditAxes" required
                                                       placeholder="1">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditCnc">CNC</label>
                                                <input type="text" class="form-control" id="frmEditCnc"
                                                       value="${tmpVal.getCnc()}"
                                                       name="frmEditCnc" required
                                                       placeholder="NUM">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditSpindles">Mandrini</label>
                                                <input type="number" class="form-control" id="frmEditSpindles"
                                                       value="${tmpVal.getSpindles()}"
                                                       name="frmEditSpindles" required
                                                       placeholder="3">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNote">Note</label>
                                                <div class="html-editor" id="frmEditNote"
                                                     value="${tmpVal.getNote()}"
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


<div class="modal fade" id="frmModalDelete" tabindex="-1" aria-labelledby="frmModalDeleteLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="${pageContext.request.contextPath}/machinetype/delete">
                <input type="hidden" name="frmEditMachineTypeId"
                       value="${tmpVal.getMachineTypeId()}">
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
                                     $('#menuSxMachineType').addClass('active');
                                 });


                                 $(() => {

                                     $('#frmEditDt').dxDateBox({
                                         type: 'date',
                                         displayFormat: 'dd.MM.yyyy',
                                         value: ${tmpVal.getDt()},
                                     });
                                 });

                             </script>

            </jsp:attribute>
</t:_layout>