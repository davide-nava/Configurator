package com.configurator.servlets.machineType;

import com.configurator.entities.MachineTypeEntity;
import com.configurator.services.MachineTypeService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/machinetype/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final MachineTypeService service = new MachineTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            MachineTypeEntity tmpVal = new MachineTypeEntity();

            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDt")));
            tmpVal.setNr(req.getParameter("frmEditNr"));
            tmpVal.setAxes(Integer.parseInt(req.getParameter("frmEditAxes")));
            tmpVal.setCnc(req.getParameter("frmEditCnc"));
            tmpVal.setNote(req.getParameter("frmEditNote"));
            tmpVal.setSpindles(Integer.parseInt(req.getParameter("frmEditSpindles")));

            tmpVal.setMachineTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/machinetype/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}