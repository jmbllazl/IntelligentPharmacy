<%--
  Created by IntelliJ IDEA.
  User: x1c
  Date: 2018/10/31
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>

    <meta charset="UTF-8">
    <title>后台登录中心</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/jquery-ui-1.9.2.custom.js"></script>

    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
    <link href="css/adminlogin.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
<div class="container">
    <div class="col-md-12">
        <h1 class="margin-bottom-15">欢迎登录</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form"
              action="/adminPage/adminLogin.action" method="post">

            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="adminName" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
                        <input type="text" class="form-control" id="adminName" name="adminName" placeholder="用户名" onblur="checkName()">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
                        <input type="password" class="form-control"id="password" name="password" placeholder="密码">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-8">
                    <div class="control-wrapper">
                        <input type="text" class="form-control" name="code" placeholder="验证码">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="control-wrapper">
                        <img id="imgCode" src="/adminPage/userImage.action" onClick="getCode()">
                    </div>
                </div>


            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="checkbox control-wrapper">
                        <label>
                            <input type="checkbox">记住密码
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <input type="submit" value="登录" class="btn btn-info">
                        <a href="#" class="text-right pull-right">忘记密码?</a>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label id="checkNameLabel"></label>
                    </div>
                </div>
            </div>
            <hr>
        </form>
        <div class="text-center">
            <a href="#" class="templatemo-create-new">新建账户 <i class="fa fa-arrow-circle-o-right"></i></a>
        </div>
    </div>
</div>
</body>
<script>
    function getCode(){
        var imgCode = document.getElementById("imgCode");
        imgCode.src = "/adminPage/userImage.action?"+Math.random();
    }
    function checkName(){
        var  adminName =$("#adminName").val();

        if(adminName==""){

            $("#checkNameLabel").text("用户名不能为空").addClass("error_msg");
            return
        }
        $.post("/adminPage/checkAdminName.action",{adminName:adminName},function (data) {

            var info = data;
            if(info.success){
                $("#checkNameLabel").text(info.message);
            }else {
                $("#checkNameLabel").text(info.message);
            }
        },"json");
    }


</script>
</html>
