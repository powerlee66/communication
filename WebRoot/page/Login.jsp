<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
<form action="../LoginAction">
	<input	type="text" name="username" placeholder="请输入用户名"/><br />
	
	<input	type="password" name="password" placeholder="请输入密码"/><br />
	
	<input   type="submit" name="登陆"/>

	<input	type="reset" name="取消" />
</form>
</body>
</html>