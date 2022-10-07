package com.configurator.servlets.articleMachine;

import com.configurator.entities.ArticleMachineEntity;
import com.configurator.services.ArticleMachineService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

@WebServlet("/articlemachine/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleMachineService service = new ArticleMachineService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleMachineEntity tmpVal = new ArticleMachineEntity();

            tmpVal.setMachineId(UUID.fromString(req.getParameter("frmEditMachineId")));
            tmpVal.setArticleId(UUID.fromString(req.getParameter("frmEditArticleId")));
            tmpVal.setQta(Float.parseFloat(req.getParameter("frmEditQta")));
            tmpVal.setNote(req.getParameter("frmEditNote"));

            tmpVal.setArticleMachineId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articlemachine/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}