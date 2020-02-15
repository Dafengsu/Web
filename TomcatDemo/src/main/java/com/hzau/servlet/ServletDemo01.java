package com.hzau.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description:
 * @author: su
 * @date: 2020/2/15
 */
public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Hello,Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
