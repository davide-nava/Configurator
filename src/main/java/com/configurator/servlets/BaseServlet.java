package com.configurator.servlets;

import com.configurator.viewModels.LookupViewModel;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BaseServlet extends HttpServlet {

    private final Gson gson = new Gson();

    protected void GetLookupViewModel(HttpServletResponse response, List<LookupViewModel> list) throws IOException {
        FlushJson(response, gson.toJson(list));
    }

    protected void FlushJson(@NotNull HttpServletResponse response, String json) throws IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }
}
