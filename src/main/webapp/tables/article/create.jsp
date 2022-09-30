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

                                            <input type="hidden" name="frmEditDesc">

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
                                                <label for="frmEditArticleTypeId">Tipo articolo</label>
                                                <div class="form-control" id="frmEditArticleTypeId"
                                                     name="frmEditArticleTypeId" required
                                                ></div>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDoc">Documentazione</label>
                                                <input type="text" class="form-control" id="frmEditDoc"
                                                       name="frmEditDoc" required
                                                       placeholder="1"  >
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditImg">Immagine</label>
                                                <input type="text" class="form-control" id="frmEditImg"
                                                       name="frmEditImg" required
                                                       placeholder="1" >
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
                                                <label for="frmEditDesc">Note</label>
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
                                     $(function() {
                                         $('#menuSxArticle').addClass('active');
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

                                         let dataGridArticleTypeId;

                                         $('#frmEditArticleTypeId').dxDropDownBox({
                                             valueExpr: 'id',
                                             displayExpr: 'desc',
                                             deferRendering: false,
                                             placeholder: 'Select a value...',
                                             showClearButton: true,
                                             dataSource: {
                                                 store: {
                                                     type: 'odata',
                                                     url: '${pageContext.request.contextPath}/api/lookup/articletype',
                                                     key: 'id',
                                                 },
                                             },

                                             contentTemplate(e) {
                                                 const value = e.component.option('value');
                                                 const $dataGridArticleTypeId = $('<div>').dxDataGrid({
                                                     dataSource: e.component.getDataSource(),
                                                     columns: ['Desc'],
                                                     hoverStateEnabled: true,
                                                     paging: {enabled: true, pageSize: 10},
                                                     filterRow: {visible: true},
                                                     scrolling: {mode: 'virtual'},
                                                     selection: {mode: 'single'},
                                                     selectedRowKeys: [value],
                                                     height: '100%',
                                                     onSelectionChanged(selectedItems) {
                                                         const keys = selectedItems.selectedRowKeys;
                                                         const hasSelection = keys.length;
                                                         e.component.option('value', hasSelection ? keys[0] : null);
                                                     },
                                                 });
                                                 dataGridArticleTypeId = $dataGridArticleTypeId.dxDataGrid('instance');
                                                 e.component.on('valueChanged', (args) => {
                                                     dataGridArticleTypeId.selectRows(args.value, false);
                                                     e.component.close();
                                                 });

                                                 return $dataGridArticleTypeId;
                                             },
                                         });

                                     });

                                 </script>

            </jsp:attribute>
</t:_layout>