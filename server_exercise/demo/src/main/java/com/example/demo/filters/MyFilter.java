package com.example.demo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class MyFilter implements Filter {
    FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
        String filterName = filterConfig.getFilterName();
        System.out.println("MyFilter.init");
        System.out.println("filterName = " + filterName);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String filterInitParam = config.getInitParameter("FilterInitParameter");
        System.out.println("filterInitParam = " + filterInitParam);
        String method = ((HttpServletRequest) request).getMethod();
        System.out.println("method = " + method);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy");
    }
}
