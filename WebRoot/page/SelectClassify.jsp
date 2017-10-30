<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择分组</title>
</head>
<body>
<c:forEach items="${classify}" var="u">
<a href = "../AddCollectionFinal?classifyid=${u.id}">${u.name}</a></br>
</c:forEach>
<a href="./NewClassify.jsp">添加新的分组</a>
</body>
</html>