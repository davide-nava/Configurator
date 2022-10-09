package com.configurator.servlets.invoice;

import com.configurator.entities.InvoiceEntity;
import com.configurator.services.InvoiceService;
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
@WebServlet("/invoice/read")
public class ReadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceService service = new InvoiceService();

    @Override
    protected void doGet(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        try {
            InvoiceEntity tmpVal = service.getViewModel(UUID.fromString(req.getParameter("id")));

            req.setAttribute("tmpVal", tmpVal);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/tables/invoice/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
