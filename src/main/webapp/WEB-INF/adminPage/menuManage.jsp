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

    function filechange(){
        $.ajax({
            url:"searchSendMenu.action",
            data:"firstMenuName="+$("#searchFirstMenu").val(),
            dataType:"text",
            type:"post",
            success:function(redata){
                var res =JSON.parse(redata);//把后台传回的json数据解析
                $("#searchSendMenu").html("");
                var option=" <option value='0' style='display:none;' >-请选择-</option>";
                $.each(res,function(i,n){//循环，i为下标从0开始，n为集合中对应的第i个对象
                    option += "<option value='"+n.phamacySecondName+"'>"+n.phamacySecondName+"</option>"
                });
                $("#searchSendMenu").append(option);//将循环拼接的字符串插入第二个下拉列表
                $("#searchSendMenu").show();//把第二个下拉列表展示
            }

        });
    }



</script>
<body onload="searchFirstMenu()">
<div class="x-nav">
            <span class="layui-breadcrumb">
               <a><cite>首页</cite></a>
              <a><cite>菜单管理</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="menuConfig.action" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>


    <div class="layui-form-pane" >
        <div class="layui-form-item">
            <div class="layui-input-inline" style="width:105px;height: 250px">
                <button class="layui-btn"  lay-submit="" lay-filter="*"><i class="layui-icon">&#xe615;</i>菜单查询:</button>
            </div><br/>
       <label class="layui-form-label" style="width: 100px">一级菜单：</label>
            <div class="layui-input-inline" style="width:85px">
            <select id="searchFirstMenu" name="searchFirstMenu" style="height: 36px;width: 95px"  onchange="filechange()">
                <option value="0" style="display:none;" >-请选择-</option>
            </select>
                <button class="layui-btn"  lay-submit="" lay-filter="*" onclick="firstMenuAdd('一级菜单添加','addFirstMenuView.action','4','','400')"><i class="layui-icon">&#xe608;</i>一级菜单添加</button><br/>
                <button class="layui-btn"  lay-submit="" lay-filter="*" onclick="firstMenuEdit('一级菜单编辑','editFirstMenuView.action','4','510','510')"><span ><img src="../images/t02.png"  ></span>一级菜单编辑</button>
            </div>
        <label class="layui-form-label" style="width: 100px">二级菜单：</label>
            <div class="layui-input-inline" style="width:100px">
            <select id="searchSendMenu" name="titleone" style="height: 36px;width: 100px" onclick="checkSecond()" onchange="showmessage()">
                <option  style="display:none;" value='0'>-请选择-</option>
            </select>
                <button class="layui-btn"  lay-submit="" lay-filter="*" onclick="secondMenuAdd('二级菜单添加','addSecondMenuView.action','4','','400')"><i class="layui-icon">&#xe608;</i>二级菜单添加</button><br/>
                <button class="layui-btn"  lay-submit="" lay-filter="*" onclick="secondMenuDetele()"><span ><img src="../images/t02.png"  ></span>二级菜单删除</button>

            </div>
        </div>
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


    // 一级菜单编辑
    function firstMenuEdit(title,url,id,w,h) {
        x_admin_show(title,url,w,h);
    }

    // 一级菜单添加
    function firstMenuAdd (title,url,id,w,h) {
        x_admin_show(title,url,w,h);
    }

    // 二级菜单删除
    function secondMenuDetele() {
        var t=confirm("确定要删除该二级菜单？");
        var searchSendMenu=document.getElementById("searchSendMenu").value;
        if(t==true){
            location.href="secondMenuDetele.action?searchSendMenu="+searchSendMenu;
            layer.msg('提交成功!',{icon: 6,time:2000});
            layer.closeAll(layer.index);
            window.parent.location.reload();
        }else{
            location.href="menuConfig.action";
        }

    }

    // 二级菜单添加
    function secondMenuAdd (title,url,id,w,h) {
        x_admin_show(title,url,w,h);
    }

        $('.tablelist tbody tr:odd').addClass('odd');
</script>
<script>
    layui.use('form',function(){});
</script>
</body>

</html>