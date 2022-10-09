package com.configurator.servlets.lookup;

import com.configurator.services.CustomerService;
import com.configurator.servlets.BaseServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/api/lookup/customer")
public class CustomerServlet extends BaseServlet {

    private final CustomerService service = new CustomerService();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws IOException {
        try {
            super.GetLookupViewModel(response, service.getLookupViewModel());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
