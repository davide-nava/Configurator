package com.configurator;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tables/articlearticlegroup")
public class ArticleArticleGroupController extends HttpServlet {
    // private String message;

    public void init() {
        // message = "Hello World!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 			throws ServletException, IOException {
	//	response.sendRedirect("login/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
      //  authenticate(request, response);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // response.setContentType("text/html");

        // // Hello
        // PrintWriter out = response.getWriter();
        // out.println("<html><body>");
        // out.println("<h1>" + message + "</h1>");
        // out.println("</body></html>");
    }

    public void destroy() {
    }
}