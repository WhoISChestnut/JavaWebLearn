package com.chestnut.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Chestnut
 */
@WebFilter(filterName = "DemoFilter", urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        String site = filterConfig.getInitParameter("Site");
        System.out.println(site);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        System.out.println(servletRequest.getParameter("abc"));

        if ("12a3".equals(servletRequest.getParameter("abc"))) {
            System.out.println("错误的参数");
            servletResponse.getWriter().println("error param");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
