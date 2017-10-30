<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加名片</title> 
  </head>
  <body>
  <a href="./Home.jsp">首页</a>
  <form action="cardadddeal.jsp">
		
		<input type="text" name="add" placeholder="请输入地址" /><br /> 
		<input type="text" name="tel" placeholder="请输入电话" /><br /> 
		<input type="text" name="email" placeholder="请输入邮箱" /><br /> 
		<input type="text" name="name" placeholder="请输入姓名" /><br /> 
		<input type="submit" value="确定"  /> <input type="reset" name="清空" />
	</form>
  </body>
</html>
