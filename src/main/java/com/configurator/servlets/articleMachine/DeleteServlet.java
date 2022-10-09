package com.configurator.servlets.articleMachine;

import com.configurator.services.ArticleMachineService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;
@WebServlet("/articlemachine/delete")
public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineService service = new ArticleMachineService();

    @Override
    protected void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("frmEditArticleMachineId")));

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachine/list.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
