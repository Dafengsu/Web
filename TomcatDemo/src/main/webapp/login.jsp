<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Title</title>
	<script>
		window.onload = function () {
			var checkCode = document.getElementById("checkCode");
			checkCode.onclick = function () {
				var time = new Date().getTime();
				checkCode.src = "${pageContext.request.contextPath}/checkCodeServlet?" + time;
			};
		};
	</script>
	<style>
		div{
			color: red;
		}
	</style>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
	<table>
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>验证码</td>
			<td><input type="text" name="checkCode"></td>
		</tr>
		<tr>
			<td colspan="2">
				<img id="checkCode" src="${pageContext.request.contextPath}/checkCodeServlet">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="登录">
			</td>
		</tr>
	</table>
</form>
<div>
	${requestScope.cc_error}
</div>
<div>
	${requestScope.login_error}
</div>
</body>
</html>
