package com.configurator.servlets.articleType;

import com.configurator.services.ArticleTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;
@WebServlet("/articletype/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleTypeService service = new ArticleTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articletype/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
