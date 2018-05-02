package com.canjie.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class sessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;// 涉及到HTTP请求处理，转型处理
        HttpServletResponse hresponse = (HttpServletResponse) response;// 涉及到HTTP请求处理，转型处理

        String loginUser = (String) hrequest.getSession().getAttribute("loginUser");// 判断用户是否完成了登录操作，session中是否存储用户名

        if (loginUser == null) {
            hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp?flag2=1");// 未登录，系统强制重定向至登录页面
            return;
        } else {
            chain.doFilter(hrequest, hresponse);
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
