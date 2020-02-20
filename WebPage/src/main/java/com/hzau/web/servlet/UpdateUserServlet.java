package com.hzau.web.servlet;

import com.hzau.domain.User;
import com.hzau.service.UserService;
import com.hzau.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hzau.utils.BeanUtils.beanUserByReq;

/**
 * @author su
 * @description
 * @date 2020/2/20
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = beanUserByReq(request);
        UserService service = new UserServiceImpl();
        service.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/userListServlet");
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
