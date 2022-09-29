package com.configurator.Servlets.InvoiceItem;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import com.configurator.Entities.InvoiceItemEntity;
import com.configurator.Services.InvoiceItemService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/invoiceitem/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceItemService service = new InvoiceItemService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InvoiceItemEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditInvoiceItemId")));

            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDt")));
            tmpVal.setInvoiceId(UUID.fromString(req.getParameter("frmEditInvoiceId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));

            tmpVal.setInvoiceItemId(UUID.fromString(req.getParameter("frmEditInvoiceItemId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/invoiceitem/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}