package com.configurator.Servlets;

import com.configurator.Entities.InvoiceEntity;
import com.configurator.Services.InvoiceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@WebServlet("/api/invoice")
public class InvoiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final InvoiceService service = new InvoiceService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("InvoiceId")));

            resp.sendRedirect(req.getContextPath() + "/tables/invoice");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InvoiceEntity tmpVal = new InvoiceEntity();

            tmpVal.setDt(new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("Dt")));
            tmpVal.setCustomerId(UUID.fromString(req.getParameter("CustomerId")));
            tmpVal.setTotal(Float.valueOf(req.getParameter("Total")));
            tmpVal.setNr(req.getParameter("Nr"));

            tmpVal.setInvoiceId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/invoice");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InvoiceEntity tmpVal = service.get(UUID.fromString(req.getParameter("InvoiceId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/invoice/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InvoiceEntity tmpVal = service.get(UUID.fromString(req.getParameter("InvoiceId")));

            tmpVal.setDt( new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("Dt")));
            tmpVal.setCustomerId(UUID.fromString(req.getParameter("CustomerId")));
            tmpVal.setTotal(Float.valueOf(req.getParameter("Total")));
            tmpVal.setNr(req.getParameter("Nr"));

            tmpVal.setInvoiceId(UUID.fromString(req.getParameter("InvoiceId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/invoice");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}