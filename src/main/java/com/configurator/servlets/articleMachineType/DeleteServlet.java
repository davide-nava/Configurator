package com.configurator.servlets.articleMachineType;

import com.configurator.services.ArticleMachineTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/articlemachinetype/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineTypeService service = new ArticleMachineTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleMachineTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachinetype/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}