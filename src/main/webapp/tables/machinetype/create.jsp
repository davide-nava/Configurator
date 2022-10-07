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

                                            <input type="hidden" name="frmEditDesc" id="frmEditDesc" >
                                            <input type="hidden" name="frmEditNote" id="frmEditNote" >

                                            <div class="mb-3">
                                                <label for="frmEditCode">Codice</label>
                                                <input type="text" class="form-control" id="frmEditCode"
                                                       name="frmEditCode" required
                                                       placeholder="Codice">
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditDescEditor">Descrizione</label>
                                                <div   id="frmEditDescEditor"
                                                       class="form-control frmEditDesc"></div>
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
                                                <label for="frmEditNoteEditor">Note</label>
                                                <div  id="frmEditNoteEditor"
                                                       class="form-control frmEditNote"></div>
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

                                        $('#frmEditData').dxDateBox({
                                            type: 'date',
                                            displayFormat: 'dd.MM.yyyy',
                                            value:  now,
                                        });

                                        const editorNote = $('.frmEditNote').dxHtmlEditor({
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
                                            onValueChanged({ component, value }) {
                                                $('#frmEditNote').text(prettierFormat(value) );
                                            },
                                        }).dxHtmlEditor('instance');

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
                                            onValueChanged({ component, value }) {
                                                $('#frmEditDesc').text(prettierFormat(value) );
                                            },
                                        }).dxHtmlEditor('instance');

                                    });
                                </script>

            </jsp:attribute>
</t:_layout>