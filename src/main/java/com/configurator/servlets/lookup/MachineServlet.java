package com.configurator.servlets.lookup;

import com.configurator.services.MachineService;
import com.configurator.servlets.BaseServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/api/lookup/machine")
public class MachineServlet extends BaseServlet {

    private final MachineService service = new MachineService();
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
