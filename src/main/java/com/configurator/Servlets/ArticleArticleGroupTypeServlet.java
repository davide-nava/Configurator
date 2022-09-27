package com.configurator.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;
import com.configurator.Services.ArticleArticleGroupTypeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/articlearticlegrouptype")
public class ArticleArticleGroupTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleArticleGroupTypeService service = new ArticleArticleGroupTypeService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleArticleGroupTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlearticlegrouptype");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleArticleGroupTypeEntity tmpVal = new ArticleArticleGroupTypeEntity();

            tmpVal.setArticleGroupTypeId(UUID.fromString(req.getParameter("frmEditArticleGroupTypeId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));

            tmpVal.setArticleArticleGroupTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlearticlegrouptype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleArticleGroupTypeEntity tmpVal = service
                    .get(UUID.fromString(req.getParameter("frmEditArticleArticleGroupTypeId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/articlearticlegrouptype/edit.jsp").forward(req,
                    resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleArticleGroupTypeEntity tmpVal = service
                    .get(UUID.fromString(req.getParameter("frmEditArticleArticleGroupTypeId")));

            tmpVal.setArticleGroupTypeId(UUID.fromString(req.getParameter("frmEditArticleGroupTypeId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));

            tmpVal.setArticleArticleGroupTypeId(UUID.fromString(req.getParameter("frmEditArticleArticleGroupTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlearticlegrouptype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}