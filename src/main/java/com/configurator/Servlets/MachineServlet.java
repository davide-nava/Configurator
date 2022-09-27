package com.configurator.Servlets;

import com.configurator.Entities.MachineEntity;
import com.configurator.Services.MachineService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/api/machine")
public class MachineServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineService service = new MachineService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("MachineId")));

            resp.sendRedirect(req.getContextPath() + "/tables/machine");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            MachineEntity tmpVal = new MachineEntity();

            tmpVal.setNr(Integer.parseInt(req.getParameter("Nr")));
            tmpVal.setYear(Integer.parseInt(req.getParameter("Year")));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setImg(req.getParameter("Img"));
            tmpVal.setDoc(req.getParameter("Doc"));
            tmpVal.setMachineTypeId(UUID.fromString(req.getParameter("MachineTypeId")));
            tmpVal.setBasePrice(Float.parseFloat(req.getParameter("BasePrice")));
            tmpVal.setNote(req.getParameter("Note"));
            tmpVal.setProductionOrder(req.getParameter("ProductionOrder"));
            tmpVal.setAddress(req.getParameter("Address"));
            tmpVal.setDtDelivery(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DtDelivery")));
            tmpVal.setDtAcceptance(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DtAcceptance")));
            tmpVal.setDtEndWarranty(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DtEndWarranty")));
            tmpVal.setDtStartWarranty(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DtStartWarranty")));

            tmpVal.setMachineId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machine");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MachineEntity tmpVal = service.get(UUID.fromString(req.getParameter("MachineId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/machine/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MachineEntity tmpVal = service.get(UUID.fromString(req.getParameter("MachineId")));

            tmpVal.setNr(Integer.parseInt(req.getParameter("Nr")));
            tmpVal.setYear(Integer.parseInt(req.getParameter("Year")));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setImg(req.getParameter("Img"));
            tmpVal.setDoc(req.getParameter("Doc"));
            tmpVal.setMachineTypeId(UUID.fromString(req.getParameter("MachineTypeId")));
            tmpVal.setBasePrice(Float.parseFloat(req.getParameter("BasePrice")));
            tmpVal.setNote(req.getParameter("Note"));
            tmpVal.setProductionOrder(req.getParameter("ProductionOrder"));
            tmpVal.setAddress(req.getParameter("Address"));
            tmpVal.setDtDelivery(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DtDelivery")));
            tmpVal.setDtAcceptance(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DtAcceptance")));
            tmpVal.setDtEndWarranty(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DtEndWarranty")));
            tmpVal.setDtStartWarranty(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DtStartWarranty")));

            tmpVal.setMachineId(UUID.fromString(req.getParameter("MachineId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machine");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}