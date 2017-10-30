<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="communication.dao.impl.*,communication.bean.*" %>

<%
  int id=Integer.parseInt(request.getParameter("id").trim());
  String action = request.getParameter("action");
  
  if (action != null && action.trim().equals("modify")) {
        String add=new String(request.getParameter("add").getBytes("8859_1"),"GBK");
        String tel=new String(request.getParameter("tel").getBytes("8859_1"),"GBK");
        String email=new String(request.getParameter("email").getBytes("8859_1"),"GBK");
        String name=new String(request.getParameter("name").getBytes("8859_1"),"GBK");
        
        Card card=new Card();
        card.setId(id);
        card.setAdd(add);
        card.setTel(tel);
        card.setEmail(email);
        card.setName(name);
        new CardDaoImpl().updateSimple(card);
        response.sendRedirect("Home.jsp");
        return;
        }
%>

<% 
 Card card=new CardDaoImpl().findCardById(id);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改名片</title> 
  </head>
  <body>
  <form action="cardmodify.jsp" method="post">
		<input type="hidden" name="action" value="modify" />
		<input type="hidden" name="id" value="<%=id %>"/>
		<input type="text" name="add" placeholder=<%=card.getAdd() %> /><br /> 
		<input type="text" name="tel" placeholder=<%=card.getTel() %> /><br /> 
		<input type="text" name="email" placeholder=<%=card.getEmail() %> /><br /> 
		<input type="text" name="name" placeholder=<%=card.getName() %> /><br /> 
		<input type="submit" value="确定"  /> <input type="reset" name="清空" />
	</form>
  </body>
</html>
