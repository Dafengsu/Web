package com.hzau.web.servlet;

import com.hzau.domain.PageBean;
import com.hzau.domain.User;
import com.hzau.service.UserService;
import com.hzau.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author su
 * @description
 * @date 2020/2/20
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String currentPage = request.getParameter("currentPage");//当前页码
        currentPage = currentPage == null ? "1" : currentPage;
        String rows = request.getParameter("rows");//每页显示条数
        rows = rows == null ? "5" : rows;
        Map<String, String[]> condition = request.getParameterMap();
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows), condition);
        request.setAttribute("pb", pb);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
