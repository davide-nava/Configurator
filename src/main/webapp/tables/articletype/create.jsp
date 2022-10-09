<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout title="Tipo articolo">
            <jsp:attribute name="body_area">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <h5>Nuovo tipo articolo</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row ">
                                    <div class="col ">

                                        <form id="frmEdit" method="post"
                                              action="${pageContext.request.contextPath}/articletype/create">

                                            <div class="mb-3">
                                                <label for="frmEditDesc">Descrizione</label>
                                                <textarea id="frmEditDesc" name="frmEditDesc" rows="5" style="height: 250px;"
                                                          class="form-control text-start"></textarea>
                                            </div>

                                            <div class="mb-3">
                                                <label for="frmEditYear">Anno</label>
                                                <input type="number" class="form-control" id="frmEditYear"
                                                       name="frmEditYear" required
                                                       placeholder="2022">
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
                                        $('#menuSxArticleType').addClass('active');
                                    });

                                </script>

            </jsp:attribute>
</t:_layout>