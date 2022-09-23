package com.configurator.Servlets.Dx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;
import com.configurator.Entities.ArticleTypeEntity;
import com.configurator.Services.ArticleArticleGroupTypeService;
import com.configurator.Services.ArticleTypeService;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ArticleTypeServlet", value = "/api/dx/articletype")
public class ArticleTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArticleTypeService service = new ArticleTypeService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

        List<ArticleTypeEntity> list = null;
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