
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="layui-unselect lau-sign-body" style="padding-top: 0px " >
    <form  class="layui-form">
        <div >
            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i> 停车场名称</label>
            <div class="layui-input-block">
                <input type="text" name="parkName" placeholder="请输入停车场名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div >
            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i> 停车场地址</label>
            <div class="layui-input-block">
                <input type="text" name="parkLocation" style="height: 30px;" placeholder="请输入停车场地址" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div >
            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i> 停车位数量</label>
            <div class="layui-input-block">
                <input type="text" name="parkNumber"  placeholder="请输入停车位数量" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div >
            <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i> 租金</label>
            <div class="layui-input-block">
                <input type="text" name="feeScale" placeholder="请输入租金(每小时/元)" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item lau-sign-other" style="margin-top: 20px;text-align:center">
            <button type="button" class="layui-btn layui-btn-normal" lay-submit="" lay-filter="submitPark" style="margin-right: 100px">提交</button>
        </div>
    </form>
</body>
<script>
    var avatarUrl_imgpath,img_imgpath,content_path;
    layui.use(['upload','form'], function(){
        var $ = layui.jquery,upload = layui.upload,form=layui.form;


        form.on('submit(submitPark)', function(result) {
            console.log("result.field:"+typeof (result.field))//object
            res = result.field
            data = JSON.stringify(res)//把js对象转换成json字符串,string
            console.log(data);
            console.log("data:"+typeof (data))
            $.ajax({
                url : '${pageContext.request.contextPath}/insertPark',
                data : data,
                type:'POST',
                dataType:'text',
                contentType : 'application/json',
                success:function(data){
                    if(data=="success"){
                        layer.msg("成功！",function(){

                        });
                    }else{
                        layer.msg("失败！",function(){

                        });
                    }
                },
                error:function(args){
                    layer.msg("失败！",function(){

                    });
                }
            });
        });

    })
</script>
</html>
