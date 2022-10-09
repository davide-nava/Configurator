package com.configurator.servlets.articleType;

import com.configurator.entities.ArticleTypeEntity;
import com.configurator.services.ArticleTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;
@WebServlet("/articletype/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleTypeService service = new ArticleTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            ArticleTypeEntity tmpVal = new ArticleTypeEntity();

            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setYear(Integer.parseInt(req.getParameter("frmEditYear")));

            tmpVal.setArticleTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articletype/list.jsp");
        } catch (IOException | NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
    }

}
