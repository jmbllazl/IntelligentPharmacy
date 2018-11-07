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
    <title>药库药品审核</title>
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
    <a><cite>药库药品审核</cite></a> </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<form method="post">
    <table class="tablelist" lay-filter="demo">
        <thead>
        <tr>
            <th> 申请日期 </th>
            <th> 药品</th>
            <th> 申请数量 </th>
            <th> 状态 </th>
            <th lay-data="{event:'del'}"> 操作 </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.phamacyPurchase.list}"  var="purchase" >
            <tr>
                <td name ="adstate" align="center">${purchase.receivedDate} </td>
                <td align="center">${purchase.drugName}</td>
                <td align="center">${purchase.drugQuantity}</td>

                <c:if test="${purchase.state=='审核中'}">
                    <td class="td-status" align="center">
                        <button class="sp2">${purchase.state}</button>
                    </td>

                    <td class="td-manage" align="center" >

                        <a title="通过审核" href="reviewPass.action?purchaseId=${purchase.purchaseId}&drugQuantity=${purchase.drugQuantity}&drugName=${purchase.drugName}" style="text-decoration:none">
                            <i class="layui-icon">&#xe62f;</i>

                        </a>
                        <a title="不通过审核" href="noReviewPass.action?purchaseId=${purchase.purchaseId}" style="text-decoration:none">
                            <i class="layui-icon">&#xe601;</i>
                        </a>
                        <a title="删除" href="purchaseDetele.action?drugId=${purchase.purchaseId}"
                           style="text-decoration:none">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </c:if>

                <c:if test="${purchase.state=='审核通过'}">
                    <td class="td-status" align="center">
                        <button class="sp">${purchase.state}</button>
                    </td>

                    <td class="td-manage" align="center" >

                        <a title="删除" href="purchaseDetele.action?drugId=${purchase.purchaseId}"
                           style="text-decoration:none">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </c:if>

                <c:if test="${purchase.state=='审核不通过'}">
                    <td class="td-status" align="center">
                        <button class="sp2">${purchase.state}</button>
                    </td>
                    <td class="td-manage" align="center" >
                        <a title="删除" href="purchaseDetele.action?drugId=${purchase.purchaseId}"
                           style="text-decoration:none">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </c:if>

            </tr>
            <%--            <div>
                        共有${purchase.total}条记录，当前第${purchase.pageNum}页，共${purchase.pages}页
                        <a href="#" onclick="chageNum(1)"   target="main">首页</a>
                        <a href="#" onclick="chageNum(${purchase.prePage})"  target="main">上一页</a>
                        <a href="#" onclick="chageNum(${purchase.nextPage})"   target="main">下一页</a>
                        <a href="#" onclick="chageNum(${purchase.navigateLastPage})"   target="main">尾页</a>
                        </h>
                        </div>--%>
        </c:forEach>
        </tbody>
    </table>
</form>
<div class="page"  v-show="show">
    <div class="pagelist"> <span class="jump"><a href="#" onclick="chageNum(${phamacyPurchase.prePage})" >上一页</a>
    </span> <span class="jump"><a href="#" onclick="chageNum(${phamacyPurchase.nextPage})">下一页</a></span>
    </div>
</div>
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
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data=obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    //obj.del();
                    console.log(obj);
                    console.log(data);
                    //layer.close(index);
                    $.ajax({
                        url: "/lightnote/informa/informationDelete",
                        type: "POST",
                        data:{'id':data.id},
                        dataType: "json",
                        success: function(data){
                            if(data==null){
                                layer.msg("删除失败", {icon: 5});
                            }else{
                                //删除这一行
                                obj.del();
                                //关闭弹框
                                layer.close(index);
                                layer.msg("删除成功", {icon: 6});
                                layer.closeAll();
                                parent.location.reload();
                                Load(); //删除完需要加载数据
                            }
                        },
                        error:function(){
                            alert(data);
                        },

                    });
                });
            };
        });
    });

</script>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
<script>

    function  detele() {
        alert("删除")
        var id = document.getElementById("uid").value;
        alert(id)
    }

    function chageNum(num) {
        console.log(num);
        var form = $("form");
        form.action="${pageContext.request.contextPath}/phamacy/selectPurasePage.action";
        $("input[name='num']").val(num);
        form.method="post";
        form.submit();
    }
</script>
</body>
</html>