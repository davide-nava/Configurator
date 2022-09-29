package com.configurator.Servlets.Customer;

import com.configurator.Entities.CustomerEntity;
import com.configurator.Services.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/customer/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final CustomerService service = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditCustomerId")));

            resp.sendRedirect(req.getContextPath() + "/tables/customer/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}