package com.configurator.servlets.articleMachineType;

import com.configurator.entities.ArticleMachineTypeEntity;
import com.configurator.services.ArticleMachineTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
@WebServlet("/articlemachinetype/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineTypeService service = new ArticleMachineTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            ArticleMachineTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditArticleMachineTypeId")));

            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setMachineTypeId(UUID.fromString(req.getParameter("frmEditMachineTypeId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachinetype/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}