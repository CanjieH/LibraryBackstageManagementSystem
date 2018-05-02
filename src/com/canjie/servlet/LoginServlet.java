package com.canjie.servlet;

import com.canjie.DAO.LibDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private LibDaoImpl libDao = new LibDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(libDao.login(username, password) == 1){
            //System.out.println("登陆成功！");
            request.getSession().setAttribute("loginUser", username);
            response.sendRedirect(request.getContextPath()+"/server.jsp");
        }else{
            //System.out.println("登录失败！");
            response.sendRedirect(request.getContextPath() + "/index.jsp?flag=1");
        }
    }
}
