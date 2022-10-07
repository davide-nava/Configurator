package com.configurator.servlets.articleGroupType;

import com.configurator.entities.ArticleGroupTypeEntity;
import com.configurator.services.ArticleGroupTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

@WebServlet("/articlegrouptype/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleGroupTypeService service = new ArticleGroupTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleGroupTypeEntity tmpVal = new ArticleGroupTypeEntity();

            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setProductionOrder(req.getParameter("frmEditProductionOrder"));

            tmpVal.setArticleGroupTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlegrouptype/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}