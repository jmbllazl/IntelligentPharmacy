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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript">
    function searchFirstMenu(){
        $.ajax({
            url:"searchFirstMenu.action",
            dataType:"text",
            type:"post",
            success:function(redata){
                var res =JSON.parse(redata);//把后台传回的json数据解析
                $("#searchFirstMenu").html("");
                var option=" <option value='0' style='display:none;' >-请选择-</option>";
                $.each(res,function(i,n){//循环，i为下标从0开始，n为集合中对应的第i个对象
                    option += "<option value='"+n.phamacyFirstName+"'>"+n.phamacyFirstName+"</option>"
                });
                $("#searchFirstMenu").append(option);//将循环拼接的字符串插入第二个下拉列表
                $("#searchFirstMenu").show();//把第二个下拉列表展示
            }
        });
    }


</script>
<body onload="searchFirstMenu()">
<form class="layui-form" action="#"  method="post" >
    <div style="text-align:center">
        一级菜单：
        <select id="searchFirstMenu" name="searchFirstMenu" style="height: 36px;width: 95px"  onchange="searchFirstMenu()">
            <option value="0" style="display:none;" >-请选择-</option>
        </select>
        <span><img src="../images/t01.png" /></span>
        <input type="text" name="secondName" id="secondName" style="width: 150px;height: 40px" placeholder="输入二级菜单"  >
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
        var searchFirstMenu=document.getElementById("searchFirstMenu").value;
        var secondName=document.getElementById("secondName").value;
        if(searchFirstMenu==0){
            alert("请先选择一级菜单")
        }else {
            var t=confirm("确定要提交？");
            if (t == true) {
                location.href = "submitSecondMenu.action?secondName=" + secondName+"&searchFirstMenu="+searchFirstMenu;
                layer.msg('提交成功!', {icon: 6, time: 2000});
                layer.closeAll(layer.index);
                window.parent.location.reload();
            } else {
                location.href = "addSecondMenuView.action";
            }
        }

    }


</script>
</body>
</html>
