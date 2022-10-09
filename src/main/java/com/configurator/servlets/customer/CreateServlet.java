package com.configurator.servlets.customer;

import com.configurator.entities.CustomerEntity;
import com.configurator.services.CustomerService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;
@WebServlet("/customer/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final CustomerService service = new CustomerService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            CustomerEntity tmpVal = new CustomerEntity();

            tmpVal.setName(req.getParameter("frmEditName"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setCustomerId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/customer/list.jsp");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
