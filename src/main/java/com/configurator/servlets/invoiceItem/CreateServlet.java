package com.configurator.servlets.invoiceItem;

import com.configurator.entities.InvoiceItemEntity;
import com.configurator.services.InvoiceItemService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/invoiceitem/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceItemService service = new InvoiceItemService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InvoiceItemEntity tmpVal = new InvoiceItemEntity();

            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("frmEditDt")));
            tmpVal.setInvoiceId(UUID.fromString(req.getParameter("frmEditInvoiceId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));

            tmpVal.setInvoiceItemId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/invoiceitem/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}