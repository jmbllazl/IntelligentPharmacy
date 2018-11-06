<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/10/31
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" import="java.util.*,com.cy.bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        菜单编辑成功
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
<div style="line-height:200px;text-align:center">
    <span><img src="${pageContext.request.contextPath}/images/t02.png" /></span>
    <input type="text" name="firstMenuName" id="firstMenuName" style="width: 100px;height: 40px" value="<%=request.getAttribute("firstMenuName")%>"/><br/>
    <a href="#" class="layui-btn" onclick="close()" value="提交">提交</a>
</div>
</form>
</body>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
<script type="text/javascript">


    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form()
            ,layer = layui.layer;
    });

    function close(){
        var t=confirm("确定要提交？");
        var firstMenuName=document.getElementById("firstMenuName").value;
        alert(firstMenuName);
        if(t==true){
            location.href="updateFirstMenu.action?firstMenuName="+firstMenuName;
            layer.msg('已启用!',{icon: 6,time:1000});
            layer.closeAll(layer.index);
            window.parent.location.reload();
        }else{
            location.href="editFirstMenu.action";
        }
    }
</script>
</html>
