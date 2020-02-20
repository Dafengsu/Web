package com.hzau.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author su
 * @description
 * @date 2020/2/18
 */
@WebServlet("/servletContext01")
public class ServletContextDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context1 = req.getServletContext();
        ServletContext contxt2 = this.getServletContext();
        System.out.println(context1);
        System.out.println(contxt2);
        System.out.println(context1 == contxt2);
        String str = "a.jpg";
        System.out.println(context1.getMimeType(str));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
