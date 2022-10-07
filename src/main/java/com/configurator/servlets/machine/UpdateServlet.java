package com.configurator.servlets.machine;

import com.configurator.entities.MachineEntity;
import com.configurator.services.MachineService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/machine/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineService service = new MachineService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            MachineEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditMachineId")));

            tmpVal.setNr(Integer.parseInt(req.getParameter("frmEditNr")));
            tmpVal.setYear(Integer.parseInt(req.getParameter("frmEditYear")));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setDesc(req.getParameter("frmEditDesc"));
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

            tmpVal.setMachineId(UUID.fromString(req.getParameter("frmEditMachineId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machine/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}