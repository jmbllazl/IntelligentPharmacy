<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/10/31
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        一级菜单添加
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">
</head>
<body>
<form class="layui-form" action="#"  method="post" >
<div style="line-height:230px;text-align:center">
    <span><img src="../images/t01.png" /></span>
    <input type="text" name="firstName" id="firstName" style="width: 150px;height: 40px" placeholder="输入一级菜单"  >
    <br/>
        <input type="submit" class="layui-btn" onclick="view()" value="提交" >

</div>
</form>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
</script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
</script>
<script type="text/javascript" >

    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form()
            ,layer = layui.layer;
    });
    function view(){
        var t=confirm("确定要提交？");
        var firstName=document.getElementById("firstName").value;
        if(t==true){
            location.href="submitFirstMenu.action?firstName="+firstName;
            layer.msg('提交成功!',{icon: 6,time:2000});
            layer.closeAll(layer.index);
            window.parent.location.reload();
        }else{
            location.href="addFirstMenuView.action";
        }


    }


</script>
</body>
</html>
