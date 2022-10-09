package com.configurator.servlets.article;

import com.configurator.entities.ArticleEntity;
import com.configurator.services.ArticleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
@WebServlet("/article/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleService service = new ArticleService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            ArticleEntity tmpVal = new ArticleEntity();

            tmpVal.setDoc(req.getParameter("frmEditDoc"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setName(req.getParameter("frmEditName"));
            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setArticleTypeId(UUID.fromString(req.getParameter("frmEditArticleTypeId")));
            tmpVal.setBasePrice(Float.parseFloat(req.getParameter("frmEditBasePrice")));
            tmpVal.setIsMachine(Boolean.parseBoolean(req.getParameter("frmEditIsMachine")));

            tmpVal.setArticleId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/article/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
