package com.configurator.Servlets;

import com.configurator.Entities.ArticleGroupTypeEntity;
import com.configurator.Services.ArticleGroupTypeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/api/articlegrouptype")
public class ArticleGroupTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleGroupTypeService service = new ArticleGroupTypeService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("ArticleGroupTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlegrouptype");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleGroupTypeEntity tmpVal = new ArticleGroupTypeEntity();

            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setProductionOrder(req.getParameter("ProductionOrder"));

            tmpVal.setArticleGroupTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlegrouptype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleGroupTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleGroupTypeId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/articlegrouptype/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleGroupTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleGroupTypeId")));

            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setProductionOrder(req.getParameter("ProductionOrder"));

            tmpVal.setArticleGroupTypeId(UUID.fromString(req.getParameter("ArticleGroupTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlegrouptype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}