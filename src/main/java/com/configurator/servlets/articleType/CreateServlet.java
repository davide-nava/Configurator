package com.configurator.servlets.articleType;

import com.configurator.entities.ArticleTypeEntity;
import com.configurator.services.ArticleTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

@WebServlet("/articletype/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleTypeService service = new ArticleTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleTypeEntity tmpVal = new ArticleTypeEntity();

            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setYear(Integer.parseInt(req.getParameter("frmEditYear")));

            tmpVal.setArticleTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articletype/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}