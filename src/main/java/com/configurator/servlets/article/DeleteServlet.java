package com.configurator.servlets.article;

import com.configurator.services.ArticleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/article/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleService service = new ArticleService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleId")));

            resp.sendRedirect(req.getContextPath() + "/tables/article/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}