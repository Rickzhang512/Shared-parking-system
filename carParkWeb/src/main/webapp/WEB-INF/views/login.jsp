<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>共享车位后台管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" media="all">
</head>
<body style="background-image: url('images/123.jpg')">
<div class="layui-layout layui-layout-login" >
    <h1>
        <strong>共享车位系统_管理员登录入口</strong>
    </h1>
    <div class="layui-user-icon larry-login">
        <input type="text" placeholder="账号" class="login_txtbx" id="account"/>
    </div>
    <div class="layui-pwd-icon larry-login">
        <input type="password" placeholder="密码" class="login_txtbx" id="password"/>
    </div>
    <div class="layui-submit larry-login">
        <input type="button" value="立即登录" class="submit_btn"/>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
    function showLoad() {
        return layer.msg('登录中...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: 'auto', time:1000});
    }

    function closeLoad(index) {
        layer.close(index);

    }
    function showSuccess() {
        layer.msg('登录成功！',{time: 1000,offset: 'auto'});
    }
    function showFailure() {
        layer.msg('登录失败！',{time: 1000,offset: 'auto'});
    }
    $(function(){
        $(".layui-canvs").jParticle({
            background: "#141414",
            color: "#E6E6E6"
        });
        //登录链接测试，使用时可删除
        $(".submit_btn").click(function(){
            account = $("#account").val()
            password = $("#password").val()
            $.post({
                url:'${pageContext.request.contextPath}/login',
                data:{'account':account,'pwd':password},
                dataType:'text',
                beforeSend: function () {
                    i=showLoad();
                },
                success:function(data){
                    console.log(data)
                    if(data =="success"){
                        closeLoad(i);
                        showSuccess();
                        window.location.href="${pageContext.request.contextPath}/index"
                    }else{
                        closeLoad(i);
                        showFailure();
                    }
                },
                error : function (data) {
                    console.log("error")
                }
            })
        });
    });
</script>
</body>
</html>
