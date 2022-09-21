package com.configurator.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.configurator.Services.ArticleArticleGroupTypeService;
import com.configurator.Services.ArticleGroupTypeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ArticleGroupTypeServlet", urlPatterns = "/tables/articlegroup")
public class ArticleGroupTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArticleGroupTypeService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // String id = request.getParameter("name");
        // String password = request.getParameter("password");

        // LoginBean bean = new LoginBean();
        // bean.setName(name);
        // bean.setPassword(password);
        // request.setAttribute("bean", bean);

        // boolean status = bean.validate();

        // if(status){
        // RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");
        // rd.forward(request, response);
        // }
        // else{
        // RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");
        // rd.forward(request, response);
        // }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    public void init() {
        service = new ArticleGroupTypeService();
    }

}