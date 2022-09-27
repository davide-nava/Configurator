package com.configurator.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import com.configurator.Entities.CustomerEntity;
import com.configurator.Services.CustomerService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/customer")
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final CustomerService service = new CustomerService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditCustomerId")));

            resp.sendRedirect(req.getContextPath() + "/tables/customer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            CustomerEntity tmpVal = new CustomerEntity();

            tmpVal.setName(req.getParameter("frmEditName"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setCustomerId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/customer");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CustomerEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditCustomerId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/customer/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CustomerEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditCustomerId")));

            tmpVal.setName(req.getParameter("frmEditName"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setCustomerId(UUID.fromString(req.getParameter("frmEditCustomerId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/customer");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}