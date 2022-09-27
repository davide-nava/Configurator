package com.configurator.Servlets;

import com.configurator.Entities.InvoiceItemEntity;
import com.configurator.Services.InvoiceItemService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/api/invoiceitem")
public class InvoiceItemServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceItemService service = new InvoiceItemService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("InvoiceItemId")));

            resp.sendRedirect(req.getContextPath() + "/tables/invoiceitem");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InvoiceItemEntity tmpVal = new InvoiceItemEntity();

            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("Dt")));
            tmpVal.setInvoiceId(UUID.fromString(req.getParameter("InvoiceId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("ArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("Qta")));

            tmpVal.setInvoiceItemId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/invoiceitem");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InvoiceItemEntity tmpVal = service.get(UUID.fromString(req.getParameter("InvoiceItemId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/invoiceitem/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InvoiceItemEntity tmpVal = service.get(UUID.fromString(req.getParameter("InvoiceItemId")));

            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("Dt")));
            tmpVal.setInvoiceId(UUID.fromString(req.getParameter("InvoiceId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("ArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("Qta")));

            tmpVal.setInvoiceItemId(UUID.fromString(req.getParameter("InvoiceItemId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/invoiceitem");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}