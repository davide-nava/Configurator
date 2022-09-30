package com.configurator.Servlets.Invoice;

import java.io.IOException;
import java.util.UUID;

import com.configurator.Services.InvoiceService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/invoice/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceService service = new InvoiceService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditInvoiceId")));

            resp.sendRedirect(req.getContextPath() + "/tables/invoice/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}