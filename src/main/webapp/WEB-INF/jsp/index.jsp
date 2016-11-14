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
<title>Index</title>

<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--不支持老版本IE-->
<meta http-equiv="X-UA-Compatible" content="IE=7">
<!--device-width自适应移动端宽度，initial-scale=1不进行缩放-->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="<%=path%>/css/login.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/bootstrap.min.css">
<script type="text/javascript" src="<%=path%>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
</head>

<body>
	<div style="hight: 100%">
		<!-----------------------------------------导航条设计开始--------------------------------->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>

		<!------------------------------------------导航条结束-------------------------------->
		<!------------------------------------------page-header开始-------------------------------->
		<div class="page-header">
			<h1>
				Example page header <small>Subtext for header</small>
			</h1>
		</div>
		<!------------------------------------------page-header结束-------------------------------->
		<div class="panel panel-default" higth>
			<!-- Default panel contents -->
			<div class="panel-heading">Panel heading</div>

			<!-- Table -->
			<table class="table table-bordered table-hover">
				<tr>
					<th>state</th>
					<th>openId</th>
					<th>accessToken</th>
					<th>Company</th>
					<th>Company</th>
				</tr>
				<tr>
					<td class="active">${state},</td>
					<td class="success">${openId}</td>
					<td class="warning">${accessToken}</td>
					<td class="danger">...</td>
					<td class="info">...</td>
				</tr>
				<tr>
					<td class="active">...</td>
					<td class="success">...</td>
					<td class="warning">...</td>
					<td class="danger">...</td>
					<td class="info">...</td>
				</tr>
				<tr>
					<td class="active">...</td>
					<td class="success">...</td>
					<td class="warning">...</td>
					<td class="danger">...</td>
					<td class="info">...</td>
				</tr>
				<tr>
					<td class="active">...</td>
					<td class="success">...</td>
					<td class="warning">...</td>
					<td class="danger">...</td>
					<td class="info">...</td>
				</tr>
				<tr>
					<td class="active">...</td>
					<td class="success">...</td>
					<td class="warning">...</td>
					<td class="danger">...</td>
					<td class="info">...</td>
				</tr>
				<tr>
					<td class="active">...</td>
					<td class="success">...</td>
					<td class="warning">...</td>
					<td class="danger">...</td>
					<td class="info">...</td>
				</tr>

			</table>
		</div>
	</div>
</body>
<!-- <footer>
<div id="copyright">
	<p style="margin-top: 5px">2016@共享gis All Rights Reserved.</p>
	<p>工信部备案号： 晋ICP备16002450号-1</p>
</div>
</footer> -->
<!--页脚结束-->
</html>
