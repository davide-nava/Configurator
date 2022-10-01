package com.configurator.Servlets.InvoiceItem;

import com.configurator.Services.InvoiceItemService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/invoiceitem/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceItemService service = new InvoiceItemService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditInvoiceItemId")));

            resp.sendRedirect(req.getContextPath() + "/tables/invoiceitem/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}