package com.configurator.servlets.articleArticleGroupType;

import com.configurator.services.ArticleArticleGroupTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/articlearticlegrouptype/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleArticleGroupTypeService service = new ArticleArticleGroupTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleArticleGroupTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlearticlegrouptype/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}