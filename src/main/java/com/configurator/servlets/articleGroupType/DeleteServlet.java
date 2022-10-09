package com.configurator.servlets.articleGroupType;

import com.configurator.services.ArticleGroupTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;
@WebServlet("/articlegrouptype/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleGroupTypeService service = new ArticleGroupTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleGroupTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlegrouptype/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
