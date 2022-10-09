package com.configurator.servlets.article;

import com.configurator.entities.ArticleEntity;
import com.configurator.services.ArticleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;
@WebServlet("/article/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleService service = new ArticleService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            ArticleEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditArticleId")));

            tmpVal.setDoc(req.getParameter("frmEditDoc"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setName(req.getParameter("frmEditName"));
            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setArticleTypeId(UUID.fromString(req.getParameter("frmEditArticleTypeId")));
            tmpVal.setBasePrice(Float.parseFloat(req.getParameter("frmEditBasePrice")));
            tmpVal.setIsMachine(Boolean.parseBoolean(req.getParameter("frmEditIsMachine")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/article/list.jsp");
        } catch (IOException | NumberFormatException | SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
