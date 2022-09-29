package com.configurator.Servlets.ArticleMachineType;

import java.io.IOException;
import java.util.UUID;

import com.configurator.Entities.ArticleMachineTypeEntity;
import com.configurator.Services.ArticleMachineTypeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/articlemachinetype/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineTypeService service = new ArticleMachineTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleMachineTypeEntity tmpVal = service
                    .get(UUID.fromString(req.getParameter("frmEditArticleMachineTypeId")));

            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setMachineTypeId(UUID.fromString(req.getParameter("frmEditMachineTypeId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));

            tmpVal.setArticleMachineTypeId(UUID.fromString(req.getParameter("frmEditArticleMachineTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachinetype/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}