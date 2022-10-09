package com.configurator.servlets.machine;

import com.configurator.services.MachineService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;
@WebServlet("/machine/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineService service = new MachineService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditMachineId")));

            resp.sendRedirect(req.getContextPath() + "/tables/machine/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
