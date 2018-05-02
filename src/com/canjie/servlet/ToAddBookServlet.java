package com.canjie.servlet;

import com.canjie.DAO.LibDaoImpl;
import com.canjie.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToAddBookServlet extends HttpServlet {
    private LibDaoImpl libDao = new LibDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先获取参数
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("bookName");
        int price = Integer.parseInt(request.getParameter("price"));
        String descript = request.getParameter("description");
        String category = request.getParameter("catgoryName");

        libDao.addBook(new Book(id, name, category, price, descript));
        response.sendRedirect(request.getContextPath() + "/server.jsp");
    }
}
