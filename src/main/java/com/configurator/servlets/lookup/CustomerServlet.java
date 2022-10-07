package com.configurator.servlets.lookup;

import com.configurator.services.CustomerService;
import com.configurator.viewModels.LookupViewModel;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/api/lookup/customer")
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final CustomerService service = new CustomerService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<LookupViewModel> list;
        try {
            list = service.getLookupViewModel();

            String userJsonString = this.gson.toJson(list);

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(userJsonString);
            out.flush();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
