<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/26 0026
  Time: 下午 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" import="java.util.*,com.cy.bean.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <title>药库退还厂家单</title>
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
<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a>
    <a><cite>退还厂家单</cite></a> </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<form method="post">
    <table class="tablelist" lay-filter="demo">
        <thead>
        <tr>
            <th> 申请日期 </th>
            <th> 药品</th>
            <th> 退还数量 </th>
            <th> 退还原因 </th>
            <th> 状态 </th>
            <th lay-data="{event:'del'}"> 操作 </th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty requestScope.drugStoreOut.list}">
              <c:forEach items="${requestScope.drugStoreOut.list}"  var="drugStoreOut" >
            <tr>
                <td name ="adstate" align="center">${drugStoreOut.receiveDate} </td>
                <td align="center">${drugStoreOut.drugName}</td>
                <td align="center">${drugStoreOut.drugQuantity}</td>
                <td align="center">${drugStoreOut.outReason}</td>

                <c:if test="${drugStoreOut.state=='审核中'}">
                    <td class="td-status" align="center">
                        <button class="sp2">${drugStoreOut.state}</button>
                    </td>

                    <td class="td-manage" align="center" >

                        <a title="通过审核" href="drugStoreOutReviewPass.action?drugStoreOutId=${drugStoreOut.drugStoreOutId}&drugQuantity=${drugStoreOut.drugQuantity}&drugName=${drugStoreOut.drugName}" style="text-decoration:none">
                            <i class="layui-icon">&#xe62f;</i>
                        </a>
                        <a title="不通过审核" href="drugStoreOutNoReviewPass.action?drugStoreOutId=${purchase.drugStoreOutId}" style="text-decoration:none">
                            <i class="layui-icon">&#xe601;</i>
                        </a>
                        <a title="删除" href="DrugStoreOutDetele.action?drugStoreOutId=${drugStoreOut.drugStoreOutId}"
                           style="text-decoration:none">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </c:if>

                <c:if test="${drugStoreOut.state=='审核通过'}">
                    <td class="td-status" align="center">
                        <button class="sp">${drugStoreOut.state}</button>
                    </td>
                    <td class="td-manage" align="center" >
                    <a title="删除" href="DrugStoreOutDetele.action?drugStoreOutId=${drugStoreOut.drugStoreOutId}"
                       style="text-decoration:none">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                    </td>
                </c:if>

                <c:if test="${drugStoreOut.state=='审核不通过'}">
                    <td class="td-status" align="center">
                        <button class="sp2">${drugStoreOut.state}</button>
                    </td>
                    <td class="td-manage" align="center" >
                    <a title="删除" href="DrugStoreOutDetele.action?drugStoreOutId=${drugStoreOut.drugStoreOutId}"
                       style="text-decoration:none">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                    </td>
                </c:if>


            </tr>
        </c:forEach>
            </c:when>
        </c:choose>
        <tr>
            <td colspan="3" align="left">共有${drugStoreOut.total}条记录，当前第${drugStoreOut.pageNum}页，共${drugStoreOut.pages}页</td>
            <td colspan="9" align="right">
                <a href="#" onclick="chageNum(1)"   target="main">首页</a>
                <a href="#" onclick="chageNum(${drugStoreOut.prePage})"  target="main">上一页</a>
                <a href="#" onclick="chageNum(${drugStoreOut.nextPage})"   target="main">下一页</a>
                <a href="#" onclick="chageNum(${drugStoreOut.navigateLastPage})"   target="main">尾页</a>
            </td>
        </tr>
        </tbody>
    </table>
</form>

<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
<script>
    layui.use(['table','element','laypage','layer'], function(){
        $ = layui.jquery;
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层
        var table=layui.table;

    });

</script>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
<script>
    function chageNum(num) {
        console.log(num);
        var form = $("form");
        form.action="${pageContext.request.contextPath}/phamacy/selectDrugStoreOut.action";
        $("input[name='num']").val(num);
        form.method="post";
        form.submit();
    }
</script>
</body>
</html>