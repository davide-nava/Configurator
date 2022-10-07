package com.configurator.servlets.machineType;

import com.configurator.services.MachineTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/machinetype/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineTypeService service = new MachineTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditMachineTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/machinetype/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}