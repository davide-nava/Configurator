package com.configurator.Servlets;

import com.configurator.Entities.ArticleEntity;
import com.configurator.Services.ArticleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/api/article")
public class ArticleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ArticleService service = new ArticleService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            service.delete(UUID.fromString(req.getParameter("ArticleId")));

            resp.sendRedirect(req.getContextPath() + "/tables/article");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArticleEntity tmpVal = new ArticleEntity();

            tmpVal.setImg(req.getParameter("Img"));
            tmpVal.setDoc(req.getParameter("Doc"));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setName(req.getParameter("Name"));
            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setArticleTypeId(UUID.fromString(req.getParameter("ArticleTypeId")));
            tmpVal.setBasePrice(Float.parseFloat(req.getParameter("BasePrice")));
            tmpVal.setIsMachine(Boolean.parseBoolean(req.getParameter("IsMachine")));

            tmpVal.setArticleId(UUID.randomUUID());

            service.insert(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/article");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleId")));

            req.setAttribute("tmpVal", tmpVal);

            req.getRequestDispatcher(req.getContextPath() + "/tables/article/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArticleEntity tmpVal = service.get(UUID.fromString(req.getParameter("ArticleId")));

            tmpVal.setImg(req.getParameter("Img"));
            tmpVal.setDoc(req.getParameter("Doc"));
            tmpVal.setCode(req.getParameter("Code"));
            tmpVal.setName(req.getParameter("Name"));
            tmpVal.setDesc(req.getParameter("Desc"));
            tmpVal.setArticleTypeId(UUID.fromString(req.getParameter("ArticleTypeId")));
            tmpVal.setBasePrice(Float.parseFloat(req.getParameter("BasePrice")));
            tmpVal.setIsMachine(Boolean.parseBoolean(req.getParameter("IsMachine")));

            tmpVal.setArticleId(UUID.fromString(req.getParameter("ArticleId")));

            service.update(tmpVal);

            resp.sendRedirect(req.getContextPath() + "/tables/article");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}