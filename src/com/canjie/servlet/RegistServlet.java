package com.canjie.servlet;

import com.canjie.DAO.LibDaoImpl;
import com.canjie.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private LibDaoImpl libDao = new LibDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkpwd = request.getParameter("checkPWD");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        //用户名为3-12位字母数字或下划线组合
        String usernameRegex = "[\\w]{3,12}";
        //matches方法的含义是将获取过来的username和usernameRegex这个规则进行比对，如果满足要求则返回true，否则返回false
        boolean flag1 = username.matches(usernameRegex);
        //密码长度为6-12位的纯数字
        String passRegex = "[\\d]{6,12}";
        boolean flag2 = password.matches(passRegex);
        //手机号校验：[1][3578]\\d{9}
        String phoneRegex ="1[3578]\\d{9}";
        boolean flag3 = phone.matches(phoneRegex);
        //		邮箱校验：[a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+
        String emailRegex ="[a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+";
        boolean flag4 = email.matches(emailRegex);
        boolean flag5 = password.equals(checkpwd);

        //如果username、password、email、phone同时满足格式要求且密码两次相同的话才打印数据,否则提示数据不满足格式要求
        if(flag1&&flag2&&flag3&&flag4&&flag5){
            //然后打印参数
            System.out.println("username="+username);
            System.out.println("password="+password);
            System.out.println("phone="+phone);
            System.out.println("email="+email);
            request.setAttribute("username", username);
            libDao.regist(new User(username, password, phone, email));
            request.getRequestDispatcher("/regist.jsp?flag=0").forward(request, response);
        }else if(flag1&&flag2&&flag3&&flag4){
            response.sendRedirect(request.getContextPath() + "/regist.jsp?flag5=1");    //两次密码输入不符合，重新回到注册界面
        }else{
            response.sendRedirect(request.getContextPath() + "/regist.jsp?flag=1");
        }
    }
}
