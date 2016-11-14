<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description"
	content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">
<title>Insert title here</title>
<!-- CSS样式文件 -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/jquery-weui.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/weui.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/demos.css">
</head>
<body>
	<div id="content">
		<header class='demos-header'>
		<h1 class="demos-title">表单</h1>
		</header>

		<div class="weui_cells weui_cells_form">
			<div class="weui_cell weui_cell_warn">
				<div class="weui_cell_hd">
					<label class="weui_label">门店</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input id='tel' class="weui_input" type="" placeholder="请输入门店名">
				</div>
			</div>

			<div class="weui_cell weui_cell_warn">
				<div class="weui_cell_hd">
					<label class="weui_label">地址</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input id='addr' class="weui_input" type="addr" placeholder="请输入地址">
				</div>
			</div>
			<div class="weui_cell weui_cell_warn">
				<div class="weui_cell_hd">
					<label class="weui_label">联系电话</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input id='contact' class="weui_input" type="tel"
						placeholder="请输手机号">
				</div>
			</div>
			<div class="weui_cell">
				<div class="weui_cell_hd">
					<label for="" class="weui_label">日期</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="date" value="">
				</div>
			</div>
			<div class="weui_cell">
				<div class="weui_cell_hd">
					<label for="" class="weui_label">时间</label>
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="datetime-local" value=""
						placeholder="">
				</div>
			</div>
			<div class="weui_cell weui_cell_select">
				<div class="weui_cell_bd weui_cell_primary">
					<select class="weui_select" name="select1">
						<option selected="" value="0">类别</option>
						<option value="1">微信号</option>
						<option value="2">QQ号</option>
						<option value="3">Email</option>
					</select>
				</div>
			</div>
		</div>
		<div class="weui_cell weui_cell_switch">
			<div class="weui_cell_hd weui_cell_primary">接受通知</div>
			<div class="weui_cell_ft">
				<input class="weui_switch" type="checkbox">
			</div>
		</div>
		<div class="weui_cells_title">备注</div>
		<div class="weui_cells weui_cells_form">
			<div class="weui_cell">
				<div class="weui_cell_bd weui_cell_primary">
					<textarea class="weui_textarea" placeholder="请输入备注" rows="3"></textarea>
					<div class="weui_textarea_counter">
						<span id="words">0</span>/200
					</div>
				</div>
			</div>
		</div>
		<div class="weui_btn_area">
			<a class="weui_btn weui_btn_primary" href="javascript:"
				id="showTooltips">确定</a>
		</div>
	</div>

	<!-- <p id="p1">请在微信中打开该页面！</p> -->

	<!-- js库文件</p> -->
	<script type="text/javascript" src="<%=path%>/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-weui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/city-picker.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/swiper.min.js"></script>
	<!-- js方法</p> -->
	<script>
		//确定按钮点击事件
		$("#showTooltips").click(function() {
			var tel = $('#tel').val();
			var code = $('#code').val();
			if (!tel || !/1[3|4|5|7|8]\d{9}/.test(tel))
				$.toptip('请输入手机号');
			else if (!code || !/\d{6}/.test(code))
				$.toptip('请输入六位手机验证码');
			else
				$.toptip('提交成功', 'success');
		});
		
		//限制备注文本域的文字长度
		$(function(){
			  $(".weui_textarea").keyup(function(){
			   var len = $(this).val().length;
			   if(len > 200){
			    $(this).val($(this).val().substring(0,200));
			   }
			   $("#words").text(len);
			  });
		});
		
		//限制页面只能在微信中打开
		/*$(document).ready(function() {
			var ua = window.navigator.userAgent.toLowerCase();
			if (ua.match(/MicroMessenger/i) == 'micromessenger') {
				$("#content").show();
				$("#p1").hide();
				return true;
			} else {
				$("#content").hide();
				$("#p1").show();
				return false;
			}
		});*/
	</script>
</body>
</html>

