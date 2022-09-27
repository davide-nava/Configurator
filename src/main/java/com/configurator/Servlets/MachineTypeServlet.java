package com.configurator.Servlets;

import com.configurator.Entities.MachineTypeEntity;
import com.configurator.Services.MachineTypeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/api/machinetype")
public class MachineTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineTypeService service = new MachineTypeService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("MachineTypeId")));

            resp.sendRedirect(req.getContextPath() + "/tables/machinetype");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            MachineTypeEntity tmpVal = new MachineTypeEntity();

            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("Dt")));
            tmpVal.setNr(req.getParameter("Nr"));
            tmpVal.setImg(req.getParameter("Img"));
            tmpVal.setAxes(Integer.parseInt(req.getParameter("Axes")));
            tmpVal.setCnc(req.getParameter("Cnc"));
            tmpVal.setNote(req.getParameter("Note"));
            tmpVal.setSpindles(Integer.parseInt(req.getParameter("Spindles")));

            tmpVal.setMachineTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machinetype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MachineTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("MachineTypeId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/machinetype/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MachineTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("MachineTypeId")));

            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("Dt")));
            tmpVal.setNr(req.getParameter("Nr"));
            tmpVal.setImg(req.getParameter("Img"));
            tmpVal.setAxes(Integer.parseInt(req.getParameter("Axes")));
            tmpVal.setCnc(req.getParameter("Cnc"));
            tmpVal.setNote(req.getParameter("Note"));
            tmpVal.setSpindles(Integer.parseInt(req.getParameter("Spindles")));
            tmpVal.setMachineTypeId(UUID.fromString(req.getParameter("MachineTypeId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machinetype");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}