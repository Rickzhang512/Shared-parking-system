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

<script type="text/html" id="barDemo">
    <a title="删除"  onclick="deleteRecord()" href="javascript:;" lay-event="edit">
        <i class="layui-icon">&#xe640;</i>
    </a>
</script>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
</body>
<div  style="margin-left: 20px">
    <table id="recordInfo" lay-filter="recordInfo"></table>
</div>
<script>
    layui.use(['table','form'], function(){
        var table = layui.table;
        var form = layui.form;
        var tableIns = table.render({
            elem: '#recordInfo'  //绑定table表格
            ,id:'recordInfo'
            ,method:'post'
            ,url: '${pageContext.request.contextPath}/findAllRecordByPage' //后台springmvc接收路径
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
                ,limit:3
                ,limits:[3,6,9,12]
            }
            ,cols: [
                [
                    {type: 'checkbox'}
                    ,{field:'id',title:'id', sort: true}
                    ,{field:'parkName', title:'车库名称'}
                    ,{field:'location', title:'车库地址'}
                    ,{field:'userName', title:'用户名'}
                    ,{field:'inTime', title:'停车时间'}
                    ,{field:'outTime', title:'开出时间'}
                    ,{field:'isCharge', title:'是否结算'}
                    ,{field:'charge', title:'费用'}
                    ,{field:'operation',title:'操作',toolbar: '#barDemo'}
                ]
            ]
        });
    });

    function deleteRecord() {
        var id="";
        layui.use('table',function(){
            var table = layui.table
            var checkStatus = table.checkStatus('recordInfo');
            if(!checkStatus.data[0]){
            	layer.msg("请先勾选需要修改的记录！",function(){

                });
            	return;
            }
            id = checkStatus.data[0].id;
            $.ajax({
                url:'${pageContext.request.contextPath}/deleteRecord',
                data:{"id":id},
                type:'POST',
                success:function (data) {
                    console.log(data)
                    layer.msg("删除成功！",function(){

                    });
                },error:function(args){
                    layer.msg("删除失败！",function(){

                    });
                }
            })
        });
    }
    
</script>
</html>
