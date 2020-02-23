package com.hzau.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author su
 * @description
 * @date 2020/2/23
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String username = request.getParameter("username");
        Map<String, Object> map = new HashMap<>();
        if ("tom".equals(username)) {
            map.put("userExt", true);
            map.put("msg", "此用户名太受欢迎，请更换一个！");
        } else {
            map.put("userExt", false);
            map.put("msg", "此用户名可用");
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
