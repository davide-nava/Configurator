package com.configurator.Servlets.Machine;

import java.io.IOException;
import java.util.UUID;

import com.configurator.Services.MachineService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/machine/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineService service = new MachineService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditMachineId")));

            resp.sendRedirect(req.getContextPath() + "/tables/machine/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}