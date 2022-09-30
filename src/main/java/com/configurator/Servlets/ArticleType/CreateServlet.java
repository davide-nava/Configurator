package com.configurator.Servlets.ArticleType;

import java.io.IOException;
import java.util.UUID;

import com.configurator.Entities.ArticleTypeEntity;
import com.configurator.Services.ArticleTypeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/articletype/create")
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleTypeService service = new ArticleTypeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleTypeEntity tmpVal = new ArticleTypeEntity();

            tmpVal.setDesc(req.getParameter("frmEditDesc"));
            tmpVal.setCode(req.getParameter("frmEditCode"));
            tmpVal.setYear(Integer.parseInt(req.getParameter("frmEditYear")));

            tmpVal.setArticleTypeId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/articletype/list.jsp");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}