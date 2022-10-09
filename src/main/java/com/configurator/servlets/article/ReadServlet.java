package com.configurator.servlets.article;

import com.configurator.entities.ArticleEntity;
import com.configurator.services.ArticleService;
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
@WebServlet("/article/read")
public class ReadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleService service = new ArticleService();

    @Override
    protected void doGet(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        try {
            ArticleEntity tmpVal = service.getViewModel(UUID.fromString(req.getParameter("id")));

            req.setAttribute("tmpVal", tmpVal);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/tables/article/edit.jsp");
            dispatcher.forward(req, resp);

        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

}
