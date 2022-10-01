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
                                              action="${pageContext.request.contextPath}/customer/create">

                                            <input type="hidden" name="frmEditNote" id="frmEditNote" >
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
                                                       name="frmEditQta" required
                                                       placeholder="1">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditNoteDesc">Note</label>
                                                <div id="frmEditNoteDesc"
                                                     class="frmEditNote form-control"></div>
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
 
                                        const editorNote = $('.frmEditNote').dxHtmlEditor({
                                            height: 300,
                                            value: '${tmpVal.getNote()}',
                                           toolbar: {
                                                items: [
                                                      'bold', 'italic', 'strike', 'underline', 'separator',
                                                    'alignLeft', 'alignCenter', 'alignRight', 'alignJustify', 'separator',
                                                    'orderedList', 'bulletList', 'separator',
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
                                                $('#frmEditNote').text(prettierFormat(value));
                                            },
                                        }).dxHtmlEditor('instance');

                                        $('#frmEditMachineIdLookup').dxLookup({
                                dataSource: {
                                    store: {
                                        type: 'odata',
                                        url: '${pageContext.request.contextPath}/api/lookup/machine',
                                        key: 'id',
                                    },
                                },
                                searchMode: "contains",
                                valueExpr: 'id',
                                displayExpr: 'desc',
                                value: '${tmpVal.getArticleTypeId()}',
                                onValueChanged(e) {
                                    $('#frmEditMachineId').val(e.value);
                                },
                            });
 

                                        $('#frmEditArticleIdLookup').dxLookup({
                                dataSource: {
                                    store: {
                                        type: 'odata',
                                        url: '${pageContext.request.contextPath}/api/lookup/article',
                                        key: 'id',
                                    },
                                },
                                searchMode: "contains",
                                valueExpr: 'id',
                                displayExpr: 'desc',
                                value: '${tmpVal.getArticleTypeId()}',
                                onValueChanged(e) {
                                    $('#frmEditArticleId').val(e.value);
                                },
                            });

 
                                    });

                                </script>

            </jsp:attribute>
</t:_layout>