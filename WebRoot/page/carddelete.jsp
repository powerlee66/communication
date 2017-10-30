<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="communication.dao.impl.*,communication.bean.*" %>
<%
   int id=Integer.parseInt(request.getParameter("id").trim());
   
   Card card=new Card();
   card.setId(id);
   
   boolean a = new CardDaoImpl().delete(card);
   
   System.out.print(a);
   
   response.sendRedirect("./cardmanager.jsp");
  
%>

¹§Ï²Äã£¡É¾³ýÃûÆ¬³É¹¦
