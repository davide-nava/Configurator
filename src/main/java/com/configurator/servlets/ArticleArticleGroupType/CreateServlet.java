package com.configurator.servlets.articleArticleGroupType;

import com.configurator.entities.ArticleArticleGroupTypeEntity;
import com.configurator.services.ArticleArticleGroupTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/articlearticlegrouptype/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleArticleGroupTypeService service = new ArticleArticleGroupTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            ArticleArticleGroupTypeEntity tmpVal = new ArticleArticleGroupTypeEntity();

            tmpVal.setArticleGroupTypeId(UUID.fromString(req.getParameter("frmEditArticleGroupTypeId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));

            tmpVal.setArticleArticleGroupTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlearticlegrouptype/list.jsp");
        } catch (IOException | NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
    }

}
