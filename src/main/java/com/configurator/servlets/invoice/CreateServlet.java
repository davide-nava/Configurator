package com.configurator.servlets.invoice;

import com.configurator.entities.InvoiceEntity;
import com.configurator.services.InvoiceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
@WebServlet("/invoice/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceService service = new InvoiceService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            InvoiceEntity tmpVal = new InvoiceEntity();

            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDt")));
            tmpVal.setCustomerId(UUID.fromString(req.getParameter("frmEditCustomerId")));
            tmpVal.setTotal(Float.valueOf(req.getParameter("frmEditTotal")));
            tmpVal.setNr(req.getParameter("frmEditNr"));

            tmpVal.setInvoiceId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/invoice/list.jsp");
        } catch (IOException | NumberFormatException | ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

}
