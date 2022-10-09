package com.configurator.servlets.invoiceItem;

import com.configurator.services.InvoiceItemService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;
@WebServlet("/invoiceitem/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceItemService service = new InvoiceItemService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditInvoiceItemId")));

            resp.sendRedirect(req.getContextPath() + "/tables/invoiceitem/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
