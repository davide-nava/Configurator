package com.configurator.Servlets.ArticleMachine;

import java.io.IOException;
import java.util.UUID;

import com.configurator.Services.ArticleMachineService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/articlemachine/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineService service = new ArticleMachineService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleMachineId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachine/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}