package com.configurator.servlets.invoice;

import com.configurator.entities.InvoiceEntity;
import com.configurator.services.InvoiceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/invoice/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceService service = new InvoiceService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InvoiceEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditInvoiceId")));

            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDt")));
            tmpVal.setCustomerId(UUID.fromString(req.getParameter("frmEditCustomerId")));
            tmpVal.setTotal(Float.valueOf(req.getParameter("frmEditTotal")));
            tmpVal.setNr(req.getParameter("frmEditNr"));

            tmpVal.setInvoiceId(UUID.fromString(req.getParameter("frmEditInvoiceId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/invoice/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}