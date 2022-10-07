<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Articolo">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuovo articolo</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/article/create">

                                            <input type="hidden" name="frmEditDesc" id="frmEditDesc">
                                            <input type="hidden" name="frmEditArticleTypeId" id="frmEditArticleTypeId">

                                            <div class="mb-3">
                                                <label for="frmEditName">Nome</label>
                                                <input type="text" class="form-control" id="frmEditName"
                                                       name="frmEditName" required
                                                       placeholder="1" >
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required
                                                       placeholder="1"  >
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditArticleTypeIdLookup">Tipo articolo</label>
                                                <div class="form-control" id="frmEditArticleTypeIdLookup"
                                                      required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDoc">Documentazione</label>
                                                <input type="text" class="form-control" id="frmEditDoc"
                                                       name="frmEditDoc" required
                                                       placeholder="1"  >
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditBasePrice">Prezzo base</label>
                                                <input type="number" class="form-control" id="frmEditBasePrice"
                                                       name="frmEditBasePrice" required
                                                       placeholder="1"  >
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditIsMachine">Tipo macchina</label>
                                                <input type="checkbox"  id="frmEditIsMachine"
                                                       name="frmEditIsMachine" required
                                                       >
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDescEditor">Note</label>
                                                <div id="frmEditDescEditor"
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
                                     $(function() {
                                         $('#menuSxArticle').addClass('active');
                                     });

                                     $(() => {

                                         const editorDesc = $('.frmEditDesc').dxHtmlEditor({
                                             height: 300,
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
                                                 $('#frmEditDesc').text(prettierFormat(value));
                                             },
                                         }).dxHtmlEditor('instance');

                                         $('#frmEditArticleTypeIdLookup').dxLookup({
                                            dataSource: {
                                                store: {
                                                    type: 'odata',
                                                    url: '${pageContext.request.contextPath}/api/lookup/articletype',
                                                    key: 'id',
                                                },
                                            },
                                            searchMode: "contains",
                                            valueExpr: 'id',
                                            displayExpr: 'desc',
                                            value: '${tmpVal.getArticleTypeId()}',
                                            onValueChanged(e) {
                                                $('#frmEditArticleTypeId').val(e.value);
                                            },
                                        });

                                     });

                                 </script>

            </jsp:attribute>
</t:_layout>