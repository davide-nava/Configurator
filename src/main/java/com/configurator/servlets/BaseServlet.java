package com.configurator.Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

    protected String getRequestParameter(HttpServletRequest request, String name) {
        String param = request.getParameter(name);
        return !param.isEmpty() ? param : getInitParameter(name);
    }

    protected String getContextParameter(String name) {
        return getServletContext().getInitParameter(name);
    }

    protected void forwardRequest(HttpServletRequest request, HttpServletResponse response, String path)
            throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }

    // private void processRequest(HttpServletRequest request, HttpServletResponse
    // response) throws ServletException, IOException {
    // String studentID = request.getParameter("id");
    // if (studentID != null) {
    // int id = Integer.parseInt(studentID);
    // studentService.getStudent(id)
    // .ifPresent(s -> request.setAttribute("studentRecord", s));
    // }

    // RequestDispatcher dispatcher =
    // request.getRequestDispatcher("/WEB-INF/jsp/student-record.jsp");
    // dispatcher.forward(request, response);
    // }

}