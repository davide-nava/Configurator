package com.configurator.servlets.articleType;

import com.configurator.entities.ArticleTypeEntity;
import com.configurator.services.ArticleTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
@WebServlet("/articletype/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleTypeService service = new ArticleTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            ArticleTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditArticleTypeId")));

            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setYear(Integer.parseInt(req.getParameter("frmEditYear")));

            tmpVal.setArticleTypeId(UUID.fromString(req.getParameter("frmEditArticleTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articletype/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
