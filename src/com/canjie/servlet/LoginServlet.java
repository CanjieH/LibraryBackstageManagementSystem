package com.canjie.servlet;

import com.canjie.DAO.LibDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private LibDaoImpl libDao = new LibDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置服务器端以UTF-8编码进行输出
        response.setCharacterEncoding("UTF-8");
        //设置浏览器以UTF-8编码进行接收,解决中文乱码问题
        response.setContentType("text/html;charset=UTF-8");

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
