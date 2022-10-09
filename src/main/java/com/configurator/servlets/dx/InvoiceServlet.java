package com.configurator.servlets.dx;

import com.configurator.services.InvoiceService;
import com.configurator.servlets.BaseServlet;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet( name = "InvoiceServlet", urlPatterns = {"/api/dx/invoice"})
public class InvoiceServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceService service = new InvoiceService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        try {
            super.FlushJson(response, this.gson.toJson(service.getViewModel()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
