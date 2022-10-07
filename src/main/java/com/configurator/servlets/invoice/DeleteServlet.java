package com.configurator.servlets.invoice;

import com.configurator.services.InvoiceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/invoice/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceService service = new InvoiceService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditInvoiceId")));

            resp.sendRedirect(req.getContextPath() + "/tables/invoice/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}