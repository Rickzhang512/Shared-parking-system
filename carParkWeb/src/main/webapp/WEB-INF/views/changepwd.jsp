<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人信息</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personal.css" media="all">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>修改密码</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix changepwd">
			<form class="layui-form col-lg-4" method="post" action="">
			 	<div class="layui-form-item">
					<label class="layui-form-label">用户账号</label>
					<div class="layui-input-block">  
					  	<input type="text" name="id"  autocomplete="off"  class="layui-input layui-disabled" value="${sessionScope.admin.getAccount()}" disabled="disabled" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">旧密码</label>
					<div class="layui-input-block">  
					  	<input type="password" name="old_pwd" id="old_pwd" autocomplete="off"  class="layui-input" value="" placeholder="请输入旧密码">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-block">  
					  	<input type="password" name="pwd" id="pwd" autocomplete="off"  class="layui-input" value="" placeholder="请输入新密码">
					</div>
				</div>
				<div class="layui-form-item change-submit">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="submit_chpwd" type="button">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary" lay-filter="reset">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript">
	layui.use(['form','upload'],function(){
		var form = layui.form;
		form.on('submit(submit_chpwd)', function(data) {
			var updateJson= data.field;
			data=JSON.stringify(updateJson)
			$.ajax({
				url : '${pageContext.request.contextPath}/updateAdminPwd',
				data : data,
				type:'POST',
				contentType: 'application/json',
				success:function(data){
					console.log(data)
					layer.msg("修改成功！",function(){

					});
				},
				error:function(args){
					layer.msg("修改失败！",function(){

					});
				}
			});
		});
		form.on('submit(reset)', function(data) {
			$("#old_pwd").val("");
			$("#pwd").val("");
		});
	});



</script>
</body>
</html>