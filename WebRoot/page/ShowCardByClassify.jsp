<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	 <td>地址</td>
     <td>电话</td>
     <td>邮箱</td>
     <td>姓名</td>
</tr>
<c:forEach items="${cardlist}" var="u">
<tr>
<td>${u.name}</td>
<td>${u.tel}1</td>
<td>${u.add}</td>
<td>${u.email}</td>
<td><a href="../DeleteCardFromCollection?cardid=${u.id}">删除</a></td>
</tr>
</c:forEach>
</body>
</html>