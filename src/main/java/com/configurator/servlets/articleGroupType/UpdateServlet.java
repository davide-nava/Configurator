package com.configurator.servlets.articleGroupType;

import com.configurator.entities.ArticleGroupTypeEntity;
import com.configurator.services.ArticleGroupTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

@WebServlet("/articlegrouptype/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleGroupTypeService service = new ArticleGroupTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleGroupTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditArticleGroupTypeId")));

            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setProductionOrder(req.getParameter("frmEditProductionOrder"));

            tmpVal.setArticleGroupTypeId(UUID.fromString(req.getParameter("frmEditArticleGroupTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlegrouptype/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}