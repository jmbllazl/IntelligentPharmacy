<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" import="java.util.*,com.cy.bean.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>
        后台用户管理
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/x-admin.css" media="all">
    <link rel="stylesheet" href="../css/pag.css" media="all">
</head>
<script type="text/javascript">


</script>
<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
               <a><cite>首页</cite></a>
              <a><cite>菜单管理</cite></a>
            </span>
</div>

<div align="center">
    <table width="500"  >
        <td>：
            <select id="first" name="fileone"  onchange="filechange()">
                <option value="0" style="display:none;" >-请选择-</option>
                <option value="焦虑">焦虑</option>
                <option value="亲子关系">亲子关系</option>
                <option value="抑郁">抑郁</option>
                <option value="婚姻情感">婚姻情感</option>
                <option value="失眠">失眠</option>
            </select></td>
        <td>心理咨询师：
            <select id="second" name="titleone" onchange="showmessage()">
                <option  style="display:none;" >-请选择-</option>
            </select></td>
    </table>
</div>




<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
<script>




    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层

    });


    // 用户-编辑
    function user_management_edit (title,url,id,w,h) {
        x_admin_show(title,url,w,h);   /*用户-添加*/


        /*用户-停用*/
        function member_stop(obj){
            var t=confirm("确定要禁用？");
            var name=document.getElementById("uid").value;
            if(t==true){
                location.href="stopState.action?name="+name;
                layer.msg('已禁用!',{icon: 5,time:1000});
            }else{
                location.href="adminFind.action";
            }
        }




    $('.tablelist tbody tr:odd').addClass('odd');
</script>
<script>
    layui.use('form',function(){});
</script>
</body>

</html>