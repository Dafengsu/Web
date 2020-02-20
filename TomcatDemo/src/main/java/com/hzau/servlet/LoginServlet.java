package com.hzau.servlet;

import com.hzau.dao.UserDao;
import com.hzau.domain.User;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @description
 * @author su
 * @date 2020/2/18
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("login_error");
        session.removeAttribute("cc_error");
        String checkCode = request.getParameter("checkCode");
        String session_checkCode = (String) session.getAttribute("session_checkCode");
        session.removeAttribute("session_checkCode");
        if (checkCode.equalsIgnoreCase(session_checkCode)) {
            Map<String, String[]> map = request.getParameterMap();
            User loginUser = new User();
            try {
                BeanUtils.populate(loginUser, map);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            User user = new UserDao().login(loginUser);
            if (user == null) {
                //登录失败
                request.setAttribute("login_error", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                //登录成功
                session.setAttribute("user", user.getUsername());
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            }
        } else {
            //验证码不一致，存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
