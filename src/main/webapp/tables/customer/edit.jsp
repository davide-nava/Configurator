<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Cliente">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Modifica cliente</h5>
                                <div class="ibox-tools">
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#frmModalDelete">
                                        <i class="fa-solid fa-trash"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="ibox-content no-padding">
                                <div class="row mt-3 mb-3 ">
                                    <form action="${pageContext.request.contextPath}/api/customer" method="post">

                                        <input type="hidden" name="frmEditCustomerId"
                                               value="${tmpVal.CustomerId}">

                                        <div class="form-group">
                                            <label for="frmEditName">Nome</label>
                                            <input type="text" class="form-control" id="frmEditName" name="frmEditName"
                                                   placeholder="Nome" value="${tmpVal.Name}">
                                        </div>

                                        <div class="form-group">
                                            <label for="frmEditCode">Password</label>
                                            <input type="text" class="form-control" id="frmEditCode" name="frmEditCode"
                                                   placeholder="Codice" value="${tmpVal.Name}">
                                        </div>

                                        <div class="form-group form-check">
                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                            <label class="form-check-label" for="exampleCheck1">Check me out</label>
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

<div class="modal fade" id="frmModalDelete" tabindex="-1" aria-labelledby="frmModalDeleteLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/api/customer" method="delete">
                <input type="hidden" name="frmEditCustomerId"
                       value="${tmpVal.CustomerId}">
                <div class="modal-header">
                    <h5 class="modal-title" id="frmModalDeleteLabel">Eliminazione</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Sicuro di voler procedere?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Chiudi</button>
                    <button type="button" class="btn btn-danger"><i class="fa-solid fa-trash"></i></button>
                </div>
            </form>
        </div>
    </div>
</div>

            </jsp:attribute>
</t:_layout>