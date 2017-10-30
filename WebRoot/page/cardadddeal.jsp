<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="communication.dao.impl.*,communication.bean.*" %>

<%      

		User user = (User)request.getSession().getAttribute("user");
        String add=new String(request.getParameter("add").getBytes("8859_1"),"GBK");
        String tel=new String(request.getParameter("tel").getBytes("8859_1"),"GBK");
        String email=new String(request.getParameter("email").getBytes("8859_1"),"GBK");
        String name=new String(request.getParameter("name").getBytes("8859_1"),"GBK");
        System.out.print(add+" "+tel+" "+email+" "+name);
        
        Card card=new Card();
        card.setUser(user);
        card.setAdd(add);
        card.setTel(tel);
        card.setEmail(email);
        card.setName(name);
        new CardDaoImpl().addSimple(card);
        
       
		response.sendRedirect("./cardmanager.jsp");
	    
%>
恭喜你！名片添加成功
