<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"></c:url>">
<script type="text/javascript" src="<c:url value="/js/jquery-1.8.2.min.js"></c:url>"></script>
<script type="text/javascript" src="<c:url value="/js/md5.js"></c:url>"></script>
<script type="text/javascript" src="<c:url value="/js/login.js"></c:url>"></script> -->

<!--  <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/md5.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login.js"></script>-->

<link rel="stylesheet" type="text/css" href="<%=path%>/css/login.css">
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/md5.js"></script>
<script type="text/javascript" src="<%=path%>/js/login.js"></script>
</head>

<body>
	<div>
		UserName:<input type="text" name="username" /> <br /> PassWord:<input
			type="password" name="password" /><br /> <input type="submit"
			id="loginBtn" value="Login" />
	</div>
</body>
</html>
