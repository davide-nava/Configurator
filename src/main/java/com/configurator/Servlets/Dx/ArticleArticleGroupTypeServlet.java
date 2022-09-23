package com.configurator.Servlets.Dx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.configurator.Entities.ArticleArticleGroupTypeEntity;
import com.configurator.Services.ArticleArticleGroupTypeService;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "ArticleArticleGroupTypeServlet", value = "/api/dx/articlearticlegrouptype")
public class ArticleArticleGroupTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArticleArticleGroupTypeService service = new ArticleArticleGroupTypeService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

        List<ArticleArticleGroupTypeEntity> list = null;
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