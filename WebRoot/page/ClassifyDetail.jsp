<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>名字 </p>
<p>${classifydetail.name}</p>
<a href="./UpdateClassify.jsp">更改名字</a>
<a href="../DeleteClassify?id=${classifydetail.id}">删除</a>
</body>
</html>