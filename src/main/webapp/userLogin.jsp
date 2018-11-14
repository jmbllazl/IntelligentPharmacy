<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<html >
<head>
	<title>欢迎登入</title>
    <meta charset="UTF-8">
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="j${pageContext.request.contextPath}/s/jquery-ui-1.9.2.custom.js"></script>

    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/userLogin.css" rel="stylesheet" type="text/css">


<body class="templatemo-bg-gray">
<input type="hidden" value="${requestScope.codeResult}" id="codeResult" name="codeResult">
<div class="container">
    <div class="col-md-12">
        <h1 class="margin-bottom-15">欢迎</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form"
              action="/userPage/userLogin.action" method="post">

            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="userName" class="control-label fa-label"><i
                                class="fa fa-user fa-medium"></i></label>
                        <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名"
                               onblur="checkName()">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="password" class="control-label fa-label"><i
                                class="fa fa-lock fa-medium"></i></label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="密码">
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
                        <img id="imgCode" src="/userPage/userImage.action" onClick="getCode()">
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
                        <a href="/forgot-password.html" class="text-right pull-right">忘记密码?</a>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label id="checkNameLabel"></label>
                        <label id="codeLabel"></label>
                    </div>
                </div>
            </div>
            <hr>
        </form>
        <div class="text-center">
            <a href="/create-account.html" class="templatemo-create-new">新建账户 <i class="fa fa-arrow-circle-o-right"></i></a>
        </div>
    </div>
</div>
</body>
<script>
	$(document).ready(function(){
	    var codeResult = $("#codeResult").val();
	    console.log(codeResult);
        $("#codeLabel").text(codeResult);
	});
    function getCode() {
        var imgCode = document.getElementById("imgCode");
        imgCode.src = "/userPage/userImage.action?" + Math.random();
    }
    function checkName(){
        var  userName =$("#userName").val();
console.log(userName);
        if(userName==""){
            $("#codeLabel").text('');
            $("#checkNameLabel").text("用户名不能为空").addClass("error_msg");
            return
        }
        $.post("/userPage/checkUserName.action", {userName: userName}, function (data) {
            var info = data;
            if(info.success){
                $("#codeLabel").text('');
                $("#checkNameLabel").text(info.message);
            }else {
                $("#codeLabel").text('');
                $("#checkNameLabel").text(info.message);
            }
        }, "json");
    }


</script>
</html>