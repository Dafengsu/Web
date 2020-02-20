<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>showTime</title>
</head>
<body>
    <%!
        private void setLastTime(HttpServletResponse response) {
            Cookie lastTime = new Cookie("lastTime",
                    String.valueOf(new Date().getTime()));
            lastTime.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(lastTime);
        }
    %>
    <%
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
    %>
</body>
</html>
