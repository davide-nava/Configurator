package com.configurator.servlets.articleArticleGroupType;

import com.configurator.entities.ArticleArticleGroupTypeEntity;
import com.configurator.services.ArticleArticleGroupTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;
@WebServlet("/articlearticlegrouptype/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleArticleGroupTypeService service = new ArticleArticleGroupTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            ArticleArticleGroupTypeEntity tmpVal = service
                    .get(UUID.fromString(req.getParameter("frmEditArticleArticleGroupTypeId")));

            tmpVal.setArticleGroupTypeId(UUID.fromString(req.getParameter("frmEditArticleGroupTypeId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));

            tmpVal.setArticleArticleGroupTypeId(UUID.fromString(req.getParameter("frmEditArticleArticleGroupTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlearticlegrouptype/list.jsp");
        } catch (IOException | NumberFormatException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
