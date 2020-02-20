package com.hzau.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author su
 * @description
 * @date 2020/2/19
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        DateFormat ds = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastTime")) {
                    writer.write("您好,欢迎回来，您上次的访问时间是："
                            + ds.format(new Date(Long.parseLong(cookie.getValue()))));
                    setLastTime(response);
                    return;
                }
            }
        }

        writer.write("您好，欢迎首次光临！");
        setLastTime(response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void setLastTime(HttpServletResponse response) {
        Cookie lastTime = new Cookie("lastTime",
                String.valueOf(new Date().getTime()));
        lastTime.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(lastTime);
    }
}
