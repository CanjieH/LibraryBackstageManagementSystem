package com.canjie.servlet;

import com.canjie.DAO.LibDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryServlet extends HttpServlet {

    private LibDaoImpl libDao = new LibDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        libDao.addBookCategory(Integer.parseInt(request.getParameter("id")), request.getParameter("categoryName"), request.getParameter("description"));
        response.sendRedirect(request.getContextPath() + "/server.jsp");
    }

}
