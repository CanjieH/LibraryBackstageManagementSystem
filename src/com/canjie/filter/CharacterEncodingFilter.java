package com.canjie.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    private FilterConfig config;

    public FilterConfig getConfig() {
        return config;
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(config.getInitParameter("charset"));// 根据过滤器配置字符集，设置请求字符集编码
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
