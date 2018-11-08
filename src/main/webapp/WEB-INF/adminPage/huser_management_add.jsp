<%--
  Created by IntelliJ IDEA.
  User: x1c
  Date: 2018/11/1
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        用户管理-添加
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">

    <link href="${pageContext.request.contextPath}/css/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui-1.9.2.custom.js"></script>
</head>

<body>
<div class="x-body">
    <form class="layui-form" action="/adminPage/userAdd.action" method="post">
        <input type="hidden" value="启用" name="adminState" />
        <input type="hidden" value="存在" name="adminDetele"/>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>用户名称</label>
            <div class="layui-input-inline">
                <input type="text"  name="adminName" id="adminName"
                       class="layui-input" onblur="checkName()">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>必填
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                6到16个字符
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label"><span class="color-red">* </span>角色</label>
            <div class="layui-input-inline">
                <select name="adminRoleId" id="adminRoleId">
                    <option value=""> </option>
                    <option value="1">管理员</option>
                    <option value="2">药房操作员</option>
                    <option value="3">药房管理员</option>
                    <option value="4">药库操作员</option>
                    <option value="5">药库管理员</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span class="color-red">* </span>性别</label>
            <div class="layui-input-inline">
                <select name="adminSex" id="adminSex">
                    <option value=""> </option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="adminAge" class="layui-form-label">
                <span class="x-red">*</span>年龄
            </label>
            <div class="layui-input-inline">
                <input type="text" id="adminAge" name="adminAge"  class="layui-input"
                       onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="adminPhone" class="layui-form-label">
                <span class="x-red">*</span>电话
            </label>
            <div class="layui-input-inline">
                <input type="text" id="adminPhone" name="adminPhone"  class="layui-input"
                       onkeypress="return event.keyCode>=48&&event.keyCode<=57" ng-pattern="/[^a-zA-Z]/">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="confirm" class="layui-form-label">
            </label>
            <button  class="layui-btn layui-btn-fluid login-btn" type="button" id="confirm" lay-submit lay-filter="addUser" >添加</button>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
</script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
</script>

<script>
    layui.use(['form','jquery','layer'], function() {
        var form = layui.form(); //只有执行了这一步，部分表单元素才会自动修饰成功
        //form表单提交
        var $ = layui.jquery;
        form.on('submit(addUser)', function (data) {
            var userInfo = data.field;
            $.ajax({
                type: "POST",
                url: "/adminPage/userAdd.action",
                data: userInfo,
                dataType: "json",
                success: function (data) {

                    var info = data;
                    if (info.success) {

                        layer.msg("添加成功", {icon:6,time:2000},function () {

                            layer.closeAll(layer.index);
                            window.parent.location.reload()

                        });
                    } else {
                        layer.alert(info.message);
                    }
                },
                error: function(data, XMLHttpRequest, textStatus, errorThrown){
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }

            });
            return false;

        });

        //检车密码是否为空
        $('#password').blur(function(){
            var  password =$(this).val();
            if(password==""){
                alert("密码不能为空");
                return
            }
        });

        //检测角色是否为空
        $('#adminRoleId').blur(function(){
            var  adminRoleId =$(this).val();
            if(adminRoleId==""){
                alert("角色不能为空");
                return
            }
        });


        //检查用户名是否可用
        $('#adminName').blur(function() {
            var  adminName =$("#adminName").val();
            if(adminName==""){
                layer.msg("用户名不能为空", {icon:6,time:1500});
                return
            }
            $.post("/adminPage/checkAdminName.action",{adminName:adminName},function (data) {
                var info = data;
                if(info.success){
                    layer.msg("用户名已被占用", {icon:6,time:1500});
                }else {
                    layer.msg("用户名可用", {icon:6,time:1500});
                }
            },"json");
        });
    })

</script>
</body>
</html>
