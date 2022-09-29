package com.configurator.Servlets.ArticleMachineType;

import java.io.IOException;
import java.util.UUID;

import com.configurator.Services.ArticleMachineTypeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/articlemachinetype/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineTypeService service = new ArticleMachineTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleMachineTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachinetype/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}