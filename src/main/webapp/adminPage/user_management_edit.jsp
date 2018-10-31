<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" import="java.util.*,com.cy.bean.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <title>
        用户管理-编辑
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>

<body>
<div class="x-body">
    <form class="layui-form" action="userEdit.action"  method="post" >

        <c:forEach items="${adminList}"  var="admin" >
        <div class="layui-form-item">
            <label class="layui-form-label">
                用户ID
            </label>
            <div class="layui-input-inline">
                <input readonly="readonly" id="L_city"
                       class="layui-input" name="adminid" value=${admin.adminId}>
            </div>
            <div class="layui-form-mid layui-word-aux">*禁止修改
            </div>

        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                用户名称</label>
            <div class="layui-input-inline">
                <input type="text"  class="layui-input" name="adminname" id="adminname" onblur="checkname()" value=${admin.adminName}>
            </div>

            <div>
                <span id="cn" class="layui-form-mid layui-word-aux"></span>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                电话
            </label>
            <div class="layui-input-inline">
                <input type="text"
                       class="layui-input" name="admintel" id="admintel" onblur="checktel()" value=${admin.adminPhone}>
            </div>
            <div>
                <span id="telid" class="layui-form-mid layui-word-aux"></span>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">
                年龄
            </label>
            <div class="layui-input-inline">
                <input type="text"
                       class="layui-input" name="adminage" id="adminage" onblur="checkgraduate()" value=${admin.adminAge}>
            </div>
            <div>
                <span id="cg" class="layui-form-mid layui-word-aux"></span>
            </div>

        </div>
        </c:forEach>
        <div class="layui-form-item">
            <%--@declare id="l_sign"--%><label for="L_sign" class="layui-form-label">
            </label>
            <input type="submit" class="layui-btn" onclick="view()" value="提交" >
        </div>

    </form>
</div>
<script src="./lib/layui/layui.js" charset="utf-8">
</script>
<script src="./js/x-layui.js" charset="utf-8">
</script>
<script type="text/javascript" >

    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form()
            ,layer = layui.layer;
    });
    function view(){
    layer.msg('修改成功!',{icon: 6,time:1000});
    }


</script>
</body>

</html>