<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">  
<head>  
	<title>Login</title> 
	
    <meta charset="UTF-8">  
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
     
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/login.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/md5.js"></script>
	<script type="text/javascript" src="<%=path%>/js/login.js"></script>
</head>  
<body>  
    <div id="login">  
        <h1>Login</h1>  
        <form>  
            <input type="text" required="required" placeholder="用户名" name="username"></input>  
            <input type="password" required="required" placeholder="密码" name="password"></input> 
            <input class="but" type="button" id="loginBtn" value="登录" />
        </form>  
    </div>  
</body>  
</html>  