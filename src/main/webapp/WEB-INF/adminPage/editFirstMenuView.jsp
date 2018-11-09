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
        一级菜单编辑
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
<div align="center">
        <table border="1px">
        <th style="width: 50px">ID</th>  <th style="width: 100px">一级菜单名</th>  <th style="width: 100px">操作</th>
         <c:forEach items="${firstMenu}"  var="firstMenu" >
        <tr>
            <td align="center">${firstMenu.phamacyFirstId}</td>
            <td align="center">${firstMenu.phamacyFirstName}</td>
            <td align="center">
                <a title="编辑" href="#" onclick="firstMenuEdit('编辑','editFirstMenu.action?firstMenuName=${firstMenu.phamacyFirstName}&firstMenuId=${firstMenu.phamacyFirstId}','4','510','510')"
                   class="ml-5" style="text-decoration:none">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" href="firstMenuDelete.action?firstMenuName=${firstMenu.phamacyFirstName}&firstMenuId=${firstMenu.phamacyFirstId}" onclick="member_del(this)"
                   style="text-decoration:none">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
         </c:forEach>
    </table>
</div>
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

    // 一级菜单添加
    function firstMenuEdit (title,url,id,w,h) {
        x_admin_show(title,url,w,h);
    }

</script>
</body>
</html>
