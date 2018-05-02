package com.canjie.servlet;

import com.canjie.DAO.LibDaoImpl;
import com.canjie.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;

public class SearchServlet extends HttpServlet {
    private LibDaoImpl libDao = new LibDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、首先获取jsp页面传递过来的参数信息
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        List<Book> books = libDao.getBooksByCondition(id, name, category);

        JSONArray jsonArray = new JSONArray(books);
        response.getOutputStream().write(jsonArray.toString().getBytes("utf-8"));
    }
}
