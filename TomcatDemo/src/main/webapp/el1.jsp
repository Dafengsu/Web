<%@ page import="com.hzau.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setId(1);
        request.setAttribute("u", user);
    %>
    ${u.username}<br>
    ${a}
    测试
</body>
</html>
