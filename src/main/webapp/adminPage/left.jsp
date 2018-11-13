<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
    <head></head>

<body id="bg">

<!-- 左边节点 -->
<div class="container">

    <div class="leftsidebar_box">
        <a href="main.jsp" target="main">
            <div class="line">
                <img class="icon1" src="images/coin01.png" />
                <img class="icon2" src="images/coin02.png" />&nbsp;&nbsp;首页
            </div>
        </a>

        <!--用户管理-->
        <dl class="system_log">
            <dt>
                <img class="icon1" src="images/coin07.png" />
                <img class="icon2" src="images/coin08.png" />
                账户管理
                <img class="icon3" src="images/coin19.png" />
                <img class="icon4" src="images/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="showuser?action=showuser" target="main" class="cks">用户管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="/adminPage/adminFind.action" target="main" class="cks">后台用户管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
        </dl>

        <!--业务管理-->
        <dl class="system_log">
            <dt>
                <img class="icon1" src="images/coin09.png" />
                <img class="icon2" src="images/coin10.png" />
                业务管理
                <img class="icon3" src="images/coin19.png" />
                <img class="icon4" src="images/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="consultmanage?action=consultmanage" target="main" class="cks">咨询管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="ordermanage?action=ordermanage" target="main" class="cks">预约管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>

            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="onlieassessmanage?action=onlieassessmanage" target="main" class="cks">在线评估管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="topicmanage?action=topicmanage" target="main" class="cks">题库管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>

        </dl>

        <!--统计报表-->
        <dl class="system_log">
            <dt>
                <img class="icon1" src="images/coin05.png" />
                <img class="icon2" src="images/coin06.png" />
                统计报表
                <img class="icon3" src="images/coin19.png" />
                <img class="icon4" src="images/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a class="cks" href="sumuser.jsp" target="main">用户统计</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a class="cks" href="channel.jsp" target="main">渠道量统计</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
        </dl>

        <!--系统管理-->
        <dl class="system_log">
            <dt>
                <img class="icon1" src="images/coin03.png" />
                <img class="icon2" src="images/coin04.png" />
                系统管理
                <img class="icon3" src="images/coin19.png" />
                <img class="icon4" src="images/coin20.png" />
            </dt>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="" target="main" class="cks">菜单管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="" target="main" class="cks">角色管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="" target="main" class="cks">权限管理</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="" target="main" class="cks">日志查看</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
            <dd>
                <img class="coin11" src="images/coin111.png" />
                <img class="coin22" src="images/coin222.png" />
                <a href="" target="main" class="cks">参数配置</a>
                <img class="icon5" src="images/coin21.png" />
            </dd>
        </dl>
    </div>

</div>




</body>
</html>
