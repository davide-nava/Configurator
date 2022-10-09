package com.configurator.servlets.machineType;

import com.configurator.entities.MachineTypeEntity;
import com.configurator.services.MachineTypeService;
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

@WebServlet("/machinetype/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineTypeService service = new MachineTypeService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            MachineTypeEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditMachineTypeId")));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setDt(new Date(sdf.parse(req.getParameter("frmEditDt")).getTime()));
            tmpVal.setNr(req.getParameter("frmEditNr"));
            tmpVal.setAxes(Integer.parseInt(req.getParameter("frmEditAxes")));
            tmpVal.setCnc(req.getParameter("frmEditCnc"));
            tmpVal.setNote(req.getParameter("frmEditNote"));
            tmpVal.setSpindles(Integer.parseInt(req.getParameter("frmEditSpindles")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machinetype/list.jsp");
        } catch (IOException | NumberFormatException | SQLException | ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

}
