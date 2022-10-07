package com.configurator.servlets.dx;

import com.configurator.services.ArticleMachineTypeService;
import com.configurator.viewModels.ArticleMachineTypeViewModel;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/api/dx/articlemachinetype")
public class ArticleMachineTypeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineTypeService service = new ArticleMachineTypeService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        try {
            List<ArticleMachineTypeViewModel> list = service.getViewModel();

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
