package com.configurator.servlets.machine;

import com.configurator.entities.MachineEntity;
import com.configurator.services.MachineService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet("/machine/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineService service = new MachineService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            MachineEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditMachineId")));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
            tmpVal.setDtDelivery(new Date(sdf.parse(req.getParameter("frmEditDtDelivery")).getTime()));
            tmpVal.setDtAcceptance(new Date(sdf.parse(req.getParameter("frmEditDtAcceptance")).getTime()));
            tmpVal.setDtEndWarranty(new Date(sdf.parse(req.getParameter("frmEditDtEndWarranty")).getTime()));
            tmpVal.setDtStartWarranty(new Date(sdf.parse(req.getParameter("frmEditDtStartWarranty")).getTime()));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machine/list.jsp");
        } catch (IOException | NumberFormatException | SQLException | ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

}
