<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>

<script type="text/javascript">
	function a() {

		var password1 = document.getElementsByName("password1")[0].value;

		var password2 = document.getElementsByName("password2")[0].value;

		if (password1 != password2) {

			alert("两次输入密码不一致")
		} else {
			alert("密碼一致")
			//Location.href="./index.jsp";
			//location = "./index.jsp";
			//這裡需要一個跳轉到action的方法；
		}

		alert(password1);
	}
</script>


</head>
<body>
	<form action="../RegisterAction">
		<input type="text" name="username" placeholder="请输入用户名" /><br /> <input
			type="password" name="password1" placeholder="请输入密码" /><br /> <input
			type="password" name="password2" placeholder="请再次输入密码" /><br /> <input
			type="submit" value="注册"  /> <input type="reset"
			name="取消" />
	</form>
</body>
</html>