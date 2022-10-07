package com.configurator.servlets.articleMachineType;

import com.configurator.entities.ArticleMachineTypeEntity;
import com.configurator.services.ArticleMachineTypeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/articlemachinetype/read")
public class ReadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineTypeService service = new ArticleMachineTypeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleMachineTypeEntity tmpVal = service.getViewModel(UUID.fromString(req.getParameter("id")));

            req.setAttribute("tmpVal", tmpVal);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/tables/articlemachinetype/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}