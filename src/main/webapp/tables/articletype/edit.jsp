<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Tipo articolo">
            <jsp:attribute name="body_area">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Modifica tipo articolo</h5>
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
                                              action="${pageContext.request.contextPath}/articletype/update">

       <input type="hidden" name="frmEditDesc" >

                                            <input type="hidden" name="frmEditArticleTypeId"
                                                   value="${tmpVal.getArticleTypeId()}">

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required
                                                       placeholder="Codice" value="${tmpVal.getCode()}">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDesc">Codice</label>
                                                <div id="frmEditDesc" class="frmEditDesc form-control"></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditYear">Anno</label>
                                                <input type="text" class="form-control" id="frmEditYear"
                                                       name="frmEditYear" required
                                                       placeholder="2022" value="${tmpVal.getYear()}">
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
            <form method="post" action="${pageContext.request.contextPath}/articletype/delete" >
                <input type="hidden" name="frmEditArticleTypeId"
                       value="${tmpVal.getArticleTypeId()}">
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
                                    $(function() {
                                        $('#menuSxArticleType').addClass('active');
                                    });

                                    $(() => {

                                    const editorDesc = $('.frmEditDesc').dxHtmlEditor({
                                        height: 300,
                                        value: ${tmpVal.getDesc()},
                                        toolbar: {
                                            items: [
                                                'undo', 'redo', 'separator',
                                                {
                                                    name: 'size',
                                                    acceptedValues: ['8pt', '10pt', '12pt', '14pt', '18pt', '24pt', '36pt'],
                                                },
                                                'separator', 'bold', 'italic', 'strike', 'underline', 'separator',
                                                'alignLeft', 'alignCenter', 'alignRight', 'alignJustify', 'separator',
                                                'orderedList', 'bulletList', 'separator',
                                                {
                                                    name: 'header',
                                                    acceptedValues: [false, 1, 2, 3, 4, 5],
                                                }, 'separator',
                                                'color', 'background', 'separator',
                                                'link', 'separator',
                                                'clear', 'codeBlock', 'blockquote', 'separator',
                                                'insertTable', 'deleteTable',
                                                'insertRowAbove', 'insertRowBelow', 'deleteRow',
                                                'insertColumnLeft', 'insertColumnRight', 'deleteColumn',
                                            ],
                                        },
                                        mediaResizing: {
                                            enabled: true,
                                        },
                                        onValueChanged({component, value}) {
                                            $('#frmEditDesc').text(prettierFormat(value));
                                        },
                                    }).dxHtmlEditor('instance');

                                    });
                                </script>

            </jsp:attribute>
</t:_layout>