package com.configurator.servlets.articleType;

import com.configurator.entities.ArticleTypeEntity;
import com.configurator.services.ArticleTypeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;
@WebServlet("/articletype/read")
public class ReadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleTypeService service = new ArticleTypeService();

    @Override
    protected void doGet(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("id")));

            req.setAttribute("tmpVal", tmpVal);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/tables/articletype/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
