package com.configurator.servlets.machineType;

import com.configurator.services.MachineTypeService;
import org.jetbrains.annotations.NotNull;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
@WebServlet("/machinetype/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineTypeService service = new MachineTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditMachineTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/machinetype/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
