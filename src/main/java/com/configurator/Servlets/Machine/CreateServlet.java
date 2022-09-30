package com.configurator.Servlets.Machine;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import com.configurator.Entities.MachineEntity;
import com.configurator.Services.MachineService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/machine/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineService service = new MachineService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MachineEntity tmpVal = new MachineEntity();

            tmpVal.setNr(Integer.parseInt(req.getParameter("frmEditNr")));
            tmpVal.setYear(Integer.parseInt(req.getParameter("frmEditYear")));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setImg(req.getParameter("frmEditImg"));
            tmpVal.setDoc(req.getParameter("frmEditDoc"));
            tmpVal.setMachineTypeId(UUID.fromString(req.getParameter("frmEditMachineTypeId")));
            tmpVal.setBasePrice(Float.parseFloat(req.getParameter("frmEditBasePrice")));
            tmpVal.setNote(req.getParameter("frmEditNote"));
            tmpVal.setProductionOrder(req.getParameter("frmEditProductionOrder"));
            tmpVal.setAddress(req.getParameter("frmEditAddress"));
            tmpVal.setDtDelivery(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDtDelivery")));
            tmpVal.setDtAcceptance(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDtAcceptance")));
            tmpVal.setDtEndWarranty(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDtEndWarranty")));
            tmpVal.setDtStartWarranty(
                    new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDtStartWarranty")));

            tmpVal.setMachineId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machine/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}