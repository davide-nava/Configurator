package com.configurator.Servlets;

import com.configurator.Entities.ArticleTypeEntity;
import com.configurator.Services.ArticleTypeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/api/articletype")
public class ArticleTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleTypeService service = new ArticleTypeService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("ArticleTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articletype");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleTypeEntity tmpVal = new ArticleTypeEntity();

            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setYear(Integer.parseInt(req.getParameter("Year")));

            tmpVal.setArticleTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articletype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleTypeId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/articletype/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleTypeId")));

            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setYear(Integer.parseInt(req.getParameter("Year")));

            tmpVal.setArticleTypeId(UUID.fromString(req.getParameter("ArticleTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articletype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}