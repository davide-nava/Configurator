package com.configurator.servlets.machineType;

import com.configurator.entities.MachineTypeEntity;
import com.configurator.services.MachineTypeService;
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
@WebServlet("/machinetype/read")
public class ReadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineTypeService service = new MachineTypeService();

    @Override
    protected void doGet(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        try {
            MachineTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("id")));

            req.setAttribute("tmpVal", tmpVal);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/tables/machinetype/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (ServletException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
