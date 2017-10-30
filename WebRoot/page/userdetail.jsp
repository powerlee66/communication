<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<a href="./Home.jsp">首页</a>
<!-- 显示用户的信息，提供修改密码等操作   2014014431
									130719thc -->
									
<p>${user.name}</p>
<a href="./UpdatePassword.jsp">修改密码</a>
<a href="../RemoveUser?userid=${suer.id}">注销账号</a>
</body>
</html>