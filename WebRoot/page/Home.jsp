<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首頁</title>
</head>
<body>
<div id="userdetail">
<!-- 显示用户信息 -->
<!-- 用el表达式获取用户信息 -->
</div>

<div id="topbar">
<!-- 首頁功能條  用el表達式動態生成 -->

</div>
<div id="serachbar">
<!-- 搜索功能條 -->
<form action="../Search">
<input type="text" name="search" placeholder="請輸入搜索的內容">
<input type="submit" value="搜索">
</form>         
</div>          
<div id="items">
<a href="./SetClassify.jsp">收藏夹</a>
<a href="cardmanager.jsp">管理名片</a>
<a href="./userdetail.jsp">查看个人信息</a>
<a href="../Out">退出</a>


</div>
</body>
</html>