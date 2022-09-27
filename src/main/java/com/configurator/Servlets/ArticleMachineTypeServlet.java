package com.configurator.Servlets;

import com.configurator.Entities.ArticleMachineTypeEntity;
import com.configurator.Services.ArticleMachineTypeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/api/articlemachinetype")
public class ArticleMachineTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineTypeService service = new ArticleMachineTypeService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("ArticleMachineTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachinetype");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleMachineTypeEntity tmpVal = new ArticleMachineTypeEntity();

            tmpVal.setArticleId(UUID.fromString(req.getParameter("ArticleId")));
            tmpVal.setMachineTypeId(UUID.fromString(req.getParameter("MachineTypeId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("Qta")));

            tmpVal.setArticleMachineTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachinetype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleMachineTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleMachineTypeId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/articlemachinetype/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleMachineTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleMachineTypeId")));

            tmpVal.setArticleId(UUID.fromString(req.getParameter("ArticleId")));
            tmpVal.setMachineTypeId(UUID.fromString(req.getParameter("MachineTypeId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("Qta")));

            tmpVal.setArticleMachineTypeId(UUID.fromString(req.getParameter("ArticleMachineTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachinetype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}