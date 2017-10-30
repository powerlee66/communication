<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="communication.dao.impl.*,communication.bean.*,java.sql.*,communication.util.*" %>

<%     
        
        List<Card> cards=new ArrayList<Card>();
        Connection conn = null;
        Statement  stmt = null;
        ResultSet    rs = null;
        
       
         User user = (User)request.getSession().getAttribute("user");
        String sql = "select * from card where userid="+user.getId();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/communication?characterEncoding=utf-8", "root",
					"root");
		    
		    stmt = conn.createStatement();
		    
		    
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Card card = new Card();
				
			    card.setId(rs.getInt("id"));

				card.setAdd(rs.getString("address"));

				card.setEmail(rs.getString("email"));

				card.setImage(rs.getString("image"));

				card.setName(rs.getString("name"));

				card.setState(rs.getInt("state"));

				card.setTel(rs.getString("tel"));
				
				cards.add(card);

				}
			
		} catch (SQLException e) {
			e.printStackTrace();
	}finally{
		   
			//new Util().closeConn(conn, stmt, rs);
		
	    }
   
	 
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>管理名片</title> 	
  </head>
  
  <body>
  
  <a href="./Home.jsp">首页</a>
     <table border = 1 align = center>
     
	 
     <tr>
     <td>地址</td>
     <td>电话</td>
     <td>邮箱</td>
     <td>姓名</td>
     <td>
      <a href="cardadd.jsp">添加名片</a>
     </td>
     </tr>
     
     <% for (Iterator<Card> it = cards.iterator(); it.hasNext();) {
		 Card card = it.next();
     %>
     
     <tr>
     <td><%=card.getAdd() %></td>
     <td><%=card.getTel() %></td>
     <td><%=card.getEmail() %></td>
     <td><%=card.getName() %></td>
     <td >
      <a href="carddelete.jsp?id=<%=card.getId() %>">删除名片</a>
     </td>
     <td >
      <a href="cardmodify.jsp?id=<%=card.getId() %>">修改名片</a>
     </td>
     </tr> 
     <% } %>
     
     </table>
  </body>
</html>
