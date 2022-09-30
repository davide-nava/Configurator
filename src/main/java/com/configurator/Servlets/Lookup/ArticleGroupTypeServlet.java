package com.configurator.Servlets.Lookup;

import com.configurator.Entities.ArticleGroupTypeEntity;
import com.configurator.Services.ArticleGroupTypeService;
import com.configurator.ViewModels.LookupViewModel;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/api/dx/lookup/articlegrouptype")
public class ArticleGroupTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleGroupTypeService service = new ArticleGroupTypeService();
    private final Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<LookupViewModel> list = null;
        try {
            list = service.getLookupViewModal();

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
