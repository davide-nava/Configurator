package com.configurator.Servlets;

import com.configurator.Entities.ArticleMachineEntity;
import com.configurator.Services.ArticleMachineService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/api/articlemachine")
public class ArticleMachineServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineService service = new ArticleMachineService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("ArticleMachineId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachine");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleMachineEntity tmpVal = new ArticleMachineEntity();

            tmpVal.setMachineId(UUID.fromString(req.getParameter("MachineId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("ArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("Qta")));
            tmpVal.setNote(req.getParameter("Note"));

            tmpVal.setArticleMachineId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachine");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleMachineEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleMachineId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/articlemachine/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleMachineEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleMachineId")));

            tmpVal.setMachineId(UUID.fromString(req.getParameter("MachineId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("ArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("Qta")));
            tmpVal.setNote(req.getParameter("Note"));

            tmpVal.setArticleMachineId(UUID.fromString(req.getParameter("ArticleMachineId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachine");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}