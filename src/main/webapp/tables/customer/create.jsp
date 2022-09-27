<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Cliente">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuovo cliente</h5>
                            </div>
                            <div class="ibox-content no-padding">

                                <div class="row mt-3 mb-3 ">

                                    <form action="${pageContext.request.contextPath}/api/customer" method="put">

                                        <div class="mb-3">
                                            <label for="frmEditName">Nome</label>
                                            <input type="text" class="form-control" id="frmEditName" name="frmEditName"
                                                   placeholder="Nome" value="${tmpVal.Name}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="frmEditCode">Codice</label>
                                            <input type="text" class="form-control" id="frmEditCode" name="frmEditCode"
                                                   placeholder="Codice" value="${tmpVal.Code}">
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

            </jsp:attribute>
</t:_layout>