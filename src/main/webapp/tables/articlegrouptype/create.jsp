<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo tipo gruppo">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuovo articolo tipo gruppo</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/articlegrouptype/create">

                                            <input type="hidden" name="frmEditDesc">

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditProductionOrder">Qta</label>
                                                <input type="text" class="form-control" id="frmEditProductionOrder"
                                                       name="frmEditProductionOrder" required>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDesc">Descrizione</label>
                                                <div id="frmEditDesc"
                                                     class="frmEditDesc form-control"></div>
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
                                            $('#menuSxArticleGroupType').addClass('active');
                                        });

                                        $(() => {

                                            const editorDesc = $('.frmEditDesc').dxHtmlEditor({
                                                height: 300,
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