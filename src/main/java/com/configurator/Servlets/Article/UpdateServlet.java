package com.configurator.Servlets.Article;

import com.configurator.Entities.ArticleEntity;
import com.configurator.Services.ArticleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/article/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleService service = new ArticleService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditArticleId")));

            tmpVal.setImg(req.getParameter("frmEditImg"));
            tmpVal.setDoc(req.getParameter("frmEditDoc"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setName(req.getParameter("frmEditName"));
            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setArticleTypeId(UUID.fromString(req.getParameter("frmEditArticleTypeId")));
            tmpVal.setBasePrice(Float.parseFloat(req.getParameter("frmEditBasePrice")));
            tmpVal.setIsMachine(Boolean.parseBoolean(req.getParameter("frmEditIsMachine")));

            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/article/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}