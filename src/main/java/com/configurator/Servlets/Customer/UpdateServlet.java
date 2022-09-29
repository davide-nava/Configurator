package com.configurator.Servlets.Customer;

import java.io.IOException;
import java.util.UUID;

import com.configurator.Entities.CustomerEntity;
import com.configurator.Services.CustomerService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer/update")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final CustomerService service = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CustomerEntity tmpVal = service.get(UUID.fromString(req.getParameter("frmEditCustomerId")));

            tmpVal.setName(req.getParameter("frmEditName"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setCustomerId(UUID.fromString(req.getParameter("frmEditCustomerId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/customer/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}