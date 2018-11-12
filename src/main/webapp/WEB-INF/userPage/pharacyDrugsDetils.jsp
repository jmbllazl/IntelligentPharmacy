<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/26 0026
  Time: 下午 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>药品商城</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/style.css">
</head>
<body>
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">药品商城</a></li>
                <li>|</li>
                <li><a href="">DRUG</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">药品商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="">购物车</a></div>
            <div class="fr">
                <ul>
                    <li><a href="./login.html" target="_blank">登录</a></li>
                    <li>|</li>
                    <li><a href="./register.html" target="_blank" >注册</a></li>
                    <li>|</li>
                    <li><a href="">消息通知</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
    <a href=""><div class="ad_top fl"></div></a>
    <div class="nav fl">
        <ul>
            <li><a href="">抗生素</a></li>
            <li><a href="">心脑血管用药</a></li>
            <li><a href="">消化系统用药</a></li>
            <li><a href="">呼吸系统用药</a></li>
            <li><a href="">麻醉类药品</a></li>
            <li><a href="">精神类药品</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru"  placeholder="药品   ">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->


<!-- xiangqing -->
<form action="post" method="">
    <div class="jieshao mt20 w">
        <div class="left fl"><img src="${pageContext.request.contextPath}/userPage/selectPhamacyDrugDetils.action?receiverId=${phamacyDrug.pharmacyId}"></div>
        <div class="right fr">
            <div class="h3 ml20 mt20">${phamacyDrug.drugName}</div>
            <div class="jianjie mr40 ml20 mt10">${phamacyDrug.drugDetails}</div>
            <div class="jiage ml20 mt10">${phamacyDrug.drugPrice}.00元</div>
            <div class="xqxq mt20 ml20">
                <div class="bot mt20 ft20 ftbc">总计：${phamacyDrug.drugPrice}元</div>
            </div>
            <div class="xiadan ml20 mt20">
                <input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
                <input class="jrgwc" type="button" name="jrgwc" value="加入购物车" />

            </div>
        </div>
        <div class="clear"></div>
    </div>
</form>
<!-- footer -->
</body>
</html>