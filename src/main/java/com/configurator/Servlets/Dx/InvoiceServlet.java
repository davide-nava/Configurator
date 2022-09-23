package com.configurator.Servlets.Dx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;
import com.configurator.Entities.InvoiceEntity;
import com.configurator.Services.ArticleArticleGroupTypeService;
import com.configurator.Services.InvoiceService;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "InvoiceServlet", value = "/api/dx/invoice")
public class InvoiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private InvoiceService service = new InvoiceService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

        List<InvoiceEntity> list = null;
        try {
            list = service.get();

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

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {

    }
}
